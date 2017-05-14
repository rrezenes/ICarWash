/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.icarwash.dao;

import br.icarwash.model.Solicitacao;
import br.icarwash.model.Status;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import br.icarwash.util.Conexao;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author rezen
 */
public class SolicitacaoDAO implements BasicoDAO {

    private Connection conexao;

    @Override
    public void cadastrar(Object object) {
        Solicitacao solicitacao = (Solicitacao) object;
        try {
            conexao = Conexao.getConexao();

            PreparedStatement pstmt = conexao.prepareStatement("insert into solicitacao(id_cliente, porte, data_solicitacao,valor_total) values (?,?,?,?)");

            pstmt.setInt(1, solicitacao.getCliente().getId());
            pstmt.setString(2, solicitacao.getPorte());
            pstmt.setDate(3, new java.sql.Date(solicitacao.getDataSolicitacao().getTimeInMillis()));
            pstmt.setBigDecimal(4, solicitacao.getValorTotal());
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

    public void alterarStatus(Status status) {

    }

    public Solicitacao selecionaUltimoIdSolicitacao() {
        Solicitacao solicitacao = new Solicitacao();
        try {
            conexao = Conexao.getConexao();

            PreparedStatement pstmt = conexao.prepareStatement("SELECT id FROM solicitacao WHERE id = (SELECT MAX(id) FROM solicitacao)");

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                solicitacao.setId(rs.getInt("id"));
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
        return solicitacao;
    }

}
