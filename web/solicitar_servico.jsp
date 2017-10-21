<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page  contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="cabecalho.jsp"%>

<div class="container">    
    <div class="row">
        <h4>Solicitar Serviço</h4>
        <div class="divider"></div>
    </div>

    <form name="solicitarServico" action="ControleSolicitacao" method="post" class="col s12">
        <div class="row">
            <h5 class="erro-porte col s12">Porte do Veículo</h5>
            <p class="col s4">
                <input class="with-gap" name="porte" type="radio" id="pequeno" value="pequeno"/>
                <label for="pequeno">Pequeno</label>
            </p>
            <p class="col s4">
                <input class="with-gap" name="porte" type="radio" id="medio" value="medio"/>
                <label for="medio">Médio</label>
            </p>
            <p class="col s4">
                <input class="with-gap" name="porte" type="radio" id="grande" value="grande"/>
                <label for="grande">Grande</label>
            </p>
        </div>
        <div class="row col s12">
            <h5 class="erro-servico col s12">Serviços</h5>
            <c:forEach var="servico" items="${servicos}">
                <c:if test = "${servico.ativo}">
                    <p class="col s6">
                        <input type="checkbox" name="servico" id="${servico.id}" value="${servico.id}"/>
                        <label for="${servico.id}">${servico.nome}</label>
                    </p>  
                </c:if>
            </c:forEach> 
        </div>

        <div class="row">
            <h5 class="erro-data"></h5>
            <div class="input-field col s12">
                <input  type="text" class="datepicker" id="data_solicitacao" name="data_solicitacao">
                <label>Data da Solicitação</label>
            </div>
        </div>

        <div class="row">
            <div class="input-field col s12">
                <select id="selectHora" name="selectHora">
                    <option value=" " selected></option>
                </select>
                <label>Hora da Solicitação</label>
            </div>
        </div>

        <div class="fixed-action-btn">
            <a class="btn-floating btn-large waves-effect waves-light red"><i class="material-icons" id="confirmar">done</i></a>
        </div>
    </form>

</div>
<script type="text/javascript" src="js/solicitar-servico.js"></script>



















<%--<br>


<div class="container">
    <div class="jumbotron">
        <h1>Solicitar Serviço</h1>
    </div>
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

        $("#datepicker2").on("dp.change", function () {
            popularSelect();
        });
        $('#datepicker2').datetimepicker({
            format: 'L',
            locale: 'pt-br',
            daysOfWeekDisabled: [0, 6],
            minDate: moment(),
            maxDate: moment().add(90, 'days')
        });
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
--%>
<%@include file="rodape.jsp"%>
