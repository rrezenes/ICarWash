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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String usuario = request.getParameter("usuario");
        String senha = request.getParameter("senha");
        UsuarioDAO user = new UsuarioDAO();
        int nivelAcesso = user.usuarioLogin(usuario, senha);
        //System.out.println(nivelAcesso);
        if (nivelAcesso == 3) { // falta implementar login
            out.print("Bem Vindo, " + usuario);
            HttpSession session = request.getSession(true);
            // session if exist
            // or create one
            session.setAttribute("user", usuario);
            session.setAttribute("acesso", nivelAcesso);
            session.setMaxInactiveInterval(600);
            response.sendRedirect("painel_admin.jsp");
        } else if (nivelAcesso == 1) {
            out.print("Bem vindo, " + usuario);
            HttpSession session = request.getSession(true);
            // session if exist
            // or create one
            session.setAttribute("user", usuario);
            session.setAttribute("acesso", nivelAcesso);
            session.setMaxInactiveInterval(600);
            response.sendRedirect("painel_cliente.jsp");
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            out.println("<font color=red>Usuario e ou senha errado</font>");
            rd.include(request, response);
        }
    }
}
