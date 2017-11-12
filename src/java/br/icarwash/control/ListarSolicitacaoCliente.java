package br.icarwash.control;

import br.icarwash.dao.ClienteDAO;
import br.icarwash.dao.SolicitacaoDAO;
import br.icarwash.model.Solicitacao;
import br.icarwash.model.Usuario;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ListarSolicitacaoCliente", urlPatterns = {"/ListarSolicitacaoCliente","/solicitacoes-cliente"})
public class ListarSolicitacaoCliente extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        SolicitacaoDAO solicitacaoDAO = new SolicitacaoDAO();
        HttpSession session = ((HttpServletRequest) request).getSession(true);
        Usuario usuario = (Usuario) session.getAttribute("user");
        ClienteDAO clienteDAO = new ClienteDAO();

        ArrayList<Solicitacao> solicitacoes = solicitacaoDAO.listarSolicitacaoPorIDCliente(clienteDAO.localizarPorIdUsuario(usuario.getId()).getId());

        request.setAttribute("solicitacoes", solicitacoes);

        request.getRequestDispatcher("/listar_solicitacao_cliente.jsp").forward(request, response);

    }

}
