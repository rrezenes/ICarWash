
<!DOCTYPE html>
<html lang="pt-BR">

    <head>
        <meta charset="utf-8">

        <title>ICarWash</title>        

        <link rel="shortcut icon" href="img/favicon.ico" />

        <link rel="stylesheet" type="text/css" href="css/materialize.css">
        <style>
            body {
                display: flex;
                min-height: 100vh;
                flex-direction: column;
            }

            main {
                flex: 1 0 auto;
            }

            body {
                background-image: linear-gradient(to bottom, #bbdefb, #0d47a1);
                
            }

            .input-field input[type=date]:focus + label,
            .input-field input[type=text]:focus + label,
            .input-field input[type=email]:focus + label,
            .input-field input[type=password]:focus + label {
                color: #01579b !important;
            }

            .input-field input[type=date]:focus,
            .input-field input[type=text]:focus,
            .input-field input[type=email]:focus,
            .input-field input[type=password]:focus {
                border-bottom: 2px solid #01579b !important;
                box-shadow: none;
            }
        </style>
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
                            <div class="description">
                                <%  if (request.getParameter("c") != null) {
                                        if (request.getParameter("c").equals("ok")) {%>
                                <p>Cadastrado com Sucesso!</p>
                                <p>Acesse abaixo com seu usuario e senha.</p>
                                <%
                                        }
                                    }

                                %>
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
