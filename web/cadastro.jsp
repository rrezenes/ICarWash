<!DOCTYPE html>
<html lang="pt-BR">

    <head>
        <meta charset="utf-8">

        <title>Cadastro de um novo cliente</title>        

        <link rel="shortcut icon" href="img/favicon.ico" />
        <link rel="stylesheet" type="text/css" href="css/materialize.css">
        <link rel="stylesheet" type="text/css" href="css/estilo-index.css">

    </head>

    <body>
        <div class="section"></div>
        <main>
            <center>
                <div class="section"></div>

                <h5 class="indigo-text">Cadastro de um novo cliente</h5>
                <div class="section"></div>

                <div class="container">
                    <div class="z-depth-4 grey lighten-4 row" style="display: inline-block; padding: 32px 48px 0px 48px; border: 1px solid #EEE;">
                        <form class="col s12" role="form" action="NovoCliente" id="formCliente" method="post" class="login-form">
                            <div class='row'>
                                <div class='col s12'>
                                </div>
                            </div>
                            <div class='row'>
                                <div class='input-field col s12'>
                                    <input class="validate" type="email" id="email" for="email" name="txtEmail"/>
                                    <label for='email'>E-mail</label>
                                </div>
                            </div>
                            <div class='row'>
                                <div class='input-field col s12'>
                                    <input class='validate' type='password' name='senha' id="password" />
                                    <label for='password'>Entre com a sua senha</label>
                                </div>
                                <label style='float: right;'>
                                    <a class='blue-text' href='#!'><b>Esqueceu sua senha?</b></a>
                                </label>
                            </div>

                            <br />
                            <center>
                                <div class='row'>
                                    <button type='submit' name='btn' class='col s12 btn btn-large waves-effect light-blue darken-4'>Entrar</button>
                                </div>
                            </center>
                        </form>
                    </div>
                </div>
                <a class='blue-text' href="novo-cliente">Criar uma conta</a>
            </center>

            <div class="section"></div>
            <div class="section"></div>
        </main>

        <script type="text/javascript" src="js/jquery-3.1.1.js"></script>
        <script type="text/javascript" src="js/materialize.js"></script>
    </body>

    <script type="text/javascript" src="js/materialize.js"></script>
</html>





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
                        email: {
                            remote: 'CheckUsuarioEmail',
                            required: true,
                            email: true
                        },
                        senha: {
                            required: true,
                            minlength: 5
                        },
                        confirme_senha: {
                            required: true,
                            minlength: 5,
                            equalTo: "#senha"
                        }

                    },
                    messages: {
                        email: {
                            remote: "E-mail já está em uso.",
                            required: "Por favor, coloque um e-mail válido.",
                            email: "Por favor, coloque um e-mail válido."
                        },
                        senha: {
                            required: "Por favor, coloque sua senha.",
                            minlength: "Sua senha deve conter no mínimo 5 caracteres."
                        },
                        confirme_senha: {
                            required: "Por favor, coloque sua senha novamente.",
                            minlength: "Sua senha deve conter no mínimo 5 caracteres",
                            equalTo: "Sua senha deve ser a mesma a cima."
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