package br.icarwash.control.command;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ICommand {

    public String executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
