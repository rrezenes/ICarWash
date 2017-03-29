/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.icarwash.dao;

import br.icarwash.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author rezen
 */
public class UsuarioDAO {//terminar de implementar

    private Connection conexao;

    private static final String SELECT_USUARIO = "select nivel from usuario where usuario = ? and senha = SHA1(?)";

    public int usuarioLogin(String login, String senha) {//terminar de implementar
        int nivel = 0; //terminar de implementar
        try {
            System.out.println(login + " " + senha);
            conexao = Conexao.getConexao();
            PreparedStatement pstmt = conexao.prepareStatement(SELECT_USUARIO);
            pstmt.setString(1, login);
            pstmt.setString(2, senha);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                nivel = rs.getInt(1);
            } else {
                nivel = 0;
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
        return nivel;
    }

}
