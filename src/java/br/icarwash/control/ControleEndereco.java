package br.icarwash.control;

import br.icarwash.dao.ClienteDAO;
import br.icarwash.dao.ClienteEnderecoDAO;
import br.icarwash.dao.EnderecoDAO;
import br.icarwash.model.Cliente;
import br.icarwash.model.Cliente.ClienteBuilder;
import br.icarwash.model.ClienteEndereco;
import br.icarwash.model.Endereco;
import br.icarwash.model.Usuario;
import java.io.IOException;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ControleEndereco", urlPatterns = {"/AlterarEndereco", "/AdicionarEndereco", "/ExcluirEndereco"})
public class ControleEndereco extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String URI = ((HttpServletRequest) request).getRequestURI();

        if (URI.endsWith("/AlterarEndereco")) {
            alterarEndereco(request, response);

        } else if (URI.endsWith("/AdicionarEndereco")) {
            adicionarEndereco(request, response);

        } else if (URI.endsWith("/ExcluirEndereco")) {
            excluirEndereco(request, response);

        }

        response.sendRedirect(request.getContextPath() + "/usuario");
    }

    protected void alterarEndereco(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conexao = (Connection) request.getAttribute("conexao");

        Endereco endereco = new Endereco.EnderecoBuilder()
                .withId(Integer.parseInt(request.getParameter("idEndereco")))
                .withCep(request.getParameter("cep"))
                .withEstado(request.getParameter("estado"))
                .withCidade(request.getParameter("cidade"))
                .withBairro(request.getParameter("bairro"))
                .withEndereco(request.getParameter("endereco"))
                .withNumero(Integer.parseInt(request.getParameter("numero")))
                .withNome(request.getParameter("nomeEndereco"))
                .build();

        new EnderecoDAO(conexao).atualizar(endereco);

        request.setAttribute("alterado", "ok");
    }

    protected void adicionarEndereco(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conexao = (Connection) request.getAttribute("conexao");

        HttpSession session = ((HttpServletRequest) request).getSession(true);
        Usuario usuario = (Usuario) session.getAttribute("user");

        Cliente cliente = new ClienteBuilder()
                .withUsuario(usuario)
                .build();

        cliente = new ClienteDAO(conexao).localizarPorIdUsuario(cliente);

        Endereco endereco = new Endereco.EnderecoBuilder()
                .withCep(request.getParameter("cep"))
                .withEstado(request.getParameter("estado"))
                .withCidade(request.getParameter("cidade"))
                .withBairro(request.getParameter("bairro"))
                .withEndereco(request.getParameter("endereco"))
                .withNumero(Integer.parseInt(request.getParameter("numero")))
                .withNome(request.getParameter("nomeEndereco"))
                .build();

        endereco = new EnderecoDAO(conexao).cadastrar(endereco);

        ClienteEndereco clienteEndereco = new ClienteEndereco(cliente, endereco);
        new ClienteEnderecoDAO(conexao).cadastraClienteEndereco(clienteEndereco);

        request.setAttribute("alterado", "ok");
    }

    protected void excluirEndereco(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conexao = (Connection) request.getAttribute("conexao");

        HttpSession session = ((HttpServletRequest) request).getSession(true);
        Usuario usuario = (Usuario) session.getAttribute("user");

        Cliente cliente = new ClienteBuilder()
                .withUsuario(usuario)
                .build();

        cliente = new ClienteDAO(conexao).localizarPorIdUsuario(cliente);

        Endereco endereco = new Endereco.EnderecoBuilder()
                .withId(Integer.parseInt(request.getParameter("idEndereco")))
                .build();

        ClienteEndereco clienteEndereco = new ClienteEndereco(cliente, endereco);
        new ClienteEnderecoDAO(conexao).excluirClienteEndereco(clienteEndereco);
        
        new EnderecoDAO(conexao).excluir(endereco);

        request.setAttribute("excluido", "ok");
    }

}
