
package br.icarwash.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SolicitacaoServicoDAO {

    private final Connection conexao;

    public SolicitacaoServicoDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void cadastraSolicitacaoServico(int idSolicitacao, int idServico) {
        try {
            PreparedStatement pstmt = conexao.prepareStatement("insert into solicitacao_servico(id_solicitacao, id_servico) values (?,?)");
            pstmt.setInt(1, idSolicitacao);
            pstmt.setInt(2, idServico);
            pstmt.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
