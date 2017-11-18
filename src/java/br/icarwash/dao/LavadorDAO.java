package br.icarwash.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import br.icarwash.model.Endereco;
import br.icarwash.model.Endereco.EnderecoBuilder;
import br.icarwash.model.Lavador;
import br.icarwash.model.Lavador.LavadorBuilder;
import br.icarwash.model.Usuario;
import br.icarwash.model.Usuario.UsuarioBuilder;
import br.icarwash.util.Conexao;
import java.sql.Statement;

public class LavadorDAO {

    private boolean fechaConexao = false;
    private final Connection conexao;
    private static final String INSERT = "insert into lavador(id_usuario, dt_contrato, nome, telefone, dt_nascimento, CPF) values(?,?,?,?,?,?)";
    private static final String SELECT_ALL = "select l.id, l.id_usuario, l.dt_contrato, u.email, l.nome, l.telefone, l.dt_nascimento, l.cpf, l.ocupado, u.ativo from Lavador l, usuario u where u.id = l.id_usuario and u.ativo = 1";
    private static final String UPDATE = "update lavador set nome = ?, telefone = ?, dt_nascimento = ? WHERE id = ?";
    private static final String INACTIVE_BY_ID = "UPDATE usuario SET ativo=0 where id = ?;";
    private static final String OCUPAR_LAVADOR = "UPDATE lavador SET ocupado = true where id = ?;";
    private static final String DESOCUPAR_LAVADOR = "UPDATE lavador SET ocupado = false where id = ?;";
    private static final String SELECT_BY_ID = "select id, id_usuario, dt_contrato, nome, telefone, dt_nascimento, CPF, ocupado from lavador where id = ?";
    private static final String SELECT_BY_ID_USUARIO = "select * from lavador where id_usuario = ?";
    private static final String SELECT_ID_BY_CPF = "select id from lavador where cpf = ?";
    private static final String SELECT_QTD_LAVADORES = "select COUNT(*) as quantidade_lavadores from Lavador l, usuario u where u.id = l.id_usuario and u.ativo = 1";

    public LavadorDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public LavadorDAO() {
        this.conexao = Conexao.getConexao();
        fechaConexao = true;
    }

    public int cadastrar(Lavador lavador) {
        int idEndereco = 0;
        try {
            PreparedStatement pstmt = conexao.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, lavador.getUsuario().getId());
            pstmt.setDate(2, new java.sql.Date(lavador.getDataContrato().getTimeInMillis()));
            pstmt.setString(3, lavador.getNome());
            pstmt.setString(4, lavador.getTelefone());
            pstmt.setDate(5, new java.sql.Date(lavador.getDataNascimento().getTimeInMillis()));
            pstmt.setString(6, lavador.getCPF());

            pstmt.execute();

            final ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                idEndereco = rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.fechaConexao();
        return idEndereco;
    }

