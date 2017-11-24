package br.icarwash.control;

import br.icarwash.dao.ClienteDAO;
import br.icarwash.dao.EnderecoDAO;
import br.icarwash.dao.LavadorDAO;
import br.icarwash.dao.UsuarioDAO;
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

@WebServlet(name = "ControleUsuario", urlPatterns = {"/usuario"})
public class ControleUsuario extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conexao = (Connection) request.getAttribute("conexao");

        HttpSession session = ((HttpServletRequest) request).getSession(true);
        Usuario usuario = (Usuario) session.getAttribute("user");

        switch (usuario.getNivel()) {
            case 1: {

                request.setAttribute("enderecos", new EnderecoDAO(conexao).localizarPorIdUsuario(usuario.getId()));
                request.setAttribute("cliente", new ClienteDAO(conexao).localizarPorIdUsuario(usuario.getId()));

                RequestDispatcher rd = request.getRequestDispatcher("localizar_cliente.jsp");
                rd.forward(request, response);

                break;
            }
            case 2: {
                request.setAttribute("endereco", new EnderecoDAO(conexao).localizarPorIdUsuario(usuario.getId()).get(0));
                request.setAttribute("lavador", new LavadorDAO(conexao).localizarPorIdUsuario(usuario.getId()));

                RequestDispatcher rd = request.getRequestDispatcher("localizar_lavador.jsp");
                rd.forward(request, response);
                break;
            }
            default: {

                RequestDispatcher rd = request.getRequestDispatcher("/painel_admin.jsp");
                rd.forward(request, response);
                break;
            }
        }
    }

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
