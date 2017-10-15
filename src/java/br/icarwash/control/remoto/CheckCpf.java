package br.icarwash.control.remoto;

import br.icarwash.dao.ClienteDAO;
import br.icarwash.dao.LavadorDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CheckCpf", urlPatterns = {"/CheckCpfCliente", "/CheckCpfLavador"})
public class CheckCpf extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String URI = ((HttpServletRequest) request).getRequestURI();
        PrintWriter out = response.getWriter();
        if (URI.endsWith("/CheckCpfCliente")) {

            ClienteDAO clienteDAO = new ClienteDAO();
            out.print(clienteDAO.checkCpfDisponivel(request.getParameter("cpf")));
            out.flush();
        } else {

            LavadorDAO lavadorDAO = new LavadorDAO();

            out.print(lavadorDAO.checkCpfDisponivel(request.getParameter("cpf")));
            out.flush();
        }
    }

}
