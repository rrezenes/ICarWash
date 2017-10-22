/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.icarwash.control;

import br.icarwash.dao.UsuarioDAO;
import br.icarwash.model.Usuario;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author Ricardo
 */
public class ControleNovoClienteTest {

    @Test
    public void testDoGet() throws Exception {
        /*
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        
        new ControleNovoCliente().doGet(request, response);
         */
    }

    /**
     * Test of doPost method, of class ControleNovoCliente.
     */
    @Test
    public void testDoPost() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        HttpSession sessionTest = mock(HttpSession.class);
        UsuarioDAO usuarioDAO = mock(UsuarioDAO.class);
        Usuario usuario = mock(Usuario.class);
        
        when(request.getParameter("email")).thenReturn("1234@1234.com");
        when(request.getParameter("senha")).thenReturn("12345");
        when(request.getSession()).thenReturn(sessionTest);
        new ControleNovoCliente().doPost(request, response);
    }

}
