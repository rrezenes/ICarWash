
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="cabecalho.jsp"%>
<div class="container">
    <div class="jumbotron">
        <h1>Alterar Serviço</h1>
    </div>
    <form id="formServico" action="Controle" method="post">
        <div class="form-group">
            <input type="hidden" name="quem" value="servico"/>
            <input type="hidden" name="txtId" value="${servico.id}"/>
            <div class="col-sm-5">
                <label>Nome:</label> 
                <input class="form-control erro-nome" type="text" name="txtNome" value="${servico.nome}"><br>
            </div>
            <div class="col-sm-5">
                <label>Descrição:</label> 
                <input class="form-control erro-descricao" type="text" name="txtDescricao" value="${servico.descricao}"><br>
            </div>
            <div class="col-sm-5">
                <label>Valor:</label> 
                <input class="form-control erro-valor" type="text" name="txtValor" value="${servico.valor}"><br>
            </div>
            <input class="form-control btn btn-primary" type="submit" name="action" value="Atualizar"><br>

        </div>
    </form>
</div>

<script src="js/jquery.validate.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        $("#formServico").validate({
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
                },
                txtValor: {
                    maxlength: 6,
                required: true,
                number: true
                }
            },
            messages: {
                txtNome: {
                    maxlength: "Por favor, entre com o nome do serviço",
                    required: "Por favor, entre com o nome do serviço",
                    minlength: "Por favor, digite um nome de no mínimo 3 dígitos"
                },
                txtDescricao: {
                    required: "Por favor, entre com uma descrição breve do serviço"
                },
                txtValor: {
                    maxlength: "Utilize no máximo 6 caracteres",
                required: "Campo obrigarório preencher",
                number: "Apenas valores reais, utilize ponto para separar reais dos centavos"
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
                } else if (element.prop("txtValor") === "txtValor") {
                    error.insertAfter(".erro-valor");
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
