package br.icarwash.dao;

import br.icarwash.model.Produto;
import br.icarwash.model.Servico;
import br.icarwash.model.ServicoProduto;
import br.icarwash.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ServicoProdutoDAO {

    private final Connection conexao;
    private boolean fechaConexao = false;
    private static final String INSERT = "insert into servico_produtos(id_servico, id_produto, quantidade) values (?,?,?)";
    private static final String UPDATE_QTD = "update servico_produtos set quantidade = ? where id_servico = ? and id_produto = ?";
    private static final String DELETE_BY_IDS = "DELETE FROM servico_produtos where id_servico = ? and id_produto = ?";
    private static final String SELECT_PRODUTO_BY_ID_SERVICO = "select * from servico_produtos where id_servico = ?";

    public ServicoProdutoDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public ServicoProdutoDAO() {
        this.conexao = Conexao.getConexao();
        fechaConexao = true;
    }

    public void cadastraServicoProduto(int idServico, int idProduto, int quantidade) {
        try {
            PreparedStatement pstmt = conexao.prepareStatement(INSERT);
            pstmt.setInt(1, idServico);
            pstmt.setInt(2, idProduto);
            pstmt.setInt(3, quantidade);
            pstmt.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.fechaConexao();
    }

    public void atualizarServicoProduto(int idServico, int idProduto, int quantidade) {
        try {
            PreparedStatement pstmt = conexao.prepareStatement(UPDATE_QTD);
            pstmt.setInt(1, quantidade);
            pstmt.setInt(2, idServico);
            pstmt.setInt(3, idProduto);
            pstmt.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.fechaConexao();
    }

    public void excluirServicoProduto(int idServico, int idProduto) {
        try {
            PreparedStatement pstmt = conexao.prepareStatement(DELETE_BY_IDS);
            pstmt.setInt(1, idServico);
            pstmt.setInt(2, idProduto);
            pstmt.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.fechaConexao();
    }

    public ArrayList<ServicoProduto> selecionaProdutosPorIdServico(int idServico) {

        ArrayList<ServicoProduto> servicosProdutos = new ArrayList<>();
        Servico servico = new Servico.ServicoBuilder().withId(idServico).build();

        try {
            PreparedStatement pstmt = conexao.prepareStatement(SELECT_PRODUTO_BY_ID_SERVICO);
            pstmt.setInt(1, idServico);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {

                Produto produto = new Produto.ProdutoBuilder()
                        .withId(rs.getInt("id_produto"))
                        .build();

                servicosProdutos.add(new ServicoProduto(servico, produto, rs.getInt("quantidade")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        this.fechaConexao();

        return servicosProdutos;

    }

    private void fechaConexao() throws RuntimeException {
        if (fechaConexao) {
            try {
                conexao.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
