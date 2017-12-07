package br.icarwash.control;

import br.icarwash.dao.LavadorDAO;
import br.icarwash.dao.ProdutoDAO;
import br.icarwash.dao.ServicoDAO;
import br.icarwash.dao.ServicoProdutoDAO;
import br.icarwash.dao.SolicitacaoDAO;
import br.icarwash.dao.SolicitacaoServicoDAO;
import br.icarwash.model.Lavador;
import br.icarwash.model.Lavador.LavadorBuilder;
import br.icarwash.model.Produto;
import br.icarwash.model.Servico;
import br.icarwash.model.ServicoProduto;
import br.icarwash.model.Solicitacao;
import br.icarwash.model.Solicitacao.SolicitacaoBuilder;
import br.icarwash.model.SolicitacaoServico;
import br.icarwash.model.Usuario;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ListarProdutosHoje", urlPatterns = {"/produtos-de-hoje"})
public class ListarProdutosHoje extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conexao = (Connection) request.getAttribute("conexao");

        HttpSession session = ((HttpServletRequest) request).getSession(true);
        Usuario usuario = (Usuario) session.getAttribute("user");

        Lavador lavador = new LavadorBuilder()
                .withUsuario(usuario)
                .build();
        lavador = new LavadorDAO(conexao).localizarPorIdUsuario(lavador);

        SolicitacaoDAO solicitacaoDAO = new SolicitacaoDAO(conexao);

        Solicitacao soli = new SolicitacaoBuilder()
                .withLavador(lavador)
                .build();

        ArrayList<Solicitacao> solicitacoes = solicitacaoDAO.listarSolicitacaoHojeLavador(soli);
        SolicitacaoServico solicitacaoServico;
        SolicitacaoServicoDAO solicitacaoServicoDAO = new SolicitacaoServicoDAO(conexao);
        ServicoDAO servicoDAO = new ServicoDAO(conexao);

        HashMap<String, Integer> quantidadeDeProdutosTotal = new HashMap<>();

        ArrayList<Produto> products = new ProdutoDAO(conexao).listar();
        for (Produto product : products) {
            quantidadeDeProdutosTotal.put(product.getNome(), 0);
        }

        for (Solicitacao solicitacao : solicitacoes) {
            solicitacaoServico = new SolicitacaoServico(solicitacao);

            ArrayList<SolicitacaoServico> solicitacaoServicos = solicitacaoServicoDAO.selecionaServicosPorIdSolicitacao(solicitacaoServico);

            ArrayList<Servico> servicos = new ArrayList<>();
            solicitacaoServicos.forEach(soliServi -> {
                servicos.add(servicoDAO.localizarPorId(soliServi.getServico()));
            });

            ProdutoDAO produtoDAO = new ProdutoDAO(conexao);
            ServicoProduto servicoProduto;

            Integer aux = 0;
            for (Servico servico : servicos) {
                servicoProduto = new ServicoProduto(servico);

                ArrayList<ServicoProduto> servicoProdutos = new ServicoProdutoDAO(conexao).selecionaProdutosPorIdServico(servicoProduto);

                HashMap<Produto, Integer> produtos = new HashMap<>();
                Produto produto;
                for (ServicoProduto sp : servicoProdutos) {
                    produto = produtoDAO.localizarPorId(sp.getProduto());
                    produtos.put(produto, sp.getQuantidade());
                    for (Map.Entry<String, Integer> entry : quantidadeDeProdutosTotal.entrySet()) {
                        if (entry.getKey().equals(produto.getNome())) {
                            quantidadeDeProdutosTotal.get(produto.getNome());
                            aux += sp.getQuantidade();
                            quantidadeDeProdutosTotal.replace(produto.getNome(), aux);
                        }
                    }
                }

                servico.setProdutos(produtos);
            }

            solicitacao.setServicos(servicos);
        }

        request.setAttribute("quantidadeDeProdutosTotal", quantidadeDeProdutosTotal);
        request.setAttribute("solicitacoes", solicitacoes);
        RequestDispatcher rd = request.getRequestDispatcher("/produtos_hoje_lavador.jsp");
        rd.forward(request, response);
    }

}
