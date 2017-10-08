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
public class Lavador extends Pessoa {

    private int id;
    private Calendar dataContrato = Calendar.getInstance();

    public Lavador(int id, String nome, String telefone, Calendar dtNascimento, Endereco endereco) {
        super(nome, telefone, dtNascimento, endereco);
        this.id = id;
    }

    public Lavador(int id, Calendar dtContrato, String nome, String telefone, Calendar dtNascimento, String CPF, Endereco endereco) {
        super(nome, telefone, dtNascimento, CPF, endereco);
        this.id = id;
        this.dataContrato = dtContrato;
    }

    public Lavador(Calendar dtContrato, String nome, String telefone, Calendar dtNascimento, String CPF, Endereco endereco) {
        super(nome, telefone, dtNascimento, CPF, endereco);
        this.dataContrato = dtContrato;
    }

    public Lavador(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Calendar getDataContrato() {
        return dataContrato;
    }

    public void setDataContrato(Calendar dataContrato) {
        this.dataContrato = dataContrato;
    }

}
