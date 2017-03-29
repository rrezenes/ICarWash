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
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import br.icarwash.model.Cliente;
import br.icarwash.model.Endereco;
import br.icarwash.model.Lavador;
import br.icarwash.util.Conexao;

/**
 *
 * @author rezen
 */
public class LavadorDAO implements BasicoDAO{

    private Connection conexao;
    private static final String INSERT = "insert into lavador(dt_contrato,email, nome, telefone, dt_nascimento, CPF, CEP, estado, cidade, bairro, endereco, numero) values(?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String SELECT_ALL = "select id, email, dt_contrato, nome, telefone, dt_nascimento, CPF, CEP, estado, cidade, bairro, endereco, numero from lavador";
    private static final String UPDATE = "update lavador set email = ?, nome = ?, telefone = ?, dt_nascimento = ?, cpf = ?, cep = ?, estado = ?, cidade = ?, bairro = ?, endereco = ?, numero = ? WHERE id = ?";
    private static final String DELETE_BY_ID = "delete from lavador WHERE id = ?";
    private static final String SELECT_BY_ID = "select id, dt_contrato, email, nome, telefone, dt_nascimento, CPF, CEP, estado, cidade, bairro, endereco, numero from lavador where id = ?";

    @Override
    public void cadastrar(Object obj) {
        Lavador func = (Lavador) obj;
        try {
            conexao = Conexao.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(INSERT);
            pstmt.setDate(1, new java.sql.Date(func.getDataContrato().getTimeInMillis()));
            pstmt.setString(2, func.getEmail());
            pstmt.setString(3, func.getNome());
            pstmt.setString(4, func.getTelefone());
            pstmt.setDate(5, new java.sql.Date(func.getDataNascimento().getTimeInMillis()));
            pstmt.setString(6, func.getCPF());
            pstmt.setString(7, func.getEndereco().getCEP());
            pstmt.setString(8, func.getEndereco().getEstado());
            pstmt.setString(9, func.getEndereco().getCidade());
            pstmt.setString(10, func.getEndereco().getBairro());
            pstmt.setString(11, func.getEndereco().getEndereco());
            pstmt.setInt(12, func.getEndereco().getNumero());

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
    public ArrayList<Lavador> listar() {
        ArrayList<Lavador> func = new ArrayList();
        try {
            conexao = Conexao.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(SELECT_ALL);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Calendar cal1 = Calendar.getInstance(), cal2 = Calendar.getInstance();
                Timestamp timestamp;
                timestamp = rs.getTimestamp("dt_contrato");
                cal1.setTimeInMillis(timestamp.getTime());
                timestamp = rs.getTimestamp("dt_nascimento");
                cal2.setTimeInMillis(timestamp.getTime());
                Lavador f = new Lavador(rs.getInt("id"), cal1, rs.getString("email"),rs.getString("nome"), rs.getString("telefone"), cal2, rs.getString("cpf"), new Endereco(rs.getString("cep"), rs.getString("estado"), rs.getString("cidade"), rs.getString("bairro"), rs.getString("endereco"), rs.getInt("numero")));
                func.add(f);
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
        return func;
    }

    @Override
    public Lavador localizarPorId(int id) {
        Calendar cal1 = Calendar.getInstance(), cal2 = Calendar.getInstance();
        Lavador func = null;
        try {
            conexao = Conexao.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(SELECT_BY_ID);
            pstmt.setString(1, Integer.toString(id));
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                cal1.setTimeInMillis(rs.getTime("dt_contrato").getTime());
                cal2.setTimeInMillis(rs.getTime("dt_nascimento").getTime());
                func = new Lavador(rs.getInt("id"), cal1, rs.getString("email"), rs.getString("nome"), rs.getString("telefone"), cal2, rs.getString("cpf"), new Endereco(rs.getString("cep"), rs.getString("estado"), rs.getString("cidade"), rs.getString("bairro"), rs.getString("endereco"), rs.getInt("numero")));
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
        return func;
    }

    @Override
    public void atualizar(Object obj) {
        Lavador func = (Lavador) obj;
        try {
            conexao = Conexao.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(UPDATE);
            pstmt.setString(1, func.getEmail());
            pstmt.setString(2, func.getNome());
            pstmt.setString(3, func.getTelefone());
            pstmt.setDate(4, new java.sql.Date(func.getDataNascimento().getTimeInMillis()));
            pstmt.setString(5, func.getCPF());
            pstmt.setString(6, func.getEndereco().getCEP());
            pstmt.setString(7, func.getEndereco().getEstado());
            pstmt.setString(8, func.getEndereco().getCidade());
            pstmt.setString(9, func.getEndereco().getBairro());
            pstmt.setString(10, func.getEndereco().getEndereco());
            pstmt.setInt(11, func.getEndereco().getNumero());
            pstmt.setInt(12, func.getId());
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
    public void exluir(int id) {
        try {
            conexao = Conexao.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(DELETE_BY_ID);
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
