package br.icarwash.model;

import java.util.Calendar;

public class Lavador extends Pessoa {

    private int id;
    private Calendar dataContrato = Calendar.getInstance();
    private int idUsuario;

    public Lavador(int id, String nome, String telefone, Calendar dtNascimento, Endereco endereco) {
        super(nome, telefone, dtNascimento, endereco);
        this.id = id;
    }

    public Lavador(int id, Calendar dtContrato, String nome, String telefone, Calendar dtNascimento, String CPF, Endereco endereco) {
        super(nome, telefone, dtNascimento, CPF, endereco);
        this.id = id;
        this.dataContrato = dtContrato;
    }

    public Lavador(int id, int idUsuario, Calendar dtContrato, String nome, String telefone, Calendar dtNascimento, String CPF, Endereco endereco) {
        super(nome, telefone, dtNascimento, CPF, endereco);
        this.id = id;
        this.idUsuario = idUsuario;
        this.dataContrato = dtContrato;
    }

    public Lavador(Calendar dtContrato, String nome, String telefone, Calendar dtNascimento, String CPF, Endereco endereco) {
        super(nome, telefone, dtNascimento, CPF, endereco);
        this.dataContrato = dtContrato;
    }

    public Lavador(int id) {
        this.id = id;
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

}
