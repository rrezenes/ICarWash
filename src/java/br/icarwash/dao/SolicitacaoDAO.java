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

    public void cadastraSolicitacao(int idCliente, int idServico, int idLavador, int idAvaliacao) {
        try {
            conexao = Conexao.getConexao();
            
            PreparedStatement pstmt = conexao.prepareStatement("insert into solicitacao(id_cliente, id_servico, id_lavador, id_avaliacao) values (?,?,?,?)");
            
            pstmt.setInt(1, idCliente);
            pstmt.setInt(2, idServico);
            pstmt.setInt(3, idLavador);
            pstmt.setInt(4, idAvaliacao);
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
