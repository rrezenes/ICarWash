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
public class Avalicacao {
    private int notaPontualidade;
    private int notaServico;
    private int notaAtendimento;
    private int notaAgilidade;
    private int notaMedia;

    public Avalicacao(int notaPontualidade, int notaServico, int notaAtendimento, int notaAgilidade, int notaMedia) {
        this.notaPontualidade = notaPontualidade;
        this.notaServico = notaServico;
        this.notaAtendimento = notaAtendimento;
        this.notaAgilidade = notaAgilidade;
        this.notaMedia = notaMedia;
    }

    public int getNotaPontualidade() {
        return notaPontualidade;
    }

    public void setNotaPontualidade(int notaPontualidade) {
        this.notaPontualidade = notaPontualidade;
    }

    public int getNotaServico() {
        return notaServico;
    }

    public void setNotaServico(int notaServico) {
        this.notaServico = notaServico;
    }

    public int getNotaAtendimento() {
        return notaAtendimento;
    }

    public void setNotaAtendimento(int notaAtendimento) {
        this.notaAtendimento = notaAtendimento;
    }

    public int getNotaAgilidade() {
        return notaAgilidade;
    }

    public void setNotaAgilidade(int notaAgilidade) {
        this.notaAgilidade = notaAgilidade;
    }

    public int getNotaMedia() {
        return notaMedia;
    }

    public void setNotaMedia(int notaMedia) {
        this.notaMedia = notaMedia;
    }
    
}
