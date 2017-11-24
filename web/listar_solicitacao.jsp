
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="cabecalho.jsp"%>

<div class="row">
    <p class="titulo-controle">Solicitações Realizadas</p>
    <div class="divider"></div>
</div>
<div class="row">
    <div class="col s6">
        
    </div>
    <div class="input-field col s6">
        <input class="validate" id="buscar" type="text" name="buscar" />
        <label for='email'>Buscar</label>
    </div>
</div>
<table id="tabela" class="table table-hover centered striped responsive-table">
    <thead>
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Lavador</th>
            <th>Porte</th>
            <th>Data</th>
            <th>Total</th>
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
                <td>${solicitacao.modelo.id}</td>
                <td>${dataSolicitacao}</td>
                <td>${solicitacao.valorTotal.doubleValue()}</td>
                <td>${solicitacao.estado}</td>
                <c:choose>
                    <c:when test="${(solicitacao.estado == 'Em Analise') || (solicitacao.estado == 'Agendado')}">
                        <td>
                            <form action="CancelarSolicitacao" method="post">
                                <input type="hidden" name="id_solicitacao" value="${solicitacao.id}"/> 
                                <button type="submit" class="btn btn-danger" value="Cancelar">Cancelar</button>
                            </form>
                        </td>
                    </c:when> 
                    <c:otherwise>
                        <td></td>
                    </c:otherwise>
                </c:choose>
            </tr>
        </c:forEach>
    </tbody>
</table>

<script src="js/buscar-na-tabela-7.js"></script>
<script type="text/javascript" src="js/materialize.js"></script>

<%@include file="rodape.jsp"%>
