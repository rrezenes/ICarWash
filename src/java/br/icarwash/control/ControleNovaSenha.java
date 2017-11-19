package br.icarwash.control;

import br.icarwash.dao.UsuarioDAO;
import br.icarwash.model.Usuario;
import br.icarwash.util.Conexao;
import java.io.IOException;
import java.sql.Connection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ControleNovaSenha", urlPatterns = {"/ControleNovaSenha"})
public class ControleNovaSenha extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conexao = (Connection) request.getAttribute("conexao");
        
        HttpSession session = ((HttpServletRequest) request).getSession(true);
        Usuario usuario = (Usuario) session.getAttribute("user");

        usuario.setSenha(request.getParameter("senha"));

        UsuarioDAO usuarioDAO = new UsuarioDAO(conexao);

        usuario = usuarioDAO.usuarioLogin(usuario);

        if (usuario != null) {
            usuario.setSenha(request.getParameter("nova_senha"));
            usuarioDAO.alterarSenha(usuario);
        }

        request.setAttribute("alterado", "ok");
        RequestDispatcher rd = request.getRequestDispatcher("/Controle?action=LocalizarPorId&q=" + request.getParameter("quem") + "&id=" + request.getParameter("id"));
        rd.forward(request, response);
    }

}
