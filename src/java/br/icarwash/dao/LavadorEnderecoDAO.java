package br.icarwash.dao;

import br.icarwash.model.Cliente;
import br.icarwash.model.Lavador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LavadorEnderecoDAO {

    private final Connection conexao;

    public LavadorEnderecoDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void cadastraLavadorEndereco(int idLavador, int idEndereco) {
        try {
            PreparedStatement pstmt = conexao.prepareStatement("insert into lavador_endereco(id_lavador, id_endereco) values (?,?)");
            pstmt.setInt(1, idLavador);
            pstmt.setInt(2, idEndereco);
            pstmt.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
