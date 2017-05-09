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
public class Cancelado implements SolicitacaoState {

    @Override
    public SolicitacaoState analisarSolicitacao() {
        return this;
    }

    @Override
    public SolicitacaoState agendarSolicitacao() {
        return this;
    }

    @Override
    public SolicitacaoState processarSolicitacao() {
        return this;
    }

    @Override
    public SolicitacaoState finalizarSolicitacao() {
        return this;
    }

    @Override
    public SolicitacaoState avaliarSolicitacao() {
        return this;
    }

    @Override
    public SolicitacaoState concluirSolicitacao() {
        return this;
    }

    @Override
    public SolicitacaoState cancelarSolicitacao() {
        return this;
    }
    

}
