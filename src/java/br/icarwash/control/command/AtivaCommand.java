package br.icarwash.control.command;

import br.icarwash.dao.ProdutoDAO;
import br.icarwash.dao.ServicoDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AtivaCommand implements ICommand {

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ativar = request.getParameter("q");
        final int id = Integer.parseInt(request.getParameter("id"));

        switch (ativar) {
            case "produto": {
                new ProdutoDAO().ativar(id);
                return "/Controle?action=ListaCommand&listar=produto";
            }
            case "servico": {
                new ServicoDAO().ativar(id);
                return "/Controle?action=ListaCommand&listar=servico";
            }
            default:
                return "painel_admin.jsp";
        }

    }

}
