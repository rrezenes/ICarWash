package br.icarwash.dao;

import br.icarwash.model.Marca.MarcaBuilder;
import br.icarwash.model.Modelo;
import br.icarwash.model.Modelo.ModeloBuilder;
import br.icarwash.model.Modelo.PorteVeiculo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloDAO {

    private final Connection conexao;
    private static final String SELECT_ALL_BY_ID = "SELECT * FROM modelo where id = ?";

    public ModeloDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public ArrayList<Modelo> localizarPorId(int idMarca) {
        ArrayList<Modelo> modelos = new ArrayList();
        Modelo modelo;
        try {
            PreparedStatement pstmt = conexao.prepareStatement(SELECT_ALL_BY_ID);
            pstmt.setString(1, Integer.toString(idMarca));
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                modelo = new ModeloBuilder()
                        .withId(rs.getInt("id"))
                        .withMarca(new MarcaBuilder().withId(rs.getInt("id_marca")).build())
                        .withNome(rs.getString("porte"))
                        .withPorteVeiculo(PorteVeiculo.valueOf(rs.getString("porte")))
                        .build();

                modelos.add(modelo);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return modelos;
    }

}
