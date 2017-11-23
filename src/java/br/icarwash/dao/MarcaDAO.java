package br.icarwash.dao;

import br.icarwash.model.Marca;
import br.icarwash.model.Marca.MarcaBuilder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MarcaDAO {

    private final Connection conexao;
    private static final String SELECT_ALL = "SELECT * FROM marca";

    public MarcaDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public ArrayList<Marca> listar() {
        ArrayList<Marca> marcas = new ArrayList();
        Marca marca;
        try {
            PreparedStatement pstmt = conexao.prepareStatement(SELECT_ALL);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                marca = new MarcaBuilder()
                        .withId(rs.getInt("id"))
                        .withNome(rs.getString("nome"))
                        .build();

                marcas.add(marca);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return marcas;
    }

}
