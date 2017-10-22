package br.icarwash.control;
import br.icarwash.dao.ServicoDAO;
import br.icarwash.model.Servico;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SolicitarServico", urlPatterns = {"/SolicitarServico"})
public class SolicitarServico extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getParameter("data");
        ServicoDAO servicoDAO = new ServicoDAO();
        ArrayList<Servico> servicos = servicoDAO.listar();
        
        request.setAttribute("servicos", servicos);

        RequestDispatcher rd = request.getRequestDispatcher("/solicitar_servico.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    
    
}
