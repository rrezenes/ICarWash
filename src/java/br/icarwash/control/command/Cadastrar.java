
package br.icarwash.control.command;

import br.icarwash.control.ControleSolicitacao;
import br.icarwash.dao.*;
import br.icarwash.model.Cliente;
import br.icarwash.model.ClienteUsuario;
import java.io.IOException;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.icarwash.model.*;
import br.icarwash.util.Conexao;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
                Cliente cliente = new Cliente(request.getParameter("nome"), request.getParameter("telefone"), cal1, request.getParameter("cpf"), new Endereco(request.getParameter("cep"), request.getParameter("estado"), request.getParameter("cidade"), request.getParameter("bairro"), request.getParameter("endereco"), Integer.parseInt(request.getParameter("numero"))));
                
                Connection conexao = Conexao.getConexao();
                try {
                    conexao.setAutoCommit(false);
                    //VERIFICAR REPETIÇÃO
                    Usuario usuario = new Usuario(request.getParameter("email"), request.getParameter("login"), request.getParameter("senha"), 1, true);
                    UsuarioDAO usuarioDAO = new UsuarioDAO(conexao);
                    usuarioDAO.cadastrar(usuario);
                    usuario = usuarioDAO.localizarIdPorUsuario(usuario);
                    //VERIFICAR REPETIÇÃO

                    ClienteDAO clienteDAO = new ClienteDAO(conexao);
                    clienteDAO.cadastrar(cliente);
                    Cliente clienteID = new Cliente(clienteDAO.localizarIdPorEmail(cliente.getEmail()));

                    ClienteUsuario clienteUsuario = new ClienteUsuario(clienteID, usuario);
                    ClienteUsuarioDAO clienteUsuarioDAO = new ClienteUsuarioDAO(conexao);
                    clienteUsuarioDAO.cadastrar(clienteUsuario);

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
                
                request.setAttribute("objCliente", cliente);
                return "sucesso.jsp";
            }

            case "lavador": {
                String[] nascimento = request.getParameter("nascimento").split("/");
                cal1.set(Integer.parseInt(nascimento[2]), Integer.parseInt(nascimento[1]) - 1, Integer.parseInt(nascimento[0]));
                Lavador lavador = new Lavador(cal2, request.getParameter("nome"), request.getParameter("telefone"), cal1, request.getParameter("cpf"), new Endereco(request.getParameter("cep"), request.getParameter("estado"), request.getParameter("cidade"), request.getParameter("bairro"), request.getParameter("endereco"), Integer.parseInt(request.getParameter("numero"))));

                Connection conexao = Conexao.getConexao();
                try {
                    conexao.setAutoCommit(false);
                    //VERIFICAR REPETIÇÃO
                    Usuario usuario = new Usuario(request.getParameter("login"), request.getParameter("senha"), 2, true);
                    UsuarioDAO usuarioDAO = new UsuarioDAO(conexao);
                    usuarioDAO.cadastrar(usuario);
                    usuario = usuarioDAO.localizarIdPorUsuario(usuario);
                    //VERIFICAR REPETIÇÃO

                    LavadorDAO lavadorDAO = new LavadorDAO(conexao);
                    lavadorDAO.cadastrar(lavador);
                    Lavador lavadorID = new Lavador(lavadorDAO.localizarIdPorEmail(lavador.getEmail()));

                    LavadorUsuario lavadorUsuario = new LavadorUsuario(lavadorID, usuario);
                    LavadorUsuarioDAO lavadorUsuarioDAO = new LavadorUsuarioDAO(conexao);
                    lavadorUsuarioDAO.cadastrar(lavadorUsuario);
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
                request.setAttribute("objLavador", lavador);
                return "sucesso_lavador.jsp";
            }
            case "produto": {
                Produto produto = new Produto(request.getParameter("nome"), request.getParameter("descricao"), true);
                ProdutoDAO produtoDAO = new ProdutoDAO();
                produtoDAO.cadastrar(produto);

                request.setAttribute("objProduto", produto);
                return "Controle?action=Listar&listar=produto";
            }
            case "servico": {

                String[] produtos = request.getParameterValues("produtos");
                Servico servico = new Servico(request.getParameter("nome"), request.getParameter("descricao"), new BigDecimal(request.getParameter("valor")), true);
                Connection conexao = Conexao.getConexao();
                try {
                    conexao.setAutoCommit(false);
                    
                    ServicoDAO servicoDAO = new ServicoDAO(conexao);
                    servicoDAO.cadastrar(servico);
                    servico = servicoDAO.localizarIdUltimoInsert();

                    ServicoProdutoDAO servicoProdutoDAO = new ServicoProdutoDAO(conexao);

                    for (String idProduto : produtos) {
                        int quantidade = Integer.parseInt(request.getParameter("combo" + idProduto));
                        servicoProdutoDAO.cadastraServicoProduto(servico.getId(), Integer.parseInt(idProduto), quantidade);
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

                request.setAttribute("objProduto", servico);
                return "sucesso_servico.jsp";
            }
            default:
                return "painel_admin.jsp";
        }

    }
}
