/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.icarwash.dao;

import br.icarwash.model.LavadorSolicitacao;
import br.icarwash.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author rezen
 */
public class LavadorSolicitacaoDAO {

    private Connection conexao;
    private static final String INSERT_LAVADOR_SOLICITACAO = "INSERT INTO `icarwash`.`lavador_solicitacao`(`id_lavador`,`id_solicitacao`,`dataAgendamento`)VALUES(?,?,?);";


    public void cadastrar(Object obj) {
        LavadorSolicitacao lavadorSolicitacao = (LavadorSolicitacao) obj;
        Timestamp timestampDataSolicitacao = new Timestamp(lavadorSolicitacao.getDataSolicitacao().getTimeInMillis());
        try {
            conexao = Conexao.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(INSERT_LAVADOR_SOLICITACAO);
            pstmt.setInt(1, lavadorSolicitacao.getIdLavador());
            pstmt.setInt(2, lavadorSolicitacao.getIdSolicitacao());
            pstmt.setTimestamp(3, timestampDataSolicitacao);
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
