package br.icarwash.model.state;

import br.icarwash.dao.AvaliacaoDAO;
import br.icarwash.dao.SolicitacaoDAO;
import br.icarwash.model.Avaliacao;
import br.icarwash.model.Solicitacao;
import br.icarwash.util.Conexao;
import java.sql.Connection;

public class Finalizado implements SolicitacaoState {

    @Override
    public SolicitacaoState analisarSolicitacao(Solicitacao solicitacao) {
        return this;
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

        AvaliacaoDAO avaliacaoDAO = new AvaliacaoDAO(Conexao.getConexao());
        
        avaliacao.setId(avaliacaoDAO.atribuirNotas(avaliacao));
        avaliacao.calcularMedia();
        
        new SolicitacaoDAO(Conexao.getConexao()).avaliarSolicitacao(solicitacao, avaliacao);

        return new Avaliado();
    }

    @Override
    public SolicitacaoState concluirSolicitacao(Solicitacao solicitacao) {
        return this;
    }

    @Override
    public SolicitacaoState cancelarSolicitacao(Solicitacao solicitacao) {
        return this;
    }

    @Override
    public String toString() {
        return "Finalizado";
    }

}
