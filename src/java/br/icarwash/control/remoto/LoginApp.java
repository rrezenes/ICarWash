/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.icarwash.control.remoto;

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
 *
 * @author Mirian
 */
@WebServlet(name = "LoginApp", urlPatterns = {"/LoginApp"})
public class LoginApp extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //TODO: externalize the Allow-Origin
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
        response.addHeader("Access-Control-Allow-Headers", "X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");
        response.addHeader("Access-Control-Max-Age", "1728000");

        Usuario usuario = new Usuario(request.getParameter("usuario"), request.getParameter("senha"));

        UsuarioDAO usuarioDAO = new UsuarioDAO();

        usuario = usuarioDAO.usuarioLogin(usuario);

        this.validaLogin(request, response, usuario);

    }

    private void validaLogin(HttpServletRequest request, HttpServletResponse response, Usuario usuario) throws IOException, ServletException {

        PrintWriter out = response.getWriter();
        if (!usuario.isAtivo() || usuario == null) {
            out.println("false");
        } else {
            out.println("true");
        }

    }

}
