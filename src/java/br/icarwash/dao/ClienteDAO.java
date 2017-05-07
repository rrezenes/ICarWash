/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.icarwash.dao;

import br.icarwash.model.Cliente;
import br.icarwash.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import br.icarwash.model.Endereco;
import br.icarwash.model.Usuario;

/**
 *
 * @author rezen
 */
public class ClienteDAO implements BasicoDAO {

    private Connection conexao;
    private static final String INSERT = "insert into cliente(email, nome, telefone, dt_nascimento, cpf, cep, estado, cidade, bairro, endereco, numero) values(?,?,?,?,?,?,?,?,?,?,?)";
    private static final String SELECT_ALL = "select c.id, c.email, c.nome, c.telefone, c.dt_nascimento, c.cpf, c.cep, c.estado, c.cidade, c.bairro, c.endereco, c.numero, u.usuario, u.ativo from Cliente c, usuario u, cliente_usuario cu where c.id = cu.id_CLIENTE and u.id = cu.id_usuario and u.ativo = 1";
    private static final String UPDATE = "update cliente set email = ?, nome = ?, telefone = ?, dt_nascimento = ?, cep = ?, estado = ?, cidade = ?, bairro = ?, endereco = ?, numero = ? WHERE id = ?";
    private static final String INACTIVE_BY_ID = "UPDATE usuario SET ativo=0 where id=(SELECT id_usuario FROM cliente_usuario where id_cliente = ?);";
    private static final String SELECT_BY_ID = "select id, email, nome, telefone, dt_nascimento, cpf, cep, estado, cidade, bairro, endereco, numero from cliente where id = ?";
    private static final String SELECT_ID_BY_EMAIL = "select id from cliente where email = ?";

    @Override
    public void cadastrar(Object obj) {
        Cliente cliente = (Cliente) obj;
        try {
            conexao = Conexao.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(INSERT);
            pstmt.setString(1, cliente.getEmail());
            pstmt.setString(2, cliente.getNome());
            pstmt.setString(3, cliente.getTelefone());
            pstmt.setDate(4, new java.sql.Date(cliente.getDataNascimento().getTimeInMillis()));
            pstmt.setString(5, cliente.getCPF());
            pstmt.setString(6, cliente.getEndereco().getCEP());
            pstmt.setString(7, cliente.getEndereco().getEstado());
            pstmt.setString(8, cliente.getEndereco().getCidade());
            pstmt.setString(9, cliente.getEndereco().getBairro());
            pstmt.setString(10, cliente.getEndereco().getEndereco());
            pstmt.setInt(11, cliente.getEndereco().getNumero());
           
            pstmt.execute();
            
        } catch (SQLException e) {
            throw new RuntimeException("ERRROO: " + e);
        } finally {
            try {
                conexao.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public ArrayList<Object> listar() {

        ArrayList<Object> clientes = new ArrayList();

        try {
            conexao = Conexao.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(SELECT_ALL);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Calendar cal = Calendar.getInstance();
                Timestamp timestamp;
                timestamp = rs.getTimestamp("dt_nascimento");
                cal.setTimeInMillis(timestamp.getTime());
                Cliente cli = new Cliente(rs.getInt("id"),rs.getString("email"), rs.getString("nome"), rs.getString("telefone"), cal, rs.getString("cpf"), new Endereco(rs.getString("cep"), rs.getString("estado"), rs.getString("cidade"), rs.getString("bairro"), rs.getString("endereco"), rs.getInt("numero")));
                
                clientes.add(cli);
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
        return clientes;
    }

    @Override
    public Cliente localizarPorId(int id) {
        Cliente cli = null;
        try {
            Calendar cal = Calendar.getInstance();
            Timestamp timestamp;
            conexao = Conexao.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(SELECT_BY_ID);
            pstmt.setString(1, Integer.toString(id));
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                timestamp = rs.getTimestamp("dt_nascimento");
                cal.setTimeInMillis(timestamp.getTime());
                cli = new Cliente(rs.getInt("id"),rs.getString("email"),  rs.getString("nome"), rs.getString("telefone"), cal, rs.getString("cpf"), new Endereco(rs.getString("cep"), rs.getString("estado"), rs.getString("cidade"), rs.getString("bairro"), rs.getString("endereco"), rs.getInt("numero")));
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
        return cli;
    }

    @Override
    public void atualizar(Object obj) {
        Cliente cliente = (Cliente) obj;
        try {
            conexao = Conexao.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(UPDATE);
            pstmt.setString(1, cliente.getEmail());
            pstmt.setString(2, cliente.getNome());
            pstmt.setString(3, cliente.getTelefone());
            pstmt.setDate(4, new java.sql.Date(cliente.getDataNascimento().getTimeInMillis()));
            pstmt.setString(5, cliente.getEndereco().getCEP());
            pstmt.setString(6, cliente.getEndereco().getEstado());
            pstmt.setString(7, cliente.getEndereco().getCidade());
            pstmt.setString(8, cliente.getEndereco().getBairro());
            pstmt.setString(9, cliente.getEndereco().getEndereco());
            pstmt.setInt(10, cliente.getEndereco().getNumero());
            pstmt.setInt(11, cliente.getId());
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
    
    public int localizarIdPorEmail(String email) {
        int IDCliente = 0;
        try {
            conexao = Conexao.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(SELECT_ID_BY_EMAIL);
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                IDCliente = rs.getInt("id");
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
        return IDCliente;
    }

}
