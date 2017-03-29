/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.icarwash.control;

import br.icarwash.dao.ClienteDAO;
import br.icarwash.dao.LavadorDAO;
import java.io.IOException;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.icarwash.model.Cliente;
import br.icarwash.model.Endereco;
import br.icarwash.model.Lavador;

/**
 *
 * @author rezen
 */
public class Atualizar implements ICommand {

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if ("cliente".equals(request.getParameter("quem"))) {
            Calendar cal = Calendar.getInstance();
            String[] nascimento = request.getParameter("txtDataNascimento").split("/");
            cal.set(Integer.parseInt(nascimento[2]), Integer.parseInt(nascimento[1]) - 1, Integer.parseInt(nascimento[0]));
            ClienteDAO dao = new ClienteDAO();
            Cliente cli = new Cliente(Integer.parseInt(request.getParameter("txtId")),request.getParameter("txtEmail"), request.getParameter("txtNome"), request.getParameter("txtTelefone"), cal, request.getParameter("txtCPF"), new Endereco(request.getParameter("txtCEP"), request.getParameter("txtEstado"), request.getParameter("txtCidade"), request.getParameter("txtBairro"), request.getParameter("txtEndereco"), Integer.parseInt(request.getParameter("txtNumero"))));
            dao.atualizar(cli);
            return "index.jsp";
        } else {
            Calendar cal1 = Calendar.getInstance(), cal2 = Calendar.getInstance();
            cal1 = (Calendar)request.getAttribute("DtAdmissao");
            String[] nascimento = request.getParameter("txtDataNascimento").split("/");
            cal2.set(Integer.parseInt(nascimento[2]), Integer.parseInt(nascimento[1]) - 1, Integer.parseInt(nascimento[0]));
            LavadorDAO dao = new LavadorDAO();
            Lavador func = new Lavador(Integer.parseInt(request.getParameter("txtId")), cal1, request.getParameter("txtEmail"), request.getParameter("txtNome"), request.getParameter("txtTelefone"), cal2, request.getParameter("txtCPF"), new Endereco(request.getParameter("txtCEP"), request.getParameter("txtEstado"), request.getParameter("txtCidade"), request.getParameter("txtBairro"), request.getParameter("txtEndereco"), Integer.parseInt(request.getParameter("txtNumero"))));
            dao.atualizar(func);
            return "index.jsp";
        }
    }

}
