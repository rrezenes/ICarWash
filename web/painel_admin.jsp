<%@page  contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="cabecalho.jsp"%>

<div class="row">
    <p class="titulo-controle">ICarWash - Painel Administrativo</p>
    <div class="divider"></div>
</div>

<div class="row">
    <div class="col s12">
        <p class="titulo-controle2">Número de serviços realizados</p>
        <div class="divider"></div>
        <canvas id="canvas"></canvas>
    </div>
    <div class="col s12">
        <p class="titulo-controle2">Status das solicitações de hoje</p>
        <div class="divider"></div>
        <div id="canvas-holder" style="width:100%">
            <canvas id="chart-area" /></canvas>
        </div>
    </div>
    <div class="col s12">
        <p class="titulo-controle2">Status das solicitações no mês</p>
        <div class="divider"></div>
        <div id="canvas-holder" style="width:100%">
            <canvas id="chart-data" /></canvas>
        </div>
    </div>
    <div class="col s12">
        <table class="responsive-table centered striped">
            <thead>
            <p class="titulo-controle2">Ranking de Lavador - Média de avaliações</p>
            <div class="divider"></div>
            <tr>
                <th>Posição</th>
                <th>Lavador</th>
                <th>Média</th>
            </tr>
            </thead>

            <tbody>
                <tr>
                    <td>#1</td>
                    <td>Epaminondas</td>
                    <td>4.90</td>
                </tr>
                <tr>
                    <td>#2</td>
                    <td>Mafalda</td>
                    <td>4.86</td>
                </tr>
                <tr>
                    <td>#3</td>
                    <td>Lollipop</td>
                    <td>4.85</td>
                </tr>
                <tr>
                    <td>#4</td>
                    <td>João</td>
                    <td>4.75</td>
                </tr>
                <tr>
                    <td>#5</td>
                    <td>Maria</td>
                    <td>4.74</td>
                </tr>
            </tbody>
        </table>
    </div>
</div>

<script src="js/Chart.bundle.js"></script>
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
</script>


<%@include file="rodape.jsp"%>