package br.icarwash.control.command;

import br.icarwash.dao.ClienteDAO;
import br.icarwash.dao.ClienteEnderecoDAO;
import br.icarwash.dao.EnderecoDAO;
import br.icarwash.dao.LavadorDAO;
import br.icarwash.dao.ProdutoDAO;
import br.icarwash.dao.ServicoDAO;
import br.icarwash.dao.ServicoProdutoDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.icarwash.model.Cliente;
import br.icarwash.model.Cliente.ClienteBuilder;
import br.icarwash.model.ClienteEndereco;
import br.icarwash.model.Endereco;
import br.icarwash.model.Lavador;
import br.icarwash.model.Servico;
import br.icarwash.model.ServicoProduto;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LocalizaPorIdCommand implements ICommand {

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conexao = (Connection) request.getAttribute("conexao");
        String localizar = request.getParameter("q");
        final int id = Integer.parseInt(request.getParameter("id"));

        switch (localizar) {
            case "cliente": {

                Cliente cliente = new ClienteBuilder()
                        .withId(id)
                        .build();
                cliente = new ClienteDAO(conexao).localizarPorId(cliente);

                ArrayList<ClienteEndereco> clienteEnderecos = new ClienteEnderecoDAO(conexao).selecionaEnderecoPorIdCliente(cliente);
                
                ArrayList<Endereco> enderecos = new ArrayList<>();
                
                for(ClienteEndereco clienteEndereco: clienteEnderecos){
                    enderecos.add(new EnderecoDAO(conexao).localizarPorId(clienteEndereco.getEndereco().getId()));
                }
              

                request.setAttribute("enderecos", enderecos);
                request.setAttribute("cliente", cliente);
                return "localizar_cliente.jsp";
            }
            case "lavador": {

                Lavador lavador = new LavadorDAO(conexao).localizarPorId(id);

                request.setAttribute("lavador", lavador);
                return "localizar_lavador.jsp";
            }
            case "produto": {
                request.setAttribute("produto", new ProdutoDAO(conexao).localizarPorId(id));
                return "localizar_produto.jsp";
            }
            case "servico": {

                Servico servico = new ServicoDAO(conexao).localizarPorId(id);
                ArrayList<ServicoProduto> servicoProdutos = new ServicoProdutoDAO(conexao).selecionaProdutosPorIdServico(servico.getId());

                Map<String, Object> mapaProdutos = new HashMap<>();

                servicoProdutos.forEach(servicoProduto -> {
                    mapaProdutos.put(String.valueOf(servicoProduto.getProduto().getId()), servicoProduto.getProduto());
                });

                request.setAttribute("todosProdutos", new ProdutoDAO(conexao).listar());
                request.setAttribute("servico", servico);
                request.setAttribute("mapaProdutos", mapaProdutos);
                request.setAttribute("servicoProdutos", servicoProdutos);

                return "localizar_servico.jsp";
            }
            default:
                return "painel_admin.jsp";
        }
    }
}
