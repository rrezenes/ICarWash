package br.icarwash.control;

import br.icarwash.dao.*;
import br.icarwash.model.*;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ControleNovoCliente", urlPatterns = {"/NovoCliente", "/novo-cliente"})
public class ControleNovoCliente extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {        
        RequestDispatcher rd = request.getRequestDispatcher("cadastro.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Usuario usuario = new Usuario(request.getParameter("email"), request.getParameter("senha"), 1, true, false);
        
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        
        usuarioDAO.cadastrar(usuario);
        
        usuarioDAO = new UsuarioDAO();
        
        new LoginController().validaLogin(request, response, usuarioDAO.usuarioLogin(usuario));
    }
}
