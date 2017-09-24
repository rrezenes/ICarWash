<%-- 
    Document   : listaCliente
    Created on : 17/11/2016, 22:13:43
    Author     : rezen
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <th>Status</th>
            <th colspan=2>Action</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="solicitacao" items="${solicitacoes}">
            <fmt:formatDate value="${solicitacao.dataSolicitacao.time}" var="dataSolicitacao" type="date" pattern="dd/MM/yyyy" />
            <tr>
                <td>${solicitacao.id}</td>
                <td>${solicitacao.cliente.nome}</td>
                <td>${solicitacao.cliente.endereco.cidade}</td>
                <td>${solicitacao.cliente.endereco.bairro}</td>
                <td>${solicitacao.porte}</td>            
                <td>${dataSolicitacao}</td>
                <td>${solicitacao.valorTotal.doubleValue()}</td>
                <td>${solicitacao.estado}</td>
                <c:if test="${solicitacao.estado == 'Agendado'}">
                    <td>
                        <form action="CancelarSolicitacao" method="post">
                            <input type="hidden" name="id_solicitacao" value="${solicitacao.id}"/> 
                            <button type="submit" class="btn btn-danger" value="Cancelar">Cancelar</button>
                        </form>
                    </td>
                    <td>
                        <form action="ProcessarSolicitacao" method="post">
                            <input type="hidden" name="id_solicitacao" value="${solicitacao.id}"/>
                            <button type="submit" class="btn btn-success">Processar</button>
                        </form>
                    </td>
                </c:if>
                <c:if test="${solicitacao.estado == 'Em Processo'}">
                    <td>
                        <form action="FinalizarSolicitacao" method="post">
                            <input type="hidden" name="id_solicitacao" value="${solicitacao.id}"/>
                            <button type="submit" class="btn btn-success">Finalizar</button>
                        </form>
                    </td>
                </c:if>
            </tr>        
        </c:forEach>

    </tbody>
</table>

<%@include file="rodape.jsp"%>