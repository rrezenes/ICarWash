/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.icarwash.control.state;

import br.icarwash.model.Avaliacao;
import br.icarwash.model.Solicitacao;

/**
 *
 * @author rezen
 */
public interface SolicitacaoState {

    SolicitacaoState analisarSolicitacao(Solicitacao solicitacao);

    SolicitacaoState agendarSolicitacao(Solicitacao solicitacao);

    SolicitacaoState processarSolicitacao(Solicitacao solicitacao);

    SolicitacaoState finalizarSolicitacao(Solicitacao solicitacao);

    SolicitacaoState avaliarSolicitacao(Solicitacao solicitacao, Avaliacao avaliacao);

    SolicitacaoState concluirSolicitacao(Solicitacao solicitacao);

    SolicitacaoState cancelarSolicitacao(Solicitacao solicitacao);

}
