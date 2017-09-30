package br.icarwash.control;

import br.icarwash.dao.ClienteDAO;
import br.icarwash.dao.ClienteUsuarioDAO;
import br.icarwash.model.Cliente;
import br.icarwash.model.ClienteUsuario;
import br.icarwash.model.Endereco;
import br.icarwash.model.Usuario;
import br.icarwash.util.Conexao;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ContinuarCadastro", urlPatterns = {"/ContinuarCadastro"})
public class ContinuarCadastro extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conexao = Conexao.getConexao();
        try {
            conexao.setAutoCommit(false);
            HttpSession session = ((HttpServletRequest) request).getSession(true);
            Usuario usuario = (Usuario) session.getAttribute("user");

            String[] dataComHora = request.getParameter("nascimento").split(" ");
            String[] nascimento = dataComHora[0].split("-");
            Calendar cal1 = Calendar.getInstance();
            cal1.set(Integer.parseInt(nascimento[0]), Integer.parseInt(nascimento[1]) - 1, Integer.parseInt(nascimento[2]));

            Cliente cliente = new Cliente(usuario.getEmail(), request.getParameter("nome"), request.getParameter("telefone"), cal1, request.getParameter("cpf"), new Endereco(request.getParameter("cep"), request.getParameter("estado"), request.getParameter("cidade"), request.getParameter("bairro"), request.getParameter("endereco"), Integer.parseInt(request.getParameter("numero"))));
            ClienteDAO clienteDAO = new ClienteDAO(conexao);
            clienteDAO.cadastrar(cliente);
            Cliente clienteID = new Cliente(clienteDAO.localizarIdPorEmail(cliente.getEmail()));

            ClienteUsuario clienteUsuario = new ClienteUsuario(clienteID, usuario);
            ClienteUsuarioDAO clienteUsuarioDAO = new ClienteUsuarioDAO(conexao);
            clienteUsuarioDAO.cadastrar(clienteUsuario);

            conexao.commit();
        } catch (SQLException e) {
            try {
                conexao.rollback();
                throw new RuntimeException(e);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        } finally {
            try {
                conexao.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        RequestDispatcher rd = request.getRequestDispatcher("SolicitarServico");
        rd.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
