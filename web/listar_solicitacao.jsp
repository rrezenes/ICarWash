
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="cabecalho.jsp"%>

<div class="row">
    <p class="titulo-controle">Solicitações Realizadas</p>
    <div class="divider"></div>
</div>
<div class="row">
    <div class="col s12">
        <input id="buscar" type="text" />
    </div>
</div>

<table id="produtos" class="table table-hover centered striped responsive-table">
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
                <td>${solicitacao.porte}</td>
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

<script>
    function filterTable(event) {
        var filter = event.target.value.toUpperCase();
        var rows = document.querySelector("#produtos tbody").rows;

        for (var i = 0; i < rows.length; i++) {

            var primeiro = rows[i].cells[0].textContent.toUpperCase();
            var segundo = rows[i].cells[1].textContent.toUpperCase();
            var terceiro = rows[i].cells[2].textContent.toUpperCase();
            var quarto = rows[i].cells[3].textContent.toUpperCase();
            var quinto = rows[i].cells[4].textContent.toUpperCase();
            var sexto = rows[i].cells[5].textContent.toUpperCase();
            var setemo = rows[i].cells[6].textContent.toUpperCase();

            if (primeiro.indexOf(filter) > -1 || segundo.indexOf(filter) > -1 || terceiro.indexOf(filter) > -1 || quarto.indexOf(filter) > -1 || quinto.indexOf(filter) > -1 || sexto.indexOf(filter) > -1 || setemo.indexOf(filter) > -1) {
                rows[i].style.display = "";
            } else {
                rows[i].style.display = "none";
            }
        }
    }

    document.querySelector('#buscar').addEventListener('keyup', filterTable, false);

</script>

<script type="text/javascript" src="js/materialize.js"></script>
<%@include file="rodape.jsp"%>
