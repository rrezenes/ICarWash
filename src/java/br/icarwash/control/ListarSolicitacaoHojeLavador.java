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
import java.util.Calendar;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ListarSolicitacaoHojeLavador", urlPatterns = {"/ListarSolicitacaoHojeLavador", "/solicitacoes-hoje"})
public class ListarSolicitacaoHojeLavador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        SolicitacaoDAO solicitacaoDAO = new SolicitacaoDAO();
        HttpSession session = ((HttpServletRequest) request).getSession(true);
        Usuario usuario = (Usuario) session.getAttribute("user");

        ArrayList<Solicitacao> solicitacoes = solicitacaoDAO.listarSolicitacaoHojeLavador(new LavadorDAO().localizarPorIdUsuario(usuario.getId()).getId());

        solicitacoes.forEach(solicitacao -> {

                solicitacao.setEndereco(new EnderecoDAO().localizarPorId(solicitacao.getEndereco().getId()));
                System.out.println(solicitacao.getEndereco().getBairro());
                solicitacao.setCliente(new ClienteDAO().localizarPorId(solicitacao.getCliente().getId()));
           
        });

        request.setAttribute("solicitacoes", solicitacoes);

        RequestDispatcher rd = request.getRequestDispatcher("/solicitacao_lavador_hoje.jsp");
        rd.forward(request, response);

    }
}
