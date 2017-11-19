
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="cabecalho.jsp"%>

<c:if test="${!empty cadastrado}">
    <script>Materialize.toast('Produto Cadastrado', 6000, 'rounded');</script>        
</c:if>

<div class="row">
    <p class="titulo-controle">Controle de Serviços</p>
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
            <th>Preço</th>
            <th></th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="servico" items="${servicos}">
            <tr>
                <td>${servico.nome}</td>
                <td>${servico.descricao}</td>
                <td>${servico.valor}</td>
                <td>
                    <a type="button" class="btn-floating blue" href="Controle?action=LocalizaPorIdCommand&q=servico&id=${servico.id}"><i class="material-icons">&#xE254;</i></a>
                    <c:choose>
                        <c:when test="${servico.ativo}">
                            <a class="btn-floating red" type="button" href="Controle?action=DesativaCommand&q=servico&id=${servico.id}"><i class="material-icons">delete</i></a>
                        </c:when>
                        <c:otherwise>
                            <a class="btn-floating green" type="button" href="Controle?action=AtivaCommand&q=servico&id=${servico.id}"><i class="material-icons">done</i></a>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </c:forEach>   
    </tbody>
</table>

<div id="modal" class="modal modal-fixed-footer">
    <form id="FormValidate" name="listarServico" action="Controle" method="post">
        <div class="modal-content">
            <div class="row">
                <p class="titulo-controle">Cadastrar Serviço</p>
                <div class="divider"></div>
            </div>
            <div class="form-group">
                <input type="hidden" name="action" value="CadastroCommand"/>
                <input type="hidden" name="quem" value="servico">
                <div class="row">
                    <div class="input-field col s12">
                        <label>Nome:</label> 
                        <input class="form-control erro-nome" type="text" name="nome" id="nome"><br>
                    </div>
                    <div class="input-field col s12">
                        <label>Descrição:</label> 
                        <input class="form-control erro-descricao" type="text" name="descricao" id="descricao"><br>
                    </div>
                    <div class="input-field col s12">
                        <label>Valor:</label> 
                        <input class="form-control erro-valor" type="text" name="valor" id="valor"><br>
                    </div>
                    <div class="row">
                        <h5>Produtos</h5>
                        <div class="divider"></div>
                    </div>
                    <legend></legend>
                    <c:forEach var="produto" items="${produtos}">
                        <c:if test = "${produto.ativo}">
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
                                <input class="form-control erro-produtos" id="quantidade${produto.id}" name="quantidade${produto.id}" type="number" class="validate" min="1" max="5" disabled>
                                <label class="quantidade${produto.id}" for="quantidade${produto.id}">Qtd</label>
                            </div> 
                        </c:if>
                    </c:forEach>
                </div>
            </div>
        </div>
        <div class="modal-footer">
            <input class="form-control btn btn-primary" type="submit" value="Cadastrar" id="confirmar">
            <a class="modal-action modal-close waves-effect waves-green btn-flat">Fechar</a>
        </div>
    </form>
</div>

<script src="js/validar-cadastro-servico.js"></script>
<script src="js/jquery.validate.js"></script>
<script src="js/inicializar-validate.js"></script>
<script src="js/inicializar-modal.js"></script>
<script src="js/buscar-na-tabela-3.js"></script>
<script>
    $(document).ready(function () {
        let searchParams = new URLSearchParams(window.location.search);
        if (searchParams.has('ok')) {
            Materialize.toast('Cadastro Efetuado', 6000, 'rounded');
        }
    });
</script>

<%@include file="rodape.jsp"%>