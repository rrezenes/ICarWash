package br.icarwash.control;

import br.icarwash.dao.ClienteDAO;
import br.icarwash.dao.SolicitacaoDAO;
import br.icarwash.model.Solicitacao;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ListarSolicitacaoEmAnalise", urlPatterns = {"/ListarSolicitacaoEmAnalise", "/solicitacao-em-analise"})
public class ListarSolicitacaoEmAnalise extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conexao = (Connection) request.getAttribute("conexao");
        
        SolicitacaoDAO solicitacaoDAO = new SolicitacaoDAO(conexao);
        ArrayList<Solicitacao> solicitacoes = solicitacaoDAO.listarEmAnalise();
        
        ClienteDAO clienteDAO = new ClienteDAO(conexao);
        
        solicitacoes.forEach(solicitacao -> {
            solicitacao.setCliente(clienteDAO.localizarPorId(solicitacao.getCliente().getId()));
        });
        
        request.setAttribute("solicitacoes", solicitacoes);

        RequestDispatcher rd = request.getRequestDispatcher("/listar_solicitacoes_pendentes.jsp");
        rd.forward(request, response);
    }

}
