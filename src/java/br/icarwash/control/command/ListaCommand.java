package br.icarwash.control.command;

import br.icarwash.dao.ClienteDAO;
import br.icarwash.dao.EnderecoDAO;
import br.icarwash.dao.LavadorDAO;
import br.icarwash.dao.ProdutoDAO;
import br.icarwash.dao.ServicoDAO;
import br.icarwash.dao.SolicitacaoDAO;
import br.icarwash.dao.UsuarioDAO;
import br.icarwash.model.Cliente;
import br.icarwash.model.Endereco;
import br.icarwash.model.Endereco.EnderecoBuilder;
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

public class ListaCommand implements ICommand {

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String quemListar = request.getParameter("listar");
        Connection conexao = Conexao.getConexao();

        switch (quemListar) {
            case "cliente":

                ClienteDAO clienteDAO = new ClienteDAO();
                ArrayList<Cliente> clientes = clienteDAO.listar();

                try {
                    UsuarioDAO usuarioDAO = new UsuarioDAO(conexao);

                    clientes.forEach((cliente) -> {
                        cliente.setUsuario(usuarioDAO.localizarUsuarioPorID(cliente.getUsuario().getId()));
                    });

                    conexao.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ListaCommand.class.getName()).log(Level.SEVERE, null, ex);
                }

                request.setAttribute("clientes", clientes);

                return "listar_cliente.jsp";

            case "lavador":

                ArrayList<Lavador> lavadores = new LavadorDAO().listar();
                ArrayList<Endereco> enderecos = new ArrayList<>();

                try {
                    UsuarioDAO usuarioDAO = new UsuarioDAO(conexao);
                    EnderecoDAO enderecoDAO = new EnderecoDAO(conexao);

                    lavadores.forEach(lavador -> {
                        lavador.setUsuario(usuarioDAO.localizarUsuarioPorID(lavador.getUsuario().getId()));
                        enderecos.add(enderecoDAO.localizarPorIdUsuario(lavador.getUsuario().getId()).get(0));
                    });

                    conexao.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ListaCommand.class.getName()).log(Level.SEVERE, null, ex);
                }

                request.setAttribute("lavadores", lavadores);
                request.setAttribute("enderecos", enderecos);

                return "listar_lavador.jsp";

            case "servico":
                request.setAttribute("servicos", new ServicoDAO().listar());

                return "listar_servico.jsp";

            case "produto":
                request.setAttribute("produtos", new ProdutoDAO().listar());

                return "listar_produto.jsp";

            case "solicitacao":
                request.setAttribute("solicitacoes", new SolicitacaoDAO().listar());

                return "listar_solicitacao.jsp";

            default:
                return "painel_admin.jsp";
        }
    }
}