    public ArrayList<Lavador> listar() {
        ArrayList<Lavador> lavadores = new ArrayList();
        Lavador lavador;
        Usuario usuario;
        try {
            PreparedStatement pstmt = conexao.prepareStatement(SELECT_ALL);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Calendar dataContrato = Calendar.getInstance(), dataNascimento = Calendar.getInstance();
                Timestamp timestamp;
                timestamp = rs.getTimestamp("dt_contrato");
                dataContrato.setTimeInMillis(timestamp.getTime());
                timestamp = rs.getTimestamp("dt_nascimento");
                dataNascimento.setTimeInMillis(timestamp.getTime());

                usuario = new UsuarioBuilder()
                        .withId(rs.getInt("id_usuario"))
                        .build();

                lavador = new LavadorBuilder()
                        .withId(rs.getInt("id"))
                        .withUsuario(usuario)
                        .withDataContrato(dataContrato)
                        .withNome(rs.getString("nome"))
                        .withTelefone(rs.getString("telefone"))
                        .withDataNascimento(dataNascimento)
                        .withCpf(rs.getString("cpf"))
                        .build();

                lavador.setOcupado(rs.getBoolean("ocupado"));
                lavadores.add(lavador);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.fechaConexao();
        return lavadores;
    }

    public Lavador localizarPorId(int id) {
        Calendar dataContrato = Calendar.getInstance(), dataNascimento = Calendar.getInstance();
        Lavador lavador = null;
        Usuario usuario;
        try {
            PreparedStatement pstmt = conexao.prepareStatement(SELECT_BY_ID);
            pstmt.setString(1, Integer.toString(id));
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {

                dataContrato.setTimeInMillis(rs.getDate("dt_contrato").getTime());
                dataNascimento.setTimeInMillis(rs.getDate("dt_nascimento").getTime());

                usuario = new UsuarioBuilder()
                        .withId(rs.getInt("id_usuario"))
                        .build();

                lavador = new LavadorBuilder()
                        .withId(rs.getInt("id"))
                        .withUsuario(usuario)
                        .withDataContrato(dataContrato)
                        .withNome(rs.getString("nome"))
                        .withTelefone(rs.getString("telefone"))
                        .withDataNascimento(dataNascimento)
                        .withCpf(rs.getString("cpf"))
                        .build();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.fechaConexao();
        return lavador;
    }

    public Lavador localizarPorIdUsuario(int id) {
        Calendar dataContrato = Calendar.getInstance(), dataNascimento = Calendar.getInstance();
        Lavador lavador = null;
        Usuario usuario;
        try {
            PreparedStatement pstmt = conexao.prepareStatement(SELECT_BY_ID_USUARIO);
            pstmt.setString(1, Integer.toString(id));
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {

                dataContrato.setTimeInMillis(rs.getTime("dt_contrato").getTime());
                dataNascimento.setTimeInMillis(rs.getTime("dt_nascimento").getTime());

                usuario = new UsuarioBuilder()
                        .withId(rs.getInt("id_usuario"))
                        .build();
                
                lavador = new LavadorBuilder()
                        .withId(rs.getInt("id"))
                        .withUsuario(usuario)
                        .withDataContrato(dataContrato)
                        .withNome(rs.getString("nome"))
                        .withTelefone(rs.getString("telefone"))
                        .withDataNascimento(dataNascimento)
                        .withCpf(rs.getString("cpf"))
                        .build();

                lavador.setOcupado(rs.getBoolean("ocupado"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.fechaConexao();
        return lavador;
    }

    public void atualizar(Lavador lavador) {
        try {
            PreparedStatement pstmt = conexao.prepareStatement(UPDATE);
            pstmt.setString(1, lavador.getNome());
            pstmt.setString(2, lavador.getTelefone());
            pstmt.setDate(3, new java.sql.Date(lavador.getDataNascimento().getTimeInMillis()));
            pstmt.setInt(4, lavador.getId());
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
    }

    public int localizarIdPorCpf(String cpf) {
        int IDLavador = 0;
        try {
            PreparedStatement pstmt = conexao.prepareStatement(SELECT_ID_BY_CPF);
            pstmt.setString(1, cpf);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                IDLavador = rs.getInt("id");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.fechaConexao();
        return IDLavador;
    }

    /**
     * Retorna um inteiro com a quantidade de lavadores
     *
     * @return
     */
    public int quantidadeLavadores() {
        int numeroLavadores = 0;

        try {
            PreparedStatement pstmt = conexao.prepareStatement(SELECT_QTD_LAVADORES);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                numeroLavadores = rs.getInt("quantidade_lavadores");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.fechaConexao();

        return numeroLavadores;
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

    public boolean checkCpfDisponivel(String cpf) {
        try {
            PreparedStatement pstmt = conexao.prepareStatement(SELECT_ID_BY_CPF);
            pstmt.setString(1, cpf);
            ResultSet rs = pstmt.executeQuery();
            return !rs.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            this.fechaConexao();
        }
    }

    public void ocuparLavador(int id) {
        try {
            PreparedStatement pstmt = conexao.prepareStatement(OCUPAR_LAVADOR);
            pstmt.setInt(1, id);
            pstmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            this.fechaConexao();
        }
    }

    public void desocuparLavador(int id) {
        try {
            PreparedStatement pstmt = conexao.prepareStatement(DESOCUPAR_LAVADOR);
            pstmt.setInt(1, id);
            pstmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            this.fechaConexao();
        }
    }

}
