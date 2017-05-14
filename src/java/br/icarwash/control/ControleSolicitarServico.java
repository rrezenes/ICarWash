/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.icarwash.control;

import br.icarwash.dao.ClienteDAO;
import br.icarwash.dao.ServicoDAO;
import br.icarwash.dao.SolicitacaoDAO;
import br.icarwash.dao.SolicitacaoServicoDAO;
import br.icarwash.model.Cliente;
import br.icarwash.model.Porte;
import br.icarwash.model.Servico;
import br.icarwash.model.Solicitacao;
import br.icarwash.model.Status;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class ControleSolicitarServico extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id_cliente = 1;

        Cliente cliente = new Cliente(id_cliente);

        ClienteDAO clienteDAO = new ClienteDAO();
        cliente = clienteDAO.localizarPorId(cliente.getId());

        /*PEGA OS PARAMETROS DA VIEW*/
        String porte = request.getParameter("porte");
        String[] servicos = request.getParameterValues("servico");
        Date data_solicitacao;
        Calendar data = null;
        try {
            data_solicitacao = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(request.getParameter("data_solicitacao"));
            data = Calendar.getInstance();
            data.setTime(data_solicitacao);
        } catch (ParseException ex) {
            Logger.getLogger(ControleSolicitarServico.class.getName()).log(Level.SEVERE, null, ex);
        }

        double valor = 0;

        Servico servico;
        ServicoDAO servicoDAO = new ServicoDAO();
        for (String idServico : servicos) {
            servico = servicoDAO.localizarPorId(Integer.parseInt(idServico));
            valor += servico.getValor().doubleValue();
        }

        BigDecimal valorTotal = new BigDecimal(valor);

        Solicitacao solicitacao = new Solicitacao(cliente, porte, data, valorTotal);
        SolicitacaoDAO solicitacaoDAO = new SolicitacaoDAO();
        solicitacaoDAO.cadastrar(solicitacao);
        solicitacao = solicitacaoDAO.selecionaUltimoIdSolicitacao();

        SolicitacaoServicoDAO solicitacaoServicoDAO = new SolicitacaoServicoDAO();

        for (String idServico : servicos) {
            servico = servicoDAO.localizarPorId(Integer.parseInt(idServico));
            solicitacaoServicoDAO.cadastraSolicitacaoServico(solicitacao, servico);
        }

        request.getRequestDispatcher("/minha_solicitacao.jsp").forward(request, response);

    }
}
