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
public class Pessoa {

    private String email;
    private String nome;
    private String telefone;
    private Calendar dtNascimento = Calendar.getInstance();
    private String CPF;
    private Endereco endereco;

    public Pessoa(String email, String nome, String telefone, Calendar dtNascimento, Endereco endereco) {
        this.email = email;
        this.nome = nome;
        this.telefone = telefone;
        this.dtNascimento = dtNascimento;
        this.endereco = endereco;
    }

    public Pessoa(String email, String nome, String telefone, Calendar dtNascimento, String CPF, Endereco endereco) {
        this.email = email;
        this.nome = nome;
        this.telefone = telefone;
        this.dtNascimento = dtNascimento;
        this.CPF = CPF;
        this.endereco = endereco;
    }

    public Pessoa() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Calendar getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(Calendar dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Calendar getDataNascimento() {
        return dtNascimento;
    }

    public void setDataNascimento(Calendar dt) {
        this.dtNascimento = dt;
    }

}
