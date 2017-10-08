
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="cabecalho.jsp"%>
<div class="jumbotron">
    <h2>Solicitações</h2>
</div>

<table class="table table-hover">
    <thead>
        <tr>
            <th>ID Solicitação</th>
            <th>Nome</th>
            <th>Lavador</th>
            <th>Porte do Veículo</th>
            <th>Data Solicitação</th>
            <th>Valor Total</th>
            <th>Status</th>
            <th colspan=2></th>
        </tr>
    </thead>
    <tbody>
        
        <c:forEach var="solicitacao" items="${solicitacoes}">
            <fmt:formatDate value="${solicitacao.dataSolicitacao.time}" var="dataSolicitacao" type="date" pattern="dd/MM/yyyy HH:mm"/>
            <tr>
                <td>${solicitacao.id}</td>
                <td>${solicitacao.cliente.nome}</td>
                <td>${solicitacao.lavador.id}</td>
                <td>${solicitacao.porte}</td>
                <td>${dataSolicitacao}</td>
                <td>${solicitacao.valorTotal.doubleValue()}</td>
                <td>${solicitacao.estado}</td>
                <c:if test = "${(solicitacao.estado == 'Em Analise') || (solicitacao.estado == 'Agendado')}">
                    <td>
                        <form action="CancelarSolicitacao" method="post">
                            <input type="hidden" name="id_solicitacao" value="${solicitacao.id}"/> 
                            <button type="submit" class="btn btn-danger" value="Cancelar">Cancelar</button>
                        </form>
                    </td>
                </c:if>
            </tr>
        </c:forEach>
    </tbody>
</table>
<%@include file="rodape.jsp"%>
