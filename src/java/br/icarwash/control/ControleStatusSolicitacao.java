/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.icarwash.control;

import br.icarwash.dao.SolicitacaoDAO;
import br.icarwash.model.Solicitacao;
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
@WebServlet(name = "ControleStatusSolicitacao", urlPatterns = {"/AprovarSolicitacao", "/CancelarSolicitacao", "/ProcessarSolicitacao", "/FinalizarSolicitacao", "/AvaliarSolicitacao"})
public class ControleStatusSolicitacao extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String URI = ((HttpServletRequest) request).getRequestURI();

        SolicitacaoDAO solicitacaoDAO = new SolicitacaoDAO();
        Solicitacao solicitacao = solicitacaoDAO.localizarPorId(Integer.parseInt(request.getParameter("id_solicitacao")));

        if (URI.endsWith("/AprovarSolicitacao")) {
            solicitacao.analisarSolicitacao();
        } else if(URI.endsWith("/CancelarSolicitacao")){
            solicitacao.cancelarSolicitacao();
        } else if(URI.endsWith("/ProcessarSolicitacao")){
            solicitacao.processarSolicitacao();
        } else if(URI.endsWith("/FinalizarSolicitacao")){
            solicitacao.finalizarSolicitacao();
        } else if(URI.endsWith("/AvaliarSolicitacao")){
            System.out.println(request.getParameter("pontualidade"));
            System.out.println(request.getParameter("servico"));
            System.out.println(request.getParameter("atendimento"));
            System.out.println(request.getParameter("agilidade"));
            solicitacao.avaliarSolicitacao();
        }

        request.getRequestDispatcher("/painel_admin.jsp").forward(request, response);

    }
}
