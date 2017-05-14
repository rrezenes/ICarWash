/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.icarwash.state;

import br.icarwash.dao.SolicitacaoDAO;
import br.icarwash.model.Cliente;
import br.icarwash.model.Solicitacao;
import br.icarwash.model.Status;

/**
 *
 * @author rezen
 */
public class EmAnalise implements SolicitacaoState {
    
    @Override
    public SolicitacaoState analisarSolicitacao(Solicitacao solicitacao) {
        SolicitacaoDAO solicitacaoDAO = new SolicitacaoDAO();
        solicitacaoDAO.alterarStatus(Status.AGENDADO);
        return this;
    }

    @Override
    public SolicitacaoState agendarSolicitacao(Solicitacao solicitacao) {
        return new Agendado();
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
    public SolicitacaoState avaliarSolicitacao(Solicitacao solicitacao) {
        return this;
    }

    @Override
    public SolicitacaoState concluirSolicitacao(Solicitacao solicitacao) {
        return this;
    }

    @Override
    public SolicitacaoState cancelarSolicitacao(Solicitacao solicitacao) {
        return new Cancelado();
    }

}
