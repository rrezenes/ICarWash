package br.icarwash.control;

import br.icarwash.dao.ClienteDAO;
import br.icarwash.dao.EnderecoDAO;
import br.icarwash.dao.LavadorDAO;
import br.icarwash.dao.SolicitacaoDAO;
import br.icarwash.dao.UsuarioDAO;
import br.icarwash.model.Cliente;
import br.icarwash.model.Cliente.ClienteBuilder;
import br.icarwash.model.Endereco;
import br.icarwash.model.Lavador;
import br.icarwash.model.Solicitacao;
import br.icarwash.model.Usuario;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ControleDashboard", urlPatterns = {"/Dashboard"})
public class ControleDashboard extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conexao = (Connection) request.getAttribute("conexao");

        HttpSession session = ((HttpServletRequest) request).getSession(true);
        Usuario usuario = (Usuario) session.getAttribute("user");

        switch (usuario.getNivel()) {
            case 1: {

                break;
            }
            case 2: {
                
                break;
            }
            default: {
                ArrayList<Solicitacao> solicitacoesAvaliadas = new SolicitacaoDAO(conexao).listarSolicitacoesAvaliadas();
                Double soma = null;
                
                for(int i = 0; i < solicitacoesAvaliadas.size() - 1; i++){
                    Lavador lavador = new LavadorDAO(conexao).localizarPorId(solicitacoesAvaliadas.get(i).getLavador().getId());
                    soma += solicitacoesAvaliadas.get(i).getAvaliacao().getNotaMedia().doubleValue();
                }
                BigDecimal media = new BigDecimal(soma /solicitacoesAvaliadas.size());

                request.setAttribute();
                
                RequestDispatcher rd = request.getRequestDispatcher("/painel_admin.jsp");
                rd.forward(request, response);
                break;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conexao = (Connection) request.getAttribute("conexao");

        HttpSession session = ((HttpServletRequest) request).getSession(true);
        Usuario usuario = (Usuario) session.getAttribute("user");

        usuario.setSenha(request.getParameter("senha"));

        UsuarioDAO usuarioDAO = new UsuarioDAO(conexao);

        usuario = usuarioDAO.usuarioLogin(usuario);

        if (usuario.getNivel() >= 1) {
            usuario.setSenha(request.getParameter("nova_senha"));
            usuarioDAO.alterarSenha(usuario);
            request.setAttribute("alterado", "ok");
        } else {
            request.setAttribute("senhaInvalida", "ok");
        }

        doGet(request, response);
    }
}
