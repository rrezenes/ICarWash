package br.icarwash.model;

import java.util.Calendar;

public class Usuario {

    private int id;
    private String email;
    private String senha;
    private int nivel;
    private boolean ativo;
    private Calendar dataCadastro;
    private boolean cadastroCompleto;

    public Usuario() {
    }

    public Usuario(UsuarioBuilder builder) {
        this.id = builder.id;
        this.email = builder.email;
        this.senha = builder.senha;
        this.nivel = builder.nivel;
        this.ativo = builder.ativo;
        this.dataCadastro = builder.dataCadastro;
        this.cadastroCompleto = builder.cadastroCompleto;
    }

    public static class UsuarioBuilder {

        private int id;
        private String email;
        private String senha;
        private int nivel;
        private boolean ativo;
        private Calendar dataCadastro;
        private boolean cadastroCompleto;

        public UsuarioBuilder from(Usuario usuario) {
            this.id = usuario.id;
            this.email = usuario.email;
            this.senha = usuario.senha;
            this.nivel = usuario.nivel;
            this.ativo = usuario.ativo;
            this.dataCadastro = usuario.dataCadastro;
            this.cadastroCompleto = usuario.cadastroCompleto;
            return this;
        }

        public UsuarioBuilder withId(int id) {
            this.id = id;
            return this;
        }

        public UsuarioBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public UsuarioBuilder withSenha(String senha) {
            this.senha = senha;
            return this;
        }

        public UsuarioBuilder withNivel(int nivel) {
            this.nivel = nivel;
            return this;
        }

        public UsuarioBuilder withAtivo(boolean ativo) {
            this.ativo = ativo;
            return this;
        }

        public UsuarioBuilder withDataCadastro(Calendar dataCadastro) {
            this.dataCadastro = dataCadastro;
            return this;
        }

        public UsuarioBuilder withCadastroCompleto(boolean cadastroCompleto) {
            this.cadastroCompleto = cadastroCompleto;
            return this;
        }

        public Usuario build() {
            return new Usuario(this);
        }
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

    public Calendar getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Calendar dataCadastro) {
        this.dataCadastro = dataCadastro;
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
