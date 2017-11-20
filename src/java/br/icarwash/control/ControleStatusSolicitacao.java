package br.icarwash.control;

import br.icarwash.dao.LavadorDAO;
import br.icarwash.dao.SolicitacaoDAO;
import br.icarwash.model.Avaliacao;
import br.icarwash.model.Avaliacao.AvaliacaoBuilder;
import br.icarwash.model.Lavador;
import br.icarwash.model.Solicitacao;
import br.icarwash.model.Usuario;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ControleStatusSolicitacao", urlPatterns = {"/AprovarSolicitacao", "/CancelarSolicitacao", "/ProcessarSolicitacao", "/FinalizarSolicitacao", "/AvaliarSolicitacao"})
public class ControleStatusSolicitacao extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conexao = (Connection) request.getAttribute("conexao");

        String URI = ((HttpServletRequest) request).getRequestURI();

        Solicitacao solicitacao = new SolicitacaoDAO(conexao).localizarPorId(Integer.parseInt(request.getParameter("id_solicitacao")));

        String URIRetorno = "painel_admin.jsp";

        if (URI.endsWith("/AprovarSolicitacao")) {

            solicitacao.analisarSolicitacao();
            URIRetorno = "ListarSolicitacaoEmAnalise";

        } else if (URI.endsWith("/CancelarSolicitacao")) {

            solicitacao.cancelarSolicitacao();

            HttpSession session = ((HttpServletRequest) request).getSession(true);
            Usuario usuario = (Usuario) session.getAttribute("user");

            if (usuario.getNivel() == 1) {
                URIRetorno = "ListarSolicitacaoCliente?x";
            }

        } else if (URI.endsWith("/ProcessarSolicitacao")) {
            
            Lavador lavador = new LavadorDAO(conexao).localizarPorId(solicitacao.getLavador().getId());
            
            if (!lavador.isOcupado()) {
                solicitacao.processarSolicitacao();
                URIRetorno = "ListarSolicitacaoLavador";
            }
        } else if (URI.endsWith("/FinalizarSolicitacao")) {

            solicitacao.finalizarSolicitacao();
            URIRetorno = "ListarSolicitacaoLavador";

        } else if (URI.endsWith("/AvaliarSolicitacao")) {

            Avaliacao avaliacao = new AvaliacaoBuilder()
                    .withNotaPontualidade(BigDecimal.valueOf(Double.parseDouble(request.getParameter("pontualidade"))))
                    .withNotaServico(BigDecimal.valueOf(Double.parseDouble(request.getParameter("servico"))))
                    .withNotaAtendimento(BigDecimal.valueOf(Double.parseDouble(request.getParameter("atendimento"))))
                    .withNotaAgilidade(BigDecimal.valueOf(Double.parseDouble(request.getParameter("agilidade"))))
                    .build();

            solicitacao.setAvaliacao(avaliacao);
            solicitacao.avaliarSolicitacao();
            URIRetorno = "ListarSolicitacaoCliente";
        }
        response.sendRedirect(URIRetorno);

    }
}
