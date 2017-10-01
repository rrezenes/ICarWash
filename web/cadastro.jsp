<%-- 
    Document   : cadastro
    Created on : 06/05/2017, 15:41:53
    Author     : rezen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8"/>
        <title>Cadastro</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link href="css/navbar-fixed-side.css" rel="stylesheet" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery-3.1.1.js"></script>
        <script src="js/jquery.maskedinput.min.js"></script>
        <title>ICarWash</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-sm-8 col-sm-offset-2">
                    <div class="page-header">
                        <div class="alert alert-info" role="alert">
                            <h4>Cadastro de um novo cliente</h4>
                        </div>
                    </div>
                    <div class="panel-body">
                        <form id="formCliente" method="post" class="form-horizontal" action="NovoCliente">
                            <div class="form-group">
                                <label class="col-sm-4 control-label" for="usuario" name="login">Usuário</label>                                    
                                <div class="col-sm-5">
                                    <input type="text" class="form-control" id="usuario" name="usuario" placeholder="Digite aqui o nome de seu usuário" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-4 control-label" for="email" name="txtEmail">Email</label>
                                <div class="col-sm-5">
                                    <input type="text" class="form-control" id="email" name="email" placeholder="Email" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-4 control-label" for="senha">Senha</label>
                                <div class="col-sm-5">
                                    <input type="password" class="form-control" id="senha" name="senha" placeholder="Digite aqui sua senha" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-4 control-label" for="confirme_senha">Confirme a senha</label>
                                <div class="col-sm-5">
                                    <input type="password" class="form-control" id="confirme_senha" name="confirme_senha" placeholder="Confirme aqui sua senha" />
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-9 col-sm-offset-4">
                                    <button type="submit" class="btn btn-primary" name="signup1" value="Cadastrar">Cadastrar</button>
                                    <button type="button" class="btn btn-primary" name="back" value="Back" onclick="window.history.back()">Voltar</button>


                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <script src="js/jquery.validate.js"></script>
        <script type="text/javascript">
            $(document).ready(function () {

                $("#formCliente").validate({
                    rules: {
                        firstname1: "required",
                        lastname1: "required",
                        usuario: {                            
                            remote: 'CheckUsuarioLogin',
                            required: true,
                            minlength: 2
                        },
                        senha: {
                            required: true,
                            minlength: 5
                        },
                        confirme_senha: {
                            required: true,
                            minlength: 5,
                            equalTo: "#senha"
                        },
                        email: {
                            remote: 'CheckUsuarioEmail',
                            required: true,
                            email: true
                        },
                    },
                    messages: {
                        usuario: {
                            required: "Por favor, coloque seu usuário.",
                            minlength: "Seu usuário deve conter no mínimo 2 caracteres.",
                            remote: "Usuário já está em uso."
                        },
                        senha: {
                            required: "Por favor, coloque sua senha.",
                            minlength: "Sua senha deve conter no mínimo 5 caracteres."
                        },
                        confirme_senha: {
                            required: "Por favor, coloque sua senha novamente.",
                            minlength: "Sua senha deve conter no mínimo 5 caracteres",
                            equalTo: "Sua senha deve ser a mesma a cima."
                        },
                        email: {
                            email: "Por favor, coloque um e-mail válido.",
                            remote: "E-mail já está em uso."
                        }
                    },
                    errorElement: "em",
                    errorPlacement: function (error, element) {
                        // Add the `help-block` class to the error element
                        error.addClass("help-block");

                        // Add `has-feedback` class to the parent div.form-group
                        // in order to add icons to inputs
                        element.parents(".col-sm-5").addClass("has-feedback");

                        if (element.prop("type") === "checkbox") {
                            error.insertAfter(element.parent("label"));
                        } else {
                            error.insertAfter(element);
                        }

                        // Add the span element, if doesn't exists, and apply the icon classes to it.
                        if (!element.next("span")[ 0 ]) {
                            $("<span class='glyphicon glyphicon-remove form-control-feedback'></span>").insertAfter(element);
                        }
                    },
                    success: function (label, element) {
                        // Add the span element, if doesn't exists, and apply the icon classes to it.
                        if (!$(element).next("span")[ 0 ]) {
                            $("<span class='glyphicon glyphicon-ok form-control-feedback'></span>").insertAfter($(element));
                        }
                    },
                    highlight: function (element, errorClass, validClass) {
                        $(element).parents(".col-sm-5").addClass("has-error").removeClass("has-success");
                        $(element).next("span").addClass("glyphicon-remove").removeClass("glyphicon-ok");
                    },
                    unhighlight: function (element, errorClass, validClass) {
                        $(element).parents(".col-sm-5").addClass("has-success").removeClass("has-error");
                        $(element).next("span").addClass("glyphicon-ok").removeClass("glyphicon-remove");
                    }
                });
            });
        </script>
        <%@include file="rodape.jsp"%>