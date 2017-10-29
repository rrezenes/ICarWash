
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
    <div class="col s3">
        <a class="waves-effect waves-light btn-floating btn-large green modal-trigger" href="#modal"><i class="material-icons">&#xE145;</i></a>
    </div>
    <div class="col s9">
        <input id="buscar" type="text" />
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
    <div class="modal-content">
        <div class="row">
            <p class="titulo-controle">Cadastrar Lavador</p>
            <div class="divider"></div>
        </div>
        <form id="CadastrarLavador" action="Controle" method="post">
            <div class="form-group">
                <input type="hidden" name="quem" value="lavador">
                <div class="row">
                    <label>Email:</label>
                    <input class="form-control erro-email" type="email" name="email" id="email"><br>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <label>Senha:</label> 
                        <input class="form-control erro-senha" type="password" name="senha" id="senha" ><br>
                    </div>
                    <div class="col-md-6">
                        <label for="confirme_senha">Confirme a Senha:</label> 
                        <input class="form-control erro-confirme" type="password" name="confirme" id="confirme" placeholder="Confirme aqui sua senha"><br>
                    </div>
                </div>
                <label>Nome:</label>
                <input class="form-control erro-nome" type="text" name="nome"><br>                        
                <div class="row">
                    <div class="col-md-6">
                        <label>Telefone celular:</label>
                        <input class="form-control erro-telefone" type="text" name="telefone" id="telefone"><br>
                    </div>
                    <div class="col-md-6">
                        <label>Data de Nascimento:</label>
                        <input class="form-control" type="text" name="nascimento" id="nascimento"><br>
                    </div>
                </div>
                <div class="row">
                    <label>CPF:</label>
                    <input class="form-control erro-cpf" type="text" name="cpf" id="cpf"><br>
                </div>
                <div class="row">
                    <label>CEP:</label>
                    <input class="form-control erro-cep" type="text" name="cep" id="cep"><br>
                </div>
                <div class="row">
                    <div class="col-md-4">
                        <label>Estado:</label>
                        <input class="form-control erro-estado" type="text" name="estado" id="estado"><br>
                    </div>
                    <div class="col-md-4">
                        <label>Cidade:</label>
                        <input class="form-control erro-cidade" type="text" name="cidade" id="cidade"><br>
                    </div>
                    <div class="col-md-4">
                        <label>Bairro:</label>
                        <input class="form-control erro-bairro" type="text" name="bairro" id="bairro"><br>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-8">
                        <label>Endereço:</label>
                        <input class="form-control erro-endereco" type="text" name="endereco" id="endereco"><br>
                    </div>
                    <div class="col-md-4">
                        <label>Número:</label>
                        <input class="form-control erro-numero" type="text" name="numero" id="numero"><br>
                    </div>
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

