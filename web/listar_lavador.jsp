
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="cabecalho.jsp"%>

<c:if test="${!empty cadastrado}">
    <script>Materialize.toast('Produto Cadastrado', 6000, 'rounded');</script>        
</c:if>

<div class="row">
    <h4 class="titulo-controle">Controle de Lavadores</h4>
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
<table id="lavadores" class="table table-hover centered striped responsive-table">
    <thead>
        <tr>
            <th>Email</th>
            <th>Nome</th>
            <th>Telefone</th>
            <th>CPF</th>
            <th>Cidade</th>
            <th>Bairro</th>
            <th colspan="2"></th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="lavador" items="${lavadores}" varStatus="posicao">
            <fmt:formatDate value="${lavador.dtNascimento.time}" var="dataNascimento" type="date" pattern="dd/MM/yyyy"/>   
            <fmt:formatDate value="${lavador.dataContrato.time}" var="dataContrato" type="date" pattern="dd/MM/yyyy"/>   
            <tr>
                <td>${usuarios.get(posicao.index).email}</td>
                <td>${lavador.nome}</td>
                <td>${lavador.telefone}</td>
                <td>${lavador.CPF}</td>
                <td>${lavador.endereco.cidade}</td>
                <td>${lavador.endereco.bairro}</td>
                <td>
                    <a class="btn-floating blue" href="Controle?action=LocalizarPorId&q=lavador&id=${lavador.id}"><i class="material-icons">mode_edit</i></a>
                    <a class="btn-floating red" href="Controle?action=Excluir&q=lavador&id=${lavador.idUsuario}"><i class="material-icons">delete_forever</i></a>
                </td>
            </tr>
        </c:forEach>        
    </tbody>
</table>


<div id="modal" class="modal modal-fixed-footer">
    <form id="FormValidate" action="Controle" method="post">
        <div class="modal-content">
            <div class="row">
                <p class="titulo-controle">Cadastrar Lavador</p>
                <div class="divider"></div>
            </div>
            <div class="form-group">
                <input type="hidden" name="quem" value="lavador">
                <div class="row">
                    <div class="input-field col s6">
                        <label>Email</label>
                        <input class="form-control erro-email" type="email" name="email" id="email"><br>
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
                        <label>Nome:</label>
                        <input class="erro-nome" type="text" name="nome"><br>
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
        </div> 
        <div class="modal-footer">
            <input class="form-control btn btn-primary" type="submit" name="action" value="Cadastrar">
            <a class="modal-action modal-close waves-effect waves-green btn-flat">Fechar</a>
        </div>
    </form>
</div>

<script src="js/jquery.maskedinput.min.js"></script>
<script src="js/jquery.validate.js"></script>
<script src="js/validar-data-de-nascimento.js"></script>
<script src="js/validar-cpf.js"></script>
<script src="js/validar-cep.js"></script>
<script src="js/inicializar-modal.js"></script>
<script src="js/inicializar-mascara.js"></script>
<script src="js/inicializar-validate.js"></script>
<script type="text/javascript">
        function filterTable(event) {
            var filter = event.target.value.toUpperCase();
            var rows = document.querySelector("#lavadores tbody").rows;

            for (var i = 0; i < rows.length; i++) {

                var email = rows[i].cells[0].textContent.toUpperCase();
                var nome = rows[i].cells[1].textContent.toUpperCase();
                var telefone = rows[i].cells[2].textContent.toUpperCase();
                var cpf = rows[i].cells[3].textContent.toUpperCase();
                var cep = rows[i].cells[4].textContent.toUpperCase();
                var cidade = rows[i].cells[5].textContent.toUpperCase();
                var bairro = rows[i].cells[6].textContent.toUpperCase();

                if (email.indexOf(filter) > -1 || nome.indexOf(filter) > -1 || telefone.indexOf(filter) > -1 || cpf.indexOf(filter) > -1 || cep.indexOf(filter) > -1 || cidade.indexOf(filter) > -1 || bairro.indexOf(filter) > -1) {
                    rows[i].style.display = "";
                } else {
                    rows[i].style.display = "none";
                }
            }
        }

        document.querySelector('#buscar').addEventListener('keyup', filterTable, false);



</script>    

<%@include file="rodape.jsp"%>