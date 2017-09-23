/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.icarwash.dao;

import br.icarwash.model.ClienteUsuario;
import br.icarwash.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author rezen
 */
public class ClienteUsuarioDAO {

    private Connection conexao;
    private static final String INSERT_CLIENTE_USUARIO = "INSERT INTO `cliente_usuario` VALUES (?,?)";

    
    public void cadastrar(Object obj) {

        ClienteUsuario clienteUsuario = (ClienteUsuario) obj;

        try {
            conexao = Conexao.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(INSERT_CLIENTE_USUARIO);
            pstmt.setInt(1, clienteUsuario.getIdCliente());
            pstmt.setInt(2, clienteUsuario.getIdUsuario());

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
