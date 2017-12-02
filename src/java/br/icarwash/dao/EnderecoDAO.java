package br.icarwash.dao;

import br.icarwash.model.Endereco;
import br.icarwash.model.Endereco.EnderecoBuilder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EnderecoDAO {

    private final Connection conexao;
    private static final String INSERT = "insert into endereco(id_usuario, cep, estado, cidade, bairro, endereco, numero, nome) values(?,?,?,?,?,?,?,?)";
    private static final String UPDATE = "update endereco set cep = ?, estado = ?, cidade = ?, bairro = ?, endereco = ?, numero = ?, nome = ? WHERE id = ?";
    private static final String DELETE_BY_ID = "delete from endereco where id = ?";
    private static final String SELECT_BY_ID = "select * from endereco where id = ?";
    private static final String SELECT_ALL_BY_ID_USUARIO = "select * from endereco where id_usuario = ?";

    public EnderecoDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public int cadastrar(Endereco endereco) {
        int idEndereco = 0;
        try {
            PreparedStatement pstmt = conexao.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, endereco.getUsuario().getId());
            pstmt.setString(2, endereco.getCEP());
            pstmt.setString(3, endereco.getEstado());
            pstmt.setString(4, endereco.getCidade());
            pstmt.setString(5, endereco.getBairro());
            pstmt.setString(6, endereco.getEndereco());
            pstmt.setInt(7, endereco.getNumero());
            pstmt.setString(8, endereco.getNome());

            pstmt.execute();

            final ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                idEndereco = rs.getInt(1);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return idEndereco;
    }

    public Endereco localizarPorId(int id) {
        Endereco endereco = null;
        try {
            PreparedStatement pstmt = conexao.prepareStatement(SELECT_BY_ID);
            pstmt.setString(1, Integer.toString(id));
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                endereco = new EnderecoBuilder()
                        .withId(rs.getInt("id"))
                        .withCep(rs.getString("cep"))
                        .withEstado(rs.getString("estado"))
                        .withCidade(rs.getString("cidade"))
                        .withBairro(rs.getString("bairro"))
                        .withEndereco(rs.getString("endereco"))
                        .withNumero(rs.getInt("numero"))
                        .withNome(rs.getString("nome"))
                        .build();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return endereco;
    }

    public void atualizar(Endereco endereco) {
        try {
            PreparedStatement pstmt = conexao.prepareStatement(UPDATE);
            pstmt.setString(1, endereco.getCEP());
            pstmt.setString(2, endereco.getEstado());
            pstmt.setString(3, endereco.getCidade());
            pstmt.setString(4, endereco.getBairro());
            pstmt.setString(5, endereco.getEndereco());
            pstmt.setInt(6, endereco.getNumero());
            pstmt.setString(7, endereco.getNome());
            pstmt.setInt(8, endereco.getId());
            pstmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void excluir(Endereco endereco) {
        try {
            PreparedStatement pstmt = conexao.prepareStatement(DELETE_BY_ID);
            pstmt.setInt(1, endereco.getId());
            pstmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Endereco> localizarPorIdUsuario(int idUsuario) {
        ArrayList<Endereco> enderecos = new ArrayList<>();

        try {
            PreparedStatement pstmt = conexao.prepareStatement(SELECT_ALL_BY_ID_USUARIO);
            pstmt.setInt(1, idUsuario);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Endereco endereco = new EnderecoBuilder()
                        .withId(rs.getInt("ID"))
                        .withCep(rs.getString("cep"))
                        .withEstado(rs.getString("estado"))
                        .withCidade(rs.getString("cidade"))
                        .withBairro(rs.getString("bairro"))
                        .withEndereco(rs.getString("endereco"))
                        .withNumero(rs.getInt("numero"))
                        .withNome(rs.getString("nome"))
                        .build();

                enderecos.add(endereco);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return enderecos;
    }

}
