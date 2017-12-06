<!DOCTYPE html>
<html lang="pt-BR">

    <head>
        <meta charset="utf-8">

        <title>ICarWash</title>        

        <link rel="shortcut icon" href="img/favicon.ico" />

        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

        <link rel="stylesheet" type="text/css" href="css/materialize.css" media="screen,projection">
        <link rel="stylesheet" type="text/css" href="css/estilo-index.css">

        <script type="text/javascript" src="js/jquery-3.1.1.js"></script>
        <script type="text/javascript" src="js/materialize.js"></script>

        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    </head>

    <body>
        <div class="section"></div>
        <main>
            <center>
                <div class="section"></div>

                <h5 class="indigo-text">ICarWash</h5>
                <div class="section"></div>

                <div class="container">
                    <div class="z-depth-4 grey lighten-4 row" style="display: inline-block; padding: 32px 48px 0px 48px; border: 1px solid #EEE;">

                        <form class="col s12" role="form" action="Login" method="post" class="login-form">
                            <div class='row'>
                                <div class='col s12'>
                                </div>
                            </div>
                            <div class='row'>
                                <div class='input-field col s12'>
                                    <input class="validate" type="email" name="email" id="email"/>
                                    <label for='email'>Entre com o seu e-mail</label>
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
                <a class='blue-text modal-trigger' href="#modal">Criar uma conta</a>
            </center>

            <div class="section"></div>
            <div class="section"></div>
        </main>

        <div id="modal" class="modal modal-fixed-footer">
            <form class="col s12" role="form" action="NovoCliente" id="FormValidate" method="post" class="login-form">
                <div class="modal-content">
                    <div class="col s12">
                        <div class="row">
                            <p>Novo Cliente</p>
                            <div class="divider"></div>
                            <div class='input-field col s12'>
                                <input class="form-control erro-email" type="text" name="email" id="email"><br>
                                <label for="email">Email</label>
                            </div>
                            <div class='input-field col s12'>
                                <label for="senha">Senha</label> 
                                <input class="form-control erro-senha" type="password" name="senha" id="senha" ><br>
                            </div>
                            <div class='input-field col s12'>
                                <label for="confirme_senha">Confirme a Senha</label> 
                                <input class="form-control erro-confirme" type="password" name="confirme" id="confirme" ><br>
                            </div>
                        </div>
                    </div> 
                </div>
                <div class="modal-footer">
                    <input class="form-control btn btn-primary" type="submit" name="action" value="Cadastrar">
                    <a class="modal-action modal-close waves-effect waves-green btn-flat">Fechar</a>
                </div>  
            </form> 
        </div>
    </body>

    <script src="js/jquery.validate.js"></script>
    <script src="js/inicializar-modal.js"></script>
    <script src="js/inicializar-validate.js"></script>

    <%@include file="rodape.jsp"%>
