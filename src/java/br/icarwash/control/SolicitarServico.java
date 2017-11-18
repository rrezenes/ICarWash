package br.icarwash.control;

import br.icarwash.dao.ClienteDAO;
import br.icarwash.dao.EnderecoDAO;
import br.icarwash.dao.ServicoDAO;
import br.icarwash.model.Cliente;
import br.icarwash.model.Endereco;
import br.icarwash.model.Servico;
import br.icarwash.model.Usuario;
import br.icarwash.util.Conexao;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "SolicitarServico", urlPatterns = {"/SolicitarServico", "/solicitar-servico"})
public class SolicitarServico extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = ((HttpServletRequest) request).getSession(true);
        Usuario usuario = (Usuario) session.getAttribute("user");

        ClienteDAO clienteDAO = new ClienteDAO();
        Cliente cliente = clienteDAO.localizarPorIdUsuario(usuario.getId());

        request.getParameter("data");
        ServicoDAO servicoDAO = new ServicoDAO();
        ArrayList<Servico> servicos = servicoDAO.listar();

        EnderecoDAO enderecoDAO = new EnderecoDAO();

        ArrayList<Endereco> enderecos = enderecoDAO.localizarPorIdUsuario(usuario.getId());

        request.setAttribute("servicos", servicos);
        request.setAttribute("enderecos", enderecos);

        RequestDispatcher rd = request.getRequestDispatcher("/solicitar_servico.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

}
