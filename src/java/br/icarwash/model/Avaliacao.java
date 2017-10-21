/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.icarwash.model;

import java.math.BigDecimal;

/**
 *
 * @author rezen
 */
public class Avaliacao {

    private int ID;
    private BigDecimal notaPontualidade;
    private BigDecimal notaServico;
    private BigDecimal notaAtendimento;
    private BigDecimal notaAgilidade;
    private BigDecimal notaMedia;

    public Avaliacao(int ID) {
        this.ID = ID;
    }
    
    public Avaliacao(BigDecimal notaPontualidade, BigDecimal notaServico, BigDecimal notaAtendimento, BigDecimal notaAgilidade) {
        this.notaPontualidade = notaPontualidade;
        this.notaServico = notaServico;
        this.notaAtendimento = notaAtendimento;
        this.notaAgilidade = notaAgilidade;
        this.notaMedia = this.calcularMedia();
    }

    public Avaliacao(int ID, BigDecimal notaPontualidade, BigDecimal notaServico, BigDecimal notaAtendimento, BigDecimal notaAgilidade, BigDecimal notaMedia) {
        this.ID = ID;
        this.notaPontualidade = notaPontualidade;
        this.notaServico = notaServico;
        this.notaAtendimento = notaAtendimento;
        this.notaAgilidade = notaAgilidade;
        this.notaMedia = notaMedia;
    }
    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public BigDecimal getNotaPontualidade() {
        return notaPontualidade;
    }

    public void setNotaPontualidade(BigDecimal notaPontualidade) {
        this.notaPontualidade = notaPontualidade;
    }

    public BigDecimal getNotaServico() {
        return notaServico;
    }

    public void setNotaServico(BigDecimal notaServico) {
        this.notaServico = notaServico;
    }

    public BigDecimal getNotaAtendimento() {
        return notaAtendimento;
    }

    public void setNotaAtendimento(BigDecimal notaAtendimento) {
        this.notaAtendimento = notaAtendimento;
    }

    public BigDecimal getNotaAgilidade() {
        return notaAgilidade;
    }

    public void setNotaAgilidade(BigDecimal notaAgilidade) {
        this.notaAgilidade = notaAgilidade;
    }

    public BigDecimal getNotaMedia() {
        return notaMedia;
    }

    public void setNotaMedia(BigDecimal notaMedia) {
        this.notaMedia = notaMedia;
    }

    public BigDecimal calcularMedia(){
        notaMedia = notaPontualidade.add(notaServico.add(notaAtendimento.add(notaAgilidade)));
        return this.notaMedia = this.notaMedia.divide(BigDecimal.valueOf(4));
    }
    
}
