/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.icarwash.control;

import br.icarwash.dao.SolicitacaoDAO;
import br.icarwash.model.Solicitacao;
import br.icarwash.model.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Mirian
 */
@WebServlet(name = "ListarSolicitacaoHojeLavador", urlPatterns = {"/ListarSolicitacaoHojeLavador", "/solicitacoes-hoje"})
public class ListarSolicitacaoHojeLavador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        SolicitacaoDAO solicitacaoDAO = new SolicitacaoDAO();
        HttpSession session = ((HttpServletRequest) request).getSession(true);
        Usuario usuario = (Usuario) session.getAttribute("user");

        ArrayList<Solicitacao> solicitacoes = solicitacaoDAO.listarSolicitacaoDoLavador(usuario.getId());

        request.setAttribute("solicitacoes", solicitacoes);

        RequestDispatcher rd = request.getRequestDispatcher("/solicitacao_lavador.jsp");
        rd.forward(request, response);

    }
}
