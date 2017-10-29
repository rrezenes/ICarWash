package br.icarwash.model;

public class Endereco {

    private int id;
    private String CEP;
    private String estado;
    private String cidade;
    private String bairro;
    private String endereco;
    private int numero;

    public Endereco(String CEP, String estado, String cidade, String bairro, String endereco, int numero) {
        this.CEP = CEP;
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.endereco = endereco;
        this.numero = numero;
    }

    public Endereco(int id, String CEP, String estado, String cidade, String bairro, String endereco, int numero) {
        this.id = id;
        this.CEP = CEP;
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.endereco = endereco;
        this.numero = numero;
    }

    public Endereco(String cidade, String bairro) {
        this.cidade = cidade;
        this.bairro = bairro;
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

}
