package br.icarwash.dao;

import br.icarwash.model.Cliente;
import br.icarwash.model.Cliente.ClienteBuilder;
import br.icarwash.model.Usuario;
import br.icarwash.model.Usuario.UsuarioBuilder;
import br.icarwash.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.sql.Statement;

public class ClienteDAO {

    private boolean fechaConexao = false;
    private final Connection conexao;
    private static final String INSERT = "insert into cliente(id_usuario, nome, telefone, dt_nascimento, cpf) values(?,?,?,?,?)";
    private static final String SELECT_ALL = "select c.id, c.id_usuario, c.nome, c.telefone, c.dt_nascimento, c.cpf, u.ativo from Cliente c, usuario u where c.id_usuario = u.id and u.ativo = 1 group by id";
    private static final String UPDATE = "update cliente set nome = ?, telefone = ?, dt_nascimento = ? WHERE id = ?";
    private static final String INACTIVE_BY_ID = "UPDATE usuario SET ativo = 0 where id = ?;";
    private static final String SELECT_BY_ID = "select id, id_usuario, nome, telefone, dt_nascimento, cpf from cliente where id = ?";
    private static final String SELECT_BY_ID_USUARIO = "select * from cliente where id_usuario = ?";
    private static final String SELECT_ID_BY_CPF = "select id from cliente where cpf = ?";

    public ClienteDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public ClienteDAO() {
        this.conexao = Conexao.getConexao();
        fechaConexao = true;
    }

    public int cadastrar(Cliente cliente) {
        int idCliente = 0;

        try {
            PreparedStatement pstmt = conexao.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, cliente.getUsuario().getId());
            pstmt.setString(2, cliente.getNome());
            pstmt.setString(3, cliente.getTelefone());
            pstmt.setDate(4, new java.sql.Date(cliente.getDataNascimento().getTimeInMillis()));
            pstmt.setString(5, cliente.getCPF());

            pstmt.execute();

            final ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                idCliente = rs.getInt(1);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        this.fechaConexao();

        return idCliente;
    }

    public ArrayList<Cliente> listar() {

        ArrayList<Cliente> clientes = new ArrayList();
        Cliente cliente;
        try {
            PreparedStatement pstmt = conexao.prepareStatement(SELECT_ALL);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Calendar cal = Calendar.getInstance();
                Timestamp timestamp;
                timestamp = rs.getTimestamp("dt_nascimento");
                cal.setTimeInMillis(timestamp.getTime());

                cliente = new ClienteBuilder()
                        .withId(rs.getInt("id"))
                        .withUsuario(new UsuarioBuilder().withId(rs.getInt("id_usuario")).build())
                        .withNome(rs.getString("nome"))
                        .withTelefone(rs.getString("telefone"))
                        .withDataNascimento(cal)
                        .withCpf(rs.getString("cpf"))
                        .build();

                clientes.add(cliente);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.fechaConexao();
        return clientes;
    }

    public Cliente localizarPorId(int id) {
        Cliente cliente = null;
        Usuario usuario;
        try {
            Calendar cal = Calendar.getInstance();
            Timestamp timestamp;
            PreparedStatement pstmt = conexao.prepareStatement(SELECT_BY_ID);
            pstmt.setString(1, Integer.toString(id));
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                timestamp = rs.getTimestamp("dt_nascimento");
                cal.setTimeInMillis(timestamp.getTime());

                usuario = new UsuarioBuilder()
                        .withId(rs.getInt("id_usuario"))
                        .build();

                cliente = new ClienteBuilder()
                        .withId(rs.getInt("id"))
                        .withUsuario(usuario)
                        .withNome(rs.getString("nome"))
                        .withTelefone(rs.getString("telefone"))
                        .withDataNascimento(cal)
                        .withCpf(rs.getString("cpf"))
                        .build();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.fechaConexao();
        return cliente;
    }

    public void atualizar(Cliente cliente) {
        try {
            PreparedStatement pstmt = conexao.prepareStatement(UPDATE);
            pstmt.setString(1, cliente.getNome());
            pstmt.setString(2, cliente.getTelefone());
            pstmt.setDate(3, new java.sql.Date(cliente.getDataNascimento().getTimeInMillis()));
            pstmt.setInt(4, cliente.getId());
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

    public int localizarIdPorCpf(String cpf) {
        int IDCliente = 0;
        try {
            PreparedStatement pstmt = conexao.prepareStatement(SELECT_ID_BY_CPF);
            pstmt.setString(1, cpf);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                IDCliente = rs.getInt("id");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.fechaConexao();
        return IDCliente;
    }

    public Cliente localizarPorIdUsuario(int idUsuario) {
        Cliente cliente = null;
        Usuario usuario;
        try {
            Calendar cal = Calendar.getInstance();
            Timestamp timestamp;
            PreparedStatement pstmt = conexao.prepareStatement(SELECT_BY_ID_USUARIO);
            pstmt.setInt(1, idUsuario);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                timestamp = rs.getTimestamp("dt_nascimento");
                cal.setTimeInMillis(timestamp.getTime());

                usuario = new UsuarioBuilder()
                        .withId(rs.getInt("id_usuario"))
                        .build();

                cliente = new ClienteBuilder()
                        .withId(rs.getInt("id"))
                        .withUsuario(usuario)
                        .withNome(rs.getString("nome"))
                        .withTelefone(rs.getString("telefone"))
                        .withDataNascimento(cal)
                        .withCpf(rs.getString("cpf"))
                        .build();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.fechaConexao();
        return cliente;
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
