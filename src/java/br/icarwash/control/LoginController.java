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
        System.out.println("no get login");
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        Usuario usuario = new Usuario(request.getParameter("usuario"), request.getParameter("senha"));

        UsuarioDAO user = new UsuarioDAO();

        usuario = user.usuarioLogin(usuario);

        //System.out.println(nivelAcesso);
        switch (usuario.getNivel()) {
            case 1: {
                out.print("Bem vindo, " + usuario);
                HttpSession session = request.getSession(true);
                // session if exist
                // or create one
                session.setAttribute("user", usuario);
                session.setAttribute("acesso", usuario.getNivel());
                session.setMaxInactiveInterval(600);
                response.sendRedirect("painel_admin.jsp");
                break;
            }
            case 2: {
                out.print("Bem vindo, " + usuario);
                HttpSession session = request.getSession(true);
                // session if exist
                // or create one
                session.setAttribute("user", usuario);
                session.setAttribute("acesso", usuario.getNivel());
                session.setMaxInactiveInterval(600);
                response.sendRedirect("painel_admin.jsp");
                break;
            }
            case 3: {
                HttpSession session = request.getSession(true);
                // session if exist
                // or create one
                session.setAttribute("user", usuario);
                session.setAttribute("acesso", usuario.getNivel());
                session.setMaxInactiveInterval(600);
                response.sendRedirect("painel_admin.jsp");
                break;
            }
            default:
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                out.println("<font color=red>Usuario e ou senha errado</font>");
                rd.include(request, response);
                break;
        }
    }
}
