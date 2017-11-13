package br.icarwash.model;

public final class Cliente extends Pessoa {

    private int id;
    private int idUsuario;

    protected Cliente() {
    }

    public static final class ClienteBuilder extends Pessoa.PessoaBuilder<Cliente, ClienteBuilder> {

        private int id;
        private int idUsuario;

        public ClienteBuilder() {
        }

        public ClienteBuilder from(Cliente cliente) {
            this.id = cliente.id;
            this.idUsuario = cliente.idUsuario;
            return this;
        }

        public ClienteBuilder withId(int id) {
            object.id = id;
            return this;
        }

        public ClienteBuilder withIdUsuario(int idUsuario) {
            object.idUsuario = idUsuario;
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

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

}
