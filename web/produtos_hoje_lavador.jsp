<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@page  contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="cabecalho.jsp"%>

<link rel="stylesheet" href="css/star-rating-svg.css">
<script src="js/jquery.star-rating-svg.js"></script>

<div class="row">
    <p class="titulo-controle">Produtos para hoje</p>
    <div class="divider"></div>
</div>

<div class="row">
    <div class="col s12">
        <ul class="collection with-header">
            <li class="collection-header"><h4>Produtos Para Hoje</h4></li>

            <c:forEach var="produtoQuantidade" items="${quantidadeDeProdutosTotal}">
                <c:if test="${produtoQuantidade.value > 0}">
                    <li class="collection-item"><div>${produtoQuantidade.key}<a href="#!" class="secondary-content">${produtoQuantidade.value}</a></div></li>
                        </c:if>
                    </c:forEach> 
        </ul> 
    </div>
</div>

<div class="row">
    <c:forEach var="solicitacao" items="${solicitacoes}"> 
        <fmt:formatDate value="${solicitacao.dataSolicitacao.time}" var="dataSolicitacao" type="date" pattern="HH:mm"/>

        <div class="col s12 m6">
            <div class="card blue-grey darken-1">
                <div class="card-content white-text">
                    <span class="card-title">Solicitação #${solicitacao.id} - ${dataSolicitacao}</span>
                    <c:forEach var="servico" items="${solicitacao.servicos}">
                        <br>
                        <p>${fn:toUpperCase(servico.nome)}</p> 
                        <div class="divider"></div>
                        <c:forEach var="produto" items="${servico.produtos}">
                            <p class="${produto.key.nome}">${produto.key.nome} <a class="secondary-content quantidade">${produto.value}</a></p> 
                            </c:forEach>  
                        </c:forEach>  

                </div>
            </div>
        </div>
    </c:forEach>  
</div> 
<%--            <fmt:formatDate value="${solicitacao.dataSolicitacao.time}" var="dataSolicitacao" type="date" pattern="dd/MM/yyyy HH:mm" />
            <tr>
                <td>#${solicitacao.id}</td>
                <td>${solicitacao.cliente.nome}</td>
                <td>${solicitacao.endereco.cidade}</td>
                <td>${solicitacao.endereco.bairro}</td>
                <td>${solicitacao.modelo.porte}</td>            
                <td>${dataSolicitacao}</td>
                <td>${solicitacao.valorTotal.doubleValue()}</td>
                <td>${solicitacao.estado}</td>
                <c:if test="${solicitacao.estado == 'Agendado' && !ocupado}">
                    <td>
                        <form action="CancelarSolicitacao" method="post">
                            <input type="hidden" name="id_solicitacao" value="${solicitacao.id}"/> 
                            <button type="submit" class="btn waves-effect waves-light red lighten-1" value="Cancelar">Cancelar</button>
                        </form>
                    </td>
                    <td>
                        <form action="ProcessarSolicitacao" method="post">
                            <input type="hidden" name="id_solicitacao" value="${solicitacao.id}"/>
                            <button type="submit" class="btn waves-effect waves-light blue lighten-1">Processar</button>
                        </form>
                    </td>
                </c:if>
                <c:if test="${solicitacao.estado == 'Em Processo'}">
                    <td>
                        <form action="FinalizarSolicitacao" method="post">
                            <input type="hidden" name="id_solicitacao" value="${solicitacao.id}"/>
                            <button type="submit" class="btn waves-effect waves-light blue lighten-1">Finalizar</button>
                        </form>
                    </td>
                </c:if>
                <c:if test="${solicitacao.estado == 'Avaliado'}">
                    <td> 
            <center><div class="nota-${solicitacao.id}"></div></center>

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
    <c:if test="${solicitacao.estado == 'Finalizado'}">
        <td> 
        <center>
            <div class="nota-${solicitacao.id}"></div>
            Aguardando Avaliação</center>
        <script>
                                $(".nota-${solicitacao.id}").starRating({
                                    readOnly: true,
                                    starSize: 25,
                                    initialRating: 0,
                                    strokeWidth: 0
                                });
        </script>
    </td>
</c:if>
</tr>        
</c:forEach>
</tbody>
</table>--%>

<%@include file="rodape.jsp"%>