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
import br.icarwash.model.Cliente.ClienteBuilder;
import br.icarwash.model.Endereco.EnderecoBuilder;
import br.icarwash.model.Lavador.LavadorBuilder;
import br.icarwash.model.Produto.ProdutoBuilder;
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
        Calendar dataNascimento = Calendar.getInstance(), dataContrato = Calendar.getInstance();

        switch (cadastrar) {
            case "cliente": {
                String[] nascimento = request.getParameter("dataNascimento").split("/");
                dataNascimento.set(Integer.parseInt(nascimento[2]), Integer.parseInt(nascimento[1]) - 1, Integer.parseInt(nascimento[0]));

                Endereco endereco = new EnderecoBuilder()
                        .withCep(request.getParameter("cep"))
                        .withEstado(request.getParameter("estado"))
                        .withCidade(request.getParameter("cidade"))
                        .withBairro(request.getParameter("bairro"))
                        .withEndereco(request.getParameter("endereco"))
                        .withNumero(Integer.parseInt(request.getParameter("numero")))
                        .withNome(request.getParameter("nomeEndereco"))
                        .build();

                Cliente cliente = new ClienteBuilder()
                        .withNome(request.getParameter("nome"))
                        .withTelefone(request.getParameter("telefone"))
                        .withDataNascimento(dataNascimento)
                        .withCpf(request.getParameter("cpf"))
                        .withEndereco(endereco)
                        .build();

                Connection conexao = Conexao.getConexao();
                try {
                    conexao.setAutoCommit(false);

                    ClienteEnderecoDAO clienteEnderecoDAO = new ClienteEnderecoDAO(conexao);

                    cliente.setIdUsuario(criaUsuario(request, conexao, 1));

                    ClienteDAO clienteDAO = new ClienteDAO(conexao);
                    EnderecoDAO enderecoDAO = new EnderecoDAO(conexao);

                    clienteEnderecoDAO.cadastraClienteEndereco(clienteDAO.cadastrar(cliente), enderecoDAO.cadastrar(cliente.getEndereco()));

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
                    } catch (SQLException ex) {
                        Logger.getLogger(Cadastrar.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                request.setAttribute("cadastrado", "ok");
                return "Controle?action=Listar&listar=cliente";
            }

            case "lavador": {
                String[] nascimento = request.getParameter("dataNascimento").split("/");
                dataNascimento.set(Integer.parseInt(nascimento[2]), Integer.parseInt(nascimento[1]) - 1, Integer.parseInt(nascimento[0]));

                Connection conexao = Conexao.getConexao();
                try {
                    conexao.setAutoCommit(false);

                    Endereco endereco = new EnderecoBuilder()
                            .withCep(request.getParameter("cep"))
                            .withEstado(request.getParameter("estado"))
                            .withCidade(request.getParameter("cidade"))
                            .withBairro(request.getParameter("bairro"))
                            .withEndereco(request.getParameter("endereco"))
                            .withNumero(Integer.parseInt(request.getParameter("numero")))
                            .withNome("Residencia")
                            .build();

                    endereco.setId(new EnderecoDAO(conexao).cadastrar(endereco));

                    Lavador lavador = new LavadorBuilder()
                            .withIdUsuario(criaUsuario(request, conexao, 2))
                            .withDataContrato(dataContrato)
                            .withNome(request.getParameter("nome"))
                            .withTelefone(request.getParameter("telefone"))
                            .withDataNascimento(dataNascimento)
                            .withCpf(request.getParameter("cpf"))
                            .withEndereco(endereco)
                            .build();

                    new LavadorDAO(conexao).cadastrar(lavador);

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

                ProdutoBuilder produtoBuilder = new ProdutoBuilder()
                        .withNome(request.getParameter("nome"))
                        .withDescricao(request.getParameter("descricao"))
                        .withAtivo(true);

                ProdutoDAO produtoDAO = new ProdutoDAO();
                produtoDAO.cadastrar(produtoBuilder.build());

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
                        int quantidade = Integer.parseInt(request.getParameter("quantidade" + idProduto));
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
        return usuarioDAO.cadastrar(usuario);
    }
}
