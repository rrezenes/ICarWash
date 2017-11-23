package br.icarwash.dao;

import br.icarwash.model.Veiculo;
import br.icarwash.model.Veiculo.PorteVeiculo;
import br.icarwash.model.Veiculo.VeiculoBuilder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VeiculoDAO {

    private final Connection conexao;
    private static final String SELECT_ALL = "SELECT * FROM veiculo";

    public VeiculoDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public ArrayList listar() {
        ArrayList<Veiculo> veiculos = new ArrayList();
        Veiculo veiculo;
        try {
            PreparedStatement pstmt = conexao.prepareStatement(SELECT_ALL);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                veiculo = new VeiculoBuilder()
                        .withId(rs.getInt("id"))
                        .withMarca(rs.getString("marca"))
                        .withModelo(rs.getString("modelo"))
                        .withPorteVeiculo(PorteVeiculo.valueOf(rs.getString("porte")))
                        .build();

                veiculos.add(veiculo);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return veiculos;
    }

}
