/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.icarwash.control;

import br.icarwash.dao.ClienteDAO;
import br.icarwash.dao.LavadorDAO;
import br.icarwash.dao.ProdutoDAO;
import br.icarwash.dao.ServicoDAO;
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
        String excluir = request.getParameter("q");

        switch (excluir) {
            case "cliente": {
                ClienteDAO clienteDAO = new ClienteDAO();
                clienteDAO.excluir(Integer.parseInt(request.getParameter("id")));
                return "/Controle?action=Listar&listar=cliente";
            }
            case "lavador": {
                LavadorDAO lavadorDAO = new LavadorDAO();
                lavadorDAO.excluir(Integer.parseInt(request.getParameter("id")));
                return "/Controle?action=Listar&listar=lavador";
            }
            case "produto": {
                ProdutoDAO produtoDAO = new ProdutoDAO();
                produtoDAO.excluir(Integer.parseInt(request.getParameter("id")));
                return "/Controle?action=Listar&listar=produto";
            }
            case "servico": {
                ServicoDAO servicoDAO = new ServicoDAO();
                servicoDAO.excluir(Integer.parseInt(request.getParameter("id")));
                return "/Controle?action=Listar&listar=servico";
            }
            default:
                return "painel_admin.jsp";
        }
    }

}
