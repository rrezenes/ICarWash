/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.icarwash.control.command;

import br.icarwash.dao.ClienteDAO;
import br.icarwash.dao.LavadorDAO;
import br.icarwash.dao.ProdutoDAO;
import br.icarwash.dao.ServicoDAO;
import br.icarwash.model.Cliente;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.icarwash.model.Lavador;
import br.icarwash.model.Produto;
import br.icarwash.model.Servico;

/**
 *
 * @author rezen
 */
public class Listar implements ICommand {

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String quemListar = request.getParameter("listar");

        switch (quemListar) {
            case "cliente":
                ClienteDAO clienteDAO = new ClienteDAO();
                ArrayList<Cliente> clientes = clienteDAO.listar();
                request.setAttribute("lista", clientes);
                return "listar_cliente.jsp";
            case "lavador":
                LavadorDAO lavadorDAO = new LavadorDAO();
                ArrayList<Lavador> lavadores = lavadorDAO.listar();
                request.setAttribute("lista", lavadores);
                return "listar_lavador.jsp";
            case "produto":
                ProdutoDAO produtoDAO = new ProdutoDAO();
                ArrayList<Produto> produtos = produtoDAO.listar();
                request.setAttribute("lista", produtos);
                return "listar_produto.jsp";
            case "servico":
                ServicoDAO servicoDAO = new ServicoDAO();
                ArrayList<Servico> servicos = servicoDAO.listar();
                request.setAttribute("lista", servicos);
                return "listar_servico.jsp";
            default:
                return "painel_admin.jsp";
        }
    }
}
