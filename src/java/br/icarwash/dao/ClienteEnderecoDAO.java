package br.icarwash.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

    public ArrayList<Integer> selecionaEnderecosCliente(int idCliente) {
        ArrayList<Integer> idsEnderecos = null;
        try {
            PreparedStatement pstmt = conexao.prepareStatement("select * from cliente_endereco where id_cliente = ?");
            pstmt.setInt(1, idCliente);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                idsEnderecos.add(rs.getInt("id_endereco"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return idsEnderecos;

    }
}
