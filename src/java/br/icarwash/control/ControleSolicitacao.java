package br.icarwash.control;

import br.icarwash.control.state.EmAnalise;
import br.icarwash.control.state.SolicitacaoState;
import br.icarwash.dao.*;
import br.icarwash.model.*;
import br.icarwash.model.Endereco.EnderecoBuilder;
import br.icarwash.model.Solicitacao.SolicitacaoBuilder;
import br.icarwash.util.Conexao;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "ControleSolicitacao", urlPatterns = "/ControleSolicitacao")
public class ControleSolicitacao extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conexao = Conexao.getConexao();

        try {
            conexao.setAutoCommit(false);

            HttpSession session = ((HttpServletRequest) request).getSession(true);
            Usuario usuario = (Usuario) session.getAttribute("user");

            ClienteDAO clienteDAO = new ClienteDAO(conexao);
            Cliente cliente = clienteDAO.localizarPorIdUsuario(usuario.getId());
            cliente = clienteDAO.localizarPorId(cliente.getId());

            /*PEGA OS PARAMETROS DA VIEW*/
            String porteVeiculo = request.getParameter("porte");
            String[] IdServicosSolicitados = request.getParameterValues("servico");
            Calendar dataHoraSolicitacao = Calendar.getInstance();

            String[] data = request.getParameter("data_solicitacao").split("/");
            String dataSolicitacao = data[2] + "-" + data[1] + "-" + data[0];

            dataHoraSolicitacao.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(dataSolicitacao + " " + request.getParameter("selectHora")));

            int idEndereco = Integer.parseInt(request.getParameter("endereco"));

            Servico servico;
            ServicoDAO servicoDAO = new ServicoDAO(conexao);

            Solicitacao solicitacao = new SolicitacaoBuilder()
                    .withCliente(cliente)
                    .withSolicitacaoState(new EmAnalise())
                    .withPorte(porteVeiculo)
                    .withDataSolicitacao(dataHoraSolicitacao)
                    .withValorTotal(somaValorTotalSolicitacao(IdServicosSolicitados, servicoDAO))
                    .withEndereco(new EnderecoBuilder().withId(idEndereco).build())
                    .build();

            int idSolicitacao = new SolicitacaoDAO(conexao).cadastrar(solicitacao);

            SolicitacaoServicoDAO solicitacaoServicoDAO = new SolicitacaoServicoDAO(conexao);

            for (String idServico : IdServicosSolicitados) {
                servico = servicoDAO.localizarPorId(Integer.parseInt(idServico));
                solicitacaoServicoDAO.cadastraSolicitacaoServico(idSolicitacao, servico);
            }

            conexao.commit();

        } catch (SQLException e) {
            try {
                conexao.rollback();
                throw new RuntimeException(e);
            } catch (SQLException ex) {
                Logger.getLogger(ControleSolicitacao.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ParseException ex) {
            try {
                conexao.rollback();
                throw new RuntimeException(ex);
            } catch (SQLException ex1) {
                throw new RuntimeException(ex1);
            }
        } finally {
            try {
                conexao.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        //response.sendRedirect("/ICarWash/ListarSolicitacaoCliente");

        PrintWriter out = response.getWriter();
        out.println("/ICarWash/solicitacoes-cliente?ok"); //ListarSolicitacaoCliente
        out.flush();

    }

    private BigDecimal somaValorTotalSolicitacao(String[] IdServicosSolicitados, ServicoDAO servicoDAO) {
        Servico servico;
        double valor = 0;

        for (String idServico : IdServicosSolicitados) {
            servico = servicoDAO.localizarPorId(Integer.parseInt(idServico));
            valor += servico.getValor().doubleValue();
        }
        BigDecimal valorTotal = new BigDecimal(valor);
        return valorTotal;

    }
}
