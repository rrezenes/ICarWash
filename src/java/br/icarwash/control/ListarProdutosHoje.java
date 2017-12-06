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

        for (Solicitacao solicitacao : solicitacoes) {
            solicitacaoServico = new SolicitacaoServico(solicitacao);

            ArrayList<SolicitacaoServico> solicitacaoServicos = solicitacaoServicoDAO.selecionaServicosPorIdSolicitacao(solicitacaoServico);

            ArrayList<Servico> servicos = new ArrayList<>();
            solicitacaoServicos.forEach(soliServi -> {
                servicos.add(servicoDAO.localizarPorId(soliServi.getServico()));
            });

            buscarProdutosDeServicos(servicos, conexao);
            
            solicitacao.setServicos(servicos);
        }

        RequestDispatcher rd = request.getRequestDispatcher("/produtos_hoje_lavador.jsp");
        rd.forward(request, response);
    }

    private void buscarProdutosDeServicos(ArrayList<Servico> servicos, Connection conexao) {
        for (Servico servico : servicos) {
            
            servico = new ServicoDAO(conexao).localizarPorId(servico);
            
            ServicoProduto servicoProduto = new ServicoProduto(servico);
            
            ArrayList<ServicoProduto> servicoProdutos
                    = new ServicoProdutoDAO(conexao).selecionaProdutosPorIdServico(servicoProduto);
            
            ArrayList<Produto> produtos = new ArrayList<>();
            ProdutoDAO produtoDAO = new ProdutoDAO(conexao);
            
            servicoProdutos.forEach(sp -> {
                produtos.add(produtoDAO.localizarPorId(sp.getProduto()));
            });
            
            servico.setProdutos(produtos);
        }
    }

}
