/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.icarwash.control.remoto;

import org.json.JSONObject;
import br.icarwash.dao.UsuarioDAO;
import br.icarwash.model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONException;

/**
 *
 * @author Mirian
 */
@WebServlet(name = "CheckUsuario", urlPatterns = {"/CheckUsuarioEmail", "/CheckUsuarioLogin"})
public class CheckUsuario extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String URI = ((HttpServletRequest) request).getRequestURI();

        JSONObject json = new JSONObject();
        PrintWriter out = response.getWriter();
        if (URI.endsWith("/CheckUsuarioLogin")) {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            Usuario usuario = new Usuario();
            usuario.setUsuario(request.getParameter("usuario"));

            out.print(usuarioDAO.checkUsuarioDisponivel(usuario));

        } else if (URI.endsWith("/CheckUsuarioEmail")) {
            UsuarioDAO usuarioDAO = new UsuarioDAO();

            Usuario usuario = new Usuario();
            usuario.setEmail(request.getParameter("email"));

            out.print(usuarioDAO.checkEmailDisponivel(usuario));
            out.flush();

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String URI = ((HttpServletRequest) request).getRequestURI();

        JSONObject json = new JSONObject();
        PrintWriter out = response.getWriter();
        if (URI.endsWith("/CheckUsuarioLogin")) {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            Usuario usuario = new Usuario();
            usuario.setUsuario(request.getParameter("usuario"));
            out.print(usuarioDAO.checkUsuarioDisponivel(usuario));
            out.flush();

        } else if (URI.endsWith("/CheckUsuarioEmail")) {
            UsuarioDAO usuarioDAO = new UsuarioDAO();

            Usuario usuario = new Usuario();
            usuario.setEmail(request.getParameter("email"));

            out.print(usuarioDAO.checkEmailDisponivel(usuario));
            out.flush();
        }
    }

}
