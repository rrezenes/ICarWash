<%@page  contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="cabecalho.jsp"%>

<div class="row">
    <p class="titulo-controle">Media de Litros Economizados</p>
    <div class="divider"></div>
</div>

<div class="row">
    <div class="col s12 m7">
        <div class="card medium">
            <div class="card-image">
                <img  src="http://www.geo.edu.al/newweb/images/uji.jpg">
                <span class="card-title" >Economia de Água</span>
            </div>
            <div class="card-content">
                <c:choose>
                    <c:when  test="${qtdTotalDeAguaEconomizado > 0}">
                        <p>Olá ${nome}, o planeta agradece, com sua ajuda já conseguimos economizar em média ${qtdTotalDeAguaEconomizado} litros de água.</p>
                    </c:when>
                    <c:otherwise>
                        <p>Olá ${nome}, nos ajude a tornar o planeta um local melhor, a cada solicitção conseguimos em média economizar 300 litros de água.</p>
                    </c:otherwise>
                </c:choose>

            </div>
            <div class="card-action">
                <a href="solicitar-servico">Solicitar Serviço</a>
            </div>
        </div>
    </div>
</div>


<!--<script src="js/Chart.bundle.js"></script>
<script src="js/utils.js"></script>
<script src="js/carregar-chart-data.js"></script>
<script src="js/carregar-pie.js"></script>
<script src="js/carregar-line.js"></script>
<script>
     window.onload = function () {
        var ctx = document.getElementById("canvas").getContext("2d");
        window.myLine = new Chart(ctx, config_line);

        var ctx2 = document.getElementById("chart-area").getContext("2d");
        window.myPie = new Chart(ctx2, config_pie);

        var ctx = document.getElementById("chart-data").getContext("2d");
        window.myMixedChart = new Chart(ctx, {
            type: 'bar',
            data: chartData,
            options: {
                responsive: true,
                title: {
                    display: true,
                    text: 'Chart.js Combo Bar Line Chart'
                },
                tooltips: {
                    mode: 'index',
                    intersect: true
                }
            }
        });
    };
</script>-->


<%@include file="rodape.jsp"%>