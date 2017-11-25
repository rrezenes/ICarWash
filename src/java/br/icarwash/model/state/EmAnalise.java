package br.icarwash.model.state;

import br.icarwash.dao.SolicitacaoDAO;
import br.icarwash.model.Avaliacao;
import br.icarwash.model.Solicitacao;
import br.icarwash.util.Conexao;
import br.icarwash.util.email.EmailStatusSolicitacao;

public class EmAnalise implements SolicitacaoState {

    @Override
    public SolicitacaoState analisarSolicitacao(Solicitacao solicitacao) {
        solicitacao.atribuirLavador();

        String emailCliente = solicitacao.getCliente().getUsuario().getEmail();
        String nomeCliente = solicitacao.getCliente().getNome();
        solicitacao.setEstado(new Agendado());
        new EmailStatusSolicitacao(nomeCliente, emailCliente, solicitacao).enviar();

        return new Agendado();
    }

    @Override
    public SolicitacaoState agendarSolicitacao(Solicitacao solicitacao) {
        return this;
    }

    @Override
    public SolicitacaoState processarSolicitacao(Solicitacao solicitacao) {
        return this;
    }

    @Override
    public SolicitacaoState finalizarSolicitacao(Solicitacao solicitacao) {
        return this;
    }

    @Override
    public SolicitacaoState avaliarSolicitacao(Solicitacao solicitacao, Avaliacao avaliacao) {
        return this;
    }

    @Override
    public SolicitacaoState concluirSolicitacao(Solicitacao solicitacao) {
        return this;
    }

    @Override
    public SolicitacaoState cancelarSolicitacao(Solicitacao solicitacao) {
        new SolicitacaoDAO(Conexao.getConexao()).cancelarSolicitacaoPorId(solicitacao.getId());
        return new Cancelado();
    }

    @Override
    public String toString() {
        return "Em Analise";
    }
}
