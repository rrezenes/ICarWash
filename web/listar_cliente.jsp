
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="cabecalho.jsp"%>

<c:if test="${!empty cadastrado}">
    <script>Materialize.toast('Cliente Cadastrado', 6000, 'rounded');</script>        
</c:if>

<div class="row">
    <p class="titulo-controle">Controle de Clientes</p>
    <div class="divider"></div>
</div>
<div class="row">
    <div class="col s6">
        <a class="waves-effect waves-light btn green modal-trigger" href="#modal">Cadastrar</a>
    </div>
    <div class="input-field col s6">
        <input class="validate" id="buscar" type="text" name="buscar" />
        <label for='email'>Buscar</label>
    </div>
</div>
<table id="tabela" class="table table-hover centered striped responsive-table">
    <thead>
        <tr>
            <th>Email</th>
            <th>Nome</th>
            <th>Telefone</th>
            <th>CPF</th>
            <th colspan=2></th>
        </tr>
    </thead>
    <tbody>  
        <c:forEach var="cliente" items="${clientes}">
            <c:if test="${cliente.usuario.ativo}">                
                <fmt:formatDate value="${cliente.dataNascimento.time}" var="dataNascimento" type="date" pattern="dd/MM/yyyy" />
                <tr>
                    <td>${cliente.usuario.email}</td>
                    <td>${cliente.nome}</td>
                    <td>${cliente.telefone}</td>
                    <td>${cliente.CPF}</td>
                    <td>
                        <a class="btn-floating blue" href="Controle?action=LocalizaPorIdCommand&q=cliente&id=${cliente.id}"><i class="material-icons">mode_edit</i></a>
                        <a class="btn-floating red"  href="Controle?action=DesativaCommand&q=cliente&id=${cliente.usuario.id}"><i class="material-icons">delete_forever</i></a>
                    </td>
                </tr>
            </c:if>
        </c:forEach>
    </tbody>
</table>

<div id="modal" class="modal modal-fixed-footer">
    <form id="FormValidate" action="Controle" method="post">
        <div class="modal-content">
            <div class="row">
                <p class="titulo-controle">Cadastrar Cliente</p>
                <div class="divider"></div>
            </div>
            <div class="form-group">
                <input type="hidden" name="action" value="CadastroCommand"/>
                <input type="hidden" name="quem" value="cliente">
                <div class="row">
                    <div class="input-field col s6">
                        <label>Email</label>
                        <input class="form-control erro-email" type="text" name="email" id="email"><br>
                    </div>
                </div>    
                <div class="row">
                    <div class="input-field col s6">
                        <label>Senha</label> 
                        <input class="form-control erro-senha" type="password" name="senha" id="senha" ><br>
                    </div>
                    <div class="input-field col s6">
                        <label for="confirme_senha">Confirme a Senha</label> 
                        <input class="form-control erro-confirme" type="password" name="confirme" id="confirme" ><br>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s6">
                        <label>Nome</label> 
                        <input class="form-control erro-nome" type="text" name="nome" id="nome"><br>
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
                <div class="row">
                    <div class="input-field col s6">
                        <label>CEP</label> 
                        <input class="form-control erro-cep" type="text" name="cep" id="cep"><br>
                    </div>
                    <div class="input-field col s6">
                        <label>Estado</label> 
                        <input class="form-control erro-estado" type="text" name="estado" id="estado"><br>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s6">
                        <label>Cidade</label> 
                        <input class="form-control erro-cidade" type="text" name="cidade" id="cidade"><br>
                    </div>
                    <div class="input-field col s6">
                        <label>Bairro</label> 
                        <input class="form-control erro-bairro" type="text" name="bairro" id="bairro"><br>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field col s6">
                        <label>Endere�o</label> 
                        <input class="form-control erro-endereco" type="text" name="endereco" id="endereco"><br>
                    </div>
                    <div class="input-field col s6">
                        <label>N�mero</label> 
                        <input class="form-control erro-numero" type="text" name="numero" id="numero"><br>
                    </div>
                </div>   
                <div class="row">
                    <div class="input-field col s6">
                        <label>Nome Endere�o</label> 
                        <input class="form-control erro-nomeEndereco" type="text" name="nomeEndereco" id="nomeEndereco"><br>
                    </div>
                </div>   
            </div>
        </div>
        <div class="modal-footer">
            <input class="form-control btn btn-primary" type="submit" value="Cadastrar">
            <a class="modal-action modal-close waves-effect waves-green btn-flat">Fechar</a>
        </div>
    </form>
</div>

<script src="js/jquery.maskedinput.min.js"></script>
<script src="js/jquery.validate.js"></script>
<script src="js/validar-data-de-nascimento.js"></script>
<script src="js/validar-cpf.js"></script>
<script src="js/validar-apenas-letras.js"></script>
<script src="js/validar-cep.js"></script>
<script src="js/inicializar-modal.js"></script>
<script src="js/inicializar-mascara.js"></script>
<script src="js/inicializar-validate.js"></script>
<script src="js/buscar-na-tabela-3.js"></script>    

<%@include file="rodape.jsp"%>