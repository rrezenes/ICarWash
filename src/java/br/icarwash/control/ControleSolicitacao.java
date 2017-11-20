package br.icarwash.control;

import br.icarwash.model.state.EmAnalise;
import br.icarwash.dao.*;
import br.icarwash.model.*;
import br.icarwash.model.Endereco.EnderecoBuilder;
import br.icarwash.model.Solicitacao.SolicitacaoBuilder;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "ControleSolicitacao", urlPatterns = "/ControleSolicitacao")
public class ControleSolicitacao extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Calendar dataHoraSolicitacao = Calendar.getInstance();
        
        Connection conexao = (Connection) request.getAttribute("conexao");

        try {
            

            HttpSession session = ((HttpServletRequest) request).getSession(true);
            Usuario usuario = (Usuario) session.getAttribute("user");

            ClienteDAO clienteDAO = new ClienteDAO(conexao);
            Cliente cliente = clienteDAO.localizarPorIdUsuario(usuario.getId());
            cliente = clienteDAO.localizarPorId(cliente.getId());

            /*PEGA OS PARAMETROS DA VIEW*/
            String[] IdServicosSolicitados = request.getParameterValues("servico");

            String[] data = request.getParameter("data_solicitacao").split("/");
            String dataSolicitacao = data[2] + "-" + data[1] + "-" + data[0];
            dataHoraSolicitacao.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(dataSolicitacao + " " + request.getParameter("selectHora")));

            Endereco endereco;

            if (Boolean.parseBoolean(request.getParameter("cadastraEndereco"))) {

                endereco = new EnderecoBuilder()
                        .withUsuario(usuario)
                        .withCep(request.getParameter("cep"))
                        .withEstado(request.getParameter("estado"))
                        .withCidade(request.getParameter("cidade"))
                        .withBairro(request.getParameter("bairro"))
                        .withEndereco(request.getParameter("endereco"))
                        .withNumero(Integer.parseInt(request.getParameter("numero")))
                        .withNome(request.getParameter("nomeEndereco"))
                        .build();

                int idEndereco = new EnderecoDAO(conexao).cadastrar(endereco);
                endereco.setId(idEndereco);

            } else {
                int idEndereco = Integer.parseInt(request.getParameter("endereco"));
                endereco = new EnderecoBuilder().withId(idEndereco).build();
            }

            Servico servico;
            ServicoDAO servicoDAO = new ServicoDAO(conexao);

            Solicitacao solicitacao = new SolicitacaoBuilder()
                    .withCliente(cliente)
                    .withSolicitacaoState(new EmAnalise())
                    .withPorte(request.getParameter("porte"))
                    .withDataSolicitacao(dataHoraSolicitacao)
                    .withValorTotal(somaValorTotalSolicitacao(IdServicosSolicitados, servicoDAO))
                    .withEndereco(endereco)
                    .build();

            int idSolicitacao = new SolicitacaoDAO(conexao).cadastrar(solicitacao);

            SolicitacaoServicoDAO solicitacaoServicoDAO = new SolicitacaoServicoDAO(conexao);

            for (String idServico : IdServicosSolicitados) {
                servico = servicoDAO.localizarPorId(Integer.parseInt(idServico));
                solicitacaoServicoDAO.cadastraSolicitacaoServico(idSolicitacao, servico.getId());
            }

        } catch (ParseException ex) {
            try {
                conexao.rollback();
                throw new RuntimeException(ex);
            } catch (SQLException ex1) {
                throw new RuntimeException(ex1);
            }
        }

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
