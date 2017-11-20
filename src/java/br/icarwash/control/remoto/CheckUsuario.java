package br.icarwash.control.remoto;

import br.icarwash.dao.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CheckUsuario", urlPatterns = "/CheckUsuarioEmail")
public class CheckUsuario extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conexao = (Connection) request.getAttribute("conexao");
        
        PrintWriter out = response.getWriter();

        out.print(new UsuarioDAO(conexao).checkEmailDisponivel(request.getParameter("email")));
        out.flush();
    }

}
