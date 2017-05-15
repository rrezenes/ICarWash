/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.icarwash.control;

import br.icarwash.dao.ClienteDAO;
import br.icarwash.dao.ClienteUsuarioDAO;
import br.icarwash.dao.LavadorDAO;
import br.icarwash.dao.LavadorUsuarioDAO;
import br.icarwash.dao.ProdutoDAO;
import br.icarwash.dao.ServicoDAO;
import br.icarwash.dao.ServicoProdutoDAO;
import br.icarwash.dao.UsuarioDAO;
import br.icarwash.model.Cliente;
import br.icarwash.model.ClienteUsuario;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.icarwash.model.Endereco;
import br.icarwash.model.Lavador;
import br.icarwash.model.LavadorUsuario;
import br.icarwash.model.Produto;
import br.icarwash.model.Servico;
import br.icarwash.model.Usuario;
import java.math.BigDecimal;
import java.util.Enumeration;

/**
 *
 * @author rezen
 */
public class Cadastrar implements ICommand {

    @Override
    public String executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cadastrar = request.getParameter("quem");

        Calendar cal1 = Calendar.getInstance(), cal2 = Calendar.getInstance();

        switch (cadastrar) {
            case "cliente": {
                String[] nascimento = request.getParameter("nascimento").split("/");
                cal1.set(Integer.parseInt(nascimento[2]), Integer.parseInt(nascimento[1]) - 1, Integer.parseInt(nascimento[0]));

                //VERIFICAR REPETIÇÃO
                Usuario usuario = new Usuario(request.getParameter("login"), request.getParameter("senha"), 1, true);
                UsuarioDAO usuarioDAO = new UsuarioDAO();
                usuarioDAO.cadastrar(usuario);
                Usuario usuarioID = new Usuario(usuarioDAO.localizarIdPorUsuario(usuario.getUsuario()));
                //VERIFICAR REPETIÇÃO

                Cliente cliente = new Cliente(request.getParameter("txtEmail"), request.getParameter("nome"), request.getParameter("telefone"), cal1, request.getParameter("cpf"), new Endereco(request.getParameter("cep"), request.getParameter("estado"), request.getParameter("cidade"), request.getParameter("bairro"), request.getParameter("endereco"), Integer.parseInt(request.getParameter("numero"))));
                ClienteDAO clienteDAO = new ClienteDAO();
                clienteDAO.cadastrar(cliente);
                Cliente clienteID = new Cliente(clienteDAO.localizarIdPorEmail(cliente.getEmail()));

                ClienteUsuario clienteUsuario = new ClienteUsuario(clienteID, usuarioID);
                ClienteUsuarioDAO clienteUsuarioDAO = new ClienteUsuarioDAO();
                clienteUsuarioDAO.cadastrar(clienteUsuario);

                request.setAttribute("objCliente", cliente);
                return "sucesso.jsp";
            }
            case "lavador": {
                String[] nascimento = request.getParameter("nascimento").split("/");
                cal1.set(Integer.parseInt(nascimento[2]), Integer.parseInt(nascimento[1]) - 1, Integer.parseInt(nascimento[0]));

                //VERIFICAR REPETIÇÃO
                Usuario usuario = new Usuario(request.getParameter("login"), request.getParameter("senha"), 2, true);
                UsuarioDAO usuarioDAO = new UsuarioDAO();
                usuarioDAO.cadastrar(usuario);
                Usuario usuarioID = new Usuario(usuarioDAO.localizarIdPorUsuario(usuario.getUsuario()));
                //VERIFICAR REPETIÇÃO

                Lavador lavador = new Lavador(cal2, request.getParameter("email"), request.getParameter("nome"), request.getParameter("telefone"), cal1, request.getParameter("cpf"), new Endereco(request.getParameter("cep"), request.getParameter("estado"), request.getParameter("cidade"), request.getParameter("bairro"), request.getParameter("endereco"), Integer.parseInt(request.getParameter("numero"))));
                LavadorDAO lavadorDAO = new LavadorDAO();
                lavadorDAO.cadastrar(lavador);
                Lavador lavadorID = new Lavador(lavadorDAO.localizarIdPorEmail(lavador.getEmail()));

                LavadorUsuario lavadorUsuario = new LavadorUsuario(lavadorID, usuarioID);
                LavadorUsuarioDAO lavadorUsuarioDAO = new LavadorUsuarioDAO();
                lavadorUsuarioDAO.cadastrar(lavadorUsuario);

                request.setAttribute("objLavador", lavador);
                return "sucesso_lavador.jsp";
            }
            case "produto": {
                Produto produto = new Produto(request.getParameter("nome"), request.getParameter("descricao"), true);
                ProdutoDAO produtoDAO = new ProdutoDAO();
                produtoDAO.cadastrar(produto);

                request.setAttribute("objProduto", produto);
                return "sucesso_produto.jsp";
            }
            case "servico": {
                String teste = "utos";
                String[] produtos = request.getParameterValues("prod" + teste);

                for(String idProduto: produtos){
                    String qtd = request.getParameter("combo" + idProduto);
                    System.out.println(qtd);
                }
                
                Servico servico = new Servico(request.getParameter("nome"), request.getParameter("descricao"), new BigDecimal(request.getParameter("valor")), true);
                ServicoDAO servicoDAO = new ServicoDAO();
                servicoDAO.cadastrar(servico);

                ServicoProdutoDAO servicoProdutoDAO = new ServicoProdutoDAO();

                request.setAttribute("objProduto", servico);
                return "sucesso_servico.jsp";
            }
            default:
                return "painel_admin.jsp";
        }

    }
}
