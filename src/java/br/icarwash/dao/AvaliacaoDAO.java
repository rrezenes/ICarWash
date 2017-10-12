package br.icarwash.dao;

import br.icarwash.model.Avaliacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import br.icarwash.util.Conexao;

public class AvaliacaoDAO {

    private final Connection conexao;
    private boolean fechaConexao = false;

    public AvaliacaoDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public AvaliacaoDAO() {
        this.conexao = Conexao.getConexao();
        fechaConexao = true;
    }

    public Avaliacao atribuirNotas(Avaliacao avaliacao) {
        try {
            PreparedStatement pstmt = conexao.prepareStatement("INSERT INTO `icarwash`.`avaliacao`(`nota_pontualidade`,`nota_servico`,`nota_atendimento`,`nota_agilidade`,`nota_media`) VALUES (?,?,?,?,?);");
            pstmt.setBigDecimal(1, avaliacao.getNotaPontualidade());
            pstmt.setBigDecimal(2, avaliacao.getNotaServico());
            pstmt.setBigDecimal(3, avaliacao.getNotaAtendimento());
            pstmt.setBigDecimal(4, avaliacao.getNotaAgilidade());
            pstmt.setBigDecimal(5, avaliacao.getNotaMedia());
            pstmt.execute();

            PreparedStatement pstmtID = conexao.prepareStatement("SELECT MAX(id) FROM avaliacao");
            ResultSet rs = pstmtID.executeQuery();
            if (rs.next()) {
                avaliacao.setID(rs.getInt(1));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.fechaConexao();
        return avaliacao;
    }

    public Avaliacao localizarAvaliacaoPorId(Avaliacao avaliacao) {
        try {
            PreparedStatement pstmt = conexao.prepareStatement("SELECT * FROM avaliacao where id = ?");
            pstmt.setString(1, Integer.toString(avaliacao.getID()));
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                avaliacao = new Avaliacao(rs.getInt("id"), rs.getBigDecimal("nota_pontualidade"), rs.getBigDecimal("nota_servico"), rs.getBigDecimal("nota_atendimento"), rs.getBigDecimal("nota_agilidade"), rs.getBigDecimal("nota_media"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.fechaConexao();
        return avaliacao;
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
