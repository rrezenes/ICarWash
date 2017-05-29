/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.icarwash.model;

import java.util.Calendar;

/**
 *
 * @author rezen
 */
public class LavadorSolicitacao {
    private int idLavador;
    private int idSolicitacao;
    private Calendar dataSolicitacao;

    public LavadorSolicitacao(int idLavador, int idSolicitacao, Calendar dataSolicitacao) {
        this.idLavador = idLavador;
        this.idSolicitacao = idSolicitacao;
        this.dataSolicitacao = dataSolicitacao;
    }

    public int getIdLavador() {
        return idLavador;
    }

    public void setIdLavador(int idLavador) {
        this.idLavador = idLavador;
    }

    public int getIdSolicitacao() {
        return idSolicitacao;
    }

    public void setIdSolicitacao(int idSolicitacao) {
        this.idSolicitacao = idSolicitacao;
    }

    public Calendar getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(Calendar dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }
    
    
    
}
