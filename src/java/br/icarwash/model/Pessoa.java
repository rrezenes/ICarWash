package br.icarwash.model;

import java.util.Calendar;

public abstract class Pessoa {

    protected String nome;
    protected String telefone;
    protected Calendar dataNascimento = Calendar.getInstance();
    protected String CPF;

    protected Pessoa() {
    }
    
    protected abstract static class PessoaBuilder<T extends Pessoa, builder extends PessoaBuilder<T, builder>> {

        protected T object;
        protected builder thisObject;

        protected abstract T getObject(); //Each concrete implementing subclass overrides this so that T becomes an object of the concrete subclass

        protected abstract builder thisObject(); //Each concrete implementing subclass builder overrides this for the same reason, but for B for the builder

        protected PessoaBuilder() {
            object = getObject();
            thisObject = thisObject();
        }

        public builder withNome(String nome) {
            object.nome = nome;
            return thisObject;
        }

        public builder withTelefone(String telefone) {
            object.telefone = telefone;
            return thisObject;
        }

        public builder withDataNascimento(Calendar dtNascimento) {
            object.dataNascimento = dtNascimento;
            return thisObject;
        }

        public builder withCpf(String cpf) {
            object.CPF = cpf;
            return thisObject;
        }

        public T build() {
            return object;
        }
    }

    public Calendar getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Calendar dataNascimento) {
        this.dataNascimento = dataNascimento;
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

}
