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
    private String usuario;
    private String senha;
    private int nivel;
    private boolean ativo;
    private Calendar cadastro = Calendar.getInstance();

    public Usuario(String email, String usuario, String senha, int nivel, boolean ativo) {
       
        this.email = email;
        this.usuario = usuario;
        this.senha = senha;
        this.nivel = nivel;
        this.ativo = ativo;
    }

    public Usuario(int id, String email, String usuario, String senha, int nivel, boolean ativo) {
        this.id = id;
        this.email = email;
        this.usuario = usuario;
        this.senha = senha;
        this.nivel = nivel;
        this.ativo = ativo;
    }

    public Usuario(int id) {
        this.id = id;
    }

    public Usuario(String usuario, String senha, int nivel, boolean ativo) {
        this.usuario = usuario;
        this.senha = senha;
        this.nivel = nivel;
        this.ativo = ativo;
    }

    public Usuario(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }

    public Usuario(int id, String usuario, String senha, int nivel, boolean ativo) {
        this.id = id;
        this.usuario = usuario;
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
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

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

}
