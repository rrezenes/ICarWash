/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.icarwash.control;

import br.icarwash.dao.*;
import br.icarwash.model.*;
import java.io.IOException;
import java.util.Calendar;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rezen
 */
@WebServlet(name = "ControleNovoCliente", urlPatterns = {"/NovoCliente"})
public class ControleNovoCliente extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Calendar cal1 = Calendar.getInstance();
        String[] nascimento = request.getParameter("nascimento").split("/");
        cal1.set(Integer.parseInt(nascimento[2]), Integer.parseInt(nascimento[1]) - 1, Integer.parseInt(nascimento[0]));

        //VERIFICAR REPETIÇÃO
        Usuario usuario = new Usuario(request.getParameter("login"), request.getParameter("senha"), 1, true);
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.cadastrar(usuario);
        usuario = usuarioDAO.localizarIdPorUsuario(usuario);
        //VERIFICAR REPETIÇÃO

        Cliente cliente = new Cliente(request.getParameter("txtEmail"), request.getParameter("nome"), request.getParameter("telefone"), cal1, request.getParameter("cpf"), new Endereco(request.getParameter("cep"), request.getParameter("estado"), request.getParameter("cidade"), request.getParameter("bairro"), request.getParameter("endereco"), Integer.parseInt(request.getParameter("numero"))));
        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.cadastrar(cliente);
        Cliente clienteID = new Cliente(clienteDAO.localizarIdPorEmail(cliente.getEmail()));

        ClienteUsuario clienteUsuario = new ClienteUsuario(clienteID, usuario);
        ClienteUsuarioDAO clienteUsuarioDAO = new ClienteUsuarioDAO();
        clienteUsuarioDAO.cadastrar(clienteUsuario);

        request.setAttribute("objCliente", cliente);
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp?c=ok");
        rd.forward(request, response);
    }

}