<script src="js/jquery.maskedinput.min.js"></script>
<script src="js/jquery.validate.js"></script>
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

    jQuery.validator.addMethod("cpf", function (value, element) {
        value = jQuery.trim(value);

        value = value.replace('.', '');
        value = value.replace('.', '');
        cpf = value.replace('-', '');
        while (cpf.length < 11)
            cpf = "0" + cpf;
        var expReg = /^0+$|^1+$|^2+$|^3+$|^4+$|^5+$|^6+$|^7+$|^8+$|^9+$/;
        var a = [];
        var b = new Number;
        var c = 11;
        for (i = 0; i < 11; i++) {
            a[i] = cpf.charAt(i);
            if (i < 9)
                b += (a[i] * --c);
        }
        if ((x = b % 11) < 2) {
            a[9] = 0
        } else {
            a[9] = 11 - x
        }
        b = 0;
        c = 11;
        for (y = 0; y < 10; y++)
            b += (a[y] * c--);
        if ((x = b % 11) < 2) {
            a[10] = 0;
        } else {
            a[10] = 11 - x;
        }

        var retorno = true;
        if ((cpf.charAt(9) != a[9]) || (cpf.charAt(10) != a[10]) || cpf.match(expReg))
            retorno = false;

        return this.optional(element) || retorno;

    }, "Informe um CPF válido");


    var msg_cep;
    $("#cep").change(function () {
        var cep_code = $(this).val();
        if (cep_code.length <= 0)
            return;
        $.get("http://apps.widenet.com.br/busca-cep/api/cep.json", {code: cep_code},
                function (result) {
                    if (result.status != 1) {
                        alert(result.message || "Houve um erro desconhecido");
                        return;
                    }
                    $("input#cep").val(result.code);
                    $("input#estado").val(result.state);
                    $("input#cidade").val(result.city);
                    $("input#bairro").val(result.district);
                    $("input#endereco").val(result.address);
                    $("input#estado").val(result.state);
                });
    });

    $(document).ready(function () {
        
        $('.modal').modal();
        $("#CadastrarLavador").validate({
            rules: {
                email: {
                    remote: 'CheckUsuarioEmail',
                    required: true,
                    email: true
                },
                senha: {
                    required: true,
                    minlength: 5
                },
                confirme: {
                    required: true,
                    minlength: 5,
                    equalTo: "#senha"
                },
                nome: {
                    required: true,
                    minlength: 3
                },
                telefone: {
                    required: true
                },
                data: {
                    required: true
                },
                cpf: {
                    remote: 'CheckCpfLavador',
                    cpf: true,
                    required: true
                },
                cep: {
                    required: true
                },
                estado: {
                    required: true,
                    minlength: 2,
                    maxlength: 2
                },
                cidade: {
                    required: true
                },
                bairro: {
                    required: true
                },
                endereco: {
                    required: true
                },
                numero: {
                    required: true
                }
            },
            messages: {
                email: {
                    remote: "Esse e-mail já está em uso, por favor utilize um e-mail válido e disponível.",
                    required: "Por favor, coloque um e-mail válido.",
                    email: "Por favor, coloque um e-mail válido"
                },
                senha: {
                    required: "Por favor, coloque sua senha.",
                    minlength: "Sua senha deve conter no mínimo 5 caracteres."
                },
                confirme: {
                    required: "Por favor, coloque sua senha novamente.",
                    minlength: "Sua senha deve conter no mínimo 5 caracteres",
                    equalTo: "Sua senha deve ser a mesma."
                },
                nome: {
                    required: "Por favor, digite seu nome aqui",
                    minlength: "Por favor, digite um nome de no mínimo 3 dígitos"
                },
                telefone: {
                    required: "Por favor, digite seu celular de contato aqui"
                },
                data: {
                    required: "Por favor, seleciona uma data de nascimento"
                },
                cpf: {
                    remote: "Cpf já está em uso",
                    cpf: 'CPF inválido',
                    required: "Por favor, digite seu CPF aqui."
                },
                cep: {
                    required: "Por favor, digite seu CEP aqui"
                },
                estado: {
                    required: "Por favor, digite corretamente as siglas de seu estado aqui.",
                    minlength: "Por favor, digite corretamente as siglas de seu estado aqui.",
                    maxlength: "Por favor, digite corretamente as siglas de seu estado aqui."
                },
                cidade: {
                    required: "Por favor, digite sua cidade aqui"
                },
                bairro: {
                    required: "Por favor, digite sua bairro aqui"
                },
                endereco: {
                    required: "Por favor, digite seu endereço aqui"
                },
                numero: {
                    required: "Por favor, digite seu número aqui"
                }
            },
            errorElement: "em",
            errorPlacement: function (error, element) {
                // Add the `help-block` class to the error element
                error.addClass("help-block");

                if (element.prop("name") === "email") {
                    error.insertAfter(".erro-email");
                } else if (element.prop("name") === "nome") {
                    error.insertAfter(".erro-nome");
                } else if (element.prop("name") === "senha") {
                    error.insertAfter(".erro-senha");
                } else if (element.prop("name") === "confirme") {
                    error.insertAfter(".erro-confirme");
                } else if (element.prop("name") === "cpf") {
                    error.insertAfter(".erro-cpf");
                } else if (element.prop("name") === "cep") {
                    error.insertAfter(".erro-cep");
                } else if (element.prop("name") === "telefone") {
                    error.insertAfter(".erro-telefone");
                } else if (element.prop("name") === "estado") {
                    error.insertAfter(".erro-estado");
                } else if (element.prop("name") === "cidade") {
                    error.insertAfter(".erro-cidade");
                } else if (element.prop("name") === "bairro") {
                    error.insertAfter(".erro-bairro");
                } else if (element.prop("name") === "endereco") {
                    error.insertAfter(".erro-endereco");
                } else if (element.prop("name") === "numero") {
                    error.insertAfter(".erro-numero");
                } else {
                    error.insertAfter(".erro-data");
                }

            }
        });
    });
    jQuery(function ($) {
        $("#nascimento").mask("99/99/9999");
        $("#telefone").mask("(99)99999-9999");
        $("#cpf").mask("999.999.999-99");
        $("#cep").mask("99999-999");

    });
</script>    

<%@include file="rodape.jsp"%>