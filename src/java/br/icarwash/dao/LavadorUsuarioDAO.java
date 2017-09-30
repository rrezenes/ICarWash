/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.icarwash.dao;

import br.icarwash.model.LavadorUsuario;
import br.icarwash.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author rezen
 */
public class LavadorUsuarioDAO {

    private Connection conexao;
    private static final String INSERT_LAVADOR_USUARIO = "INSERT INTO `lavador_usuario` VALUES (?,?)";

    public LavadorUsuarioDAO(Connection conexao) {
        this.conexao = conexao;
    }
   
    public void cadastrar(Object obj) {
        LavadorUsuario lavadorUsuario = (LavadorUsuario) obj;

        try {
            PreparedStatement pstmt = conexao.prepareStatement(INSERT_LAVADOR_USUARIO);
            pstmt.setInt(1, lavadorUsuario.getIdLavador());
            pstmt.setInt(2, lavadorUsuario.getIdUsuario());

            pstmt.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
