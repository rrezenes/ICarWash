package br.icarwash.model;

public final class Cliente extends Pessoa {

    private int id;
    private Usuario usuario;

    protected Cliente() {
    }

    public static final class ClienteBuilder extends Pessoa.PessoaBuilder<Cliente, ClienteBuilder> {

        private int id;
        private Usuario usuario;

        public ClienteBuilder() {
        }

        public ClienteBuilder from(Cliente cliente) {
            this.id = cliente.id;
            this.usuario = cliente.usuario;
            return this;
        }

        public ClienteBuilder withId(int id) {
            object.id = id;
            return this;
        }

        public ClienteBuilder withUsuario(Usuario usuario) {
            object.usuario = usuario;
            return this;
        }

        @Override
        protected Cliente getObject() {
            return new Cliente();
        }

        @Override
        protected ClienteBuilder thisObject() {
            return this;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
