/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.icarwash.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import br.icarwash.util.Conexao;

/**
 *
 * @author rezen
 */
public class AvaliacaoDAO {

    private Connection conexao;

    public int create() {
        int id = 0;
        try {
            conexao = Conexao.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement("insert into avaliacao(nota_pontualidade,nota_servico,nota_atendimento,nota_agilidade,nota_media) values (0,0,0,0,0)");
            pstmt.execute();

            PreparedStatement pstmtID = conexao.prepareStatement("SELECT MAX(id) FROM servico");
            ResultSet rs = pstmtID.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                conexao.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return id;
    }

}
