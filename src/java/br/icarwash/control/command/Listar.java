package br.icarwash.control.command;

import br.icarwash.dao.ClienteDAO;
import br.icarwash.dao.LavadorDAO;
import br.icarwash.dao.ProdutoDAO;
import br.icarwash.dao.ServicoDAO;
import br.icarwash.dao.SolicitacaoDAO;
import br.icarwash.dao.UsuarioDAO;
import br.icarwash.model.Cliente;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.icarwash.model.Lavador;
import br.icarwash.model.Produto;
import br.icarwash.model.Servico;
import br.icarwash.model.Solicitacao;
import br.icarwash.model.Usuario;
import br.icarwash.util.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Listar implements ICommand {

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String quemListar = request.getParameter("listar");
        ArrayList<Usuario> usuarios = new ArrayList<>();

        Connection conexao = Conexao.getConexao();

        switch (quemListar) {
            case "cliente":

                ArrayList<Cliente> clientes = null;
                ClienteDAO clienteDAO = new ClienteDAO();
                clientes = clienteDAO.listar();
                try {
                    UsuarioDAO usuarioDAO = new UsuarioDAO(conexao);

                    for (Cliente cliente : clientes) {
                        usuarios.add(usuarioDAO.localizarUsuarioPorID(cliente.getIdUsuario()));
                    }

                    conexao.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Listar.class.getName()).log(Level.SEVERE, null, ex);
                }

                request.setAttribute("clientes", clientes);
                request.setAttribute("usuarios", usuarios);
                return "listar_cliente.jsp";
            case "lavador":
                ArrayList<Lavador> lavadores = null;
                LavadorDAO lavadorDAO = new LavadorDAO();
                lavadores = lavadorDAO.listar();
                
                try {

                    UsuarioDAO usuarioDAO = new UsuarioDAO(conexao);

                    for (Lavador lavador : lavadores) {
                        usuarios.add(usuarioDAO.localizarUsuarioPorID(lavador.getIdUsuario()));
                        System.out.println(lavador.getId());
                    }

                    for (Usuario u : usuarios) {
                        System.out.println(u.getId());
                        System.out.println(u.getEmail());
                    }

                    conexao.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Listar.class.getName()).log(Level.SEVERE, null, ex);
                }

                request.setAttribute("lavadores", lavadores);
                request.setAttribute("usuarios", usuarios);
                
                return "listar_lavador.jsp";
                
            case "produto":
                
                ProdutoDAO produtoDAO = new ProdutoDAO();
                ArrayList<Produto> produtos = produtoDAO.listar();
                request.setAttribute("produtos", produtos);
                
                return "listar_produto.jsp";
                
            case "servico":
                
                ServicoDAO servicoDAO = new ServicoDAO();
                ArrayList<Servico> servicos = servicoDAO.listar();
                request.setAttribute("servicos", servicos);
                
                return "listar_servico.jsp";
                
            case "solicitacao":
                
                SolicitacaoDAO solicitacaoDAO = new SolicitacaoDAO();
                ArrayList<Solicitacao> solicitacoes = solicitacaoDAO.listar();
                request.setAttribute("solicitacoes", solicitacoes);
                
                return "listar_solicitacao.jsp";
                
            default:
                return "painel_admin.jsp";
        }
    }
}
