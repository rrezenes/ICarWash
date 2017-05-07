/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.icarwash.control;

import br.icarwash.dao.ClienteDAO;
import br.icarwash.dao.LavadorDAO;
import br.icarwash.dao.ProdutoDAO;
import java.io.IOException;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.icarwash.model.Cliente;
import br.icarwash.model.Endereco;
import br.icarwash.model.Lavador;
import br.icarwash.model.Produto;

/**
 *
 * @author rezen
 */
public class Atualizar implements ICommand {

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        switch (request.getParameter("quem")) {
            case "cliente": {

                Calendar calendar = Calendar.getInstance();
                String[] nascimento = request.getParameter("txtDataNascimento").split("/");
                calendar.set(Integer.parseInt(nascimento[2]), Integer.parseInt(nascimento[1]) - 1, Integer.parseInt(nascimento[0]));

                ClienteDAO dao = new ClienteDAO();
                Cliente cli = new Cliente(Integer.parseInt(request.getParameter("txtId")), request.getParameter("txtEmail"), request.getParameter("txtNome"), request.getParameter("txtTelefone"), calendar, new Endereco(request.getParameter("txtCEP"), request.getParameter("txtEstado"), request.getParameter("txtCidade"), request.getParameter("txtBairro"), request.getParameter("txtEndereco"), Integer.parseInt(request.getParameter("txtNumero"))));
                dao.atualizar(cli);

                return "Controle?action=Listar&listar=cliente";
            }
            case "lavador": {

                Calendar cal1, cal2 = Calendar.getInstance();
                cal1 = (Calendar) request.getAttribute("DtAdmissao");
                String[] nascimento = request.getParameter("txtDataNascimento").split("/");
                cal2.set(Integer.parseInt(nascimento[2]), Integer.parseInt(nascimento[1]) - 1, Integer.parseInt(nascimento[0]));

                LavadorDAO dao = new LavadorDAO();
                Lavador lavador = new Lavador(Integer.parseInt(request.getParameter("txtId")), cal1, request.getParameter("txtEmail"), request.getParameter("txtNome"), request.getParameter("txtTelefone"), cal2, request.getParameter("txtCPF"), new Endereco(request.getParameter("txtCEP"), request.getParameter("txtEstado"), request.getParameter("txtCidade"), request.getParameter("txtBairro"), request.getParameter("txtEndereco"), Integer.parseInt(request.getParameter("txtNumero"))));
                dao.atualizar(lavador);

                return "Controle?action=Listar&listar=lavador";
            }
            case "produto": {
                ProdutoDAO produtoDAO = new ProdutoDAO();
                Produto produto = new Produto(Integer.parseInt(request.getParameter("txtId")), request.getParameter("txtNome"), request.getParameter("txtDescricao"));
                produtoDAO.atualizar(produto);

                return "Controle?action=Listar&listar=produto";
            }
            default:
                return "painel_admin.jsp";
        }
    }

}
