package br.icarwash.control;

import br.icarwash.dao.EnderecoDAO;
import br.icarwash.dao.ServicoDAO;
import br.icarwash.model.Usuario;
import java.io.IOException;
import java.sql.Connection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "SolicitarServico", urlPatterns = {"/SolicitarServico", "/solicitar-servico"})
public class SolicitarServico extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conexao = (Connection) request.getAttribute("conexao");
        
        HttpSession session = ((HttpServletRequest) request).getSession(true);
        Usuario usuario = (Usuario) session.getAttribute("user");

        request.setAttribute("servicos", new ServicoDAO(conexao).listar());
        request.setAttribute("enderecos", new EnderecoDAO(conexao).localizarPorIdUsuario(usuario.getId()));

        RequestDispatcher rd = request.getRequestDispatcher("/solicitar_servico.jsp");
        rd.forward(request, response);
    }

}
