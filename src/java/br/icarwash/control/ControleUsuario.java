package br.icarwash.control;

import br.icarwash.dao.ClienteDAO;
import br.icarwash.dao.EnderecoDAO;
import br.icarwash.dao.LavadorDAO;
import br.icarwash.model.Cliente;
import br.icarwash.model.Endereco;
import br.icarwash.model.Lavador;
import br.icarwash.model.Usuario;
import br.icarwash.util.Conexao;
import java.io.IOException;
import java.util.ArrayList;
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
        
        HttpSession session = ((HttpServletRequest) request).getSession(true);
        Usuario usuario = (Usuario) session.getAttribute("user");

        if (usuario.getNivel() == 1) {
            Cliente cliente = new ClienteDAO().localizarPorIdUsuario(usuario.getId());

            new EnderecoDAO().localizarPorIdUsuario(usuario.getId());

            ArrayList<Endereco> enderecos = new EnderecoDAO().localizarPorIdUsuario(usuario.getId());

            request.setAttribute("enderecos", enderecos);
            request.setAttribute("cliente", cliente);

            RequestDispatcher rd = request.getRequestDispatcher("localizar_cliente.jsp");
            rd.forward(request, response);

        } else if (usuario.getNivel() == 2) {

            Lavador lavador = new LavadorDAO().localizarPorIdUsuario(usuario.getId());
            Endereco endereco = new EnderecoDAO().localizarPorIdUsuario(usuario.getId()).get(0);

            request.setAttribute("endereco", endereco);
            request.setAttribute("lavador", lavador);

            RequestDispatcher rd = request.getRequestDispatcher("localizar_lavador.jsp");
            rd.forward(request, response);
        }else {

            RequestDispatcher rd = request.getRequestDispatcher("/painel_admin.jsp");
            rd.forward(request, response);
        }
    }

}
