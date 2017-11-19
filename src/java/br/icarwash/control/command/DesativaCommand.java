package br.icarwash.control.command;

import br.icarwash.dao.ClienteDAO;
import br.icarwash.dao.LavadorDAO;
import br.icarwash.dao.ProdutoDAO;
import br.icarwash.dao.ServicoDAO;
import br.icarwash.dao.UsuarioDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DesativaCommand implements ICommand {

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String inativar = request.getParameter("q");
        int id = Integer.parseInt(request.getParameter("id"));
        
        switch (inativar ){
            case "cliente": {
                new UsuarioDAO().inativar(id);
                return "/Controle?action=ListaCommand&listar=cliente";
            }
            case "lavador": {
                new UsuarioDAO().inativar(id);
                return "/Controle?action=ListaCommand&listar=lavador";
            }
            case "produto": {
                new ProdutoDAO().inativar(id);
                return "/Controle?action=ListaCommand&listar=produto";
            }
            case "servico": {
                new ServicoDAO().inativar(id);
                return "/Controle?action=ListaCommand&listar=servico";
            }
            default:
                return "painel_admin.jsp";
        }
    }

}
