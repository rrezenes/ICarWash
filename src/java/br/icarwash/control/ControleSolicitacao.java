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
import br.icarwash.model.Servico;
import br.icarwash.model.Solicitacao;
import br.icarwash.model.Usuario;
import br.icarwash.util.Conexao;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author rezen
 */
@WebServlet(name = "ControleSolicitacao", urlPatterns = "/ControleSolicitacao")
public class ControleSolicitacao extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conexao = null;

        try {
            conexao = Conexao.getConexao();
            conexao.setAutoCommit(false);

            HttpSession session = ((HttpServletRequest) request).getSession(true);
            Usuario usuario = (Usuario) session.getAttribute("user");

            ClienteDAO clienteDAO = new ClienteDAO(conexao);
            Cliente cliente = new Cliente(clienteDAO.localizarIdPorIdUsuario(usuario.getId()));
            cliente = clienteDAO.localizarPorId(cliente.getId());

            /*PEGA OS PARAMETROS DA VIEW*/
            String porteVeiculo = request.getParameter("porte");
            String[] IdServicosSolicitados = request.getParameterValues("servico");
            Calendar dataHoraSolicitacao = Calendar.getInstance();
            dataHoraSolicitacao.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(request.getParameter("data_solicitacao")));

//            double valorTotalSolicitacao = 0;

            Servico servico;
            ServicoDAO servicoDAO = new ServicoDAO(conexao);

            Solicitacao solicitacao = new Solicitacao(cliente, porteVeiculo, dataHoraSolicitacao, somaValorTotalSolicitacao(IdServicosSolicitados, servicoDAO));
            SolicitacaoDAO solicitacaoDAO = new SolicitacaoDAO(conexao);
            solicitacaoDAO.cadastrar(solicitacao);
            solicitacao = solicitacaoDAO.selecionaUltimoIdSolicitacao();

            SolicitacaoServicoDAO solicitacaoServicoDAO = new SolicitacaoServicoDAO();

            for (String idServico : IdServicosSolicitados) {
                servico = servicoDAO.localizarPorId(Integer.parseInt(idServico));
                solicitacaoServicoDAO.cadastraSolicitacaoServico(solicitacao, servico);
            }

            conexao.commit();

        } catch (SQLException e) {
            throw new RuntimeException("ERRROO: " + e);
        } catch (ParseException ex) {
            Logger.getLogger(ControleSolicitacao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conexao.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        request.getRequestDispatcher("/minha_solicitacao.jsp").forward(request, response);

    }

    private BigDecimal somaValorTotalSolicitacao(String[] IdServicosSolicitados, ServicoDAO servicoDAO) {
        Servico servico;
        BigDecimal valorTotal = BigDecimal.ZERO;
        
        for (String idServico : IdServicosSolicitados) {
            servico = servicoDAO.localizarPorId(Integer.parseInt(idServico));
            valorTotal.add(servico.getValor());
        }
        
        return valorTotal;

    }

//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        
//        
//        int id_cliente = 1;
//
//        Cliente cliente = new Cliente(id_cliente);
//
//        ClienteDAO clienteDAO = new ClienteDAO();
//        cliente = clienteDAO.localizarPorId(cliente.getId());
//
//        /*PEGA OS PARAMETROS DA VIEW*/
//        String porte = request.getParameter("porte");
//        String[] servicos = request.getParameterValues("servico");
//        Date data_solicitacao;
//        Calendar data = GregorianCalendar.getInstance();
//        try {
//            data_solicitacao = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(request.getParameter("data_solicitacao"));            
//            data.setTime(data_solicitacao);
//            
//        } catch (ParseException ex) {
//            Logger.getLogger(ControleSolicitacao.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        double valor = 0;
//
//        Servico servico;
//        ServicoDAO servicoDAO = new ServicoDAO();
//        for (String idServico : servicos) {
//            servico = servicoDAO.localizarPorId(Integer.parseInt(idServico));
//            valor += servico.getValor().doubleValue();
//        }
//
//        BigDecimal valorTotal = new BigDecimal(valor);
//
//        Solicitacao solicitacao = new Solicitacao(cliente, porte, data, valorTotal);
//        SolicitacaoDAO solicitacaoDAO = new SolicitacaoDAO();
//        solicitacaoDAO.cadastrar(solicitacao);
//        solicitacao = solicitacaoDAO.selecionaUltimoIdSolicitacao();
//
//        SolicitacaoServicoDAO solicitacaoServicoDAO = new SolicitacaoServicoDAO();
//
//        for (String idServico : servicos) {
//            servico = servicoDAO.localizarPorId(Integer.parseInt(idServico));
//            solicitacaoServicoDAO.cadastraSolicitacaoServico(solicitacao, servico);
//        }
//
//        request.getRequestDispatcher("/minha_solicitacao.jsp").forward(request, response);
//
//    }
}
