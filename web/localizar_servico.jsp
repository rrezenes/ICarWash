
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="cabecalho.jsp"%>
<div class="container">
    <div class="row">
        <p class="titulo-controle">Alterar Serviço</p>
        <div class="divider"></div>
    </div>
    <form id="FormValidate" action="Controle" method="post">
        <div class="form-group">
            <input type="hidden" name="quem" value="servico"/>
            <input type="hidden" name="id" value="${servico.id}"/>
            <div class="row">
                <div class="input-field col s12">
                    <label>Nome:</label> 
                    <input class="form-control erro-nome" type="text" name="nome" value="${servico.nome}"><br>
                </div>
                <div class="input-field col s12">
                    <label>Descrição:</label> 
                    <input class="form-control erro-descricao" type="text" name="descricao" id="descricao" value="${servico.descricao}"><br>
                </div>
                <div class="input-field col s12">
                    <label>Valor:</label> 
                    <input class="form-control erro-valor" type="text" name="valor" id="valor" value="${servico.valor}"><br>
                </div>
                <div class="row">
                    <h5>Produtos</h5>
                    <div class="divider"></div>
                </div>
                <legend></legend>
                <c:forEach var="produto" items="${todosProdutos}">
                    <c:forEach var="servicoProduto" items="${servicoProdutos}">
                        <c:choose>
                            <c:when test="${produto.ativo && servicoProduto.produto.id == produto.id}">
                                <div class="checkbox col s9">
                                    <p>
                                        <input type="checkbox" id="check${produto.id}" value="${produto.id}" name="produtos" checked
                                               onclick="
                                                       if ($(this).is(':checked')) {
                                                           $('#quantidade${produto.id}').prop('disabled', false);
                                                       } else {
                                                           $('#quantidade${produto.id}').prop('disabled', true);
                                                           $('#quantidade${produto.id}').val(null);
                                                           $('#quantidade${produto.id}').removeClass('valid');
                                                           $('.quantidade${produto.id}').removeClass('active')
                                                       }"/>
                                        <label for="check${produto.id}">${produto.nome}</label>
                                    </p>             
                                </div>
                                <div class="input-field col s3">
                                    <input id="quantidade${produto.id}" name="quantidade${produto.id}" type="number" class="validate" min="1" max="5" value="${servicoProduto.quantidade}">
                                    <label class="quantidade${produto.id}" for="quantidade${produto.id}">Qtd</label>
                                </div> 
                            </c:when>                            
                        </c:choose>
                    </c:forEach>
                    <c:if test="${produto.ativo && !mapaProdutos.containsKey(String.valueOf(produto.id))}">
                        <div class="checkbox col s9">
                            <p>
                                <input type="checkbox" id="check${produto.id}" value="${produto.id}" name="produtos"
                                       onclick="
                                                       if ($(this).is(':checked')) {
                                                           $('#quantidade${produto.id}').prop('disabled', false);
                                                       } else {
                                                           $('#quantidade${produto.id}').prop('disabled', true);
                                                           $('#quantidade${produto.id}').val(null);
                                                           $('#quantidade${produto.id}').removeClass('valid');
                                                           $('.quantidade${produto.id}').removeClass('active')
                                                       }"/>
                                <label for="check${produto.id}">${produto.nome}</label>
                            </p>             
                        </div>
                        <div class="input-field col s3">
                            <input id="quantidade${produto.id}" name="quantidade${produto.id}" type="number" class="validate" min="1" max="5" disabled>
                                   <label class="quantidade${produto.id}" for="quantidade${produto.id}">Qtd</label>
                        </div> 
                    </c:if>
                </c:forEach>
            </div>
        </div>
        <div class="">
            <input class="form-control btn btn-primary" type="submit" name="action" value="Atualizar"><br>
        </div>
    </form>

</div>

<script src="js/jquery.validate.js"></script>

<script src="js/inicializar-validate.js"></script>
<script src="js/validar-apenas-letras-numeros.js"></script>

<%@include file="rodape.jsp"%>
