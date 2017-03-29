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
public class SolicitacaoServicoDAO {

    private Connection conexao;

        public void cadastraSolicitacaoServico(int idSolicitacao, int idServico) {
        try {
            conexao = Conexao.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement("insert into solicitacao_servico(id_solicitacao, id_servico) values (?,?)");
            pstmt.setInt(1, idSolicitacao);
            pstmt.setInt(2, idServico);
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
