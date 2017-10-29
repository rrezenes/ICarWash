package br.icarwash.dao;

import br.icarwash.model.Endereco;
import br.icarwash.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EnderecoDAO {

    private boolean fechaConexao = false;
    private final Connection conexao;
    private static final String INSERT = "insert into endereco(cep, estado, cidade, bairro, endereco, numero) values(?,?,?,?,?,?)";
    private static final String UPDATE = "update endereco set cep = ?, estado = ?, cidade = ?, bairro = ?, endereco = ?, numero = ? WHERE id = ?";
    private static final String DELETE_BY_ID = "delete from endereco where id = ?;";
    private static final String SELECT_BY_ID = "select id, cep, estado, cidade, bairro, endereco, numero from endereco where id = ?";

    public EnderecoDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public EnderecoDAO() {
        this.conexao = Conexao.getConexao();
        fechaConexao = true;
    }

    public int cadastrar(Endereco endereco) {
        int idEndereco = 0;
        try {
            PreparedStatement pstmt = conexao.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, endereco.getCEP());
            pstmt.setString(2, endereco.getEstado());
            pstmt.setString(3, endereco.getCidade());
            pstmt.setString(4, endereco.getBairro());
            pstmt.setString(5, endereco.getEndereco());
            pstmt.setInt(6, endereco.getNumero());

            pstmt.execute();

            final ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                idEndereco = rs.getInt(1);
            }
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.fechaConexao();
        return idEndereco;
    }

    public Endereco localizarPorId(int id) {
        Endereco endereco = null;
        try {
            PreparedStatement pstmt = conexao.prepareStatement(SELECT_BY_ID);
            pstmt.setString(1, Integer.toString(id));
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                endereco = new Endereco(rs.getInt("id"), rs.getString("cep"), rs.getString("estado"), rs.getString("cidade"), rs.getString("bairro"), rs.getString("endereco"), rs.getInt("numero"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.fechaConexao();
        return endereco;
    }

    public void atualizar(Endereco endereco) {
        try {
            PreparedStatement pstmt = conexao.prepareStatement(UPDATE);
            pstmt.setString(4, endereco.getCEP());
            pstmt.setString(5, endereco.getEstado());
            pstmt.setString(6, endereco.getCidade());
            pstmt.setString(7, endereco.getBairro());
            pstmt.setString(8, endereco.getEndereco());
            pstmt.setInt(9, endereco.getNumero());
            pstmt.setInt(10, endereco.getId());
            pstmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.fechaConexao();
    }

    public void excluir(int id) {
        try {
            PreparedStatement pstmt = conexao.prepareStatement(DELETE_BY_ID);
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
