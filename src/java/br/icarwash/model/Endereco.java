package br.icarwash.model;

public class Endereco {

    private int id;
    private String CEP;
    private String estado;
    private String cidade;
    private String bairro;
    private String endereco;
    private int numero;
    private String nome;

    public Endereco() {
    }

    public Endereco(EnderecoBuilder builder) {
        this.id = builder.id;
        this.CEP = builder.CEP;
        this.estado = builder.estado;
        this.cidade = builder.cidade;
        this.bairro = builder.bairro;
        this.endereco = builder.endereco;
        this.numero = builder.numero;
        this.nome = builder.nome;
    }

    public static class EnderecoBuilder {

        private int id;
        private String CEP;
        private String estado;
        private String cidade;
        private String bairro;
        private String endereco;
        private int numero;
        private String nome;

        public EnderecoBuilder from(Endereco endereco) {
            this.id = endereco.id;
            this.CEP = endereco.CEP;
            this.estado = endereco.estado;
            this.cidade = endereco.cidade;
            this.bairro = endereco.bairro;
            this.endereco = endereco.endereco;
            this.numero = endereco.numero;
            this.nome = endereco.nome;
            return this;
        }

        public EnderecoBuilder withId(int id) {
            this.id = id;
            return this;
        }

        public EnderecoBuilder withCep(String cep) {
            this.CEP = cep;
            return this;
        }

        public EnderecoBuilder withEstado(String estado) {
            this.estado = estado;
            return this;
        }

        public EnderecoBuilder withCidade(String cidade) {
            this.cidade = cidade;
            return this;
        }

        public EnderecoBuilder withBairro(String bairro) {
            this.bairro = bairro;
            return this;
        }

        public EnderecoBuilder withEndereco(String endereco) {
            this.endereco = endereco;
            return this;
        }

        public EnderecoBuilder withNumero(int numero) {
            this.numero = numero;
            return this;
        }

        public EnderecoBuilder withNome(String nome) {
            this.nome = nome;
            return this;
        }

        public Endereco build() {
            return new Endereco(this);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
