/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.icarwash.model;

/**
 *
 * @author rezen
 */
public interface SolicitacaoState {

    SolicitacaoState analisarSolicitacao();

    SolicitacaoState agendarSolicitacao();

    SolicitacaoState processarSolicitacao();

    SolicitacaoState finalizarSolicitacao();

    SolicitacaoState avaliarSolicitacao();

    SolicitacaoState concluirSolicitacao();

    SolicitacaoState cancelarSolicitacao();
}
