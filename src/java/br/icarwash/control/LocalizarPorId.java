/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.icarwash.control;

import br.icarwash.dao.ClienteDAO;
import br.icarwash.dao.LavadorDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.icarwash.model.Cliente;
import br.icarwash.model.Lavador;

/**
 *
 * @author rezen
 */
public class LocalizarPorId implements ICommand {

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if ("cli".equals(request.getParameter("q"))) {
            ClienteDAO dao = new ClienteDAO();
            Cliente cli = dao.localizarPorId(Integer.parseInt(request.getParameter("id")));
            request.setAttribute("cliente", cli);
            return "localizar_cli.jsp";
        } else {
            LavadorDAO dao = new LavadorDAO();
            Lavador func = dao.localizarPorId(Integer.parseInt(request.getParameter("id")));
            request.setAttribute("funcionario", func);
            return "localizar_func.jsp";
        }
    }
}
