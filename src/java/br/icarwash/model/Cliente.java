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
public class Cliente extends Pessoa {

    private int id;

    public Cliente(int id) {
        this.id = id;
    }

    public Cliente(String email, String nome, String telefone, Calendar dtNascimento, String CPF, Endereco endereco) {
        super(email, nome, telefone, dtNascimento, CPF, endereco);
    }

    public Cliente(int id, String email, String nome, String telefone, Calendar dtNascimento, String CPF, Endereco endereco) {
        super(email, nome, telefone, dtNascimento, CPF, endereco);
        this.id = id;
    }

    public Cliente() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void finalizarSolicitacao() {

    }

}
