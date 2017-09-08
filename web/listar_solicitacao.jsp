<%-- 
    Document   : listar_solicitacoes
    Created on : 07/09/2017, 11:22:14
    Author     : rezen
--%>
<%@page import="br.icarwash.model.Solicitacao"%>
<%@page import="br.icarwash.dao.SolicitacaoDAO"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="cabecalho.jsp"%>
<div class="jumbotron">
    <h2>Solicitações Pendentes</h2>
</div>

<table class="table table-hover">
    <thead>
        <tr>
            <th>ID Solicitação</th>
            <th>Nome</th>
            <th>Lavador</th>
            <th>Porte do Veiculo</th>
            <th>Data Solicitação</th>
            <th>Valor Total</th>
            <th>Status</th>
            <th colspan=2></th>
        </tr>
    </thead>
    <tbody>
        <%  DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm");
            SolicitacaoDAO solicitacaoDAO = new SolicitacaoDAO();
            ArrayList<Solicitacao> solicitacoes = solicitacaoDAO.listar();
            for (Solicitacao solicitacao : solicitacoes) {%>  
        <tr>
            <td><%=solicitacao.getId()%></td>
            <td><%=solicitacao.getCliente().getNome()%></td>
            <td><%=solicitacao.getLavador().getId()%></td>
            <td><%=solicitacao.getPorte()%></td>
            <td><%=dateFormat.format(solicitacao.getDataSolicitacao().getTime())%></td>
            <td><%=solicitacao.getValorTotal().doubleValue()%></td>
            <td><%=solicitacao.getEstado()%></td>
            <% if (solicitacao.getEstado().toString().equals("Em Analise") || solicitacao.getEstado().toString().equals("Agendado")) {%>
            <td>
                <form action="CancelarSolicitacao" method="post">
                    <input type="hidden" name="id_solicitacao" value="<%=solicitacao.getId()%>"/> 
                    <button type="submit" class="btn btn-danger" value="Cancelar">Cancelar</button>
                </form>
            </td>
            <%}%> 
        </tr>
        <%}%> 
    </tbody>
</table>
<%@include file="rodape.jsp"%>
