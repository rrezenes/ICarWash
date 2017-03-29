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
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.icarwash.model.Endereco;
import br.icarwash.model.Lavador;

/**
 *
 * @author rezen
 */
public class Cadastrar implements ICommand {

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Calendar cal1 = Calendar.getInstance(), cal2 = Calendar.getInstance();
        if ("cliente".equals(request.getParameter("quem"))) {
            String[] nascimento = request.getParameter("nascimento").split("/");
            cal1.set(Integer.parseInt(nascimento[2]), Integer.parseInt(nascimento[1]) - 1, Integer.parseInt(nascimento[0]));
            Cliente cli = new Cliente(request.getParameter("txtEmail"), request.getParameter("nome"), request.getParameter("telefone"), cal1, request.getParameter("cpf"), new Endereco(request.getParameter("cep"), request.getParameter("estado"), request.getParameter("cidade"), request.getParameter("bairro"), request.getParameter("endereco"), Integer.parseInt(request.getParameter("numero"))));
            ClienteDAO dao = new ClienteDAO();
            dao.cadastrar(cli);
            request.setAttribute("objCliente", cli);
            return "sucesso.jsp";
        } else {
            String[] nascimento = request.getParameter("nascimento").split("/");
            cal1.set(Integer.parseInt(nascimento[2]), Integer.parseInt(nascimento[1]) - 1, Integer.parseInt(nascimento[0]));
            Lavador func = new Lavador(cal2, request.getParameter("email"), request.getParameter("nome"), request.getParameter("telefone"), cal1, request.getParameter("cpf"), new Endereco(request.getParameter("cep"), request.getParameter("estado"), request.getParameter("cidade"), request.getParameter("bairro"), request.getParameter("endereco"), Integer.parseInt(request.getParameter("numero"))));
            LavadorDAO dao = new LavadorDAO();
            dao.cadastrar(func);
            request.setAttribute("objFuncionario", func);
            return "sucesso_lavador.jsp";
        }

    }

}
