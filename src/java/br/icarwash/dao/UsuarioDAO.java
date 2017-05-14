/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.icarwash.dao;

import br.icarwash.model.Usuario;
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
public class UsuarioDAO implements BasicoDAO {//terminar de implementar

    private Connection conexao;
    private static final String CREATE_USUARIO = "INSERT INTO usuario(usuario, senha, nivel, ativo,cadastro) VALUES (?,SHA1(?),?,?, NOW());";
    private static final String SELECT_USUARIO = "select nivel from usuario where usuario = ? and senha = SHA1(?)";
    private static final String SELECT_ID_BY_USUARIO = "select id from usuario where usuario = ?";

    @Override
    public void cadastrar(Object obj) {
        Usuario usuario = (Usuario) obj;

        try {
            conexao = Conexao.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(CREATE_USUARIO);
            pstmt.setString(1, usuario.getUsuario());
            pstmt.setString(2, usuario.getSenha());
            pstmt.setInt(3, usuario.getNivel());
            pstmt.setBoolean(4, usuario.isAtivo());

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

    public int usuarioLogin(String login, String senha) {//terminar de implementar
        int nivel = 0; //terminar de implementar
        try {
            System.out.println(login + " " + senha);
            conexao = Conexao.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(SELECT_USUARIO);
            pstmt.setString(1, login);
            pstmt.setString(2, senha);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                nivel = rs.getInt(1);
            } else {
                nivel = 0;
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
        return nivel;
    }

    @Override
    public ArrayList listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object localizarPorId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizar(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int localizarIdPorUsuario(String usuario) {
        int IDCliente = 0;
        try {
            conexao = Conexao.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(SELECT_ID_BY_USUARIO);
            pstmt.setString(1, usuario);
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
