<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@page  contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="cabecalho.jsp"%>

<div class="container">    
    <div class="row">
    <p class="titulo-controle">Aprovar Serviço</p>
        <div class="divider"></div>
    </div>

    <div class="row">
        <div class="col s8 offset-s2 center-align">
            <div class="card grey lighten-3">
                <div class="card-content black-text">
                    <span class="card-title">Solicitação #${solicitacao.id}</span>

                    <div class="divider"></div>
                    <table class="bordered">
                        <c:forEach var="servico" items="${solicitacao.servicos}">
                            <tr>
                                <td>${servico.nome}</td>
                                <td>R$ <fmt:formatNumber type = "number" maxFractionDigits = "2" minFractionDigits = "2" value = "${servico.valor * solicitacao.modelo.porte.taxa}"/></td>                            
                            </tr>
                        </c:forEach>
                        <tr class="grey lighten-1 white-text">
                            <td>Total</td>     
                            <td>R$ <fmt:formatNumber type = "number" maxFractionDigits = "2" minFractionDigits = "2" value = "${solicitacao.valorTotal}" /></td>                         
                        </tr>
                    </table>
                </div>
                <div class="card-action">
                    <a class="text-black" href="#"></a>
                </div>

            </div>

            <form action="via-boleto" method="post">
                <button class="btn waves-effect waves-light" type="submit" name="action">Pagar com boleto
                    <i class="material-icons right">send</i>
                </button>
            </form>
        </div>
    </div>    
</div>

<!--<script src="js/solicitar-servico.js"></script>
<script src="js/validar-cep.js"></script>-->
<!--<script src="js/inicializar-mascara.js"></script>-->
<!--<script src="js/inicializar-validate.js"></script>-->

<%@include file="rodape.jsp"%>
