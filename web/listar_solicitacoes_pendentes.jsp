<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="cabecalho.jsp"%>

<div class="row">
    <p class="titulo-controle">Solicitações Pendentes</p>
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

<table id="produtos" class="table table-hover centered striped responsive-table">
    <thead>
        <tr>
            <th>ID</th>
            <th>Cliente</th>
            <th>Lavador</th>
            <th>Porte</th>
            <th>Data</th>
            <th>Valor</th>
            <th>Status</th>
            <th colspan=2></th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="solicitacao" items="${solicitacoes}">
            <tr>
                <td>${solicitacao.id}</td>
                <td>${solicitacao.cliente.nome}</td>
                <td>${solicitacao.lavador.id}</td>
                <td>${solicitacao.porte}</td>
                <%--Formatar a data antes de exibir na tela--%>
                <fmt:formatDate value="${solicitacao.dataSolicitacao.time}" var="dataSolicitacao" type="date" pattern="dd/MM/yyyy" />
                <td>${dataSolicitacao}</td>
                <td>${solicitacao.valorTotal}</td>
                <td>${solicitacao.estado}</td>
                <td>
                    <form action="CancelarSolicitacao" method="post">
                        <input type="hidden" name="id_solicitacao" value="${solicitacao.id}"/> 
                        <button type="submit" class="btn btn-danger" value="Cancelar">Cancelar</button>                
                    </form>                    
                </td>
                <td>
                    <form action="AprovarSolicitacao" method="post">
                        <input type="hidden" name="id_solicitacao" value="${solicitacao.id}"/>
                        <button type="submit" class="btn btn-success">Aprovar</button>
                    </form>
                </td>
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
<%@include file="rodape.jsp"%>
