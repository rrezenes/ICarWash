
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page  contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="cabecalho.jsp"%>
<link rel="stylesheet" href="css/star-rating.css">

<script src="js/star-rating.js"></script>
<script src="js/star-rating_locale_pt-BR.js"></script>

<div class="container">
    <div class="jumbotron">
        <h1>Minhas solicitações de lavagem</h1>
    </div>
    <table class="table table-hover bordered responsive-table">
        <thead>
            <tr>
                <th>ID</th>
                <th>Lavador</th>
                <th>Porte</th>
                <th>Data</th>
                <th>Valor</th>
                <th>Status</th>
                <th colspan=2>Ação</th>
            </tr>
        </thead>
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
                                <input type="submit" value="Cancelar" class="btn waves-effect waves-light red lighten-1">
                            </form>                    
                        </td>
                    </c:if>
                    <c:if test="${solicitacao.estado == 'Finalizado'}">
                        <td id="td-${solicitacao.id}">
                            <button type="button" class="btn waves-effect waves-light light-blue accent-1" data-toggle="modal" data-target="#myModal${solicitacao.id}">Avaliar</button> 
                            <div id="myModal${solicitacao.id}" class="modal fade" role="dialog">
                                <div class="modal-dialog">
                                    <!-- Modal content-->
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                                            <h4 class="modal-title">Avaliar Solicitação</h4>
                                        </div>
                                        <div class="modal-body">
                                            <form name="avaliar${solicitacao.estado}" action="AvaliarSolicitacao" method="post">
                                                <div class="form-group">
                                                    <input type="hidden" name="id_solicitacao" value="${solicitacao.id}"/> 
                                                    <div class="row">
                                                        <label for="pontualidade${solicitacao.id}" class="control-label">Pontualidade</label>
                                                        <input id="pontualidade${solicitacao.id}" name="pontualidade" class="pontualidade" value="0" class="rating-loading"><br>
                                                    </div>
                                                    <div class="row">
                                                        <label for="servico${solicitacao.id}" class="control-label">Serviço</label>
                                                        <input id="servico${solicitacao.id}" name="servico" class="servico" value="0" class="rating-loading"><br>
                                                    </div>
                                                    <div class="row">
                                                        <label for="atendimento${solicitacao.id}" class="control-label">Atendimento</label>
                                                        <input id="atendimento${solicitacao.id}" name="atendimento" class="atendimento" value="0" class="rating-loading"><br>
                                                    </div>
                                                    <div class="row">
                                                        <label for="agilidade${solicitacao.id}" class="control-label">Agilidade</label>
                                                        <input id="agilidade${solicitacao.id}" name="agilidade" class="agilidade" value="0" class="rating-loading"><br>
                                                    </div>
                                                    <center><span id="erro"></span></center><br><br>
                                                </div>
                                                <div class="form-group">
                                                    <input class="form-control btn btn-primary" name="action" value="Avaliar" onclick="enviarAvaliacao($('#td-${solicitacao.id}'));"><br>
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
                                $('#pontualidade${solicitacao.id}').rating({});
                                $('#servico${solicitacao.id}').rating({});
                                $('#atendimento${solicitacao.id}').rating({});
                                $('#agilidade${solicitacao.id}').rating({});
                            </script>
                        </td>
                    </c:if>
                    <c:if test="${(solicitacao.estado == 'Avaliado')}">   
                        <td>
                            <input id="input-${solicitacao.id}" name="input-${solicitacao.id}" value="${solicitacao.avaliacao.notaMedia}" class="rating-loading" data-size="xs">
                            <script>$("#input-${solicitacao.id}").rating({displayOnly: true, step: 0.5})</script>   
                        </td>
                    </c:if>
                    <c:if test="${(solicitacao.estado == 'Cancelado')}">   
                        <td>                        
                        </td>
                    </c:if>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

<script type="text/javascript" src="js/jquery-3.1.1.js"></script>
<script type="text/javascript" src="js/materialize.js"></script>

<script>
                                $(document).ready(function () {
                                    let searchParams = new URLSearchParams(window.location.search);
                                    if (searchParams.has('ok')) {
                                        Materialize.toast('Solicitacao Efetuada', 6000, 'rounded');
                                    } else if (searchParams.has('x')) {
                                        Materialize.toast('Solicitacao Cancelada', 6000, 'rounded');
                                    }
                                });
                                function enviarAvaliacao(ele) {

                                    var pontualidade = document.getElementById(ele.attr('id')).querySelector(".pontualidade").value;
                                    var servico = document.getElementById(ele.attr('id')).querySelector(".servico").value;
                                    var atendimento = document.getElementById(ele.attr('id')).querySelector(".atendimento").value;
                                    var agilidade = document.getElementById(ele.attr('id')).querySelector(".agilidade").value;

                                    if (pontualidade == "" || servico == "" || atendimento == "" || agilidade == "") {
                                        $("#erro").addClass('alert alert-danger');
                                        $("#erro").text("Por favor avalie todos os quesitos");
                                    } else {
                                        document.avaliar.submit();
                                    }

                                }
</script>
<%@include file="rodape.jsp"%>