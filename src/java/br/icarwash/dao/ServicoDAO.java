/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.icarwash.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import br.icarwash.model.Servico;
import br.icarwash.util.Conexao;
import java.util.ArrayList;

/**
 *
 * @author rezen
 */
public class ServicoDAO implements BasicoDAO {

    private Connection conexao;
    private static final String INSERT = "insert into servico(nome, descricao, valor, ativo) values(?, ?, ?, ?)";
    private static final String SELECT_ALL = "select * from servico";
    private static final String UPDATE = "update servico set nome = ?, descricao = ?, valor = ? WHERE id = ?";
    private static final String INACTIVE_BY_ID = "UPDATE servico SET ativo=0 where id=?";
    private static final String ACTIVE_BY_ID = "UPDATE servico SET ativo=1 where id=?";
    private static final String SELECT_BY_ID = "select id, nome, descricao, valor, ativo from servico where id = ?";

    //UTILIZAR METODOS DA INTERFACE
    @Override
    public void cadastrar(Object obj) {
        Servico servico = (Servico) obj;
        try {
            conexao = Conexao.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(INSERT);
            pstmt.setString(1, servico.getNome());
            pstmt.setString(2, servico.getDescricao());
            pstmt.setBigDecimal(3, servico.getValor());
            pstmt.setBoolean(4, servico.isAtivo());

            pstmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                conexao.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public ArrayList listar() {
        ArrayList<Servico> servicos = new ArrayList();
        try {
            conexao = Conexao.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(SELECT_ALL);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Servico servico = new Servico(rs.getInt("id"), rs.getString("nome"), rs.getString("descricao"), rs.getBigDecimal("valor"), rs.getBoolean("ativo"));
                servicos.add(servico);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                conexao.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return servicos;
    }

    @Override
    public Servico localizarPorId(int id) {
        Servico servico = null;
        try {
            conexao = Conexao.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(SELECT_BY_ID);
            pstmt.setString(1, Integer.toString(id));
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                servico = new Servico(rs.getInt("id"), rs.getString("nome"), rs.getString("descricao"), rs.getBigDecimal("valor"), rs.getBoolean("ativo"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                conexao.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return servico;
    }

    @Override
    public void atualizar(Object obj) {
        Servico servico = (Servico) obj;
        try {
            conexao = Conexao.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(UPDATE);
            pstmt.setString(1, servico.getNome());
            pstmt.setString(2, servico.getDescricao());
            pstmt.setBigDecimal(3, servico.getValor());
            pstmt.setInt(4, servico.getId());
            pstmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                conexao.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void excluir(int id) {
        try {
            conexao = Conexao.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(INACTIVE_BY_ID);
            pstmt.setInt(1, id);
            pstmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                conexao.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void ativar(int id) {
        try {
            conexao = Conexao.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(ACTIVE_BY_ID);
            pstmt.setInt(1, id);
            pstmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                conexao.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
