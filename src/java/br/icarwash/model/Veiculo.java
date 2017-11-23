package br.icarwash.model;

public class Veiculo {

    private int id;
    private String marca;
    private String modelo;
    private PorteVeiculo porte;

    public enum PorteVeiculo {
        PEQUENO, MEDIO, GRANDE;
    }

    public Veiculo(VeiculoBuilder builder) {
        this.id = builder.id;
        this.marca = builder.marca;
        this.modelo = builder.modelo;
        this.porte = builder.porte;
    }

    public static class VeiculoBuilder {

        private int id;
        private String marca;
        private String modelo;
        private PorteVeiculo porte;

        public VeiculoBuilder from(Veiculo veiculo) {
            this.id = veiculo.id;
            this.marca = veiculo.marca;
            this.modelo = veiculo.modelo;
            this.porte = veiculo.porte;
            return this;
        }

        public VeiculoBuilder withId(int id) {
            this.id = id;
            return this;
        }

        public VeiculoBuilder withMarca(String marca) {
            this.marca = marca;
            return this;
        }

        public VeiculoBuilder withModelo(String modelo) {
            this.modelo = modelo;
            return this;
        }

        public VeiculoBuilder withPorteVeiculo(PorteVeiculo porte) {
            this.porte = porte;
            return this;
        }

        public Veiculo build() {
            return new Veiculo(this);
        }
    }

    public Veiculo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public PorteVeiculo getPorte() {
        return porte;
    }

    public void setPorte(PorteVeiculo porte) {
        this.porte = porte;
    }

}
