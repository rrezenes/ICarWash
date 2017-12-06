package br.icarwash.control;

import br.icarwash.dao.ClienteDAO;
import br.icarwash.dao.SolicitacaoDAO;
import br.icarwash.model.Cliente;
import br.icarwash.model.Cliente.ClienteBuilder;
import br.icarwash.model.Solicitacao;
import br.icarwash.model.Solicitacao.SolicitacaoBuilder;
import br.icarwash.model.Usuario;
import br.icarwash.model.state.Avaliado;
import br.icarwash.model.state.Finalizado;
import br.icarwash.model.state.SolicitacaoState;
import java.io.IOException;
import java.sql.Connection;
import java.time.Instant;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang3.time.DateUtils;

@WebServlet(name = "ControleDashboard", urlPatterns = {"/Dashboard", "/dashboard"})
public class ControleDashboard extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = ((HttpServletRequest) request).getSession(true);
        Usuario usuario = (Usuario) session.getAttribute("user");

        switch (usuario.getNivel()) {
            case 1:
                carregarDashboardCliente(request, response);
                break;
            case 2:
                carregarDashboardLavador(request, response);
                break;
            case 3:
                carregarDashboardAdmin(request, response);
                break;
        }

    }

    private void carregarDashboardAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HashMap<String, Integer> qtdPorStatusSolicitacao = geraMapaSolicitacaoQuantidadePorStatus(request);
        HashMap<String, Integer> qtdPorStatusSolicitacaoHoje = gerarMapaSolicitacaoQuantidadePorStatusHoje(request);
        HashMap<String, Integer> qtdPorStatusSolicitacaoMes = gerarMapaSolicitacaoQuantidadePorStatusMes(request);

        request.setAttribute("qtdPorStatusSolicitacao", qtdPorStatusSolicitacao);
        request.setAttribute("qtdPorStatusSolicitacaoHoje", qtdPorStatusSolicitacaoHoje);
        request.setAttribute("qtdPorStatusSolicitacaoMes", qtdPorStatusSolicitacaoMes);

        RequestDispatcher rd = request.getRequestDispatcher("/painel_admin.jsp");
        rd.forward(request, response);
    }

    private HashMap<String, Integer> geraMapaSolicitacaoQuantidadePorStatus(HttpServletRequest request) {
        Connection conexao = (Connection) request.getAttribute("conexao");

        HashMap<String, Integer> estadosSolicitacoes = new HashMap<>();

        SolicitacaoDAO solicitacaoDAO = new SolicitacaoDAO(conexao);

        final int quantidadeTotal = solicitacaoDAO.listar().size();
        final int quantidadeAgendado = solicitacaoDAO.listarAgendado().size();
        final int quantidadeAvaliado = solicitacaoDAO.listarAvaliado().size();
        final int quantidadeCancelado = solicitacaoDAO.listarCancelado().size();
        final int quantidadeEmAnalise = solicitacaoDAO.listarEmAnalise().size();
        final int quantidadeEmProcesso = solicitacaoDAO.listarEmProcesso().size();
        final int quantidadeFinalizado = solicitacaoDAO.listarFinalizado().size();

        estadosSolicitacoes.put("totalSolicitacao", quantidadeTotal);
        estadosSolicitacoes.put("agendado", quantidadeAgendado);
        estadosSolicitacoes.put("avaliado", quantidadeAvaliado);
        estadosSolicitacoes.put("cancelado", quantidadeCancelado);
        estadosSolicitacoes.put("emAnalise", quantidadeEmAnalise);
        estadosSolicitacoes.put("emProcesso", quantidadeEmProcesso);
        estadosSolicitacoes.put("finalizado", quantidadeFinalizado);
        return estadosSolicitacoes;

    }

    private HashMap<String, Integer> gerarMapaSolicitacaoQuantidadePorStatusHoje(HttpServletRequest request) {
        Connection conexao = (Connection) request.getAttribute("conexao");

        HashMap<String, Integer> estadosSolicitacoesHoje = new HashMap<>();

        SolicitacaoDAO solicitacaoDAO = new SolicitacaoDAO(conexao);

        ArrayList<Solicitacao> solicitacoesAgendado = solicitacaoDAO.listarAgendado();
        ArrayList<Solicitacao> solicitacoesAvaliado = solicitacaoDAO.listarAvaliado();
        ArrayList<Solicitacao> solicitacoesCancelado = solicitacaoDAO.listarCancelado();
        ArrayList<Solicitacao> solicitacoesEmAnalise = solicitacaoDAO.listarEmAnalise();
        ArrayList<Solicitacao> solicitacoesEmProcesso = solicitacaoDAO.listarEmProcesso();
        ArrayList<Solicitacao> solicitacoesFinalizado = solicitacaoDAO.listarFinalizado();

        manterSolicitacaoHoje(solicitacoesAgendado);
        manterSolicitacaoHoje(solicitacoesAvaliado);
        manterSolicitacaoHoje(solicitacoesCancelado);
        manterSolicitacaoHoje(solicitacoesEmAnalise);
        manterSolicitacaoHoje(solicitacoesEmProcesso);
        manterSolicitacaoHoje(solicitacoesFinalizado);

        estadosSolicitacoesHoje.put("agendado", solicitacoesAgendado.size());
        estadosSolicitacoesHoje.put("avaliado", solicitacoesAvaliado.size());
        estadosSolicitacoesHoje.put("cancelado", solicitacoesCancelado.size());
        estadosSolicitacoesHoje.put("emAnalise", solicitacoesEmAnalise.size());
        estadosSolicitacoesHoje.put("emProcesso", solicitacoesEmProcesso.size());
        estadosSolicitacoesHoje.put("finalizado", solicitacoesFinalizado.size());
        return estadosSolicitacoesHoje;

    }

    private void manterSolicitacaoHoje(ArrayList<Solicitacao> solicitacoes) {
        Calendar calendarHoje = Calendar.getInstance();
        for (Iterator<Solicitacao> i = solicitacoes.iterator(); i.hasNext();) {
            Solicitacao solicitacao = i.next();
            if (!DateUtils.isSameDay(calendarHoje, solicitacao.getDataSolicitacao())) {
                i.remove();
            }
        }
    }

    private HashMap<String, Integer> gerarMapaSolicitacaoQuantidadePorStatusMes(HttpServletRequest request) {
        Connection conexao = (Connection) request.getAttribute("conexao");

        HashMap<String, Integer> estadosSolicitacoesMes = new HashMap<>();

        SolicitacaoDAO solicitacaoDAO = new SolicitacaoDAO(conexao);

        ArrayList<Solicitacao> solicitacoesAgendado = solicitacaoDAO.listarAgendado();
        ArrayList<Solicitacao> solicitacoesAvaliado = solicitacaoDAO.listarAvaliado();
        ArrayList<Solicitacao> solicitacoesCancelado = solicitacaoDAO.listarCancelado();
        ArrayList<Solicitacao> solicitacoesEmAnalise = solicitacaoDAO.listarEmAnalise();
        ArrayList<Solicitacao> solicitacoesEmProcesso = solicitacaoDAO.listarEmProcesso();
        ArrayList<Solicitacao> solicitacoesFinalizado = solicitacaoDAO.listarFinalizado();

        manterSolicitacaoMesAtual(solicitacoesAgendado);
        manterSolicitacaoMesAtual(solicitacoesAvaliado);
        manterSolicitacaoMesAtual(solicitacoesCancelado);
        manterSolicitacaoMesAtual(solicitacoesEmAnalise);
        manterSolicitacaoMesAtual(solicitacoesEmProcesso);
        manterSolicitacaoMesAtual(solicitacoesFinalizado);

        estadosSolicitacoesMes.put("agendado", solicitacoesAgendado.size());
        estadosSolicitacoesMes.put("avaliado", solicitacoesAvaliado.size());
        estadosSolicitacoesMes.put("cancelado", solicitacoesCancelado.size());
        estadosSolicitacoesMes.put("emAnalise", solicitacoesEmAnalise.size());
        estadosSolicitacoesMes.put("emProcesso", solicitacoesEmProcesso.size());
        estadosSolicitacoesMes.put("finalizado", solicitacoesFinalizado.size());
        return estadosSolicitacoesMes;
    }

    private void manterSolicitacaoMesAtual(ArrayList<Solicitacao> solicitacoes) {
        Calendar calendarHoje = Calendar.getInstance();
        Instant i1 = calendarHoje.toInstant();
        ZoneId zoneId = ZoneId.of("America/Montreal");

        ZonedDateTime zdt1 = ZonedDateTime.ofInstant(i1, zoneId);
        YearMonth ym1 = YearMonth.from(zdt1);

        for (Iterator<Solicitacao> i = solicitacoes.iterator(); i.hasNext();) {
            Solicitacao solicitacao = i.next();

            Instant i2 = solicitacao.getDataSolicitacao().toInstant();
            ZonedDateTime zdt2 = ZonedDateTime.ofInstant(i2, zoneId);
            YearMonth ym2 = YearMonth.from(zdt2);

            if (!ym1.equals(ym2)) {
                i.remove();
            }
        }
    }

    private void carregarDashboardCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conexao = (Connection) request.getAttribute("conexao");

        HttpSession session = ((HttpServletRequest) request).getSession(true);
        Usuario usuario = (Usuario) session.getAttribute("user");

        Cliente cliente = new ClienteBuilder()
                .withUsuario(usuario)
                .build();
        cliente = new ClienteDAO(conexao).localizarPorIdUsuario(cliente);

        SolicitacaoDAO solicitacaoDAO = new SolicitacaoDAO(conexao);

        Solicitacao solicitacao = new SolicitacaoBuilder()
                .withCliente(cliente)
                .build();

        ArrayList<Solicitacao> solicitacoes = solicitacaoDAO.listarSolicitacaoPorIDCliente(solicitacao);

        filtrarSomenteSolicitacoesAvaliadasOuFinalizadas(solicitacoes);

        request.setAttribute("qtdTotalDeAguaEconomizado", solicitacoes.size() * 300);

        RequestDispatcher rd = request.getRequestDispatcher("/painel_cliente.jsp");
        rd.forward(request, response);

    }

    private void filtrarSomenteSolicitacoesAvaliadasOuFinalizadas(ArrayList<Solicitacao> solicitacoes) {
        for (Iterator<Solicitacao> i = solicitacoes.iterator(); i.hasNext();) {
            Solicitacao soli = i.next();
            SolicitacaoState solicitacaoState = soli.getEstado();
            String estado = solicitacaoState.toString();
            switch (estado) {
                case "Em Analise":
                    i.remove();
                    break;
                case "Aprovado":
                    i.remove();
                    break;
                case "Em Processo":
                    i.remove();
                    break;
                case "Agendado":
                    i.remove();
                    break;
                case "Cancelado":
                    i.remove();
                    break;
            }
        }
    }

    private void carregarDashboardLavador(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher rd = request.getRequestDispatcher("/painel_lavador.jsp");
        rd.forward(request, response);
    }

}
