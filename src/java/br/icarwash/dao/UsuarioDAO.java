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

/**
 *
 * @author rezen
 */
public class UsuarioDAO {//terminar de implementar

    private boolean fechaConexao = false;
    private Connection conexao;
    private static final String CREATE_USUARIO = "INSERT INTO usuario(email, usuario, senha, nivel, ativo,cadastro) VALUES (?,?,SHA1(?),?,?, NOW());";
    private static final String SELECT_USUARIO = "select * from usuario where usuario = ? and senha = SHA1(?)";
    private static final String SELECT_ID_BY_USUARIO = "select id from usuario where usuario = ?";
    private static final String SELECT_ID_BY_EMAIL = "select id from usuario where email = ?";

    public UsuarioDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public UsuarioDAO() {
        this.conexao = Conexao.getConexao();
        fechaConexao = true;
    }

    public void cadastrar(Object obj) {
        Usuario usuario = (Usuario) obj;

        try {
            PreparedStatement pstmt = conexao.prepareStatement(CREATE_USUARIO);
            pstmt.setString(1, usuario.getEmail());
            pstmt.setString(2, usuario.getUsuario());
            pstmt.setString(3, usuario.getSenha());
            pstmt.setInt(4, usuario.getNivel());
            pstmt.setBoolean(5, usuario.isAtivo());

            pstmt.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.fechaConexao();
    }

    public Usuario usuarioLogin(Usuario usuarioLogin) {//terminar de implementar
        Usuario usuario = null;
        try {
            PreparedStatement pstmt = conexao.prepareStatement(SELECT_USUARIO);
            pstmt.setString(1, usuarioLogin.getUsuario());
            pstmt.setString(2, usuarioLogin.getSenha());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                usuario = new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getBoolean(6));
            } else {
                usuario = new Usuario();
                usuario.setNivel(0);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.fechaConexao();
        return usuario;
    }

    public Usuario localizarIdPorUsuario(Usuario usuario) {

        try {
            PreparedStatement pstmt = conexao.prepareStatement(SELECT_ID_BY_USUARIO);
            pstmt.setString(1, usuario.getUsuario());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                usuario.setId(rs.getInt("id"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.fechaConexao();
        return usuario;
    }

    public boolean checkUsuarioDisponivel(Usuario usuario) {

        try {
            PreparedStatement pstmt = conexao.prepareStatement(SELECT_ID_BY_USUARIO);
            pstmt.setString(1, usuario.getUsuario());
            ResultSet rs = pstmt.executeQuery();
            return !rs.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            this.fechaConexao();
        }
    }

    public boolean checkEmailDisponivel(Usuario usuario) {

        try {
            PreparedStatement pstmt = conexao.prepareStatement(SELECT_ID_BY_EMAIL);
            pstmt.setString(1, usuario.getEmail());
            ResultSet rs = pstmt.executeQuery();
            return !rs.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            this.fechaConexao();
        }
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
