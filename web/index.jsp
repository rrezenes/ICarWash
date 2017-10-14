
<!DOCTYPE html>
<html lang="pt-BR">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>ICarWash</title>        
        <link rel="shortcut icon" href="img/favicon.ico" />

        <!-- CSS -->
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/font-awesome.min.css">
        <link rel="stylesheet" href="css/form-elements.css">
        <link rel="stylesheet" href="css/style.css">

        <!-- Favicon and touch icons -->
        <link rel="shortcut icon" href="assets/ico/favicon.png">
    </head>

    <body>

        <!-- Top content -->
        <div class="top-content">

            <div class="inner-bg">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-8 col-sm-offset-2 text">
                            <h1><strong>ICarWash</strong> Login</h1>
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
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-6 col-sm-offset-3 form-box">
                            <div class="form-top">
                                <div class="form-top-left">
                                    <h3>Acesse o ICarWash!</h3>
                                    <p>Insira seu nome de usuario e senha para acessar:</p>
                                </div>
                                <div class="form-top-right">
                                    <i class="glyphicon glyphicon-lock"></i>
                                </div>
                            </div>

                            <div class="form-bottom">
                                <form role="form" action="Login" method="post" class="login-form">
                                    <div class="form-group">
                                        <label class="sr-only" for="form-username">Email:</label>
                                        <input type="text" name="email" placeholder="Email..." class="form-username form-control" id="form-username">
                                    </div>
                                    <div class="form-group">
                                        <label class="sr-only" for="form-password">Senha:</label>
                                        <input type="password" name="senha" placeholder="Senha..." class="form-password form-control" id="form-password">
                                    </div>
                                    <button type="submit" class="btn">Entrar!</button>

                                </form>

                            </div>
                            <div>
                                <a href="novo-cliente" align="right">Cadastre-se</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <!-- Javascript -->
        <script src="js/jquery-3.1.1.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.backstretch.min.js"></script>
        <script src="js/scripts.js"></script>

        <!--[if lt IE 10]>
            <script src="assets/js/placeholder.js"></script>
        <![endif]-->

    </body>

</html>
