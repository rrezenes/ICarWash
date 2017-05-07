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
        <h1>Hello World!</h1>
        <div style='width: 1000px;'>
            <form action="Controle" method="post">
                <div class="form-group">
                    <input type="hidden" name="quem" value="cliente">
                    <div class="row">
                        <div class="col-md-8"><label>Email:</label> <input class="form-control" type="email" name="txtEmail" id="txtEmail"><br></div>
                    </div>    
                    <div class="row">
                        <div class="col-md-6"><label>Login:</label> <input class="form-control" type="text" name="login"><br></div>
                        <div class="col-md-6"><label>Senha:</label> <input class="form-control" type="password" name="senha"><br></div>
                    </div>
                    <div class="row">
                        <div class="col-md-6"><label>Nome:</label> <input class="form-control" type="text" name="nome"><br></div>
                        <div class="col-md-6"><label>Telefone:</label> <input class="form-control" type="text" name="telefone" id="telefone"><br></div>
                    </div>
                    <div class="row">
                        <div class="col-md-6"><label>Data de Nascimento:</label> <input class="form-control" type="text" name="nascimento" id="nascimento"><br></div>
                        <div class="col-md-6"><label>CPF:</label> <input class="form-control" type="text" name="cpf" id="cpf"><br></div>
                    </div>
                    <div class="row">
                        <div class="col-md-6"><label>CEP:</label> <input class="form-control" type="text" name="cep" id="cep"><br></div>
                        <div class="col-md-6"><label>Estado:</label> <input class="form-control" type="text" name="estado" id="estado"><br></div>
                    </div>
                    <div class="row">
                        <div class="col-md-6"><label>Cidade:</label> <input class="form-control" type="text" name="cidade" id="cidade"><br></div>
                        <div class="col-md-6"><label>Bairro:</label> <input class="form-control" type="text" name="bairro" id="bairro"><br></div>
                    </div>
                    <div class="row">
                        <div class="col-md-8"><label>Endereço:</label> <input class="form-control" type="text" name="endereco" id="endereco"><br></div>
                        <div class="col-md-4"><label>Numero:</label> <input class="form-control" type="text" name="numero" id="numero"><br></div>
                    </div>
                </div>
                <div class="form-group">
                    <input class="form-control btn btn-primary" type="submit" name="action" value="Cadastrar"><br>
                </div>
            </form>
        </div>
    </body>
</html>
