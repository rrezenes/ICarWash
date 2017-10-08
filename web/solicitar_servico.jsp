<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page  contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="cabecalho.jsp"%>
<div class="jumbotron">
    <h1>Solicitar Serviço</h1>
</div>
<% if (request.getParameter("erro") == "data") {
%><p>Marque o campo de porte do veículo</p><%
    }%>
<div class="container" style="max-width: 1000.0px;">
    <form id="solicitarServico" action="ControleSolicitacao" method="post">
        <div class="form-group col-sm-6">
            <input type="hidden" value="cliente">
            <fieldset>
                <legend class="erro-data">Data da Solicitação</legend>
                <div class='input-group date' id='datepicker2'>
                    <input type='text' class="form-control" name="data_solicitacao" id="data_solicitacao"/>
                    <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
                    </span>
                </div>
            </fieldset>         
        </div>
        <div class="form-group col-sm-6">
            <input type="hidden" value="cliente">
            <fieldset>
                <legend class="erro-data">Hora da Solicitação</legend>
                <div class="form-group">
                    <select class="form-control" id="selectHora" name="selectHora">
                    </select>
                </div>
            </fieldset>         
        </div>
        <legend class="erro-servico">Serviços</legend>
        <div class="form-group">
            <c:forEach var="servico" items="${servicos}">
                <c:if test = "${servico.ativo}">
                    <div class="checkbox">
                        <label style="padding-left: 35px;">
                            <input class="check" type="checkbox" name="servico" value="${servico.id}">${servico.nome} R$${servico.valor}
                        </label>
                    </div>   
                </c:if>
            </c:forEach> 
        </div>
        <fieldset>
            <div class="form-group">
                <legend class="erro-tamanho">Tamanho do veículo</legend>
                <label class="radio-inline" style="padding-left: 35px;">
                    <input type="radio" name="porte" value="pequeno">Pequeno
                </label>
                <label class="radio-inline">
                    <input type="radio" name="porte" value="medio">Médio
                </label>
                <label class="radio-inline">
                    <input type="radio" name="porte" value="grande">Grande
                </label>
            </div>     
        </fieldset>


        <div class="form-group">
            <input class="form-control btn btn-primary" type="submit" name="action" value="Cadastrar"><br>
        </div>
    </form>
</div>

<script type="text/javascript" src="./js/jquery-3.1.1.js" charset="UTF-8"></script>
<script type="text/javascript" src="./js/jquery.validate.js" charset="UTF-8"></script>
<script type="text/javascript" src="./js/moment.js" charset="UTF-8"></script>
<script type="text/javascript" src="./js/locales/moment.pt-BR.js" charset="UTF-8"></script>
<script type="text/javascript" src="./js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
<script type="text/javascript">
    $(function () {
        $('#datepicker2').datetimepicker({
            locale: 'pt-br',
            format: 'L',
            daysOfWeekDisabled: [0, 6],
            minDate: moment().add(24, 'hours'),
            maxDate: moment().add(30, 'days')
        });
    });

    $("#datepicker2").on("dp.change", function () {
        popularSelect();
    });

</script>
<script type="text/javascript">
    $(document).ready(function () {
        $("#solicitarServico").validate({
            rules: {
                data: {
                    required: true
                },
                servico: {
                    required: true
                },
                porte: {
                    required: true
                }
            },
            messages: {
                data: {
                    required: "Por favor, selecione uma data."
                },
                servico: {
                    required: "Por favor, selecione um serviço."
                },
                porte: {
                    required: "Por favor, selecione um porte de veículo."
                }
            },
            errorElement: "em",
            errorPlacement: function (error, element) {
                // Add the `help-block` class to the error element
                error.addClass("help-block");

                if (element.prop("type") === "checkbox") {
                    error.insertAfter(".erro-servico");
                } else if (element.prop("type") === "radio") {
                    error.insertAfter(".erro-tamanho");
                } else {
                    error.insertAfter(".erro-data");
                }

            }
        });
    });


    function popularSelect() {
        $("#selectHora").empty();
        var checkData = {data: $('#data_solicitacao').val()};
        $.getJSON("CheckSolicitacaoData", checkData, function (dataVal) {
            $.each(dataVal, function (index, item) {
                $('#selectHora').append($('<option></option>').val(item).html(item));
            });
        });
    }
</script>
<%@include file="rodape.jsp"%>
