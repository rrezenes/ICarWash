<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="cabecalho.jsp"%>

<div class="container">
    <div class="row">
        <div class="jumbotron">
            <h1>Alterar Cliente</h1>
        </div>
        <form id="FormValidate" action="Controle" method="post">
            <div class="form-group">
                <input type="hidden" name="quem" value="cliente"/>
                <input type="hidden" name="txtId" value="${cliente.id}"/>
                <div class="input-field col s6">
                    <label>Nome</label> 
                    <input class="form-control erro-nome" type="text" name="nome" value="${cliente.nome}"><br>
                </div>
                <div class="input-field col s6">
                    <label>Telefone celular</label> 
                    <input class="form-control erro-telefone" type="text" name="telefone" id="telefone" value="${cliente.telefone}"><br>
                </div>
                <div class="input-field col s6">
                    <%--Formatar a data antes de exibir na tela--%>
                    <fmt:formatDate value="${cliente.dtNascimento.time}" var="dataNascimento" type="date" pattern="dd/MM/yyyy" />            
                    <label>Data de Nascimento</label> 
                    <input class="form-control erro-dataNascimento" type="text" name="dataNascimento" id="nascimento" value="${dataNascimento}"><br>
                </div>
                <div class="input-field col s6">
                    <label>CEP</label> 
                    <input class="form-control erro-cep" type="text" id="cep" name="cep" value="${cliente.endereco.CEP}"><br>
                </div>
                <div class="input-field col s6">
                    <label>Estado</label> 
                    <input class="form-control erro-estado" type="text" id="estado" name="estado" value="${cliente.endereco.estado}"><br>
                </div>
                <div class="input-field col s6">
                    <label>Cidade</label> 
                    <input class="form-control erro-cidade" type="text" id="cidade" name="cidade" value="${cliente.endereco.cidade}"><br>
                </div>
                <div class="input-field col s6">
                    <label>Bairro</label> 
                    <input class="form-control erro-bairro" type="text" id="bairro" name="bairro" value="${cliente.endereco.bairro}"><br>
                </div>
                <div class="input-field col s6">
                    <label>Endereço</label> 
                    <input class="form-control erro-endereco" type="text" id="endereco" name="endereco" value="${cliente.endereco.endereco}"><br>
                </div>
                <div class="input-field col s6">
                    <label>Número</label> 
                    <input class="form-control erro-numero" type="text" name="numero" value="${cliente.endereco.numero}"><br>
                </div>
                <div class="col s12">
                    <input class="form-control btn btn-primary" type="submit" name="action" value="Atualizar"><br>
                </div>
            </div>
        </form>
    </div>
</div>

                
<script src="js/jquery.validate.js"></script>
<script src="js/validar-cep.js"></script>
<script src="js/jquery.maskedinput.min.js"></script>
<script src="js/validar-data-de-nascimento.js"></script>
<script src="js/inicializar-mascara.js"></script>
<script src="js/validar-apenas-letras.js"></script>
<script src="js/validar-apenas-letras-numeros.js"></script>
<script src="js/inicializar-validate.js"></script>

<%@include file="rodape.jsp"%>
