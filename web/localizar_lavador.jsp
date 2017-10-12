<%-- 
    Document   : localizar_func
    Created on : 22/11/2016, 14:10:06
    Author     : rezen
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="cabecalho.jsp"%>

<div class="container">
    <div class="jumbotron">                
        <h1>Alterar Lavador</h1>
    </div>
    <form id="formLavador" action="Controle" method="post">
        <div class="form-group">
            <input type="hidden" name="quem" value="lavador"/>
            <input type="hidden" name="DtAdmissao" value="${lavador.dataContrato}">
            <input type="hidden" name="txtId" value="${lavador.id}"/>
            <div class="col-sm-5">
                <label>Nome:</label> 
                <input class="form-control erro-nome" type="text" name="txtNome" value="${lavador.nome}"><br>
            </div>
            <div class="col-sm-5">
                <label>Telefone:</label> 
                <input class="form-control erro-telefone" type="text" id ="telefone" name="txtTelefone" value="${lavador.telefone}"><br>
            </div>
            <div class="col-sm-5">
                <%--Formatar a data antes de exibir na tela--%>
                <fmt:formatDate value="${lavador.dtNascimento.time}" var="dataNascimento" type="date" pattern="dd/MM/yyyy" />            
                <label>Data de Nascimento:</label> 
                <input class="form-control erro-data" type="text" id ="data" name="txtDataNascimento" value="${dataNascimento}"><br>
            </div>
            <div class="col-sm-5">
                <label>CEP:</label> 
                <input class="form-control erro-cep" type="text" id="cep" name="txtCEP" value="${lavador.endereco.CEP}"><br>
            </div>
            <div class="col-sm-5">
                <label>Estado:</label> 
                <input class="form-control erro-estado" type="text" id="estado" name="txtEstado" value="${lavador.endereco.estado}"><br>
            </div>
            <div class="col-sm-5">
                <label>Cidade:</label> 
                <input class="form-control erro-cidade" type="text" id="cidade" name="txtCidade" value="${lavador.endereco.cidade}"><br>
            </div>
            <div class="col-sm-5">
                <label>Bairro:</label> 
                <input class="form-control erro-bairro" type="text" id ="bairro" name="txtBairro" value="${lavador.endereco.bairro}"><br>
            </div>
            <div class="col-sm-5">
                <label>Endereço:</label> 
                <input class="form-control erro-endereco" type="text" name="txtEndereco" value="${lavador.endereco.endereco}"><br>
            </div>
            <div class="col-sm-5">
                <label>Número:</label> 
                <input class="form-control erro-numero" type="text" name="txtNumero" value="${lavador.endereco.numero}"><br>
            </div>
            <input class="form-control btn btn-primary" type="submit" name="action" value="Atualizar"><br>
        </div>
    </form>
</div>
<script src="js/jquery.validate.js"></script>
<script type="text/javascript">
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

    $(document).ready(function () {
        $("#formLavador").validate({
            rules: {
                senha: {
                    required: true,
                    minlength: 5
                },
                confirme: {
                    required: true,
                    minlength: 5,
                    equalTo: "#senha"
                },
                txtNome: {
                    required: true,
                    minlength: 3
                },
                txtTelefone: {
                    required: true
                },
                data: {
                    required: true
                },
                txtCEP: {
                    required: true
                },
                txtEstado: {
                    required: true,
                    minlength: 2,
                    maxlength: 2
                },
                txtCidade: {
                    required: true
                },
                txtBairro: {
                    required: true
                },
                txtEndereco: {
                    required: true
                },
                txtNumero: {
                    required: true
                }
            },
            messages: {
                senha: {
                    required: "Por favor, coloque sua senha.",
                    minlength: "Sua senha deve conter no mínimo 5 caracteres."
                },
                confirme: {
                    required: "Por favor, coloque sua senha novamente.",
                    minlength: "Sua senha deve conter no mínimo 5 caracteres",
                    equalTo: "Sua senha deve ser a mesma."
                },
                txtNome: {
                    required: "Por favor, digite seu nome aqui",
                    minlength: "Por favor, digite um nome de no mínimo 3 dígitos"
                },
                txtTelefone: {
                    required: "Por favor, digite seu celular de contato aqui"
                },
                data: {
                    required: "Por favor, seleciona uma data de nascimento"
                },
                txtCEP: {
                    required: "Por favor, digite seu CEP aqui"
                },
                txtEstado: {
                    required: "Por favor, digite corretamente as siglas de seu estado aqui.",
                    minlength: "Por favor, digite corretamente as siglas de seu estado aqui.",
                    maxlength: "Por favor, digite corretamente as siglas de seu estado aqui."
                },
                txtCidade: {
                    required: "Por favor, digite sua cidade aqui"
                },
                txtBairro: {
                    required: "Por favor, digite sua bairro aqui"
                },
                txtEndereco: {
                    required: "Por favor, digite seu endereço aqui"
                },
                txtNumero: {
                    required: "Por favor, digite seu número aqui"
                }
            },
            errorElement: "em",
            errorPlacement: function (error, element) {
                // Add the `help-block` class to the error element
                error.addClass("help-block");

                if (element.prop("name") === "txtNome") {
                    error.insertAfter(".erro-nome");
                } else if (element.prop("name") === "senha") {
                    error.insertAfter(".erro-senha");
                } else if (element.prop("name") === "confirme") {
                    error.insertAfter(".erro-confirme");
                } else if (element.prop("name") === "txtCEP") {
                    error.insertAfter(".erro-cep");
                } else if (element.prop("name") === "txtTelefone") {
                    error.insertAfter(".erro-telefone");
                } else if (element.prop("name") === "txtEstado") {
                    error.insertAfter(".erro-estado");
                } else if (element.prop("name") === "txtCidade") {
                    error.insertAfter(".erro-cidade");
                } else if (element.prop("name") === "txtBairro") {
                    error.insertAfter(".erro-bairro");
                } else if (element.prop("name") === "txtEndereco") {
                    error.insertAfter(".erro-endereco");
                } else if (element.prop("name") === "txtNumero") {
                    error.insertAfter(".erro-numero");
                } else {
                    error.insertAfter(".erro-data");
                }

            }
        });
    });
</script>    

<%@include file="rodape.jsp"%>
