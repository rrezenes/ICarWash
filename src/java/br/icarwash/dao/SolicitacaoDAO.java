/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.icarwash.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import br.icarwash.util.Conexao;

/**
 *
 * @author rezen
 */
public class SolicitacaoDAO {

    private Connection conexao;

    public void cadastraSolicitacao(int idCliente, String porte) {
        try {
            conexao = Conexao.getConexao();
            
            PreparedStatement pstmt = conexao.prepareStatement("insert into solicitacao(id_cliente, porte) values (?,?)");
            
            pstmt.setInt(1, idCliente);
            pstmt.setString(2, porte);
            pstmt.execute();
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                conexao.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
