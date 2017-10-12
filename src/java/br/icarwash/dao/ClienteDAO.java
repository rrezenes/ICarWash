package br.icarwash.dao;

import br.icarwash.model.Cliente;
import br.icarwash.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import br.icarwash.model.Endereco;

public class ClienteDAO {

    private boolean fechaConexao = false;
    private final Connection conexao;
    private static final String INSERT = "insert into cliente(id_usuario, nome, telefone, dt_nascimento, cpf, cep, estado, cidade, bairro, endereco, numero) values(?,?,?,?,?,?,?,?,?,?,?)";
    private static final String SELECT_ALL = "select c.id, c.id_usuario, c.nome, c.telefone, c.dt_nascimento, c.cpf, c.cep, c.estado, c.cidade, c.bairro, c.endereco, c.numero, u.ativo from Cliente c, usuario u where c.id_usuario = u.id and u.ativo = 1";
    private static final String UPDATE = "update cliente set nome = ?, telefone = ?, dt_nascimento = ?, cep = ?, estado = ?, cidade = ?, bairro = ?, endereco = ?, numero = ? WHERE id = ?";
    private static final String INACTIVE_BY_ID = "UPDATE usuario SET ativo = 0 where id = ?;";
    private static final String SELECT_BY_ID = "select id, id_usuario, nome, telefone, dt_nascimento, cpf, cep, estado, cidade, bairro, endereco, numero from cliente where id = ?";
    private static final String SELECT_ID_BY_CPF = "select id from cliente where cpf = ?";
    private static final String SELECT_ID_BY_ID_USUARIO = "SELECT c.id FROM cliente c, usuario u where u.id = c.id_usuario and u.id = ?;";

    public ClienteDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public ClienteDAO() {
        this.conexao = Conexao.getConexao();
        fechaConexao = true;
    }

    public void cadastrar(Cliente cliente) {
        
        try {
            PreparedStatement pstmt = conexao.prepareStatement(INSERT);
            pstmt.setInt(1, cliente.getIdUsuario());
            pstmt.setString(2, cliente.getNome());
            pstmt.setString(3, cliente.getTelefone());
            pstmt.setDate(4, new java.sql.Date(cliente.getDataNascimento().getTimeInMillis()));
            pstmt.setString(5, cliente.getCPF());
            pstmt.setString(6, cliente.getEndereco().getCEP());
            pstmt.setString(7, cliente.getEndereco().getEstado());
            pstmt.setString(8, cliente.getEndereco().getCidade());
            pstmt.setString(9, cliente.getEndereco().getBairro());
            pstmt.setString(10, cliente.getEndereco().getEndereco());
            pstmt.setInt(11, cliente.getEndereco().getNumero());

            pstmt.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.fechaConexao();
    }

    public ArrayList<Cliente> listar() {

        ArrayList<Cliente> clientes = new ArrayList();

        try {
            PreparedStatement pstmt = conexao.prepareStatement(SELECT_ALL);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Calendar cal = Calendar.getInstance();
                Timestamp timestamp;
                timestamp = rs.getTimestamp("dt_nascimento");
                cal.setTimeInMillis(timestamp.getTime());
                Cliente cli = new Cliente(rs.getInt("id"), rs.getInt("id_usuario"), rs.getString("nome"), rs.getString("telefone"), cal, rs.getString("cpf"), new Endereco(rs.getString("cep"), rs.getString("estado"), rs.getString("cidade"), rs.getString("bairro"), rs.getString("endereco"), rs.getInt("numero")));

                clientes.add(cli);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.fechaConexao();
        return clientes;
    }

    public Cliente localizarPorId(int id) {
        Cliente cli = null;
        try {
            Calendar cal = Calendar.getInstance();
            Timestamp timestamp;
            PreparedStatement pstmt = conexao.prepareStatement(SELECT_BY_ID);
            pstmt.setString(1, Integer.toString(id));
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                timestamp = rs.getTimestamp("dt_nascimento");
                cal.setTimeInMillis(timestamp.getTime());
                cli = new Cliente(rs.getInt("id"), rs.getInt("id_usuario"), rs.getString("nome"), rs.getString("telefone"), cal, rs.getString("cpf"), new Endereco(rs.getString("cep"), rs.getString("estado"), rs.getString("cidade"), rs.getString("bairro"), rs.getString("endereco"), rs.getInt("numero")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.fechaConexao();
        return cli;
    }

    public void atualizar(Cliente cliente) {
        try {
            PreparedStatement pstmt = conexao.prepareStatement(UPDATE);
            pstmt.setString(1, cliente.getNome());
            pstmt.setString(2, cliente.getTelefone());
            pstmt.setDate(3, new java.sql.Date(cliente.getDataNascimento().getTimeInMillis()));
            pstmt.setString(4, cliente.getEndereco().getCEP());
            pstmt.setString(5, cliente.getEndereco().getEstado());
            pstmt.setString(6, cliente.getEndereco().getCidade());
            pstmt.setString(7, cliente.getEndereco().getBairro());
            pstmt.setString(8, cliente.getEndereco().getEndereco());
            pstmt.setInt(9, cliente.getEndereco().getNumero());
            pstmt.setInt(10, cliente.getId());
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

    public Cliente localizarIdClientePorIdUsuario(int idUsuario) {
        Cliente cliente = null;
        try {
            PreparedStatement pstmt = conexao.prepareStatement(SELECT_ID_BY_ID_USUARIO);
            pstmt.setInt(1, idUsuario);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                cliente = new Cliente(rs.getInt("id"));
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
