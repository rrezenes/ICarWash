/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.icarwash.control;

import br.icarwash.model.Avaliacao;
import br.icarwash.dao.AvaliacaoDAO;
import br.icarwash.dao.ClienteDAO;
import br.icarwash.dao.ServicoDAO;
import br.icarwash.dao.ServicoProdutoDAO;
import br.icarwash.dao.SolicitacaoDAO;
import br.icarwash.dao.SolicitacaoServicoDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.icarwash.model.Cliente;
import br.icarwash.model.Servico;

/**
 *
 * @author rezen
 */
@WebServlet(name = "PedidoController", urlPatterns = {"/PedidoController"})
public class PedidoController extends HttpServlet {

    private String porteVeiculo;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        this.porteVeiculo = request.getParameter("porte_veiculo");
        
        int[] quantidades = this.processa();
        
        ServicoDAO servDAO = new ServicoDAO();
        Servico serv = servDAO.localizarPorId(1/**request.getParameter("servico")**/);
        
        ClienteDAO cliDAO = new ClienteDAO();
        Cliente cli = new Cliente(cliDAO.localizarIdPorEmail(email));
        
        AvaliacaoDAO avaDAO = new AvaliacaoDAO();
        Avaliacao ava = new Avaliacao(avaDAO.create());
        
        SolicitacaoServicoDAO soliServDAO = new SolicitacaoServicoDAO();
        soliServDAO.cadastraSolicitacaoServico(0, 0);               /// AQUI FALTA SOLICITAR ID DA SOLICITACAO NO DAO SOLICITACAODAO
        
        ServicoProdutoDAO servProdDAO = new ServicoProdutoDAO();
        servProdDAO.cadastraServicoProduto(serv.getId(), 1, quantidades[0]);//1 = pano
        servProdDAO.cadastraServicoProduto(serv.getId(), 2, quantidades[1]);//2 = Cristalizador de vidros
        servProdDAO.cadastraServicoProduto(serv.getId(), 3, quantidades[2]);//3 = Spray de lavagem a seco
                
        SolicitacaoDAO solicitaDAO = new SolicitacaoDAO();
        solicitaDAO.cadastraSolicitacao(cli.getId(), serv.getId(), 1, ava.getID());
        
    }

    public int[] processa() {
        int[] qtds = new int[3];
        
        if (this.porteVeiculo.equalsIgnoreCase("Pequeno")) {
            qtds[0] = 5;            qtds[1] = 1;            qtds[2] = 1;
        } else if (this.porteVeiculo.equalsIgnoreCase("Medio")) {
            qtds[0] = 8;            qtds[1] = 1;            qtds[2] = 1;
        } else {
            qtds[0] = 11;           qtds[1] = 1;            qtds[2] = 2;
        }
        return qtds;
    }

}
