package br.icarwash.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClienteEnderecoDAO {
    private final Connection conexao;

    public ClienteEnderecoDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void cadastraClienteEndereco(int idCliente, int idEndereco) {
        try {
            PreparedStatement pstmt = conexao.prepareStatement("insert into cliente_endereco(id_cliente, id_endereco) values (?,?)");
            pstmt.setInt(1, idCliente);
            pstmt.setInt(2, idEndereco);
            pstmt.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
