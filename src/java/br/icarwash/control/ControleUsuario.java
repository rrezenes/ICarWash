package br.icarwash.control;

import br.icarwash.dao.ClienteDAO;
import br.icarwash.dao.ClienteEnderecoDAO;
import br.icarwash.dao.EnderecoDAO;
import br.icarwash.dao.LavadorDAO;
import br.icarwash.dao.UsuarioDAO;
import br.icarwash.model.Cliente;
import br.icarwash.model.Cliente.ClienteBuilder;
import br.icarwash.model.ClienteEndereco;
import br.icarwash.model.Endereco;
import br.icarwash.model.Lavador;
import br.icarwash.model.Usuario;
import java.io.IOException;
import java.sql.Connection;
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
        Connection conexao = (Connection) request.getAttribute("conexao");

        HttpSession session = ((HttpServletRequest) request).getSession(true);
        Usuario usuario = (Usuario) session.getAttribute("user");

        switch (usuario.getNivel()) {
            case 1: {
                Cliente cliente = new ClienteBuilder()
                        .withUsuario(usuario)
                        .build();

                cliente = new ClienteDAO(conexao).localizarPorIdUsuario(cliente);

                ArrayList<ClienteEndereco> clienteEnderecos = new ClienteEnderecoDAO(conexao).selecionaEnderecoPorIdCliente(cliente);

                ArrayList<Endereco> enderecos = new ArrayList<>();

                EnderecoDAO enderecoDAO = new EnderecoDAO(conexao);

                for (ClienteEndereco clienteEndereco : clienteEnderecos) {
                    enderecos.add(enderecoDAO.localizarPorId(clienteEndereco.getEndereco().getId()));
                }

                cliente = new ClienteDAO(conexao).localizarPorIdUsuario(cliente);

                request.setAttribute("enderecos", enderecos);
                request.setAttribute("cliente", cliente);

                RequestDispatcher rd = request.getRequestDispatcher("localizar_cliente.jsp");
                rd.forward(request, response);

                break;
            }
            case 2: {

                Lavador lavador = new LavadorDAO(conexao).localizarPorIdUsuario(usuario.getId());

                Endereco endereco = new EnderecoDAO(conexao).localizarPorId(lavador.getEndereco().getId());

                lavador.setEndereco(endereco);

                request.setAttribute("lavador", lavador);

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

        if (usuario.getNivel() >= 1) {
            usuario.setSenha(request.getParameter("nova_senha"));
            usuarioDAO.alterarSenha(usuario);
            request.setAttribute("alterado", "ok");
        } else {
            request.setAttribute("senhaInvalida", "ok");
        }

        doGet(request, response);
    }
}
