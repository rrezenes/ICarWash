package br.icarwash.model;

import java.util.Calendar;

public final class Lavador extends Pessoa {

    private int id;
    private Calendar dataContrato = Calendar.getInstance();
    private int idUsuario;
    private boolean ocupado = false;

    protected Lavador() {
    }

    public static final class LavadorBuilder extends Pessoa.PessoaBuilder<Lavador, LavadorBuilder> {

        private int id;
        private int idUsuario;
        private Calendar dataContrato = Calendar.getInstance();
        private boolean ocupado = false;

        public LavadorBuilder() {
        }

        public LavadorBuilder from(Lavador lavador) {
            this.id = lavador.id;
            this.idUsuario = lavador.idUsuario;
            this.dataContrato = lavador.dataContrato;
            this.ocupado = lavador.ocupado;
            return this;
        }

        public LavadorBuilder withId(int id){
            object.id = id;
            return this;
        }
        
        public LavadorBuilder withIdUsuario(int idUsuario){
            object.idUsuario = idUsuario;
            return this;
        }
        
        public LavadorBuilder withDataContrato(Calendar dataContrato){
            object.dataContrato = dataContrato;
            return this;
        }
        
        public LavadorBuilder withOcupado(boolean ocupado){
            object.ocupado = ocupado;
            return  this;
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

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

}
