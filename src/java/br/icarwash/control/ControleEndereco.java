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

        Endereco endereco = new Endereco.EnderecoBuilder()
                .withId(Integer.parseInt(request.getParameter("idEndereco")))
                .withCep(request.getParameter("cep"))
                .withEstado(request.getParameter("estado"))
                .withCidade(request.getParameter("cidade"))
                .withBairro(request.getParameter("bairro"))
                .withEndereco(request.getParameter("endereco"))
                .withNumero(Integer.parseInt(request.getParameter("numero")))
                .withNome(request.getParameter("nomeEndereco"))
                .build();

        new EnderecoDAO().atualizar(endereco);

        request.setAttribute("alterado", "ok");
        RequestDispatcher rd = request.getRequestDispatcher("/Controle?action=LocalizarPorId&q=" + request.getParameter("quem") + "&id=" + request.getParameter("id"));
        rd.forward(request, response);
    }

    protected void adicionarEndereco(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Endereco endereco = new Endereco.EnderecoBuilder()
                .withCep(request.getParameter("cep"))
                .withEstado(request.getParameter("estado"))
                .withCidade(request.getParameter("cidade"))
                .withBairro(request.getParameter("bairro"))
                .withEndereco(request.getParameter("endereco"))
                .withNumero(Integer.parseInt(request.getParameter("numero")))
                .withNome(request.getParameter("nomeEndereco"))
                .build();

        new EnderecoDAO().cadastrar(endereco);

        request.setAttribute("alterado", "ok");
        RequestDispatcher rd = request.getRequestDispatcher("/Controle?action=LocalizarPorId&q=" + request.getParameter("quem") + "&id=" + request.getParameter("id"));
        rd.forward(request, response);
    }

    protected void excluirEndereco(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
