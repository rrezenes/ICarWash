
$(document).ready(function () {
    $("input#nome").get(0).setAttribute("maxlength", 50);
    $("input#email").get(0).setAttribute("maxlength", 50);
    $("input#senha").get(0).setAttribute("maxlength", 50);
    $("input#confirme").get(0).setAttribute("maxlength", 50);
    $("input#telefone").get(0).setAttribute("maxlength", 11);
    $("input#nascimento").get(0).setAttribute("maxlength", 8);
    $("input#cpf").get(0).setAttribute("maxlength", 11);
    $("input#cep").get(0).setAttribute("maxlength", 8);
    $("input#estado").get(0).setAttribute("maxlength", 2);
    $("input#cidade").get(0).setAttribute("maxlength", 50);
    $("input#bairro").get(0).setAttribute("maxlength", 50);
    $("input#endereco").get(0).setAttribute("maxlength", 50);
    $("input#numero").get(0).setAttribute("maxlength", 5);
    $("input#descricao").get(0).setAttribute("maxlength", 50);
    $("input#valor").get(0).setAttribute("maxlength", 6);
   
    $("#FormValidate").validate({
        rules: {
            nome: {
                maxlength: 50,
                required: true,
                minlength: 3,
                letterAndNumbersOnly: true
            },
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
            telefone: {
                required: true
            },
            dataNascimento: {
                required: true,
                regex: "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/[12][0-9]{3}$"
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
            },
            descricao: {
                required: true,
                maxlength: 50,
                minlength: 3,
                letterAndNumbersOnly: true
            },
            valor: {
                maxlength: 6,
                required: true,
                number: true
            }
        },
        messages: {
            nome: {
                maxlength: "Por favor, entre com o nome apenas!",
                required: "Por favor, digite o nome aqui!",
                minlength: "Por favor, digite um nome de no mínimo 3 dígitos!",
                letterAndNumbersOnly: "Por favor, utilize apenas letras e números!"
            },
            email: {
                remote: "E-mail já está em uso!",
                required: "Por favor, coloque um e-mail válido!",
                email: "Por favor, coloque um e-mail válido!"
            },
            senha: {
                required: "Por favor, coloque sua senha!",
                minlength: "Sua senha deve conter no mínimo 5 caracteres!"
            },
            confirme: {
                required: "Por favor, coloque sua senha novamente!",
                minlength: "Sua senha deve conter no mínimo 5 caracteres!",
                equalTo: "Sua senha deve ser a mesma!"
            },
            telefone: {
                required: "Por favor, digite seu telefone celular aqui!"
            },
            dataNascimento: {
                required: "Por favor, seleciona uma data de nascimento!",
                regex: "Data inválida!"
            },
            cpf: {
                remote: "Cpf já está em uso!",
                cpf: "CPF inválido!",
                required: "Por favor, digite seu CPF aqui!"
            },
            cep: {
                required: "Por favor, digite seu CEP aqui!"
            },
            estado: {
                required: "Por favor, digite corretamente as siglas de seu estado aqui!",
                minlength: "Por favor, digite corretamente as siglas de seu estado aqui!",
                maxlength: "Por favor, digite corretamente as siglas de seu estado aqui!"
            },
            cidade: {
                required: "Por favor, digite sua cidade aqui!"
            },
            bairro: {
                required: "Por favor, digite sua bairro aqui!"
            },
            endereco: {
                required: "Por favor, digite seu endereço aqui!"
            },
            numero: {
                required: "Por favor, digite seu número aqui!"
            },
            descricao: {
                required: "Campo obrigarório preencher!",
                maxlength: "Utilize no máximo 150 caracteres!",
                minlength: "Utilize no mínimo 3 caracteres!",
                letterAndNumbersOnly: "Por favor, utilize apenas letras e números!"
            },
            valor: {
                maxlength: "Utilize no máximo 6 caracteres!",
                required: "Campo obrigarório preencher!",
                number: "Apenas valores reais, utilize ponto para separar reais dos centavos!"
            },
            produtos: {
                required: "Campo obrigarório preencher!"
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
            } else if (element.prop("name") === "dataNascimento") {
                error.insertAfter(".erro-dataNascimento");
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
            } else if (element.prop("name") === "descricao") {
                error.insertAfter(".erro-descricao");
            } else if (element.prop("name") === "valor") {
                error.insertAfter(".erro-valor");
            } else if (element.prop("name") === "produtos") {
                error.insertAfter(".erro-produtos");
            } else {
                error.insertAfter(".erro-data");
            }
        }
    });
});
