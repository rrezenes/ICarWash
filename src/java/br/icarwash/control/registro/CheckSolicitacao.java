/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.icarwash.control.registro;

import br.icarwash.dao.SolicitacaoDAO;
import br.icarwash.model.Solicitacao;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mirian
 */
@WebServlet(name = "CheckSolicitacao", urlPatterns = {"/CheckSolicitacaoData"})
public class CheckSolicitacao extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            PrintWriter out = response.getWriter();
            SolicitacaoDAO solicitacaoDAO = new SolicitacaoDAO();
            Solicitacao solicitacao = new Solicitacao();

            Calendar dataHoraSolicitacao = Calendar.getInstance();
            dataHoraSolicitacao.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(request.getParameter("data")));

            solicitacao.setDataSolicitacao(dataHoraSolicitacao);
            
            solicitacaoDAO.checkHorarioDisponivel(solicitacao);

        } catch (ParseException ex) {
            Logger.getLogger(CheckSolicitacao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
