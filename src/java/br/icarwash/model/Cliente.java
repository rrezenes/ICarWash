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
    private int idUsuario;

    public Cliente(int id) {
        this.id = id;
    }

    public Cliente(int id, String nome, Endereco endereco) {
        super(nome, endereco);
        this.id = id;
    }

    public Cliente(int id, String nome, String telefone, Calendar dtNascimento, Endereco endereco) {
        super(nome, telefone, dtNascimento, endereco);
        this.id = id;
    }

    public Cliente(String nome, String telefone, Calendar dtNascimento, String CPF, Endereco endereco) {
        super(nome, telefone, dtNascimento, CPF, endereco);
    }

    public Cliente(int id, int idUsuario, String nome, String telefone, Calendar dtNascimento, String CPF, Endereco endereco) {
        super(nome, telefone, dtNascimento, CPF, endereco);
        this.id = id;
        this.idUsuario = idUsuario;
    }

    public Cliente() {

    }

    public Cliente(int id, String nome) {
        super(nome);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

}
