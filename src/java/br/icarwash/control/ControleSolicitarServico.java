/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.icarwash.control;

import br.icarwash.dao.SolicitacaoDAO;
import br.icarwash.dao.SolicitacaoServicoDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rezen
 */
@WebServlet(name = "ControleSolicitarServico", urlPatterns = "/ControleSolicitarServico")
public class ControleSolicitarServico extends HttpServlet{
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id_cliente = 1;
        
        String porte = request.getParameter("porte");
        String[] servicos = request.getParameterValues("servicos");
        SolicitacaoServicoDAO solicitacaoServicoDAO = new SolicitacaoServicoDAO();
                
        for(String idServico: servicos){
            solicitacaoServicoDAO.cadastraSolicitacaoServico(Integer.parseInt(idServico), id_cliente);
        }
        
        SolicitacaoDAO solicitacaoDAO = new SolicitacaoDAO();
        solicitacaoDAO.cadastraSolicitacao(id_cliente, porte);
        
        
    }
}
