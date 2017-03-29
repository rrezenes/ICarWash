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
public class Solicitacao {
    private int os;
    private boolean status;
    private Cliente cliente;
    private Servico servico;
    private Lavador lavador;
    private Avalicacao avaliacao;

    public Solicitacao(int os, boolean status, Cliente cliente, Servico servico, Lavador lavador, Avalicacao avaliacao) {
        this.os = os;
        this.status = status;
        this.cliente = cliente;
        this.servico = servico;
        this.lavador = lavador;
        this.avaliacao = avaliacao;
    }

    public int getOs() {
        return os;
    }

    public void setOs(int os) {
        this.os = os;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public Lavador getLavador() {
        return lavador;
    }

    public void setLavador(Lavador lavador) {
        this.lavador = lavador;
    }

    public Avalicacao getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Avalicacao avaliacao) {
        this.avaliacao = avaliacao;
    }
    
    
    
}
