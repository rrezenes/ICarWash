/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.icarwash.control;

/**
 *
 * @author rezen
 */
import br.icarwash.dao.UsuarioDAO;
import br.icarwash.model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Session
 */
@WebServlet(name = "LoginController", urlPatterns = "/Login")
public class LoginController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        Usuario usuario = new Usuario(request.getParameter("usuario"), request.getParameter("senha"));

        UsuarioDAO usuarioDAO = new UsuarioDAO();

        usuario = usuarioDAO.usuarioLogin(usuario);

        this.validaLogin(request, response, usuario);

    }

    private void validaLogin(HttpServletRequest request, HttpServletResponse response, Usuario usuario) throws IOException, ServletException {

        if (!usuario.isAtivo() || usuario == null) {
            PrintWriter out = response.getWriter();
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            out.println("<font color=red>Usuario e ou senha errado</font>");
            rd.include(request, response);
        } else {
            HttpSession session = request.getSession(true);
            session.setAttribute("user", usuario);
            session.setAttribute("acesso", usuario.getNivel());
            session.setMaxInactiveInterval(600);
            response.sendRedirect("painel_admin.jsp");
        }

    }
}
