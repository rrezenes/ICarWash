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




<!--        < %
            if (session != null) {
//                if (Integer.parseInt(session.getAttribute("acesso").toString()) == 3) {
                    String name = (String) session.getAttribute("user");
        %>-->
<div class="jumbotron">
    <h1>Minhas Solicitações</h1>
    <!--    < % //      }else{
    //                  response.sendRedirect("index.jsp");   
    //                } 
            }
        %>-->
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
            <th colspan=2>Action</th>
        </tr>
    </thead>
    <tbody>
        <%  DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm");
            SolicitacaoDAO solicitacaoDAO = new SolicitacaoDAO();
            ArrayList<Solicitacao> solicitacoes = solicitacaoDAO.listarSolicitacaoPorIDCliente(1);
            for(Solicitacao solicitacao: solicitacoes){%>  
        <tr>
            <td><%=solicitacao.getId()%></td>
            <td><%=solicitacao.getCliente().getNome()%></td>
            <td><%=solicitacao.getLavador().getId()%></td>
            <td><%=solicitacao.getPorte()%></td>
            <td><%=dateFormat.format(solicitacao.getDataSolicitacao().getTime())%></td>
            <td><%=solicitacao.getValorTotal().doubleValue()%></td>
            <td><%=solicitacao.getEstado()%></td>
            <% if(solicitacao.getEstado().toString().equals("Em Analise") || solicitacao.getEstado().toString().equals("Agendado")){  %>
                <td>
                    <form action="ControleCancelarSolicitacao" method="post">
                        <input type="hidden" name="id_solicitacao" value="<%=solicitacao.getId()%>"/> 
                        <input type="submit" value="Cancelar">
                    </form>
                    
                </td>
            <%}%> 
        </tr>
        <%}%> 
    </tbody>
</table>

<%@include file="rodape.jsp"%>