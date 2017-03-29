<%-- 
    Document   : solicitacao
    Created on : 30/11/2016, 23:00:03
    Author     : rezen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <title>Bootstrap Example</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>

        <div class="container">
            <h2>Formulario para teste da condução.</h2>
            <form method="post" action="PedidoController">
                <div class="form-group">
                    <label for="email">Email do cliente:</label>
                    <input type="email" class="form-control" id="email" name="email" placeholder="Entre com o email de algum dos clientes para testar a condução">
                </div>
                <div class="form-group">
                    <label for="sel1">Selecione o tamanho do veiculo: </label>
                    <select class="form-control" id="porte_veiculo"name="porte_veiculo">
                        <option>Pequeno</option>
                        <option>Medio</option>
                        <option>Grande</option>
                    </select><br>
                    <label for="sel1">Selecione os servicos: </label>
                    <div class="checkbox ">
                        <label><input type="checkbox" value="Aspirar">Aspirar</label>
                    </div>
                    <div class="checkbox ">
                        <label><input type="checkbox" value="Lavagem">Lavagem</label>
                    </div>
                    <div class="checkbox ">
                        <label><input type="checkbox" value="Higienização">Higienização</label>
                    </div>
                    <div class="checkbox">
                        <label><input type="checkbox" value="Lavagem do Motor">Lavagem do Motor</label>
                    </div>
                </div>
                <button type="submit" class="btn btn-default">Enviar</button>
            </form>
        </div>

    </body>
</html>
