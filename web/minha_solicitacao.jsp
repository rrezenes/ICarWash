<%-- 
    Document   : listaCliente
    Created on : 17/11/2016, 22:13:43
    Author     : rezen
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page  contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="cabecalho.jsp"%>
<link rel="stylesheet" href="css/star-rating.css">
<div class="jumbotron">
    <h1>Minhas solicitações de lavagem</h1>
</div>
<table class="table table-hover">
    <thead>
        <tr>
            <th>ID solicitação</th>
            <th>ID lavador</th>
            <th>Porte do veículo</th>
            <th>Data solicitação</th>
            <th>Valor total</th>
            <th>Status</th>
            <th colspan=2>Ação</th>
        </tr>
    </thead>
    <script src="js/star-rating.js"></script>
    <script src="js/star-rating_locale_pt-BR.js"></script>
    <tbody>  
        <c:forEach var="solicitacao" items="${solicitacoes}">
            <tr>
                <td>${solicitacao.id}</td>
                <td>${solicitacao.lavador.id}</td>
                <td>${solicitacao.porte}</td>
                <%--Formatar a data antes de exibir na tela--%>
                <fmt:formatDate value="${solicitacao.dataSolicitacao.time}" var="dataSolicitacao" type="date" pattern="dd/MM/yyyy HH:mm" />
                <td>${dataSolicitacao}</td>
                <td>${solicitacao.valorTotal}</td>
                <td>${solicitacao.estado}</td>
                
                <c:if test="${(solicitacao.estado == 'Em Analise') || (solicitacao.estado == 'Agendado')}">
                    <td>
                        <form action="CancelarSolicitacao" method="post">
                            <input type="hidden" name="id_solicitacao" value="${solicitacao.id}"/> 
                            <input type="submit" value="Cancelar" class="btn btn-danger">
                        </form>                    
                    </td>
                </c:if>
                <c:if test="${solicitacao.estado == 'Finalizado'}">
                    <td>
                        <button type="button" class="btn btn-info" data-toggle="modal" data-target="#myModal">Avaliar</button> 
                        <div id="myModal" class="modal fade" role="dialog">
                            <div class="modal-dialog">
                                <!-- Modal content-->
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                                        <h4 class="modal-title">Avaliar Solicitação</h4>
                                    </div>
                                    <div class="modal-body">
                                        <form action="AvaliarSolicitacao" method="post">
                                            <div class="form-group">
                                                <div class="row">
                                                    <input type="hidden" name="id_solicitacao" value="${solicitacao.id}"/> 
                                                    <label for="pontualidade" class="control-label">Pontualidade</label>
                                                    <input id="pontualidade" name="pontualidade" value="0" class="rating-loading"><br>
                                                    <label for="servico" class="control-label">Serviço</label>
                                                    <input id="servico" name="servico" value="0" class="rating-loading"><br>
                                                    <label for="atendimento" class="control-label">Atendimento</label>
                                                    <input id="atendimento" name="atendimento" value="0" class="rating-loading"><br>
                                                    <label for="agilidade" class="control-label">Agilidade</label>
                                                    <input id="agilidade" name="agilidade" value="0" class="rating-loading"><br>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <input class="form-control btn btn-primary" type="submit" name="action" value="Avaliar"><br>
                                            </div>
                                        </form>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <script>
                            $('#pontualidade').rating({});
                            $('#servico').rating({});
                            $('#atendimento').rating({});
                            $('#agilidade').rating({});
                        </script>
                    </td>
                </c:if>
                <c:if test="${(solicitacao.estado == 'Avaliado')}">   
                    <td>
                        <input id="input-${solicitacao.id}" name="input-${solicitacao.id}" value="${solicitacao.avaliacao.notaMedia}" class="rating-loading" data-size="xs">
                        <script>$("#input-${solicitacao.id}").rating({displayOnly: true, step: 0.5}) </script>   
                    </td>
                </c:if>
            </tr>
        </c:forEach>
    </tbody>
</table>

<script src="js/star-rating.js"></script>
<script src="js/star-rating_locale_pt-BR.js"></script>
<%@include file="rodape.jsp"%>