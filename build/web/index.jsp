<%-- 
    Document   : index
    Created on : 17/11/2016, 22:03:09
    Author     : rezen
--%>


<!DOCTYPE html>
<html lang="pt-BR">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>ICarWash Admin!</title>

        <!-- CSS -->
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/font-awesome.min.css">
        <link rel="stylesheet" href="css/form-elements.css">
        <link rel="stylesheet" href="css/style.css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

        <!-- Favicon and touch icons -->
        <link rel="shortcut icon" href="assets/ico/favicon.png">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="assets/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="assets/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="assets/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="assets/ico/apple-touch-icon-57-precomposed.png">

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
                                <!--<p>
                                        This is a free responsive login form made with Bootstrap. 
                                        Download it on <a href="http://azmind.com"><strong>AZMIND</strong></a>, customize and use it as you like!
                                    </p>-->
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-6 col-sm-offset-3 form-box">
                            <div class="form-top">
                                <div class="form-top-left">
                                    <h3>Entre no Painel Admin!</h3>
                                    <p>Insira seu nome de usuario e senha para acessar:</p>
                                </div>
                                <div class="form-top-right">
                                    <i class="glyphicon glyphicon-lock"></i>
                                </div>
                            </div>
                            
                            <div class="form-bottom">
                                <form role="form" action="Login" method="post" class="login-form">
                                    <div class="form-group">
                                        <label class="sr-only" for="form-username">Usuario:</label>
                                        <input type="text" name="usuario" placeholder="Usuario..." class="form-username form-control" id="form-username">
                                    </div>
                                    <div class="form-group">
                                        <label class="sr-only" for="form-password">Senha:</label>
                                        <input type="password" name="senha" placeholder="Senha..." class="form-password form-control" id="form-password">
                                    </div>
                                    <button type="submit" class="btn">Entrar!</button>
                                   
                                </form>
                                
                            </div>
                            <div>
                                    <a href="cadastro.jsp" align="right">Cadastre-se</a>
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
<%--<jsp:forward page="Controle?action=Admin" />--%>
