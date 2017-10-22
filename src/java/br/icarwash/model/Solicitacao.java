package br.icarwash.model;

import br.icarwash.control.ControleSolicitacao;
import br.icarwash.dao.LavadorDAO;
import br.icarwash.control.state.SolicitacaoState;
import br.icarwash.control.state.EmAnalise;
import br.icarwash.dao.SolicitacaoDAO;
import br.icarwash.util.Conexao;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Solicitacao {

    private int id;
    private Cliente cliente;
    private Lavador lavador;
    private Avaliacao avaliacao;
    protected SolicitacaoState estado;
    private String porte;
    private Calendar dataSolicitacao;
    private BigDecimal valorTotal;

    public Solicitacao(int id) {
        this.id = id;
        this.estado = new EmAnalise();
    }

    public Solicitacao(int id, Cliente cliente, Lavador lavador, Avaliacao avaliacao, SolicitacaoState estado, String porte, Calendar data_solicitacao, BigDecimal valorTotal) {
        this.id = id;
        this.cliente = cliente;
        this.lavador = lavador;
        this.avaliacao = avaliacao;
        this.estado = estado;
        this.porte = porte;
        this.dataSolicitacao = data_solicitacao;
        this.valorTotal = valorTotal;
    }

    public Solicitacao(int id, Cliente cliente, Lavador lavador, SolicitacaoState estado, String porte, Calendar data_solicitacao, BigDecimal valorTotal) {
        this.id = id;
        this.cliente = cliente;
        this.lavador = lavador;
        this.estado = estado;
        this.porte = porte;
        this.dataSolicitacao = data_solicitacao;
        this.valorTotal = valorTotal;
    }

    public Solicitacao(int id, Cliente cliente, SolicitacaoState estado, String porte, Calendar data_solicitacao, BigDecimal valorTotal) {
        this.id = id;
        this.cliente = cliente;
        this.estado = estado;
        this.porte = porte;
        this.dataSolicitacao = data_solicitacao;
        this.valorTotal = valorTotal;
    }

    public Solicitacao(int id, Cliente cliente, Avaliacao avaliacao, SolicitacaoState estado, String porte, Calendar data_solicitacao, BigDecimal valorTotal) {
        this.id = id;
        this.cliente = cliente;
        this.avaliacao = avaliacao;
        this.estado = estado;
        this.porte = porte;
        this.dataSolicitacao = data_solicitacao;
        this.valorTotal = valorTotal;
    }

    public Solicitacao(Cliente cliente, String porte, Calendar dataSolicitacao, BigDecimal valorTotal) {
        this.cliente = cliente;
        this.porte = porte;
        this.estado = new EmAnalise();
        this.dataSolicitacao = dataSolicitacao;
        this.valorTotal = valorTotal;
    }

    public Solicitacao() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Lavador getLavador() {
        return lavador;
    }

    public void setLavador(Lavador lavador) {
        this.lavador = lavador;

    }

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }

    public String getPorte() {
        return porte;
    }

    public void setPorte(String porte) {
        this.porte = porte;
    }

    public SolicitacaoState getEstado() {
        return estado;
    }

    public void setEstado(SolicitacaoState estado) {
        this.estado = estado;
    }

    public Calendar getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(Calendar dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void analisarSolicitacao() {
        this.estado = this.estado.analisarSolicitacao(this);
    }

    public void agendarSolicitacao() {
        this.estado = this.estado.agendarSolicitacao(this);
    }

    public void processarSolicitacao() {
        this.estado = this.estado.processarSolicitacao(this);
    }

    public void finalizarSolicitacao() {
        this.estado = this.estado.finalizarSolicitacao(this);
    }

    public void avaliarSolicitacao() {
        this.estado = this.estado.avaliarSolicitacao(this, this.avaliacao);
    }

    public void concluirSolicitacao() {
        this.estado = this.estado.concluirSolicitacao(this);
    }

    public void cancelarSolicitacao() {
        this.estado = this.estado.cancelarSolicitacao(this);
    }

    public void atribuirLavador() {
        Connection conexao = Conexao.getConexao();

        try {
            conexao.setAutoCommit(false);
            LavadorDAO lavadorDAO = new LavadorDAO(conexao);
            //        ArrayList<Lavador> = lavadorDAO.selecionarLavadoresDisponiveis(Calendar calendar);
            ArrayList<Lavador> lavadores = lavadorDAO.listar();
            ArrayList<Lavador> lavadoresDisponiveis = new ArrayList<>();
            boolean disponivel;
            boolean encontrou = false;

            for (Lavador lavador : lavadores) {
                disponivel = lavadorDAO.isLavadorDisponivel(lavador, this.getDataSolicitacao());
                if (disponivel) {
                    lavadoresDisponiveis.add(lavador);
                    encontrou = true;
                }
            }
            if (encontrou) {
                SolicitacaoDAO solicitacaoDAO = new SolicitacaoDAO(conexao);
                Random random = new Random();

                this.setLavador(lavadoresDisponiveis.get(random.nextInt(lavadoresDisponiveis.size())));
                solicitacaoDAO.atribuirLavador(this.lavador, this);
            }// F A L T A  I M P L E M E N T A R  O  E L S E

            conexao.commit();
        } catch (SQLException e) {
            try {
                conexao.rollback();
                throw new RuntimeException(e);
            } catch (SQLException ex) {                
                throw new RuntimeException(ex);
            }
        } finally {
            try {
                conexao.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
