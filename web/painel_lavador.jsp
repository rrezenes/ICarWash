<%@page  contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="cabecalho.jsp"%>

<div class="row">
    <p class="titulo-controle">ICarWash</p>
    <div class="divider"></div>
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