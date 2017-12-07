package br.icarwash.control;

import br.icarwash.dao.AvaliacaoDAO;
import br.icarwash.dao.ClienteDAO;
import br.icarwash.dao.EnderecoDAO;
import br.icarwash.dao.LavadorDAO;
import br.icarwash.dao.ModeloDAO;
import br.icarwash.dao.SolicitacaoDAO;
import br.icarwash.model.Avaliacao;
import br.icarwash.model.Cliente;
import br.icarwash.model.Endereco;
import br.icarwash.model.Lavador;
import br.icarwash.model.Modelo;
import br.icarwash.model.Solicitacao;
import br.icarwash.model.Solicitacao.SolicitacaoBuilder;
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

@WebServlet(name = "ListarSolicitacaoLavador", urlPatterns = {"/ListarSolicitacaoLavador", "/solicitacoes-lavador"})
public class ListarSolicitacaoLavador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Connection conexao = (Connection) request.getAttribute("conexao");

        Usuario usuario = (Usuario) ((HttpServletRequest) request).getSession(true).getAttribute("user");

        Lavador lavador = new Lavador.LavadorBuilder()
                .withUsuario(usuario)
                .build();
        lavador = new LavadorDAO(conexao).localizarPorIdUsuario(lavador);

        Solicitacao solicitacaoWithLavador = new SolicitacaoBuilder()
                .withLavador(lavador)
                .build();

        ArrayList<Solicitacao> solicitacoes = new SolicitacaoDAO(conexao).listarSolicitacaoDoLavador(solicitacaoWithLavador);

        AvaliacaoDAO avaliacaoDAO = new AvaliacaoDAO(conexao);
        EnderecoDAO enderecoDAO = new EnderecoDAO(conexao);
        ClienteDAO clienteDAO = new ClienteDAO(conexao);
        ModeloDAO modeloDAO = new ModeloDAO(conexao);

        Endereco endereco;
        Cliente cliente;
        Modelo modelo;
        Avaliacao avaliacao;
        
        for (Solicitacao solicitacao : solicitacoes) {
            if (solicitacao.getAvaliacao().getId() != 0) {
                avaliacao = avaliacaoDAO.localizarAvaliacaoPorId(solicitacao.getAvaliacao());
                solicitacao.setAvaliacao(avaliacao);
            }
            endereco = enderecoDAO.localizarPorId(solicitacao.getEndereco());
            solicitacao.setEndereco(endereco);
            
            cliente = clienteDAO.localizarPorId(solicitacao.getCliente());
            solicitacao.setCliente(cliente);
            
            modelo = modeloDAO.localizarPorId(solicitacao.getModelo());
            solicitacao.setModelo(modelo);
        }

        request.setAttribute("ocupado", lavador.isOcupado());
        request.setAttribute("solicitacoes", solicitacoes);

        RequestDispatcher rd = request.getRequestDispatcher("/solicitacao_lavador.jsp");
        rd.forward(request, response);

    }

}
