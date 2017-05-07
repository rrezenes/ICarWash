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
public class Avaliacao {

    private int ID;
    private int nota_pontualidade;
    private int nota_servico;
    private int nota_atendimento;
    private int nota_agilidade;
    private int nota_media;

    public Avaliacao(int ID) {
        this.ID = ID;
        this.nota_pontualidade = 0;
        this.nota_servico = 0;
        this.nota_atendimento = 0;
        this.nota_agilidade = 0;
        this.nota_media = 0;
    }

    public Avaliacao(int ID, int nota_pontualidade, int nota_servico, int nota_atendimento, int nota_agilidade, int nota_media) {
        this.ID = ID;
        this.nota_pontualidade = nota_pontualidade;
        this.nota_servico = nota_servico;
        this.nota_atendimento = nota_atendimento;
        this.nota_agilidade = nota_agilidade;
        this.nota_media = nota_media;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getNota_pontualidade() {
        return nota_pontualidade;
    }

    public void setNota_pontualidade(int nota_pontualidade) {
        this.nota_pontualidade = nota_pontualidade;
    }

    public int getNota_servico() {
        return nota_servico;
    }

    public void setNota_servico(int nota_servico) {
        this.nota_servico = nota_servico;
    }

    public int getNota_atendimento() {
        return nota_atendimento;
    }

    public void setNota_atendimento(int nota_atendimento) {
        this.nota_atendimento = nota_atendimento;
    }

    public int getNota_agilidade() {
        return nota_agilidade;
    }

    public void setNota_agilidade(int nota_agilidade) {
        this.nota_agilidade = nota_agilidade;
    }

    public int getNota_media() {
        return nota_media;
    }

    public void setNota_media(int nota_media) {
        this.nota_media = nota_media;
    }

}
