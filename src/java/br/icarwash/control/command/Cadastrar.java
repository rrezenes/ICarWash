
package br.icarwash.control.command;

import br.icarwash.control.ControleSolicitacao;
import br.icarwash.dao.*;
import br.icarwash.model.Cliente;
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
                            
                    cliente.setIdUsuario(criaUsuario(request, conexao, 1));                    
                    ClienteDAO clienteDAO = new ClienteDAO(conexao);
                    clienteDAO.cadastrar(cliente);

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
                
                request.setAttribute("cadastrado", "ok");
                return "Controle?action=Listar&listar=cliente";
            }

            case "lavador": {
                String[] nascimento = request.getParameter("nascimento").split("/");
                cal1.set(Integer.parseInt(nascimento[2]), Integer.parseInt(nascimento[1]) - 1, Integer.parseInt(nascimento[0]));
                Lavador lavador = new Lavador(cal2, request.getParameter("nome"), request.getParameter("telefone"), cal1, request.getParameter("cpf"), new Endereco(request.getParameter("cep"), request.getParameter("estado"), request.getParameter("cidade"), request.getParameter("bairro"), request.getParameter("endereco"), Integer.parseInt(request.getParameter("numero"))));

                Connection conexao = Conexao.getConexao();
                try {
                    conexao.setAutoCommit(false);
                    
                    lavador.setIdUsuario(criaUsuario(request, conexao, 2));                    
                    LavadorDAO lavadorDAO = new LavadorDAO(conexao);
                    lavadorDAO.cadastrar(lavador);

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
                request.setAttribute("cadastrado", "ok");
                return "Controle?action=Listar&listar=lavador";
            }
            case "produto": {
                Produto produto = new Produto(request.getParameter("nome"), request.getParameter("descricao"), true);
                ProdutoDAO produtoDAO = new ProdutoDAO();
                produtoDAO.cadastrar(produto);

                request.setAttribute("cadastrado", "ok");
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
                
                request.setAttribute("cadastrado", "ok");
                return "Controle?action=Listar&listar=servico";
            }
            default:
                return "painel_admin.jsp";
        }

    }

    private int criaUsuario(HttpServletRequest request, Connection conexao, int nivelDeAcesso) {
        Usuario usuario = new Usuario(request.getParameter("email"), request.getParameter("senha"), nivelDeAcesso, true, true);
        UsuarioDAO usuarioDAO = new UsuarioDAO(conexao);
        usuarioDAO.cadastrar(usuario);
        return usuarioDAO.localizarIdPorEmailUsuario(usuario.getEmail());        
    }
}
