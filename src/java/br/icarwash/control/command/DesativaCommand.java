package br.icarwash.control.command;

import br.icarwash.dao.ProdutoDAO;
import br.icarwash.dao.ServicoDAO;
import br.icarwash.dao.UsuarioDAO;
import java.io.IOException;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DesativaCommand implements ICommand {

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conexao = (Connection) request.getAttribute("conexao");
        String inativar = request.getParameter("q");
        int id = Integer.parseInt(request.getParameter("id"));

        switch (inativar) {
            case "cliente": {
                new UsuarioDAO(conexao).inativar(id);
                return "/Controle?action=ListaCommand&listar=cliente";
            }
            case "lavador": {
                new UsuarioDAO(conexao).inativar(id);
                return "/Controle?action=ListaCommand&listar=lavador";
            }
            case "produto": {
                new ProdutoDAO(conexao).inativar(id);
                return "/Controle?action=ListaCommand&listar=produto";
            }
            case "servico": {
                new ServicoDAO(conexao).inativar(id);
                return "/Controle?action=ListaCommand&listar=servico";
            }
            default:
                return "painel_admin.jsp";
        }
    }

}
