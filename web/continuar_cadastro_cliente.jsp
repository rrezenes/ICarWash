<%-- 
    Document   : continuar_cadastro_cliente
    Created on : 23/09/2017, 21:26:25
    Author     : Mirian
--%>

<%@include file="cabecalho.jsp"%>

<div class="jumbotron">
    <h2>Antes de solicitar um serviço, por favor conclua seu Cadastro :)</h2>
</div>
<form action="ContinuarCadastro" method="post">
    <div class="form-group">
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
            <div class="col-md-6"><label>Estado:</label> <input class="form-control" type="text" name="estado" id="estado" readonly><br></div>
        </div>
        <div class="row">
            <div class="col-md-6"><label>Cidade:</label> <input class="form-control" type="text" name="cidade" id="cidade" readonly><br></div>
            <div class="col-md-6"><label>Bairro:</label> <input class="form-control" type="text" name="bairro" id="bairro" readonly><br></div>
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

<%@include file="rodape.jsp"%>
