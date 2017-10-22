package br.icarwash.control;

import br.icarwash.control.command.ICommand;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ControleCommand", urlPatterns = "/Controle")
public class ControleCommand extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //recupera a ação o usuário7
            String action = "br.icarwash.control.command." + request.getParameter("action");
            Class classeAction = Class.forName(action);
            
            ICommand commandAction = (ICommand) classeAction.newInstance();
            String pageDispatcher = commandAction.executar(request, response);
            
            RequestDispatcher rd = request.getRequestDispatcher(pageDispatcher);
            rd.forward(request, response);

        } catch (IOException | ClassNotFoundException | IllegalAccessException | InstantiationException | ServletException erro) {
            // Exibe uma mensagem de erro para o usuário.
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
