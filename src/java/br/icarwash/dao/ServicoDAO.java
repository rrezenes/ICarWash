/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.icarwash.dao;

import br.icarwash.control.Avaliacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import br.icarwash.model.Cliente;
import br.icarwash.model.Endereco;
import br.icarwash.model.Servico;
import br.icarwash.util.Conexao;

/**
 *
 * @author rezen
 */
public class ServicoDAO {

    private Connection conexao;

    public int cadastraServico(double valor, String descricao) {
        int id = 0;
        try {
            conexao = Conexao.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement("insert into servico(valor, descricao) values (?,?)");
            pstmt.setDouble(1, valor);
            pstmt.setString(2, descricao);
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
    
    public Servico selecionar(String serv){
        Servico servico = null;
        try {
            conexao = Conexao.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement("select * from servico where descricao = ?");
            pstmt.setString(1, serv);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                servico = new Servico(rs.getInt("id"), rs.getDouble("valor"), rs.getString("descricao"));
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
        return servico;
    }
    
}
