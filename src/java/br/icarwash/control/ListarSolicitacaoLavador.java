package br.icarwash.control;

import br.icarwash.dao.AvaliacaoDAO;
import br.icarwash.dao.ClienteDAO;
import br.icarwash.dao.EnderecoDAO;
import br.icarwash.dao.LavadorDAO;
import br.icarwash.dao.SolicitacaoDAO;
import br.icarwash.model.Lavador;
import br.icarwash.model.Solicitacao;
import br.icarwash.model.Usuario;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ListarSolicitacaoLavador", urlPatterns = {"/ListarSolicitacaoLavador", "/solicitacoes-lavador"})
public class ListarSolicitacaoLavador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        SolicitacaoDAO solicitacaoDAO = new SolicitacaoDAO();
        HttpSession session = ((HttpServletRequest) request).getSession(true);
        Usuario usuario = (Usuario) session.getAttribute("user");

        LavadorDAO lavadorDAO = new LavadorDAO();
        Lavador lavador = lavadorDAO.localizarPorIdUsuario(usuario.getId());

        ArrayList<Solicitacao> solicitacoes = solicitacaoDAO.listarSolicitacaoDoLavador(lavador.getId());

        solicitacoes.forEach(solicitacao -> {
            if (solicitacao.getAvaliacao().getId() != 0) {
                solicitacao.setAvaliacao(new AvaliacaoDAO().localizarAvaliacaoPorId(solicitacao.getAvaliacao().getId()));
            }
            solicitacao.setEndereco(new EnderecoDAO().localizarPorId(solicitacao.getEndereco().getId()));
            solicitacao.setCliente(new ClienteDAO().localizarPorId(solicitacao.getCliente().getId()));
        });

        request.setAttribute("ocupado", lavador.isOcupado());
        request.setAttribute("solicitacoes", solicitacoes);

        RequestDispatcher rd = request.getRequestDispatcher("/solicitacao_lavador.jsp");
        rd.forward(request, response);

    }

}
