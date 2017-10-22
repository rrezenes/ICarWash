
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
    <div class="col s3">
        <a class="waves-effect waves-light btn-floating btn-large green modal-trigger" href="#modal"><i class="material-icons">&#xE145;</i></a>
    </div>
    <div class="col s9">
        <input id="buscar" type="text" />
    </div>
</div>
<table id="produtos" class="table table-hover centered striped responsive-table">
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
                    <a type="button" class="btn-floating blue" href="Controle?action=LocalizarPorId&q=produto&id=${produto.id}"><i class="material-icons">&#xE254;</i></a>
                    <c:choose>
                        <c:when test="${produto.ativo}">                                       
                            <a class="btn-floating red" type="button" href="Controle?action=Excluir&q=produto&id=${produto.id}"><i class="material-icons">delete</i></a>
                        </c:when> 
                        <c:otherwise>
                            <a class="btn-floating green" type="button" href="Controle?action=Ativar&q=produto&id=${produto.id}"><i class="material-icons">done</i></a>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<div id="modal" class="modal modal-fixed-footer">
    <div class="modal-content">
        <div class="row">
            <p class="titulo-controle">Cadastrar Produto</p>
            <div class="divider"></div>
        </div>
        <form id="formProduto" action="Controle" method="post">
            <div class="form-group">
                <input type="hidden" name="quem" value="produto">
                <div class="row">
                    <div class="col-sm-5">
                        <label>Nome:</label> 
                        <input class="form-control erro-nome" type="text" name="nome" id="nome"><br>
                    </div>
                    <div class="col-sm-5">
                        <label>Descrição:</label> 
                        <input class="form-control erro-descricao" type="text" name="descricao" id="descricao"><br>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <input class="form-control btn btn-primary" type="submit" name="action" value="Cadastrar"><br>
            </div>
        </form>
    </div>
    <div class="modal-footer">
        <a class="modal-action modal-close waves-effect waves-green btn-flat">Fechar</a>
    </div>
</div>

<script src="js/jquery.validate.js"></script>
<script type="text/javascript">
    function filterTable(event) {
        var filter = event.target.value.toUpperCase();
        var rows = document.querySelector("#produtos tbody").rows;

        for (var i = 0; i < rows.length; i++) {

            var nome = rows[i].cells[0].textContent.toUpperCase();
            var descricao = rows[i].cells[1].textContent.toUpperCase();


            if (nome.indexOf(filter) > -1 || descricao.indexOf(filter) > -1) {
                rows[i].style.display = "";
            } else {
                rows[i].style.display = "none";
            }
        }
    }

    document.querySelector('#buscar').addEventListener('keyup', filterTable, false);

    $(document).ready(function () {
        
        $('.modal').modal();
        $("#formProduto").validate({
            rules: {
                nome: {
                    maxlength: 50,
                    required: true,
                    minlength: 3
                },
                descricao: {
                    maxlength: 50,
                    required: true,
                    minlength: 3
                }

            },
            messages: {
                nome: {
                    maxlength: "Utilize no máximo 50 caracteres",
                    required: "Campo obrigarório preencher",
                    minlength: "Utilize no mínimo 3 caracteres"
                },
                descricao: {
                    maxlength: "Utilize no máximo 50 caracteres",
                    required: "Campo obrigarório preencher",
                    minlength: "Utilize no mínimo 3 caracteres"
                }
            },
            errorElement: "em",
            errorPlacement: function (error, element) {
                // Add the `help-block` class to the error element
                //error.addClass("help-block");

                // Add `has-feedback` class to the parent div.form-group
                // in order to add icons to inputs
                element.parents(".col-sm-5").addClass("has-feedback");

                if (element.prop("nome") === "nome") {
                    error.insertAfter(".erro-nome");
                } else if (element.prop("descricao") === "descricao") {
                    error.insertAfter(".erro-descricao");
                } else {
                    error.insertAfter(element);
                }

                // Add the span element, if doesn't exists, and apply the icon classes to it.
                if (!element.next("span")[ 0 ]) {
                    $("<span class='glyphicon form-control-feedback'></span>").insertAfter(element);
                }
            },
            success: function (label, element) {
                // Add the span element, if doesn't exists, and apply the icon classes to it.
                if (!$(element).next("span")[ 0 ]) {
                    $("<span class='glyphicon form-control-feedback'></span>").insertAfter($(element));
                }
            },
            highlight: function (element, errorClass, validClass) {
                $(element).parents(".col-sm-5").addClass("has-error").removeClass("has-success");
                //$(element).next("span").addClass("glyphicon-remove").removeClass("glyphicon-ok");
            },
            unhighlight: function (element, errorClass, validClass) {
                $(element).parents(".col-sm-5").addClass("has-success").removeClass("has-error");
                //$(element).next("span").addClass("glyphicon-ok").removeClass("glyphicon-remove");
            }
        });
    });
</script>

<%@include file="rodape.jsp"%>