/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.icarwash.dao;

import br.icarwash.model.Cliente;
import br.icarwash.model.Lavador;
import br.icarwash.model.Solicitacao;
import br.icarwash.control.state.Agendado;
import br.icarwash.control.state.Avaliado;
import br.icarwash.control.state.Cancelado;
import br.icarwash.control.state.Concluido;
import br.icarwash.control.state.EmAnalise;
import br.icarwash.control.state.EmProcesso;
import br.icarwash.control.state.Finalizado;
import br.icarwash.control.state.SolicitacaoState;
import br.icarwash.model.Avaliacao;
import br.icarwash.model.Endereco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import br.icarwash.util.Conexao;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author rezen
 */
public class SolicitacaoDAO {

    private boolean fechaConexao = false;
    private Connection conexao;

    public SolicitacaoDAO() {
        this.conexao = Conexao.getConexao();
        fechaConexao = true;
    }

    public SolicitacaoDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void cadastrar(Object object) {
        Solicitacao solicitacao = (Solicitacao) object;
        Timestamp timestamp = new Timestamp(solicitacao.getDataSolicitacao().getTimeInMillis());
        try {
            PreparedStatement pstmt = conexao.prepareStatement("insert into solicitacao(id_cliente, porte, data_solicitacao,valor_total) values (?,?,?,?)");

            pstmt.setInt(1, solicitacao.getCliente().getId());
            pstmt.setString(2, solicitacao.getPorte());
            pstmt.setTimestamp(3, timestamp);
            pstmt.setBigDecimal(4, solicitacao.getValorTotal());
            pstmt.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.fechaConexao();
    }

    public ArrayList<Solicitacao> listarSolicitacaoPorIDCliente(int id) {
        ArrayList<Solicitacao> solicitacoes = new ArrayList();
        Solicitacao solicitacao;
        Cliente cliente;
        Lavador lavador;
        Avaliacao avaliacao;
        AvaliacaoDAO avaliacaoDAO = new AvaliacaoDAO(conexao);
        SolicitacaoState solicitacaoState;
        try {
            PreparedStatement pstmt = conexao.prepareStatement(
                    "SELECT solicitacao.ID as ID_Solicitacao,cliente.ID as ID_Cliente, "
                    + "cliente.nome as nome_cliente,solicitacao.id_lavador, "
                    + "solicitacao.id_avaliacao, solicitacao.porte, "
                    + "solicitacao.data_solicitacao, solicitacao.valor_total, "
                    + "solicitacao.status "
                    + "FROM icarwash.cliente,icarwash.solicitacao, "
                    + "icarwash.solicitacao_servico,icarwash.servico "
                    + "where cliente.ID = solicitacao.id_cliente "
                    + "and solicitacao.ID = solicitacao_servico.id_solicitacao "
                    + "and cliente.ID = ? group by solicitacao.ID order by solicitacao.data_solicitacao");
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                cliente = new Cliente(rs.getInt("ID_Cliente"), rs.getString("nome_cliente"));
                lavador = new Lavador(rs.getInt("id_lavador"));
                solicitacaoState = validarStatus(rs.getString("status"));
                Calendar data = Calendar.getInstance();
                data.setTime(rs.getTimestamp("data_solicitacao"));
                if (rs.getBoolean("id_avaliacao")) {
                    avaliacao = new Avaliacao(rs.getInt("id_avaliacao"));
                    avaliacao = avaliacaoDAO.localizarAvaliacaoPorId(avaliacao);
                } else {
                    avaliacao = new Avaliacao(0);
                }
                solicitacao = new Solicitacao(rs.getInt("ID_Solicitacao"), cliente, lavador, avaliacao, solicitacaoState, rs.getString("porte"), data, rs.getBigDecimal("valor_total"));
                solicitacoes.add(solicitacao);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.fechaConexao();
        return solicitacoes;
    }

    public ArrayList<Solicitacao> listarSolicitacaoDoLavador(int id) {
        ArrayList<Solicitacao> solicitacoes = new ArrayList();
        Solicitacao solicitacao;
        Cliente cliente;
        Endereco endereco;
        SolicitacaoState solicitacaoState;
        try {
            PreparedStatement pstmt = conexao.prepareStatement("select s.id as ID_Solicitacao, c.id as ID_Cliente, c.nome as nome_cliente, c.bairro, c.cidade, s.porte, s.data_solicitacao, s.valor_total, s.status from lavador l, usuario u, lavador_usuario lu, solicitacao s, cliente c where c.id = s.id_cliente and l.id = lu.id_lavador and u.id = lu.id_usuario and l.id = s.id_lavador and u.id = ? order by s.data_solicitacao");
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                endereco = new Endereco(rs.getString("cidade"), rs.getString("bairro"));
                cliente = new Cliente(rs.getInt("ID_Cliente"), rs.getString("nome_cliente"), endereco);

                //lavador = new Lavador(rs.getInt("id_lavador"));
                solicitacaoState = validarStatus(rs.getString("status"));
                Calendar data = Calendar.getInstance();
                data.setTime(rs.getTimestamp("data_solicitacao"));

                solicitacao = new Solicitacao(rs.getInt("ID_Solicitacao"), cliente, solicitacaoState, rs.getString("porte"), data, rs.getBigDecimal("valor_total"));
                solicitacoes.add(solicitacao);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.fechaConexao();
        return solicitacoes;
    }

    public ArrayList<Solicitacao> listarSolicitacaoHojeLavador(int id) {
        ArrayList<Solicitacao> solicitacoes = new ArrayList();
        Solicitacao solicitacao;
        Cliente cliente;
        Endereco endereco;
        SolicitacaoState solicitacaoState;
        try {
            PreparedStatement pstmt = conexao.prepareStatement("select s.id as ID_Solicitacao, c.id as ID_Cliente, c.nome as nome_cliente, c.bairro, c.cidade, s.porte, s.data_solicitacao, s.valor_total, s.status from lavador l, usuario u, lavador_usuario lu, solicitacao s, cliente c where c.id = s.id_cliente and l.id = lu.id_lavador and u.id = lu.id_usuario and l.id = s.id_lavador and u.id = ? order by s.data_solicitacao");
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                endereco = new Endereco(rs.getString("cidade"), rs.getString("bairro"));
                cliente = new Cliente(rs.getInt("ID_Cliente"), rs.getString("nome_cliente"), endereco);

                //lavador = new Lavador(rs.getInt("id_lavador"));
                solicitacaoState = validarStatus(rs.getString("status"));
                Calendar data = Calendar.getInstance();
                data.setTime(rs.getTimestamp("data_solicitacao"));

                solicitacao = new Solicitacao(rs.getInt("ID_Solicitacao"), cliente, solicitacaoState, rs.getString("porte"), data, rs.getBigDecimal("valor_total"));
                solicitacoes.add(solicitacao);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.fechaConexao();
        return solicitacoes;
    }

    public Solicitacao localizarPorId(int id) {
        Solicitacao solicitacao = null;
        Cliente cliente;
        Lavador lavador;
        SolicitacaoState solicitacaoState;
        try {
            PreparedStatement pstmt = conexao.prepareStatement("SELECT solicitacao.ID as ID_Solicitacao,cliente.ID as ID_Cliente, cliente.nome as nome_cliente,solicitacao.id_lavador, solicitacao.id_avaliacao, solicitacao.porte,solicitacao.data_solicitacao, solicitacao.valor_total, solicitacao.status FROM icarwash.cliente,icarwash.solicitacao,icarwash.solicitacao_servico,icarwash.servico where cliente.ID = solicitacao.id_cliente and solicitacao.ID = solicitacao_servico.id_solicitacao and solicitacao.ID = ? group by solicitacao.ID");
            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                cliente = new Cliente(rs.getInt("ID_Cliente"), rs.getString("nome_cliente"));
                lavador = new Lavador(rs.getInt("id_lavador"));
                solicitacaoState = validarStatus(rs.getString("status"));
                Calendar data = Calendar.getInstance();
                data.setTime(rs.getTimestamp("data_solicitacao"));

                solicitacao = new Solicitacao(rs.getInt("ID_Solicitacao"), cliente, lavador, solicitacaoState, rs.getString("porte"), data, rs.getBigDecimal("valor_total"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.fechaConexao();
        return solicitacao;
    }

    public ArrayList listar() {
        ArrayList<Solicitacao> solicitacoes = new ArrayList();
        Solicitacao solicitacao;
        Cliente cliente;
        Lavador lavador;
        SolicitacaoState solicitacaoState;
        try {
            PreparedStatement pstmt = conexao.prepareStatement("SELECT solicitacao.ID as ID_Solicitacao, cliente.ID as ID_Cliente, cliente.nome as nome_cliente, solicitacao.id_lavador, solicitacao.id_avaliacao, solicitacao.porte,solicitacao.data_solicitacao, solicitacao.valor_total, solicitacao.status FROM icarwash.cliente, icarwash.solicitacao, icarwash.solicitacao_servico, icarwash.servico where cliente.ID = solicitacao.id_cliente and solicitacao.ID = solicitacao_servico.id_solicitacao group by solicitacao.ID ORDER BY solicitacao.data_solicitacao");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                cliente = new Cliente(rs.getInt("ID_Cliente"), rs.getString("nome_cliente"));
                lavador = new Lavador(rs.getInt("id_lavador"));
                solicitacaoState = validarStatus(rs.getString("status"));
                Calendar data = Calendar.getInstance();
                data.setTime(rs.getTimestamp("data_solicitacao"));

                solicitacao = new Solicitacao(rs.getInt("ID_Solicitacao"), cliente, lavador, solicitacaoState, rs.getString("porte"), data, rs.getBigDecimal("valor_total"));
                solicitacoes.add(solicitacao);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.fechaConexao();
        return solicitacoes;
    }

    public ArrayList listarEmAnalise() {
        ArrayList<Solicitacao> solicitacoes = new ArrayList();
        Solicitacao solicitacao;
        Cliente cliente;
        Lavador lavador;
        SolicitacaoState solicitacaoState;
        try {
            PreparedStatement pstmt = conexao.prepareStatement("SELECT solicitacao.ID as ID_Solicitacao,cliente.ID as ID_Cliente, cliente.nome as nome_cliente,solicitacao.id_lavador, solicitacao.id_avaliacao, solicitacao.porte,solicitacao.data_solicitacao, solicitacao.valor_total, solicitacao.status FROM icarwash.cliente,icarwash.solicitacao,icarwash.solicitacao_servico,icarwash.servico where cliente.ID = solicitacao.id_cliente and solicitacao.ID = solicitacao_servico.id_solicitacao AND solicitacao.status = 'Em Analise' group by solicitacao.ID");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                cliente = new Cliente(rs.getInt("ID_Cliente"));
                cliente.setNome(rs.getString("nome_cliente"));
                lavador = new Lavador(rs.getInt("id_lavador"));
                solicitacaoState = validarStatus(rs.getString("status"));
                Calendar data = Calendar.getInstance();
                data.setTime(rs.getTimestamp("data_solicitacao"));

                solicitacao = new Solicitacao(rs.getInt("ID_Solicitacao"), cliente, lavador, solicitacaoState, rs.getString("porte"), data, rs.getBigDecimal("valor_total"));
                solicitacoes.add(solicitacao);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.fechaConexao();
        return solicitacoes;
    }

    public Solicitacao selecionaUltimoIdSolicitacao() {
        Solicitacao solicitacao = new Solicitacao();
        try {
            PreparedStatement pstmt = conexao.prepareStatement("SELECT id FROM solicitacao WHERE id = (SELECT MAX(id) FROM solicitacao)");
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                solicitacao.setId(rs.getInt("id"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return solicitacao;
    }

    public void cancelarSolicitacaoPorId(int id) {
        try {
            PreparedStatement pstmt = conexao.prepareStatement("UPDATE solicitacao SET status = 'Cancelado' WHERE ID = ?");
            pstmt.setInt(1, id);
            pstmt.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.fechaConexao();
    }

    public void agendarSolicitacao(Solicitacao solicitacao) {
        try {
            PreparedStatement pstmt = conexao.prepareStatement("UPDATE solicitacao SET status = 'Agendado' WHERE ID = ?");
            pstmt.setInt(1, solicitacao.getId());
            pstmt.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.fechaConexao();
    }

    public void finalizarSolicitacao(Solicitacao solicitacao) {
        try {
            PreparedStatement pstmt = conexao.prepareStatement("UPDATE solicitacao SET status = 'Finalizado' WHERE ID = ?");
            pstmt.setInt(1, solicitacao.getId());
            pstmt.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.fechaConexao();
    }

    public void avaliarSolicitacao(Solicitacao solicitacao, Avaliacao avaliacao) {
        try {
            PreparedStatement pstmt = conexao.prepareStatement("UPDATE solicitacao SET status = 'Avaliado', id_avaliacao = ? WHERE ID = ?");
            pstmt.setInt(1, avaliacao.getID());
            pstmt.setInt(2, solicitacao.getId());
            pstmt.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.fechaConexao();
    }

    public void concluirSolicitacao(Solicitacao solicitacao) {
        try {
            PreparedStatement pstmt = conexao.prepareStatement("UPDATE solicitacao SET status = 'Concluido' WHERE ID = ?");
            pstmt.setInt(1, solicitacao.getId());
            pstmt.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.fechaConexao();
    }

    public void processarSolicitacao(Solicitacao solicitacao) {
        try {
            PreparedStatement pstmt = conexao.prepareStatement("UPDATE solicitacao SET status = 'Em Processo' WHERE ID = ?");
            pstmt.setInt(1, solicitacao.getId());
            pstmt.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.fechaConexao();
    }

    public void atribuirLavador(Lavador lavador, Solicitacao solicitacao) {
        try {
            PreparedStatement pstmt = conexao.prepareStatement("UPDATE solicitacao SET id_lavador = ? WHERE ID = ?");
            pstmt.setInt(1, lavador.getId());
            pstmt.setInt(2, solicitacao.getId());
            pstmt.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.fechaConexao();
    }

    public ArrayList consultarHorarioIndisponivel(String dataHoraSolicitacao, int quantidadeLavadores) {
        ArrayList<String> horarios = new ArrayList<>();
        try {

            PreparedStatement pstmt = conexao.prepareStatement(
                    "SELECT data_solicitacao as hora, STATUS,count(*) as quantidade FROM solicitacao where  (status like 'Em Analise' or status like 'Agendado') and data_solicitacao like ? group by hora having quantidade >= ?"
            );

            pstmt.setString(1, dataHoraSolicitacao + "%");
            pstmt.setInt(2, quantidadeLavadores);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String horaIndisponivel[] = rs.getTime("hora").toString().split(":");
                horarios.add(horaIndisponivel[0] + ":" + horaIndisponivel[1]);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.fechaConexao();

        return horarios;
    }

    private void fechaConexao() throws RuntimeException {
        if (fechaConexao) {
            try {
                conexao.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public SolicitacaoState validarStatus(String status) throws UnsupportedOperationException, SQLException {
        SolicitacaoState solicitacaoState;
        switch (status) {
            case "Em Analise":
                solicitacaoState = new EmAnalise();
                break;
            case "Agendado":
                solicitacaoState = new Agendado();
                break;
            case "Em Processo":
                solicitacaoState = new EmProcesso();
                break;
            case "Finalizado":
                solicitacaoState = new Finalizado();
                break;
            case "Avaliado":
                solicitacaoState = new Avaliado();
                break;
            case "Concluido":
                solicitacaoState = new Concluido();
                break;
            case "Cancelado":
                solicitacaoState = new Cancelado();
                break;
            default:
                throw new UnsupportedOperationException("Solicitação sem Status");
        }
        return solicitacaoState;
    }
}
