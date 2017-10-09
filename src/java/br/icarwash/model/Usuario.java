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
public class Usuario {

    private int id;
    private String email;
    private String senha;
    private int nivel;
    private boolean ativo;
    private Calendar cadastro;
    private boolean cadastroCompleto;

    public Usuario(String email, String senha, int nivel, boolean ativo) {
        this.email = email;
        this.senha = senha;
        this.nivel = nivel;
        this.ativo = ativo;
    }

    
    
    public Usuario(int id, String email, int nivel, boolean ativo, Calendar cadastro, boolean cadastroCompleto) {
        this.id = id;
        this.email = email;
        this.nivel = nivel;
        this.ativo = ativo;
        this.cadastro = cadastro;
        this.cadastroCompleto = cadastroCompleto;
    }

    public Usuario(int id, String email, String senha, int nivel, boolean ativo) {
        this.id = id;
        this.email = email;
        this.senha = senha;
        this.nivel = nivel;
        this.ativo = ativo;
    }

    public Usuario(int id) {
        this.id = id;
    }

    public Usuario(String senha, int nivel, boolean ativo) {
        this.senha = senha;
        this.nivel = nivel;
        this.ativo = ativo;
    }

    public Usuario(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public Usuario(int id, String senha, int nivel, boolean ativo) {
        this.id = id;
        this.senha = senha;
        this.nivel = nivel;
        this.ativo = ativo;
    }

    public Usuario() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getNivel() {
        return nivel;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Calendar getCadastro() {
        return cadastro;
    }

    public void setCadastro(Calendar cadastro) {
        this.cadastro = cadastro;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public boolean isCadastroCompleto() {
        return cadastroCompleto;
    }

    public void setCadastroCompleto(boolean cadastroCompleto) {
        this.cadastroCompleto = cadastroCompleto;
    }

}
