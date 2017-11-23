package br.icarwash.model;

public class Marca {

    private Integer id;
    private String nome;

    public Marca() {
    }

    public Marca(MarcaBuilder builder) {
        this.id = builder.id;
        this.nome = builder.nome;
    }

    public static class MarcaBuilder {

        private Integer id;
        private String nome;

        public MarcaBuilder from(Marca modelo) {
            this.id = modelo.id;
            this.nome = modelo.nome;
            return this;
        }

        public MarcaBuilder withId(int id) {
            this.id = id;
            return this;
        }

        public MarcaBuilder withNome(String nome) {
            this.nome = nome;
            return this;
        }

        public Marca build() {
            return new Marca(this);
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
