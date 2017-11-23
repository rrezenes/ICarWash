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
    private static final String SELECT_ALL_BY_ID_MARCA = "SELECT * FROM modelo where id_marca = ?";

    public ModeloDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public ArrayList<Modelo> localizarPorId(int idMarca) {
        ArrayList<Modelo> modelos = new ArrayList();
        Modelo modelo;
        try {
            PreparedStatement pstmt = conexao.prepareStatement(SELECT_ALL_BY_ID_MARCA);
            pstmt.setString(1, Integer.toString(idMarca));
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                modelo = new ModeloBuilder()
                        .withId(rs.getInt("id"))
                        .withNome(rs.getString("nome"))
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
