
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page  contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="cabecalho.jsp"%>

<link rel="stylesheet" href="css/star-rating-svg.css">
<script src="js/jquery.star-rating-svg.js"></script>


<div class="row">
    <p class="titulo-controle">Minhas solicitações</p>
    <div class="divider"></div>
</div>
<div class="row">
    <div class="col s6">
        <a class="waves-effect waves-light btn green modal-trigger" href="solicitar-servico">Solicitar Serviço</a>
    </div>
    <div class="input-field col s6">
        <input class="validate" id="buscar" type="text" name="buscar" />
        <label for='email'>Buscar</label>
    </div>
</div>
<table class="table table-hover centered striped responsive-table">
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
                    <td>
                        <a class="waves-effect waves-light btn modal-trigger" href="#modal${solicitacao.id}">Avaliar</a>
                        <div id="modal${solicitacao.id}" class="modal modal-fixed-footer modal-avaliar">
                            <div class="modal-content">
                                <center>
                                    <div class="row">
                                        <h4>Avalie o Serviço</h4>
                                        <div class="divider"></div>
                                    </div>
                                    <h5 class="modal-titulo-avaliar">Pontualidade</h5>
                                    <div class="pontualidade-${solicitacao.id}"></div>
                                    <h5 class="modal-titulo-avaliar">Serviço</h5>
                                    <div class="servico-${solicitacao.id}"></div>
                                    <h5 class="modal-titulo-avaliar">Atendimento</h5>
                                    <div class="atendimento-${solicitacao.id}"></div>
                                    <h5 class="modal-titulo-avaliar">Agilidade</h5>
                                    <div class="agilidade-${solicitacao.id}"></div>      
                                </center>
                            </div>
                            <div class="modal-footer">
                                <a class="modal-action waves-effect waves-green btn-flat" onclick="avaliar($('.pontualidade-${solicitacao.id}').starRating('getRating'), $('.servico-${solicitacao.id}').starRating('getRating'), $('.atendimento-${solicitacao.id}').starRating('getRating'), $('.agilidade-${solicitacao.id}').starRating('getRating'),${solicitacao.id})">Avaliar</a>
                            </div>
                        </div>
                        <script>
                            $(document).ready(function () {
                                $('#modal${solicitacao.id}').modal();
                            });
                            $(".pontualidade-${solicitacao.id}").starRating({
                                starSize: 50,
                                disableAfterRate: false
                            });
                            $(".servico-${solicitacao.id}").starRating({
                                starSize: 50,
                                disableAfterRate: false
                            });
                            $(".atendimento-${solicitacao.id}").starRating({
                                starSize: 50,
                                disableAfterRate: false
                            });
                            $(".agilidade-${solicitacao.id}").starRating({
                                starSize: 50,
                                disableAfterRate: false
                            });
                        </script>
                    </td>
                </c:if>
                <c:if test="${(solicitacao.estado == 'Avaliado')}">   
                    <td>
                        <div class="nota-${solicitacao.id}"></div>
                        <script>
                                $(".nota-${solicitacao.id}").starRating({
                                    readOnly: true,
                                    starSize: 25,
                                    initialRating: ${solicitacao.avaliacao.notaMedia},
                                    strokeWidth: 0
                                });
                        </script>
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



<script>
    function avaliar(pontualidade, servico, atendimento, agilidade, solicitacao) {
        var dataString = 'pontualidade=' + pontualidade + '&servico=' + servico + '&atendimento=' + atendimento + '&agilidade=' + agilidade + '&id_solicitacao=' + solicitacao;
        $.ajax({
            type: "POST",
            url: "AvaliarSolicitacao",
            data: dataString,
            cache: false,
            success: function (result) {
                location.reload();
            }
        });
    }
    $(document).ready(function () {
        let searchParams = new URLSearchParams(window.location.search);
        if (searchParams.has('ok')) {
            Materialize.toast('Solicitacao Efetuada', 6000, 'rounded');
        } else if (searchParams.has('x')) {
            Materialize.toast('Solicitacao Cancelada', 6000, 'rounded');
        }
    });
</script>
<%@include file="rodape.jsp"%>