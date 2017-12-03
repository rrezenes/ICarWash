<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="cabecalho.jsp"%>

<c:if test="${!empty alterado}">
    <script>Materialize.toast('Alterado com Sucesso', 6000, 'rounded');</script>        
</c:if>
<c:if test="${!empty senhaInvalida}">
    <script>Materialize.toast('Senha atual invalida', 6000, 'rounded');</script>        
</c:if>
<div class="row">
    <p class="titulo-controle">Alterar Cliente</p>
    <div class="divider"></div>
</div>

<div class="row">
    <form id="FormValidate" action="Controle" method="post">
        <div class="form-group">
            <input type="hidden" name="action" value="AtualizaCommand"/>
            <input type="hidden" name="quem" value="cliente"/>
            <input type="hidden" name="id" value="${cliente.id}"/>
            <div class="input-field col m6 s12">
                <label>Nome</label> 
                <input class="form-control erro-nome" type="text" name="nome" id="nome" value="${cliente.nome}"><br>           
            </div>
            <div class="input-field col m3 s6">
                <label>Telefone celular</label> 
                <input class="form-control erro-telefone" type="text" name="telefone" id="telefone" value="${cliente.telefone}"><br>
            </div>
            <div class="input-field col m3 s6">
                <%--Formatar a data antes de exibir na tela--%>
                <fmt:formatDate value="${cliente.dataNascimento.time}" var="dataNascimento" type="date" pattern="dd/MM/yyyy" />            
                <label>Data de Nascimento</label> 
                <input class="form-control erro-dataNascimento" type="text" name="dataNascimento" id="nascimento" value="${dataNascimento}"><br>
            </div>
        </div>
        <div class="col s6 m3">
            <input class="form-control btn btn-primary" type="submit" value="Atualizar">
        </div>
        <div class="col s6 m3">
            <a class="waves-effect waves-light btn green modal-trigger" href="#modal-senha">Senha</a>
        </div>
    </form>
