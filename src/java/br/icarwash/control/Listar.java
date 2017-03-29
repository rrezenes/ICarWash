/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.icarwash.control;

import br.icarwash.dao.ClienteDAO;
import br.icarwash.dao.LavadorDAO;
import br.icarwash.model.Cliente;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.icarwash.model.Lavador;

/**
 *
 * @author rezen
 */
public class Listar implements ICommand {

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String quemListar = request.getParameter("listar");

        if ("cliente".equals(quemListar)) {
            ClienteDAO dao = new ClienteDAO();
            ArrayList<Cliente> clientes = dao.listar();
            request.setAttribute("lista", clientes);
            return "listar_cliente.jsp";
        } else {
            LavadorDAO dao = new LavadorDAO();
            ArrayList<Lavador> funcionarios = dao.listar();
            request.setAttribute("lista", funcionarios);
            return "listar_funcionario.jsp";
        }
    }
}
