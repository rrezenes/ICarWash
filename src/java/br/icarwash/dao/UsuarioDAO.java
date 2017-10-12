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
import java.sql.Timestamp;
import java.util.Calendar;

/**
 *
 * @author rezen
 */
public class UsuarioDAO {//terminar de implementar

    private boolean fechaConexao = false;
    private Connection conexao;
    private static final String CREATE_USUARIO = "INSERT INTO usuario(email, senha, nivel, ativo,cadastro) VALUES (?,SHA1(?),?,?, NOW());";
    private static final String SELECT_USUARIO = "select * from usuario where email = ? and senha = SHA1(?)";
    private static final String SELECT_ID_BY_USUARIO = "select id from usuario where email = ?";
    private static final String SELECT_NEXT_USUARIO = "select count(*)+1 as qtd from usuario";
    private static final String SELECT_ID_BY_EMAIL = "select id from usuario where email = ?";
    private static final String SELECT_USUARIO_BY_ID = "select * from usuario where id = ?";

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
            pstmt.setString(2, usuario.getSenha());
            pstmt.setInt(3, usuario.getNivel());
            pstmt.setBoolean(4, usuario.isAtivo());

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
            pstmt.setString(1, usuarioLogin.getEmail());
            pstmt.setString(2, usuarioLogin.getSenha());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                usuario = new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getBoolean(5));
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

    public int localizarIdPorEmailUsuario(String emailUsuario) {
        int idUsuario = 0;
        try {
            PreparedStatement pstmt = conexao.prepareStatement(SELECT_ID_BY_USUARIO);
            pstmt.setString(1, emailUsuario);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                idUsuario = rs.getInt("id");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.fechaConexao();

        return idUsuario;
    }

    public int selecionarProximoId() {
        int idProximoUsuario = 0;
        try {
            PreparedStatement pstmt = conexao.prepareStatement(SELECT_NEXT_USUARIO);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                idProximoUsuario = rs.getInt("qtd");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.fechaConexao();

        return idProximoUsuario;
    }

    public Usuario localizarUsuarioPorID(int idUsuario) {
        Usuario usuario = null;
        Calendar dataCadastro = Calendar.getInstance();
        Timestamp timestamp;
        try {
            PreparedStatement pstmt = conexao.prepareStatement(SELECT_USUARIO_BY_ID);
            pstmt.setInt(1, idUsuario);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                timestamp = rs.getTimestamp("cadastro");
                dataCadastro.setTimeInMillis(timestamp.getTime());
                usuario = new Usuario(rs.getInt("id"), rs.getString("email"), rs.getInt("nivel"), rs.getBoolean("ativo"), dataCadastro, rs.getBoolean("cadastro_completo"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.fechaConexao();

        return usuario;
    }

    public boolean checkEmailDisponivel(String email) {

        try {
            PreparedStatement pstmt = conexao.prepareStatement(SELECT_ID_BY_EMAIL);
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();
            return !rs.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            this.fechaConexao();
        }
    }
    
    public boolean isCadastroCompleto(int id) {
        boolean cadastro = false;
        try {
            PreparedStatement pstmt = conexao.prepareStatement("SELECT cadastro_completo FROM usuario where id = ?");
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                cadastro = rs.getBoolean("cadastro_completo");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            this.fechaConexao();
        }
        return cadastro;
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
