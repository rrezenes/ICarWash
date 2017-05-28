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
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rezen
 */
public class Ativar implements ICommand {

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ativar = request.getParameter("q");

        switch (ativar) {
//            $$$$$$$$$$$$$$$$---FALTA IMPLEMENTAR---$$$$$$$$$$$$$$$$$$
//            case "cliente": {
//                ClienteDAO clienteDAO = new ClienteDAO();
//                clienteDAO.ativar(Integer.parseInt(request.getParameter("id")));
//                return "/Controle?action=Listar&listar=cliente";
//            }
//            case "lavador": {
//                LavadorDAO lavadorDAO = new LavadorDAO();
//                lavadorDAO.ativar(Integer.parseInt(request.getParameter("id")));
//                return "/Controle?action=Listar&listar=lavador";
//            }
            case "produto": {
                ProdutoDAO produtoDAO = new ProdutoDAO();
                produtoDAO.ativar(Integer.parseInt(request.getParameter("id")));
                return "/Controle?action=Listar&listar=produto";
            }
            case "servico": {
                ServicoDAO servicoDAO = new ServicoDAO();
                servicoDAO.ativar(Integer.parseInt(request.getParameter("id")));
                return "/Controle?action=Listar&listar=servico";
            }
            default:
                return "painel_admin.jsp";
        }

    }

}
