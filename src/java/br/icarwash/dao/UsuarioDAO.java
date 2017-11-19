package br.icarwash.dao;

import br.icarwash.model.Usuario;
import br.icarwash.model.Usuario.UsuarioBuilder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Calendar;

public class UsuarioDAO {

    private final Connection conexao;
    private static final String CREATE_USUARIO = "INSERT INTO usuario(email, senha, nivel, ativo, cadastro, cadastro_completo) VALUES (?, SHA1(?), ?, ?, NOW(), ?);";
    private static final String SELECT_USUARIO = "select * from usuario where email = ? and senha = SHA1(?)";
    private static final String SELECT_ID_BY_USUARIO = "select id from usuario where email = ?";
    private static final String SELECT_ID_BY_EMAIL = "select id from usuario where email = ?";
    private static final String SELECT_USUARIO_BY_ID = "select * from usuario where id = ?";
    private static final String SELECT_CADASTRO_COMPLETO = "SELECT cadastro_completo FROM usuario where id = ?";
    private static final String UPDATE_USUARIO = "update usuario set senha = SHA1(?) WHERE email = ?";
    private static final String UPDATE_CONCLUIR_CAD = "update usuario set cadastro_completo = true WHERE id = ?";
    private static final String INACTIVE_BY_ID = "UPDATE usuario SET ativo = 0 where id = ?";

    public UsuarioDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public int cadastrar(Usuario usuario) {
        int idUsuario = 0;
        try {
            PreparedStatement pstmt = conexao.prepareStatement(CREATE_USUARIO, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, usuario.getEmail());
            pstmt.setString(2, usuario.getSenha());
            pstmt.setInt(3, usuario.getNivel());
            pstmt.setBoolean(4, usuario.isAtivo());
            pstmt.setBoolean(5, usuario.isCadastroCompleto());

            pstmt.execute();

            final ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                idUsuario = rs.getInt(1);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return idUsuario;
    }

    public Usuario usuarioLogin(Usuario usuarioLogin) {//terminar de implementar
        Usuario usuario = null;
        try {
            PreparedStatement pstmt = conexao.prepareStatement(SELECT_USUARIO);
            pstmt.setString(1, usuarioLogin.getEmail());
            pstmt.setString(2, usuarioLogin.getSenha());
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                usuario = new UsuarioBuilder()
                        .withId(rs.getInt("id"))
                        .withEmail(rs.getString("email"))
                        .withNivel(rs.getInt("nivel"))
                        .withAtivo(rs.getBoolean("ativo"))
                        .withCadastroCompleto(rs.getBoolean("cadastro_completo"))
                        .build();
            } else {
                usuario = new UsuarioBuilder()
                        .withNivel(0)
                        .build();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

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

        return idUsuario;
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

                usuario = new UsuarioBuilder()
                        .withId(rs.getInt("id"))
                        .withEmail(rs.getString("email"))
                        .withNivel(rs.getInt("nivel"))
                        .withAtivo(rs.getBoolean("ativo"))
                        .withDataCadastro(dataCadastro)
                        .withCadastroCompleto(rs.getBoolean("cadastro_completo"))
                        .build();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

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
        }
    }

    public boolean isCadastroCompleto(int id) {
        boolean cadastro = false;
        try {
            PreparedStatement pstmt = conexao.prepareStatement(SELECT_CADASTRO_COMPLETO);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                cadastro = rs.getBoolean("cadastro_completo");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cadastro;
    }

    public void concluirCadastro(int idUusuario) {
        try {
            PreparedStatement pstmt = conexao.prepareStatement(UPDATE_CONCLUIR_CAD);
            pstmt.setInt(1, idUusuario);
            pstmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void inativar(int id) {
        try {
            PreparedStatement pstmt = conexao.prepareStatement(INACTIVE_BY_ID);
            pstmt.setInt(1, id);
            pstmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void alterarSenha(Usuario usuario) {
        try {
            PreparedStatement pstmt = conexao.prepareStatement(UPDATE_USUARIO);
            pstmt.setString(1, usuario.getSenha());
            pstmt.setString(2, usuario.getEmail());
            pstmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
