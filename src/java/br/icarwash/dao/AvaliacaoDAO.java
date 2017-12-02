package br.icarwash.dao;

import br.icarwash.model.Avaliacao;
import br.icarwash.model.Avaliacao.AvaliacaoBuilder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AvaliacaoDAO {

    private final Connection conexao;
    private static final String ATRIBUIR_NOTAS = "INSERT INTO `icarwash`.`avaliacao`(`nota_pontualidade`,`nota_servico`,`nota_atendimento`,`nota_agilidade`,`nota_media`) VALUES (?,?,?,?,?);";
    private static final String SELECT_BY_ID = "SELECT * FROM avaliacao where id = ?";

    public AvaliacaoDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public int atribuirNotas(Avaliacao avaliacao) {
        int idAvaliacao = 0;
        try {
            PreparedStatement pstmt = conexao.prepareStatement(ATRIBUIR_NOTAS, Statement.RETURN_GENERATED_KEYS);
            pstmt.setBigDecimal(1, avaliacao.getNotaPontualidade());
            pstmt.setBigDecimal(2, avaliacao.getNotaServico());
            pstmt.setBigDecimal(3, avaliacao.getNotaAtendimento());
            pstmt.setBigDecimal(4, avaliacao.getNotaAgilidade());
            pstmt.setBigDecimal(5, avaliacao.getNotaMedia());
            pstmt.execute();

            final ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                idAvaliacao = rs.getInt(1);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return idAvaliacao;
    }

    public Avaliacao localizarAvaliacaoPorId(Avaliacao avaliacao) {
        AvaliacaoBuilder builder = null;
        try {
            PreparedStatement pstmt = conexao.prepareStatement(SELECT_BY_ID);
            pstmt.setString(1, Integer.toString(avaliacao.getId()));
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                builder = new Avaliacao.AvaliacaoBuilder()
                        .withId(rs.getInt("id"))
                        .withNotaPontualidade(rs.getBigDecimal("nota_pontualidade"))
                        .withNotaServico(rs.getBigDecimal("nota_servico"))
                        .withNotaAtendimento(rs.getBigDecimal("nota_atendimento"))
                        .withNotaAgilidade(rs.getBigDecimal("nota_agilidade"))
                        .withNotaMedia(rs.getBigDecimal("nota_media"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return builder.build();
    }
}
