package br.icarwash.control.remoto;

import br.icarwash.dao.ClienteDAO;
import br.icarwash.dao.LavadorDAO;
import br.icarwash.model.Cliente;
import br.icarwash.model.Cliente.ClienteBuilder;
import br.icarwash.model.Lavador;
import br.icarwash.model.Lavador.LavadorBuilder;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
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
        Connection conexao = (Connection) request.getAttribute("conexao");
        String URI = ((HttpServletRequest) request).getRequestURI();
        PrintWriter out = response.getWriter();

        if (URI.endsWith("/CheckCpfCliente")) {
            Cliente cliente = new ClienteBuilder()
                    .withCpf(request.getParameter("cpf"))
                    .build();
            out.print(new ClienteDAO(conexao).checkCpfDisponivel(cliente));
            out.flush();

        } else {

            Lavador lavador = new LavadorBuilder()
                    .withCpf(request.getParameter("cpf"))
                    .build();
            out.print(new LavadorDAO(conexao).checkCpfDisponivel(lavador));
            out.flush();
        }
    }

}
