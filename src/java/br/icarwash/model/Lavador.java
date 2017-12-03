package br.icarwash.model;

import java.util.Calendar;

public final class Lavador extends Pessoa {

    private int id;
    private Calendar dataContrato = Calendar.getInstance();
    private Usuario usuario;
    private boolean ocupado = false;
    Endereco endereco;

    protected Lavador() {
    }

    public static final class LavadorBuilder extends Pessoa.PessoaBuilder<Lavador, LavadorBuilder> {

        private int id;
        private Usuario usuario;
        private Calendar dataContrato = Calendar.getInstance();
        private boolean ocupado = false;
        Endereco endereco;

        public LavadorBuilder from(Lavador lavador) {
            this.id = lavador.id;
            this.usuario = lavador.usuario;
            this.dataContrato = lavador.dataContrato;
            this.ocupado = lavador.ocupado;
            this.endereco = lavador.endereco;
            return this;
        }

        public LavadorBuilder withId(int id) {
            object.id = id;
            return this;
        }

        public LavadorBuilder withUsuario(Usuario usuario) {
            object.usuario = usuario;
            return this;
        }

        public LavadorBuilder withDataContrato(Calendar dataContrato) {
            object.dataContrato = dataContrato;
            return this;
        }

        public LavadorBuilder withOcupado(boolean ocupado) {
            object.ocupado = ocupado;
            return this;
        }

        public LavadorBuilder withEndereco(Endereco endereco) {
            object.endereco = endereco;
            return this;
        }

        @Override
        protected Lavador getObject() {
            return new Lavador();
        }

        @Override
        protected LavadorBuilder thisObject() {
            return this;
        }

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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

}
