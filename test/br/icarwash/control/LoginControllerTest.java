package br.icarwash.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class LoginControllerTest {

    HttpServletRequest request = mock(HttpServletRequest.class);
    HttpServletResponse response = mock(HttpServletResponse.class);
    HttpSession sessionTest = mock(HttpSession.class);

    @Test
    public void testValidaLoginExistente() throws Exception {

        when(request.getParameter("email")).thenReturn("c13@c13.com");
        when(request.getParameter("senha")).thenReturn("12345");
        when(request.getSession()).thenReturn(sessionTest);

        new LoginController().doPost(request, response);
    }
    
    @Test
    public void testValidaLoginNaoExistente() throws Exception {

        when(request.getParameter("email")).thenReturn("c13@c13.com");
        when(request.getParameter("senha")).thenReturn("123456");
        when(request.getSession()).thenReturn(sessionTest);

        new LoginController().doPost(request, response);
    }

}
