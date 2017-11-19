package br.icarwash.control;

import br.icarwash.dao.AvaliacaoDAO;
import br.icarwash.dao.ClienteDAO;
import br.icarwash.dao.SolicitacaoDAO;
import br.icarwash.model.Cliente;
import br.icarwash.model.Solicitacao;
import br.icarwash.model.Usuario;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ListarSolicitacaoCliente", urlPatterns = {"/ListarSolicitacaoCliente", "/solicitacoes-cliente"})
public class ListarSolicitacaoCliente extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conexao = (Connection) request.getAttribute("conexao");
        
        HttpSession session = ((HttpServletRequest) request).getSession(true);
        Usuario usuario = (Usuario) session.getAttribute("user");

        ClienteDAO clienteDAO = new ClienteDAO(conexao);
        Cliente cliente = clienteDAO.localizarPorIdUsuario(usuario.getId());

        SolicitacaoDAO solicitacaoDAO = new SolicitacaoDAO(conexao);
        ArrayList<Solicitacao> solicitacoes = solicitacaoDAO.listarSolicitacaoPorIDCliente(cliente.getId());

        AvaliacaoDAO avaliacaoDAO = new AvaliacaoDAO(conexao);

        solicitacoes.forEach(solicitacao -> {
            if (solicitacao.getAvaliacao().getId() != 0) {
                solicitacao.setAvaliacao(avaliacaoDAO.localizarAvaliacaoPorId(solicitacao.getAvaliacao().getId()));
            }
        });

        request.setAttribute("solicitacoes", solicitacoes);

        request.getRequestDispatcher("/listar_solicitacao_cliente.jsp").forward(request, response);

    }

}
