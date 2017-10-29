package br.icarwash.control.command;

import br.icarwash.control.ControleSolicitacao;
import br.icarwash.dao.ClienteDAO;
import br.icarwash.dao.LavadorDAO;
import br.icarwash.dao.ProdutoDAO;
import br.icarwash.dao.ServicoDAO;
import br.icarwash.dao.ServicoProdutoDAO;
import java.io.IOException;
import java.util.Calendar;
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
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Atualizar implements ICommand {

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        switch (request.getParameter("quem")) {
            case "cliente": {

                Calendar calendar = Calendar.getInstance();
                String[] nascimento = request.getParameter("dataNascimento").split("/");
                calendar.set(Integer.parseInt(nascimento[2]), Integer.parseInt(nascimento[1]) - 1, Integer.parseInt(nascimento[0]));

                ClienteDAO dao = new ClienteDAO();
                Cliente cli = new Cliente(Integer.parseInt(request.getParameter("id")), request.getParameter("nome"), request.getParameter("telefone"), calendar, new Endereco(request.getParameter("cep"), request.getParameter("estado"), request.getParameter("cidade"), request.getParameter("bairro"), request.getParameter("endereco"), Integer.parseInt(request.getParameter("numero")), request.getParameter("nomeEndereco")));
                dao.atualizar(cli);

                return "Controle?action=Listar&listar=cliente";
            }
            case "lavador": {

                Calendar cal1, cal2 = Calendar.getInstance();
                cal1 = (Calendar) request.getAttribute("DtAdmissao");
                String[] nascimento = request.getParameter("dataNascimento").split("/");
                cal2.set(Integer.parseInt(nascimento[2]), Integer.parseInt(nascimento[1]) - 1, Integer.parseInt(nascimento[0]));

                LavadorDAO dao = new LavadorDAO();
                Lavador lavador = new Lavador(Integer.parseInt(request.getParameter("id")), cal1, request.getParameter("nome"), request.getParameter("telefone"), cal2, request.getParameter("cpf"), new Endereco(request.getParameter("cep"), request.getParameter("estado"), request.getParameter("cidade"), request.getParameter("bairro"), request.getParameter("endereco"), Integer.parseInt(request.getParameter("numero")), request.getParameter("nomeEndereco")));
                dao.atualizar(lavador);

                return "Controle?action=Listar&listar=lavador";
            }
            case "produto": {
                ProdutoDAO produtoDAO = new ProdutoDAO();
                Produto produto = new Produto(Integer.parseInt(request.getParameter("id")), request.getParameter("nome"), request.getParameter("descricao"));
                produtoDAO.atualizar(produto);

                return "Controle?action=Listar&listar=produto";
            }
            case "servico": {
                Connection conexao = Conexao.getConexao();

                try {
                    conexao.setAutoCommit(false);

                    String[] produtos = request.getParameterValues("produtos");

                    ServicoProdutoDAO servicoProdutoDAO = new ServicoProdutoDAO(conexao);
                    ServicoDAO servicoDAO = new ServicoDAO(conexao);

                    Servico servico = new Servico(Integer.parseInt(request.getParameter("id")), request.getParameter("nome"), request.getParameter("descricao"), new BigDecimal(request.getParameter("valor")));
                    servicoDAO.atualizar(servico);

                    ArrayList<ServicoProduto> servicoProdutos = servicoDAO.selecionaProdutosPorIdServico(servico.getId());

                    Map<String, Object> mapaProdutosDoServico = new HashMap<>();
                    Map<String, String> mapaProdutosDoForm = new HashMap<>();

                    for (String idProduto : produtos) {
                        mapaProdutosDoForm.put(idProduto, idProduto);
                    }

                    servicoProdutos.forEach(servicoProduto -> {
                        //Cria o HashMap de produtos do serviço atual
                        mapaProdutosDoServico.put(String.valueOf(servicoProduto.getProduto().getId()), servicoProduto.getProduto());

                        //EXCLUI produtos que perderem a vinculaçao
                        if (!mapaProdutosDoForm.containsKey(String.valueOf(servicoProduto.getProduto().getId()))) {
                            servicoProdutoDAO.excluirServicoProduto(Integer.parseInt(request.getParameter("id")), servicoProduto.getProduto().getId());
                        }

                    });

                    for (String idProduto : produtos) {
                        if (mapaProdutosDoServico.containsKey(idProduto)) { //Atualiza um novo produto ao serviço
                            servicoProdutoDAO.atualizarServicoProduto(servico.getId(), Integer.parseInt(idProduto), Integer.parseInt(request.getParameter("quantidade" + idProduto)));

                        } else { //Vincula um novo produto ao serviço
                            servicoProdutoDAO.cadastraServicoProduto(servico.getId(), Integer.parseInt(idProduto), Integer.parseInt(request.getParameter("quantidade" + idProduto)));
                        }
                    }

                    conexao.commit();
                } catch (SQLException e) {
                    try {
                        conexao.rollback();
                        throw new RuntimeException(e);
                    } catch (SQLException ex) {
                        Logger.getLogger(ControleSolicitacao.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } finally {
                    try {
                        conexao.close();
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }

                return "Controle?action=Listar&listar=servico";
            }

            default:
                return "painel";
        }
    }

}
