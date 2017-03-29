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

/**
 *
 * @author rezen
 */
public class Excluir implements ICommand {

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if ("cli".equals(request.getParameter("q"))) {
            ClienteDAO dao = new ClienteDAO();
            dao.exluir(Integer.parseInt(request.getParameter("id")));
            return "/Controle?action=Listar&listar=cliente";
        } else {
            LavadorDAO dao = new LavadorDAO();
            dao.exluir(Integer.parseInt(request.getParameter("id")));
            return "/Controle?action=Listar&listar=funcionario";
        }
    }

}
