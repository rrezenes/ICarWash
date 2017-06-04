<%-- 
    Document   : listaCliente
    Created on : 17/11/2016, 22:13:43
    Author     : rezen
--%>

<%@page import="br.icarwash.model.Solicitacao"%>
<%@page import="br.icarwash.dao.SolicitacaoDAO"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page  contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="cabecalho.jsp"%>
<div class="jumbotron">
    <h1>Minhas Solicitações</h1>
</div>

<table class="table table-hover">
    <thead>
        <tr>
            <th>ID Solicitação</th>
            <th>Nome Cliente</th>
            <th>Cidade</th>
            <th>Bairro</th>
            <th>Porte do Veículo</th>
            <th>Data Solicitação</th>
            <th>Valor Total</th>
            <th colspan=2>Action</th>
        </tr>
    </thead>
    <tbody>
        <%  DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm");
            SolicitacaoDAO solicitacaoDAO = new SolicitacaoDAO();
            ArrayList<Solicitacao> solicitacoes = solicitacaoDAO.listarSolicitacaoDoLavador(usuario.getId());
            for (Solicitacao solicitacao : solicitacoes) {%>  
        <tr>
            <td><%=solicitacao.getId()%></td>
            <td><%=solicitacao.getCliente().getNome()%></td>
            <td><%=solicitacao.getCliente().getEndereco().getCidade()%></td>
            <td><%=solicitacao.getCliente().getEndereco().getBairro()%></td>
            <td><%=solicitacao.getPorte()%></td>            
            <td><%=dateFormat.format(solicitacao.getDataSolicitacao().getTime())%></td>
            <td><%=solicitacao.getValorTotal().doubleValue()%></td>
            <td><%=solicitacao.getEstado()%></td>
            <% if (solicitacao.getEstado().toString().equals("Agendado")) {%>
                <td>
                    <form action="CancelarSolicitacao" method="post">
                        <input type="hidden" name="id_solicitacao" value="<%=solicitacao.getId()%>"/> 
                        <button type="submit" class="btn btn-danger" value="Cancelar">Cancelar</button>
                    </form>
                </td>
                <td>
                    <form action="ProcessarSolicitacao" method="post">
                        <input type="hidden" name="id_solicitacao" value="<%=solicitacao.getId()%>"/>
                        <button type="submit" class="btn btn-success">Processar</button>
                    </form>
                </td>
            <%}%> 
        </tr>
        <%}%> 
    </tbody>
</table>

<%@include file="rodape.jsp"%>