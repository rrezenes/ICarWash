package br.icarwash.control;

import br.icarwash.dao.EnderecoDAO;
import br.icarwash.model.Endereco;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ControleEndereco", urlPatterns = {"/AlterarEndereco", "/AdicionarEndereco", "/ExcluirEndereco"})
public class ControleEndereco extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String URI = ((HttpServletRequest) request).getRequestURI();

        if (URI.endsWith("/AlterarEndereco")) {
            alterarEndereco(request, response);
        } else if (URI.endsWith("/AdicionarEndereco")) {
            adicionarEndereco(request, response);
        } else if (URI.endsWith("/ExcluirEndereco")) {
            excluirEndereco(request, response);
        }

    }

    protected void alterarEndereco(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Endereco endereco = new Endereco(Integer.parseInt(request.getParameter("idEndereco")), request.getParameter("cep"), request.getParameter("estado"), request.getParameter("cidade"), request.getParameter("bairro"), request.getParameter("endereco"), Integer.parseInt(request.getParameter("numero")), request.getParameter("nomeEndereco"));
        new EnderecoDAO().atualizar(endereco);

        request.setAttribute("alterado", "ok");
        RequestDispatcher rd = request.getRequestDispatcher("/Controle?action=LocalizarPorId&q=" + request.getParameter("quem") + "&id=" + request.getParameter("id"));
        rd.forward(request, response);
    }

    protected void adicionarEndereco(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Endereco endereco = new Endereco(request.getParameter("cep"), request.getParameter("estado"), request.getParameter("cidade"), request.getParameter("bairro"), request.getParameter("endereco"), Integer.parseInt(request.getParameter("numero")), request.getParameter("nomeEndereco"));
        new EnderecoDAO().cadastrar(endereco);

        request.setAttribute("alterado", "ok");
        RequestDispatcher rd = request.getRequestDispatcher("/Controle?action=LocalizarPorId&q=" + request.getParameter("quem") + "&id=" + request.getParameter("id"));
        rd.forward(request, response);
    }

    protected void excluirEndereco(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
