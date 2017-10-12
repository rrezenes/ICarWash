/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.icarwash.dao;

import br.icarwash.model.Produto;
import br.icarwash.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author rezen
 */
public class ProdutoDAO {
    
    private boolean fechaConexao = false;
    private Connection conexao;
    private static final String INSERT = "insert into produto(nome, descricao, ativo) values(?, ?, ?)";
    private static final String SELECT_ALL = "select * from produto";
    private static final String UPDATE = "update produto set nome = ?, descricao = ? WHERE id = ?";
    private static final String INACTIVE_BY_ID = "UPDATE produto SET ativo=0 where id=?";
    private static final String ACTIVE_BY_ID = "UPDATE produto SET ativo=1 where id=?";
    private static final String SELECT_BY_ID = "select id, nome, descricao, ativo from produto where id = ?";


    public ProdutoDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public ProdutoDAO() {
        this.conexao = Conexao.getConexao();        
        fechaConexao = true;
    }

    public void cadastrar(Produto produto) {
        try {
            PreparedStatement pstmt = conexao.prepareStatement(INSERT);
            pstmt.setString(1, produto.getNome());
            pstmt.setString(2, produto.getDescricao());
            pstmt.setBoolean(3, produto.isAtivo());

            pstmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.fechaConexao();
    }

    public ArrayList listar() {
        ArrayList<Produto> produtos = new ArrayList();
        try {
            PreparedStatement pstmt = conexao.prepareStatement(SELECT_ALL);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Produto produto = new Produto(rs.getInt("id"), rs.getString("nome"), rs.getString("descricao"), rs.getBoolean("ativo"));
                produtos.add(produto);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.fechaConexao();
        return produtos;
    }

    public Produto localizarPorId(int id) {
        Produto produto = null;
        try {
            PreparedStatement pstmt = conexao.prepareStatement(SELECT_BY_ID);
            pstmt.setString(1, Integer.toString(id));
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                produto = new Produto(rs.getInt("id"), rs.getString("nome"), rs.getString("descricao"), rs.getBoolean("ativo"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.fechaConexao();
        return produto;
    }

    public void atualizar(Produto produto) {
        try {
            PreparedStatement pstmt = conexao.prepareStatement(UPDATE);
            pstmt.setString(1, produto.getNome());
            pstmt.setString(2, produto.getDescricao());
            pstmt.setInt(3, produto.getId());
            pstmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.fechaConexao();
    }

    public void excluir(int id) {
        try {
            PreparedStatement pstmt = conexao.prepareStatement(INACTIVE_BY_ID);
            pstmt.setInt(1, id);
            pstmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.fechaConexao();
    }

    public void ativar(int id) {
        try {
            PreparedStatement pstmt = conexao.prepareStatement(ACTIVE_BY_ID);
            pstmt.setInt(1, id);
            pstmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.fechaConexao();
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

}
