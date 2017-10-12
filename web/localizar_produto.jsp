<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="br.icarwash.model.Produto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.icarwash.dao.ProdutoDAO"%>
<%@include file="cabecalho.jsp"%>
<div class="container">
    <div class="jumbotron">
        <%//recupera a lista do request
            DateFormat f = new SimpleDateFormat("dd/MM/yyyy");
            Produto produto = (Produto) request.getAttribute("produto");%>
        <h1>Alterar Produto</h1>
    </div>
    <form id="formProduto" action="Controle" method="post">
        <div class="form-group">
            <input type="hidden" name="quem" value="produto"/>
            <input type="hidden" name="txtId" value="<%= produto.getId()%>"/>
            <div class="col-sm-5">
                <label>Nome:</label> 
                <input class="form-control erro-nome" type="text" name="txtNome" value="<%= produto.getNome()%>"><br>
            </div>
            <div class="col-sm-5">
                <label>Descrição:</label> 
                <input class="form-control erro-descricao" type="text" name="txtDescricao" value="<%= produto.getDescricao()%>"><br>
            </div>
            <input class="form-control btn btn-primary" type="submit" name="action" value="Atualizar"><br>
        </div>
    </form>
</div>

<script src="js/jquery.validate.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        $("#formProduto").validate({
            rules: {
                txtNome: {
                    maxlength: 50,
                    required: true,
                    minlength: 3
                },
                txtDescricao: {
                    maxlength: 50,
                    required: true,
                    minlength: 3
                }

            },
            messages: {
                txtNome: {
                    maxlength: "Utilize no máximo 50 caracteres",
                    required: "Campo obrigarório preencher",
                    minlength: "Utilize no mínimo 3 caracteres"
                },
                txtDescricao: {
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

                if (element.prop("txtNome") === "txtNome") {
                    error.insertAfter(".erro-nome");
                } else if (element.prop("txtDescricao") === "txtDescricao") {
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
