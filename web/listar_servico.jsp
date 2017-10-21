
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="cabecalho.jsp"%>

<div class="container">
    <div class="row">
        <h4>Controle de Serviços</h4>
        <div class="divider"></div>
    </div>
    <div class="row">
        <div class="col s3">
            <a class="waves-effect waves-light btn-floating btn-large green modal-trigger" href="#modal"><i class="material-icons">&#xE145;</i></a>
        </div>
        <div class="col s9">
            <input id="buscar" type="text" />
        </div>
    </div>
    <table id="clientes" class="table table-hover centered striped responsive-table">
        <thead>
            <tr>
                <th>Nome</th>
                <th>Descrição</th>
                <th colspan="2"></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="servico" items="${servicos}">
                <tr>
                    <td>                        
                        <c:choose>
                            <c:when test="${servico.ativo}">
                                <div type="button" class="glyphicon glyphicon-ok text-success"></div>
                            </c:when> 
                            <c:otherwise>
                                <div type="button" class="glyphicon glyphicon glyphicon-remove text-danger"></div>
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td>${servico.nome}</td>
                    <td>${servico.descricao}</td>
                    <td>${servico.valor}</td>
                    <td><a type="button" class="glyphicon glyphicon-pencil text-info" href="Controle?action=LocalizarPorId&q=servico&id=${servico.id}"></a></td>
                    <td>
                        <c:choose>
                            <c:when test="${servico.ativo}">
                                <a type="button" href="Controle?action=Excluir&q=servico&id=${servico.id}">Inativar</a>
                            </c:when>
                            <c:otherwise>
                                <a type="button" href="Controle?action=Ativar&q=servico&id=${servico.id}">Ativar</a>
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
            </c:forEach>   
        </tbody>
    </table>
</div>

<div id="modal" class="modal modal-fixed-footer modal-avaliar">
    <div class="modal-content">
        <div class="row">
            <h4>Cadastrar Serviço</h4>
            <div class="divider"></div>
        </div>
        <form id="formServico" action="Controle" method="post">
            <div class="form-group">
                <input type="hidden" name="quem" value="servico">
                <div class="row">
                    <div class="input-field col s12">
                        <label>Nome:</label> 
                        <input class="form-control erro-nome" type="text" name="nome"><br>
                    </div>
                    <div class="input-field col s12">
                        <label>Descrição:</label> 
                        <input class="form-control erro-descricao" type="text" name="descricao" id="descricao"><br>
                    </div>
                    <div class="input-field col s12">
                        <label>Valor:</label> 
                        <input class="form-control erro-valor" type="text" name="valor" id="valor"><br>
                    </div>
                    <jsp:useBean id="produtoDao" class="br.icarwash.dao.ProdutoDAO"/>
                    <div class="col s7"><b>Produtos:</b></div>
                    <div class="col s5"><b>Quantidade:</b></div>
                    <legend></legend>
                    <c:forEach var="produto" items="${produtoDao.listar()}">
                        <c:if test = "${produto.ativo}">
                            <div class="checkbox col s7">
                                <p>
                                    <input type="checkbox" id="check${produto.id}" value="${produto.id}" name="produtos" 
                                           onclick="
                                            if ($(this).is(':checked')) {
                                                $('#quantidade${produto.id}').prop('disabled', false);
                                            } else {
                                                $('#quantidade${produto.id}').prop('disabled', true);
                                                $('#quantidade${produto.id}').val(null)
                                            }"/>
                                    <label for="check${produto.id}">${produto.nome}</label>
                                </p>             
                            </div>
                            <div class="input-field col s5">
                                <input id="quantidade${produto.id}" type="number" class="validate" min="1" max="5" disabled>
                                <label for="quantidade${produto.id}">Quantidade</label>
                            </div> 
                        </c:if>
                    </c:forEach>
                </div>
            </div>
            <div class="form-group">
                <input class="form-control btn btn-primary" type="submit" name="action" value="Cadastrar"><br>
            </div>
        </form>
    </div>
    <div class="modal-footer">
        <a class="modal-action modal-close waves-effect waves-green btn-flat">Fechar</a>
    </div>
</div>

<script src="js/jquery.validate.js"></script>
<script type="text/javascript">
                                        function filterTable(event) {
                                            var filter = event.target.value.toUpperCase();
                                            var rows = document.querySelector("#clientes tbody").rows;

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

                                        $(document).ready(function () {
                                            $('.modal').modal();
                                            $("#formServico").validate({
                                                rules: {
                                                    nome: {
                                                        maxlength: 50,
                                                        required: true,
                                                        minlength: 3
                                                    },
                                                    descricao: {
                                                        maxlength: 50,
                                                        required: true,
                                                        minlength: 3
                                                    },
                                                    valor: {
                                                        maxlength: 6,
                                                        required: true,
                                                        number: true
                                                    }

                                                },
                                                messages: {
                                                    nome: {
                                                        maxlength: "Utilize no máximo 50 caracteres",
                                                        required: "Campo obrigarório preencher",
                                                        minlength: "Utilize no mínimo 3 caracteres"
                                                    },
                                                    descricao: {
                                                        maxlength: "Utilize no máximo 50 caracteres",
                                                        required: "Campo obrigarório preencher",
                                                        minlength: "Utilize no mínimo 3 caracteres"
                                                    },
                                                    valor: {
                                                        maxlength: "Utilize no máximo 6 caracteres",
                                                        required: "Campo obrigarório preencher",
                                                        number: "Apenas valores reais, utilize ponto para separar reais dos centavos"
                                                    }
                                                },
                                                errorElement: "em",
                                                errorPlacement: function (error, element) {
                                                    // Add the `help-block` class to the error element
                                                    //error.addClass("help-block");

                                                    // Add `has-feedback` class to the parent div.form-group
                                                    // in order to add icons to inputs
                                                    element.parents(".col-sm-5").addClass("has-feedback");

                                                    if (element.prop("nome") === "nome") {
                                                        error.insertAfter(".erro-nome");
                                                    } else if (element.prop("descricao") === "descricao") {
                                                        error.insertAfter(".erro-descricao");
                                                    } else if (element.prop("valor") === "valor") {
                                                        error.insertAfter(".erro-valor");
                                                    } else {
                                                        error.insertAfter(element);
                                                    }

                                                    // Add the span element, if doesn't exists, and apply the icon classes to it.
                                                    if (!element.next("span")[ 0 ]) {
                                                        $("<span class='glyphicon form-control-feedback'></span>").insertAfter(element);
                                                    }
                                                },
                                                success: function (label, element) {
                                                    // Add the span element, if doesn't exists, and apply the icon classes to it.
                                                    if (!$(element).next("span")[ 0 ]) {
                                                        $("<span class='glyphicon form-control-feedback'></span>").insertAfter($(element));
                                                    }
                                                },
                                                highlight: function (element, errorClass, validClass) {
                                                    $(element).parents(".col-sm-5").addClass("has-error").removeClass("has-success");
                                                    //$(element).next("span").addClass("glyphicon-remove").removeClass("glyphicon-ok");
                                                },
                                                unhighlight: function (element, errorClass, validClass) {
                                                    $(element).parents(".col-sm-5").addClass("has-success").removeClass("has-error");
                                                    //$(element).next("span").addClass("glyphicon-ok").removeClass("glyphicon-remove");
                                                }
                                            });
                                        });
</script>

<%@include file="rodape.jsp"%>