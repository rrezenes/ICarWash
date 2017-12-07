package br.icarwash.model;

import java.math.BigDecimal;
import java.util.HashMap;

public class Servico {

    private int id;
    private String nome;
    private String descricao;
    private BigDecimal valor;
    private boolean ativo;
    private HashMap<Produto, Integer> produtos;

    public Servico() {
    }

    public Servico(ServicoBuilder builder) {
        this.id = builder.id;
        this.nome = builder.nome;
        this.descricao = builder.descricao;
        this.valor = builder.valor;
        this.ativo = builder.ativo;
        this.produtos = builder.produtos;
    }

    public static class ServicoBuilder {

        private int id;
        private String nome;
        private String descricao;
        private BigDecimal valor;
        private boolean ativo;
        private HashMap<Produto, Integer> produtos;

        public ServicoBuilder from(Servico servico) {
            this.id = servico.id;
            this.nome = servico.nome;
            this.descricao = servico.descricao;
            this.ativo = servico.ativo;
            this.produtos = servico.produtos;
            return this;
        }

        public ServicoBuilder withId(int id) {
            this.id = id;
            return this;
        }

        public ServicoBuilder withNome(String nome) {
            this.nome = nome;
            return this;
        }

        public ServicoBuilder withDescricao(String descricao) {
            this.descricao = descricao;
            return this;
        }

        public ServicoBuilder withValor(BigDecimal valor) {
            this.valor = valor;
            return this;
        }

        public ServicoBuilder withAtivo(boolean ativo) {
            this.ativo = ativo;
            return this;
        }

        public ServicoBuilder withProdutos(HashMap<Produto, Integer> produtos) {
            this.produtos = produtos;
            return this;
        }

        public Servico build() {
            return new Servico(this);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public HashMap<Produto, Integer> getProdutos() {
        return produtos;
    }

    public void setProdutos(HashMap<Produto, Integer> produtos) {
        this.produtos = produtos;
    }

}
