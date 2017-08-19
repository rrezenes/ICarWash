/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import br.icarwash.control.LoginController;
import java.io.File;
import java.io.PrintWriter;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito.*;
import javax.servlet.http.*;
import org.mockito.Mockito;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author rezen
 */
public class LoginControllerTest extends Mockito{
    
    
    @Test
    public void testServlet() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);       
        HttpServletResponse response = mock(HttpServletResponse.class);

        when(request.getParameter("usuario")).thenReturn("renan");
        when(request.getParameter("senha")).thenReturn("admin");
        PrintWriter writer = new PrintWriter("somefile.txt");
        when(response.getWriter()).thenReturn(writer);

        new LoginController().doPost(request, response);

        verify(request, atLeast(1)).getParameter("user"); // only if you want to verify username was called...
        writer.flush(); // it may not have been flushed yet...
        assertTrue(FileUtils.readFileToString(new File("somefile.txt"), "UTF-8").contains("My Expected String"));
    }
    
}