</div>
<div class="row">
    <c:forEach var="endereco" items="${enderecos}">
        <div class="col s6">
            <div class="card blue-grey">
                <div class="card_excluir">
                    <form action="ExcluirEndereco" method="post">
                        <input type="hidden" name="idEndereco" value="${endereco.id}"/>
                        <button class="btn-flat card_button_excluir" type="submit" name="action" style="color: #ffc883">
                            <i class="material-icons right">close</i>
                        </button>
                    </form>
                </div>
                <div class="card-content white-text">
                    <span class="card-title">${endereco.nome}</span>
                    <p>${endereco.endereco}, ${endereco.numero} - ${endereco.bairro}</p>
                    <p>${endereco.cidade} - ${endereco.estado}</p>
                    <p>CEP: ${endereco.CEP}</p>
                </div>
                <div class="card-action">
                    <a class="modal-trigger" href="#modal${endereco.id}">Alterar</a>
                </div>
            </div>
        </div>

        <!-- Modal Alterar Endereço -->
        <div id="modal${endereco.id}" class="modal modal-fixed-footer">
            <form id="FormValidate" action="AlterarEndereco" method="post">
                <div class="modal-content">
                    <h4>Alterar Endereço</h4>
                    <div class="form-group">
                        <input type="hidden" name="id" value="${cliente.id}"/>
                        <input type="hidden" name="idEndereco" value="${endereco.id}"/>
                        <div class="input-field col s12">
                            <label>Nome</label> 
                            <input class="form-control erro-nomeEndereco" type="text" id="nomeEndereco" name="nomeEndereco" value="${endereco.nome}"><br>
                        </div>
                        <div class="input-field col s6">
                            <label>CEP</label> 
                            <input class="form-control erro-cep" type="text" id="cep${endereco.id}" name="cep" value="${endereco.CEP}"><br>
                        </div>
                        <div class="input-field col s6">
                            <label>Estado</label> 
                            <input class="form-control erro-estado" type="text" id="estado" name="estado" value="${endereco.estado}"><br>
                        </div>
                        <div class="input-field col s6">
                            <label>Cidade</label> 
                            <input class="form-control erro-cidade" type="text" id="cidade" name="cidade" value="${endereco.cidade}"><br>
                        </div>
                        <div class="input-field col s6">
                            <label>Bairro</label> 
                            <input class="form-control erro-bairro" type="text" id="bairro" name="bairro" value="${endereco.bairro}"><br>
                        </div>
                        <div class="input-field col s6">
                            <label>Endereço</label> 
                            <input class="form-control erro-endereco" type="text" id="endereco" name="endereco"  value="${endereco.endereco}"><br>
                        </div>
                        <div class="input-field col s6">
                            <label>Número</label> 
                            <input class="form-control erro-numero" type="text" name="numero" id="numero" value="${endereco.numero}"><br>
                        </div>
                        <div class="col s12">
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <a class="modal-action modal-close waves-effect waves-green btn-flat ">Fechar</a>
                    <input class="form-control btn btn-primary" type="submit">
                </div>
            </form>
        </div>
    </c:forEach>


    <!-- Modal Cadastrar Endereço -->
    <div id="modal-adicionar-endereco" class="modal modal-fixed-footer">
        <form id="FormValidate" action="AdicionarEndereco" method="post">
            <input type="hidden" name="quem" value="cliente"/>
            <input type="hidden" name="id" value="${cliente.id}"/>
            <div class="modal-content">
                <h4>Cadastrar novo Endereço</h4>
                <div class="form-group">
                    <div class="input-field col s12">
                        <label>Nome</label> 
                        <input class="form-control erro-nomeEndereco" type="text" id="nomeEndereco" name="nomeEndereco"><br>
                    </div>
                    <div class="input-field col s6">
                        <label>CEP</label> 
                        <input class="form-control erro-cep" type="text" id="cep" name="cep"><br>
                    </div>
                    <div class="input-field col s6">
                        <label>Estado</label> 
                        <input class="form-control erro-estado" type="text" id="estado" name="estado"><br>
                    </div>
                    <div class="input-field col s6">
                        <label>Cidade</label> 
                        <input class="form-control erro-cidade" type="text" id="cidade" name="cidade"><br>
                    </div>
                    <div class="input-field col s6">
                        <label>Bairro</label> 
                        <input class="form-control erro-bairro" type="text" id="bairro" name="bairro"><br>
                    </div>
                    <div class="input-field col s6">
                        <label>Endereço</label> 
                        <input class="form-control erro-endereco" type="text" id="endereco" name="endereco"><br>
                    </div>
                    <div class="input-field col s6">
                        <label>Número</label> 
                        <input class="form-control erro-numero" type="text" name="numero" id="numero"><br>
                    </div>
                    <div class="col s12">
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <a class="modal-action modal-close waves-effect waves-green btn-flat ">Fechar</a>
                <input class="form-control btn btn-primary" type="submit">
            </div>
        </form>
    </div>


    <!-- Modal Alterar Senha -->
    <div id="modal-senha" class="modal modal-fixed-footer">
        <form id="FormValidate" action="usuario" method="post">
            <div class="modal-content">
                <h4>Alterar Senha</h4>
                <div class="form-group">
                    <div class='input-field col m3 s6'>
                        <input class='form-control erro-senha' type='password' name='senha' id="senha" />
                        <label for='password'>Senha atual</label>
                    </div>
                    <div class='input-field col m3 s6'>
                        <input type="password" class="form-control erro-senha" id="nova_senha" name="nova_senha" />
                        <label for='password'>Nova senha</label>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <a class="modal-action modal-close waves-effect waves-green btn-flat ">Fechar</a>
                <input class="form-control btn btn-primary" type="submit">
            </div>
        </form>
    </div>

    <div class="fixed-action-btn">
        <a class=" modal-trigger btn-floating btn-large waves-effect waves-light red" href="#modal-adicionar-endereco"><i class="material-icons">add</i></a>
    </div>
</div>

<script src="js/jquery.validate.js"></script>
<script src="js/validar-cep.js"></script>
<script src="js/jquery.maskedinput.min.js"></script>
<script src="js/inicializar-mascara.js"></script>
<script src="js/validar-data-de-nascimento.js"></script>
<script src="js/validar-apenas-letras.js"></script>
<script src="js/validar-apenas-letras-numeros.js"></script>
<script src="js/inicializar-validate.js"></script>
<script src="js/inicializar-modal.js"></script>
<script>
    <c:forEach var="endereco" items="${enderecos}">
        $("#cep${endereco.id}").mask("99999-999");

        $("#cep${endereco.id}").change(function () {
            buscaCep(this);
        });
    </c:forEach>
</script>
<%@include file="rodape.jsp"%>
