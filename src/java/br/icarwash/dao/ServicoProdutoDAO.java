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
public class ServicoProdutoDAO {

    private Connection conexao;

    public ServicoProdutoDAO(Connection conexao) {
        this.conexao = conexao;
    }
    
    public void cadastraServicoProduto(int idServico, int idProduto, int quantidade) {
        try {
            PreparedStatement pstmt = conexao.prepareStatement("insert into servico_produtos(id_servico, id_produto, quantidade) values (?,?,?)");
            pstmt.setInt(1, idServico);
            pstmt.setInt(2, idProduto);
            pstmt.setInt(3, quantidade);
            pstmt.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
