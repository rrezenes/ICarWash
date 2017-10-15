package br.icarwash.control.remoto;

import br.icarwash.dao.LavadorDAO;
import br.icarwash.dao.SolicitacaoDAO;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CheckSolicitacao", urlPatterns = {"/CheckSolicitacaoData"})
public class CheckSolicitacao extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        SolicitacaoDAO solicitacaoDAO = new SolicitacaoDAO();

        String[] data = request.getParameter("data").split("/");
        String dataSolicitacao = data[2] + "-" + data[1] + "-" + data[0];

        ArrayList<String> horariosDisponiveis = gerarListaHoras();

        ArrayList<Integer> horariosIndisponiveis = solicitacaoDAO.consultarHorarioIndisponivel(dataSolicitacao, new LavadorDAO().quantidadeLavadores());

        horariosDisponiveis.removeAll(horariosIndisponiveis);

        Gson gson = new Gson();
        String disponiveis = gson.toJson(horariosDisponiveis);

        out.println(disponiveis);
        out.flush();

    }

    private ArrayList<String> gerarListaHoras() {
        ArrayList<String> horariosDisponiveis = new ArrayList<>();
        
        for (int hora = 8; hora < 18; hora++) {
            if (hora < 10) {
                horariosDisponiveis.add("0".concat(Integer.toString(hora).concat(":00")));
            } else {
                horariosDisponiveis.add(Integer.toString(hora).concat(":00"));
            }
        }
        return horariosDisponiveis;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
