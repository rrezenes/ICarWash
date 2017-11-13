package br.icarwash.dao;

import br.icarwash.model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import br.icarwash.model.Servico;
import br.icarwash.model.ServicoProduto;
import br.icarwash.util.Conexao;
import java.util.ArrayList;

public class ServicoDAO {

    private boolean fechaConexao = false;
    private final Connection conexao;
    private static final String INSERT = "insert into servico(nome, descricao, valor, ativo) values(?, ?, ?, ?)";
    private static final String SELECT_ALL = "select * from servico";
    private static final String UPDATE = "update servico set nome = ?, descricao = ?, valor = ? WHERE id = ?";
    private static final String INACTIVE_BY_ID = "UPDATE servico SET ativo=0 where id=?";
    private static final String ACTIVE_BY_ID = "UPDATE servico SET ativo=1 where id=?";
    private static final String SELECT_BY_ID = "select id, nome, descricao, valor, ativo from servico where id = ?";

    public ServicoDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public ServicoDAO() {
        this.conexao = Conexao.getConexao();
        fechaConexao = true;
    }

    public void cadastrar(Servico servico) {
        try {
            PreparedStatement pstmt = conexao.prepareStatement(INSERT);
            pstmt.setString(1, servico.getNome());
            pstmt.setString(2, servico.getDescricao());
            pstmt.setBigDecimal(3, servico.getValor());
            pstmt.setBoolean(4, servico.isAtivo());

            pstmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.fechaConexao();
    }

    public ArrayList listar() {
        ArrayList<Servico> servicos = new ArrayList();
        try {
            PreparedStatement pstmt = conexao.prepareStatement(SELECT_ALL);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Servico servico = new Servico(rs.getInt("id"), rs.getString("nome"), rs.getString("descricao"), rs.getBigDecimal("valor"), rs.getBoolean("ativo"));
                servicos.add(servico);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.fechaConexao();
        return servicos;
    }

    public Servico localizarPorId(int id) {
        Servico servico = null;
        try {
            PreparedStatement pstmt = conexao.prepareStatement(SELECT_BY_ID);
            pstmt.setString(1, Integer.toString(id));
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                servico = new Servico(rs.getInt("id"), rs.getString("nome"), rs.getString("descricao"), rs.getBigDecimal("valor"), rs.getBoolean("ativo"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.fechaConexao();
        return servico;
    }

    public void atualizar(Servico servico) {
        try {
            PreparedStatement pstmt = conexao.prepareStatement(UPDATE);
            pstmt.setString(1, servico.getNome());
            pstmt.setString(2, servico.getDescricao());
            pstmt.setBigDecimal(3, servico.getValor());
            pstmt.setInt(4, servico.getId());
            pstmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.fechaConexao();
    }

    public void excluir(int id) {
        try {
            PreparedStatement pstmt = conexao.prepareStatement(INACTIVE_BY_ID);
            pstmt.setInt(1, id);
            pstmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.fechaConexao();
    }

    public void ativar(int id) {
        try {
            PreparedStatement pstmt = conexao.prepareStatement(ACTIVE_BY_ID);
            pstmt.setInt(1, id);
            pstmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.fechaConexao();
    }

    public Servico localizarIdUltimoInsert() {
        Servico servico = new Servico();
        try {
            PreparedStatement pstmt = conexao.prepareStatement("SELECT id FROM servico WHERE id = (SELECT MAX(id) FROM servico)");

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                servico.setId(rs.getInt("id"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.fechaConexao();
        return servico;
    }

    public ArrayList<ServicoProduto> selecionaProdutosPorIdServico(int idServico) {

        ArrayList<ServicoProduto> servicosProdutos = new ArrayList<>();
        ServicoProduto servicoProduto;
        Servico servico = new Servico(idServico);

        try {
            PreparedStatement pstmt = conexao.prepareStatement("select s.`ID` as id_servico, p.`ID` as id_produto, s.nome as nome_servico, p.nome as nome_produto, s.descricao as descricao_servico, p.descricao as descricao_produto, s.valor as valor_servico, quantidade as quantidade_produtos from servico_produtos sp, servico s, produto p where sp.id_servico = s.id and sp.id_produto = p.id and s.id = ?");
            pstmt.setInt(1, idServico);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {

                Produto produto = new Produto.ProdutoBuilder()
                        .withId(rs.getInt("id_produto"))
                        .withNome(rs.getString("nome_produto"))
                        .withDescricao(rs.getString("descricao_produto"))
                        .build();
                
                servicosProdutos.add(new ServicoProduto(servico, produto, rs.getInt("quantidade_produtos")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        this.fechaConexao();

        return servicosProdutos;

    }

    public void fechaConexao() throws RuntimeException {
        if (fechaConexao) {
            try {
                conexao.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
