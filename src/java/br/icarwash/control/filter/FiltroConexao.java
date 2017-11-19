package br.icarwash.control.filter;

import br.icarwash.util.Conexao;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(filterName = "FiltroConexao", urlPatterns = {"/*"})
public class FiltroConexao implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        Connection conexao = Conexao.getConexao();
        try {
            conexao.setAutoCommit(false);
            
            request.setAttribute("conexao", conexao);

            chain.doFilter(request, response);

            conexao.commit();

        } catch (SQLException e) {
            try {
                conexao.rollback();
            } catch (SQLException ex) {
                Logger.getLogger(FiltroConexao.class.getName()).log(Level.SEVERE, null, ex);
            }
            throw new ServletException(e);
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(FiltroConexao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }

}
