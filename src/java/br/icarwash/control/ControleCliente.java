/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.icarwash.control;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Wolley
 */
@WebServlet(name = "ControleCliente", urlPatterns = "/Controle")
public class ControleCliente extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //recupera a ação o usuário7
            String action = "br.icarwash.control." + request.getParameter("action");
            System.out.println("0");
            Class classeAction = Class.forName(action);
            System.out.println("1");
            ICommand commandAction = (ICommand) classeAction.newInstance();
            System.out.println("2");
            String pageDispatcher = commandAction.executar(request, response);
            System.out.println("3");
            RequestDispatcher rd = request.getRequestDispatcher(pageDispatcher);
            System.out.println("4");
            rd.forward(request, response);

        } catch (IOException | ClassNotFoundException | IllegalAccessException | InstantiationException | ServletException erro) {
            // Exibe uma mensagem de erro para o usuário.
            System.out.println(erro.getLocalizedMessage() + " teste");
            request.setAttribute("erro", erro);
            RequestDispatcher rd = request.getRequestDispatcher("//erro.jsp");
            rd.forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //encaminha a requisição
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //encaminha a requisição
        processRequest(request, response);
    }

}
