
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

@WebServlet(name = "CheckUsuario", urlPatterns = "/CheckUsuarioEmail")
public class CheckUsuario extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String URI = ((HttpServletRequest) request).getRequestURI();
        PrintWriter out = response.getWriter();

        UsuarioDAO usuarioDAO = new UsuarioDAO();

        out.print(usuarioDAO.checkEmailDisponivel(request.getParameter("email")));
        out.flush();
    }

}