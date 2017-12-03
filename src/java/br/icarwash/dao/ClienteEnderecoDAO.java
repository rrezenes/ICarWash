package br.icarwash.dao;

import br.icarwash.model.Cliente;
import br.icarwash.model.ClienteEndereco;
import br.icarwash.model.Endereco;
import br.icarwash.model.Endereco.EnderecoBuilder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClienteEnderecoDAO {

    private final Connection conexao;
    private static final String INSERT = "insert into cliente_endereco(id_cliente, id_endereco) values (?,?)";
    private static final String DELETE_BY_IDS = "DELETE FROM cliente_endereco where id_cliente = ? and id_endereco = ?";
    private static final String SELECT_ID_ENDERECO_BY_ID_CLIENTE = "select * from cliente_endereco where id_cliente = ?";

    public ClienteEnderecoDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void cadastraClienteEndereco(ClienteEndereco clienteEndereco) {
        try {
            PreparedStatement pstmt = conexao.prepareStatement(INSERT);
            pstmt.setInt(1, clienteEndereco.getCliente().getId());
            pstmt.setInt(2, clienteEndereco.getEndereco().getId());
            pstmt.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void excluirClienteEndereco(ClienteEndereco clienteEndereco) {
        try {
            PreparedStatement pstmt = conexao.prepareStatement(DELETE_BY_IDS);
            pstmt.setInt(1, clienteEndereco.getCliente().getId());
            pstmt.setInt(2, clienteEndereco.getEndereco().getId());
            pstmt.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<ClienteEndereco> selecionaEnderecoPorIdCliente(Cliente cliente) {

        ArrayList<ClienteEndereco> clienteEnderecos = new ArrayList<>();

        try {
            PreparedStatement pstmt = conexao.prepareStatement(SELECT_ID_ENDERECO_BY_ID_CLIENTE);
            pstmt.setInt(1, cliente.getId());
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {

                Endereco endereco = new EnderecoBuilder()
                        .withId(rs.getInt("id_endereco"))
                        .build();

                clienteEnderecos.add(new ClienteEndereco(cliente, endereco));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return clienteEnderecos;

    }

}
