
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="cabecalho.jsp"%>
<div class="container">
    <div class="jumbotron">
        <h1>Controle de Produtos</h1>
    </div>

    <button type="button" class="btn btn-info" data-toggle="modal" data-target="#myModal">Adicionar Produto</button>

    <table class="table table-hover">
        <thead>
            <tr>
                <th></th>
                <th>Nome</th>
                <th>Descrição</th>
                <th colspan="2"></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="produto" items="${produtos}">
                <tr>
                    <td>
                        <c:choose>
                            <c:when test="${produto.ativo}">
                                <div type="button" class="glyphicon glyphicon-ok text-success"></div>
                            </c:when> 
                            <c:otherwise>
                                <div type="button" class="glyphicon glyphicon glyphicon-remove text-danger"></div>
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td>${produto.nome}</td>
                    <td>${produto.descricao}</td>
                    <td><a type="button" class="glyphicon glyphicon-pencil text-info" href="Controle?action=LocalizarPorId&q=produto&id=${produto.id}"></a></td>
                    <td>
                        <c:choose>
                            <c:when test="${produto.ativo}">          	
                                <a type="button" href="Controle?action=Excluir&q=produto&id=${produto.id}">Inativar</a>
                            </c:when> 
                            <c:otherwise>
                                <a type="button" href="Controle?action=Ativar&q=produto&id=${produto.id}">Ativar</a>
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</div>
<div class="container">
</div>
<div id="myModal" class="modal fade" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Cadastrar Produto</h4>
            </div>
            <div class="modal-body">
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
                <button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
            </div>
        </div>
    </div>
</div>

<script src="js/jquery.validate.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
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