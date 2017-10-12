
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="cabecalho.jsp"%>


<div class="container">
    <div class="jumbotron">
        <h2>Controle de Clientes</h2>
    </div>

    <button type="button" class="btn btn-info" data-toggle="modal" data-target="#myModal">Adicionar Cliente</button>

    <table class="table table-hover">
        <thead>
            <tr>
                <th>Email</th>
                <th>Nome</th>
                <th>Telefone</th>
                <th>Data Nascimento</th>
                <th>CPF</th>
                <th>CEP</th>
                <th>Estado</th>
                <th>Cidade</th>
                <th>Bairro</th>
                <th>Endereço</th>
                <th colspan=2></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="cliente" items="${clientes}" varStatus="posicao">
                <fmt:formatDate value="${cliente.dtNascimento.time}" var="dataNascimento" type="date" pattern="dd/MM/yyyy" />
                <tr>
                    <td>${usuarios.get(posicao.index).email}</td>
                    <td>${cliente.nome}</td>
                    <td>${cliente.telefone}</td>
                    <td>${dataNascimento}</td>
                    <td>${cliente.CPF}</td>
                    <td>${cliente.endereco.CEP}</td>
                    <td>${cliente.endereco.estado}</td>
                    <td>${cliente.endereco.cidade}</td>
                    <td>${cliente.endereco.bairro}</td>
                    <td>${cliente.endereco.endereco} nº${cliente.endereco.numero}</td>
                    <td><a type="button" class="glyphicon glyphicon-pencil text-info" href="Controle?action=LocalizarPorId&q=cliente&id=${cliente.id}"></a></td>
                    <td><a type="button" class="glyphicon glyphicon-remove text-danger"  href="Controle?action=Excluir&q=cliente&id=${cliente.idUsuario}"></a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

<div id="myModal" class="modal fade" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Cadastrar Cliente</h4>
            </div>
            <div class="modal-body">
                <form id="CadastrarCliente" action="Controle" method="post">
                    <div class="form-group">
                        <input type="hidden" name="quem" value="cliente">
                        <div class="row">
                            <div class="col-md-6">
                                <label>Email:</label>
                                <input class="form-control erro-email" type="text" name="email" id="email"><br>
                            </div>
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
                        <div class="row">
                            <div class="col-md-6">
                                <label>Nome:</label> 
                                <input class="form-control erro-nome" type="text" name="nome"><br>
                            </div>
                            <div class="col-md-6">
                                <label>Telefone:</label> 
                                <input class="form-control erro-telefone" type="text" name="telefone" id="telefone"><br>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <label>Data de Nascimento:</label> 
                                <input class="form-control erro-nascimento" type="text" name="nascimento" id="nascimento"><br>
                            </div>
                            <div class="col-md-6">
                                <label>CPF:</label> 
                                <input class="form-control erro-cpf" type="text" name="cpf" id="cpf"><br>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <label>CEP:</label> 
                                <input class="form-control erro-cep" type="text" name="cep" id="cep"><br>
                            </div>
                            <div class="col-md-6">
                                <label>Estado:</label> 
                                <input class="form-control erro-estado" type="text" name="estado" id="estado"><br>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <label>Cidade:</label> 
                                <input class="form-control erro-cidade" type="text" name="cidade" id="cidade"><br>
                            </div>
                            <div class="col-md-6">
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
                <button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
            </div>
        </div>
    </div>
</div>

<script src="js/jquery.validate.js"></script>
<script type="text/javascript">

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
        $("#CadastrarCliente").validate({
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
                    remote: 'CheckCpfCliente',
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
                    remote: "E-mail já está em uso",
                    required: "Por favor, coloque um e-mail válido.",
                    email: "Por favor, coloque um e-mail válido."
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
                    cpf: "CPF inválido",
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
</script>    

<%@include file="rodape.jsp"%>