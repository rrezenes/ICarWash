
<%@include file="cabecalho.jsp"%>
<div class="container">
    <div class="jumbotron">
        <p class="titulo-controle">Antes de solicitar um serviço, conclua seu Cadastro ;)</p>
    </div>
    <form id="FormValidate" action="ContinuarCadastro" method="post">
        <div class="form-group">
            <div class="row">
                <div class="input-field col s6">
                    <label class="control-label">Nome</label> 
                    <input class="form-control erro-nome" type="text" name="nome"><br>
                </div>
                <div class="input-field col s6">
                    <label>Telefone celular</label> 
                    <input class="form-control erro-telefone" type="text" name="telefone" id="telefone"><br>
                </div>
            </div>
            <div class="row">
                <div class="input-field col s6">
                    <label>Data de Nascimento</label>                
                    <input class="form-control erro-dataNascimento" type="text" name="dataNascimento" id="nascimento"><br>
                </div>
                <div class="input-field col s6">
                    <label>CPF</label>
                    <input class="form-control erro-cpf" type="text" name="cpf" id="cpf"><br>
                </div>
            </div>
        </div>
        <div class="form-group col-md-offset-9 col-md-2"style="padding-right: 5px;">
            <input class="form-control btn btn-primary" type="submit" name="action" value="Cadastrar"><br>
        </div>
    </form>
</div>
<script src="js/jquery.maskedinput.min.js"></script>
<script src="js/jquery.validate.js"></script>
<script src="js/validar-cpf.js"></script>
<script src="js/validar-data-de-nascimento.js"></script>
<script src="js/inicializar-mascara.js"></script>
<script src="js/inicializar-validate.js" charset="UTF-8"></script>

<%@include file="rodape.jsp"%>
