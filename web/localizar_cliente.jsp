<%-- 
    Document   : localizar
    Created on : 18/11/2016, 09:40:30
    Author     : rezen
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="cabecalho.jsp"%>

<div class="container">
    <div class="row">
        <div class="jumbotron">
            <h1>Alterar Cliente</h1>
        </div>

        <form id="formCliente" action="Controle" method="post">
            <div class="form-group">
                <input type="hidden" name="quem" value="cliente"/>
                <input type="hidden" name="txtId" value="${cliente.id}"/>
                <div class="col-sm-5">
                    <label>Nome:</label> 
                    <input class="form-control erro-nome" type="text" name="txtNome" value="${cliente.nome}"><br>
                </div>
                <div class="col-sm-5">
                    <label>Telefone:</label> 
                    <input class="form-control erro-telefone" type="text" id ="telefone" name="txtTelefone" value="${cliente.telefone}"><br>
                </div>
                <div class="col-sm-5">
                    <%--Formatar a data antes de exibir na tela--%>
                    <fmt:formatDate value="${cliente.dtNascimento.time}" var="dataNascimento" type="date" pattern="dd/MM/yyyy" />            
                    <label>Data de Nascimento:</label> 
                    <input class="form-control" type="text" name="txtDataNascimento" value="${dataNascimento}"><br>
                </div>
                <div class="col-sm-5">
                    <label>CEP:</label> 
                    <input class="form-control" type="text" id="cep" name="txtCEP" value="${cliente.endereco.CEP}"><br>
                </div>
                <div class="col-sm-5">
                    <label>Estado:</label> 
                    <input class="form-control" type="text" id="estado" name="txtEstado" value="${cliente.endereco.estado}"><br>
                </div>
                <div class="col-sm-5">
                    <label>Cidade:</label> 
                    <input class="form-control" type="text" id="cidade" name="txtCidade" value="${cliente.endereco.cidade}"><br>
                </div>
                <div class="col-sm-5">
                    <label>Bairro:</label> 
                    <input class="form-control" type="text" id="bairro" name="txtBairro" value="${cliente.endereco.bairro}"><br>
                </div>
                <div class="col-sm-5">
                    <label>Endereço:</label> 
                    <input class="form-control" type="text" id="endereco" name="txtEndereco" value="${cliente.endereco.endereco}"><br>
                </div>
                <div class="col-sm-5">
                    <label>Número:</label> 
                    <input class="form-control" type="text" name="txtNumero" value="${cliente.endereco.numero}"><br>
                </div>
                <div class="col-sm-10">
                    <input class="form-control btn btn-primary" type="submit" name="action" value="Atualizar"><br>
                </div>
            </div>
        </form>
    </div>
</div>

<script src="js/jquery.validate.js"></script>
<script type="text/javascript">
    jQuery.validator.addMethod("cpf", function (value, element) {
        value = jQuery.trim(value);

        value = value.replace('.', '');
        value = value.replace('.', '');
        cpf = value.replace('-', '');
        while (cpf.length < 11)
            cpf = "0" + cpf;
        var expReg = /^0+$|^1+$|^2+$|^3+$|^4+$|^5+$|^6+$|^7+$|^8+$|^9+$/;
        var a = [];
        var b = new Number;
        var c = 11;
        for (i = 0; i < 11; i++) {
            a[i] = cpf.charAt(i);
            if (i < 9)
                b += (a[i] * --c);
        }
        if ((x = b % 11) < 2) {
            a[9] = 0
        } else {
            a[9] = 11 - x
        }
        b = 0;
        c = 11;
        for (y = 0; y < 10; y++)
            b += (a[y] * c--);
        if ((x = b % 11) < 2) {
            a[10] = 0;
        } else {
            a[10] = 11 - x;
        }

        var retorno = true;
        if ((cpf.charAt(9) != a[9]) || (cpf.charAt(10) != a[10]) || cpf.match(expReg))
            retorno = false;

        return this.optional(element) || retorno;

    }, "Informe um CPF válido");


    var msg_cep;
    $("#cep").change(function () {
        var cep_code = $(this).val();
        if (cep_code.length <= 0)
            return;
        $.get("http://apps.widenet.com.br/busca-cep/api/cep.json", {code: cep_code},
                function (result) {
                    if (result.status != 1) {
                        alert(result.message || "Houve um erro desconhecido");
                        return;
                    }
                    $("input#cep").val(result.code);
                    $("input#estado").val(result.state);
                    $("input#cidade").val(result.city);
                    $("input#bairro").val(result.district);
                    $("input#endereco").val(result.address);
                    $("input#estado").val(result.state);
                });
    });

    jQuery.validator.addMethod("lettersonly", function (value, element) {
        return this.optional(element) || /^[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ ]+$/i.test(value);
    }, "Por favor, utilize apenas letras");
    
    $.validator.addMethod("letterAndNumbersOnly", function(value, element) {
        return this.optional(element) || /^[A-Za-z0-9áàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ ]+$/i.test(value);
    }, "Por favor, utilize apenas letras e números");

    $(document).ready(function () {

        $("#formCliente").validate({
            rules: {
                txtNome: {
                    required: true,
                    minlength: 3,
                    lettersonly: true
                },
                txtTelefone: {
                    required: true
                },
                txtCEP: {
                    required: true
                },
                txtEstado: {
                    required: true,
                    minlength:2,
                    maxlength: 2,
                    lettersonly: true
                },
                txtCidade: {
                    required: true,
                    letterAndNumbersOnly: true
                },
                txtBairro: {
                    required: true,
                    letterAndNumbersOnly: true
                },
                txtEndereco: {
                    required: true,
                    letterAndNumbersOnly: true
                },
                txtNumero: {
                    required: true,
                    letterAndNumbersOnly: true
                }

            },
            messages: {
                txtNome: {
                    required: "Por favor, digite seu nome aqui",
                    minlength: "Por favor, digite um nome de no mínimo 3 dígitos"
                },
                txtTelefone: {
                    required: "Por favor, digite seu telefone"
                },
                txtCEP: {
                    required: "Por favor, digite seu CEP"
                },
                txtEstado: {
                    required: "Por favor, digite seu estado",
                    minlength: "Por favor, digite apenas os dois dígitos do estado",
                    maxlength: "Por favor, digite apenas os dois dígitos do estado"
                },
                txtCidade: {
                    required: "Por favor, digite sua cidade"
                },
                txtBairro: {
                    required: "Por favor, digite seu bairro"
                },
                txtEndereco: {
                    required: "Por favor, digite seu endereço"
                },
                txtNumero: {
                    required: "Por favor, digite seu número"
                    
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
                } else if (element.prop("txtTelefone") === "txtTelefone") {
                    error.insertAfter(".erro-telefone");
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
