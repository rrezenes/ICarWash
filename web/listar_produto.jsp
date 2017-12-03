<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="cabecalho.jsp"%>

<c:if test="${!empty cadastrado}">
    <script>Materialize.toast('Produto Cadastrado', 6000, 'rounded');</script>        
</c:if>

<div class="row">
    <p class="titulo-controle">Controle de Produtos</p>
    <div class="divider"></div>
</div>
<div class="row">
    <div class="col s6">
        <a class="waves-effect waves-light btn green modal-trigger" href="#modal">Cadastrar</a>
    </div>
    <div class="input-field col s6">
        <input class="validate" id="buscar" type="text" name="buscar" />
        <label for='email'>Buscar</label>
    </div>
</div>
<table id="tabela" class="table table-hover centered striped responsive-table">
    <thead>
        <tr>
            <th>Nome</th>
            <th>Descrição</th>
            <th></th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="produto" items="${produtos}">
            <tr>
                <td>${produto.nome}</td>
                <td>${produto.descricao}</td>
                <td>
                    <a type="button" class="btn-floating blue" href="Controle?action=LocalizaPorIdCommand&q=produto&id=${produto.id}"><i class="material-icons">&#xE254;</i></a>
                    <c:choose>
                        <c:when test="${produto.ativo}">                                       
                            <a class="btn-floating red" type="button" href="Controle?action=DesativaCommand&q=produto&id=${produto.id}"><i class="material-icons">delete</i></a>
                        </c:when> 
                        <c:otherwise>
                            <a class="btn-floating green" type="button" href="Controle?action=AtivaCommand&q=produto&id=${produto.id}"><i class="material-icons">done</i></a>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<div id="modal" class="modal modal-fixed-footer">
    <form id="FormValidate" action="Controle" method="post">
        <div class="modal-content">
            <div class="form-group">
                <div class="row">
                    <p class="titulo-controle">Cadastrar Produto</p>
                    <div class="divider"></div>
                </div>
                <input type="hidden" name="action" value="CadastroCommand"/>
                <input type="hidden" name="quem" value="produto">
                <div class="row">
                    <div class="input-field col s6">
                        <label>Nome</label> 
                        <input class="form-control erro-nome" type="text" name="nome" id="nome" id="nome"><br>
                    </div>
                    <div class="input-field col s6">
                        <label>Descrição</label> 
                        <input class="form-control erro-descricao" type="text" name="descricao" id="descricao"><br>
                    </div>
                </div>
            </div>      
        </div>
        <div class="modal-footer">
            <input class="form-control btn btn-primary" type="submit" value="Cadastrar">
            <a class="modal-action modal-close waves-effect waves-green btn-flat">Fechar</a>
        </div>
    </form>
</div>

<script src="js/jquery.validate.js"></script>
<script src="js/inicializar-modal.js"></script>
<script src="js/validar-apenas-letras.js"></script>
<script src="js/validar-apenas-letras-numeros.js"></script>
<script src="js/inicializar-validate.js"></script>
<script src="js/buscar-na-tabela-2.js"></script>

<%@include file="rodape.jsp"%>