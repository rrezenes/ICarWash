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
import java.util.ArrayList;

/**
 *
 * @author rezen
 */
public class LavadorSolicitacaoDAO implements BasicoDAO {

    private Connection conexao;
    private static final String INSERT_LAVADOR_SOLICITACAO = "INSERT INTO `icarwash`.`lavador_solicitacao`(`id_lavador`,`id_solicitacao`,`dataAgendamento`)VALUES(?,?,?);";

    @Override
    public void cadastrar(Object obj) {
        LavadorSolicitacao lavadorSolicitacao = (LavadorSolicitacao) obj;

        try {
            conexao = Conexao.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(INSERT_LAVADOR_SOLICITACAO);
            pstmt.setInt(1, lavadorSolicitacao.getIdLavador());
            pstmt.setInt(2, lavadorSolicitacao.getIdSolicitacao());
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

    @Override
    public ArrayList listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object localizarPorId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizar(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
