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
    protected SolicitacaoState estado;
    private int id;
    private Status status;
    private Cliente cliente;
    private Servico servico;
    private Lavador lavador;
    private int avaliacao;
    private Porte porte;

    public Solicitacao(int id) {
        this.id = id;
    }

    public Solicitacao(int id, Status status, Cliente cliente, Servico servico, Lavador lavador, int avaliacao, Porte porte) {
        this.id = id;
        this.status = status;
        this.cliente = cliente;
        this.servico = servico;
        this.lavador = lavador;
        this.avaliacao = avaliacao;
        this.porte = porte;
        this.estado = new EmAnalise();
    }

    public Solicitacao(Status status, Cliente cliente, Servico servico, Porte porte) {
        this.status = status;
        this.cliente = cliente;
        this.servico = servico;
        this.porte = porte;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
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

    public int getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(int avaliacao) {
        this.avaliacao = avaliacao;
    }

    public Porte getPorte() {
        return porte;
    }

    public void setPorte(Porte porte) {
        this.porte = porte;
    }
    
    public void agendar(){
        this.estado = new Agendado();
    }
    
    public void processar(){
        this.estado = new EmProcesso();
    }
    
    public void finalizar(){
        this.estado = new Finalizado();
    }
    
    public void avaliar(){
        this.estado = new Avaliado();
    }
    
    public void concluir(){
        this.estado = new Concluido();
    }
    
    public void cancelar(){
        this.estado = new Cancelado();
    }
}
