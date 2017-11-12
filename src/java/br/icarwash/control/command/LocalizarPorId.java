package br.icarwash.control.command;

import br.icarwash.dao.ClienteDAO;
import br.icarwash.dao.EnderecoDAO;
import br.icarwash.dao.LavadorDAO;
import br.icarwash.dao.ProdutoDAO;
import br.icarwash.dao.ServicoDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.icarwash.model.Cliente;
import br.icarwash.model.Endereco;
import br.icarwash.model.Lavador;
import br.icarwash.model.Produto;
import br.icarwash.model.Servico;
import br.icarwash.model.ServicoProduto;
import br.icarwash.util.Conexao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LocalizarPorId implements ICommand {

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String localizar = request.getParameter("q");

        switch (localizar) {
            case "cliente": {
                
                Cliente cliente = new ClienteDAO().localizarPorId(Integer.parseInt(request.getParameter("id")));
                
                ArrayList<Endereco> enderecos = new EnderecoDAO().listarEnderecosCliente(cliente.getId());
                
                request.setAttribute("enderecos", enderecos);
                request.setAttribute("cliente", cliente);
                return "localizar_cliente.jsp";
            }
            case "lavador": {
                
                Lavador lavador = new LavadorDAO().localizarPorId(Integer.parseInt(request.getParameter("id")));
                
                lavador.setEndereco(new EnderecoDAO().localizarPorId(lavador.getEndereco().getId()));
                
                request.setAttribute("lavador", lavador);
                return "localizar_lavador.jsp";
            }
            case "produto": {
                ProdutoDAO produtoDAO = new ProdutoDAO();
                Produto produto = produtoDAO.localizarPorId(Integer.parseInt(request.getParameter("id")));
                request.setAttribute("produto", produto);
                return "localizar_produto.jsp";
            }
            case "servico": {
                
                ServicoDAO servicoDAO = new ServicoDAO(Conexao.getConexao());
                Servico servico = servicoDAO.localizarPorId(Integer.parseInt(request.getParameter("id")));                
                ArrayList<ServicoProduto> servicoProdutos = servicoDAO.selecionaProdutosPorIdServico(servico.getId());
                servicoDAO.fechaConexao();
                
                Map<String, Object> mapaProdutos = new HashMap<>();               
                                
                servicoProdutos.forEach(servicoProduto -> {
                    mapaProdutos.put(String.valueOf(servicoProduto.getProduto().getId()), servicoProduto.getProduto());
                });                
                
                request.setAttribute("todosProdutos", new ProdutoDAO().listar());
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
