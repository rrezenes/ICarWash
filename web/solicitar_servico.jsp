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
            <h5 class="erro-data"></h5>
            <div class="input-field col s6">
                <input  type="text" class="datepicker" id="data_solicitacao" name="data_solicitacao">
                <label>Data da Solicitação</label>
            </div>
            <div class="input-field col s6">
                <select id="selectHora" name="selectHora">
                    <option value=" " selected></option>
                </select>
                <label>Hora da Solicitação</label>
            </div>
        </div>

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
        <div class="row col s6">
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

        <div class="row col s6">
            <h5 class="erro-porte col s12">Endereço</h5>
            <c:forEach var="endereco" items="${enderecos}">
                <p class="col s3">
                    <input type="radio" name="endereco" id="endereco${endereco.id}" value="${endereco.id}"/>
                    <label for="endereco${endereco.id}">${endereco.nome}</label>
                </p>
            </c:forEach> 
        </div>

        <div class="fixed-action-btn">
            <a class="btn-floating btn-large waves-effect waves-light red"><i class="material-icons" id="confirmar">done</i></a>
        </div>
    </form>
</div>

<script type="text/javascript" src="js/solicitar-servico.js"></script>

<%@include file="rodape.jsp"%>
