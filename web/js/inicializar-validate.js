
$(document).ready(function () {
    $("#FormValidate").validate({
        rules: {
            nome: {
                    maxlength: 50,
                    required: true,
                    minlength: 3,
                    lettersonly: true
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
                required: true,
                maxlength: 11
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
            }
        },
        messages: {
            nome: {
                    maxlength: "Por favor, entre com seu nome apenas",
                    required: "Por favor, digite seu nome aqui!",
                    minlength: "Por favor, digite um nome de no mínimo 3 dígitos"
                },
            email: {
                remote: "E-mail já está em uso",
                required: "Por favor, coloque um e-mail válido!",
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
            telefone: {
                required: "Por favor, digite seu telefone celular aqui!",
                maxlength: "Por favor, digite seu telefone válido"
            },
            dataNascimento: {
                required: "Por favor, seleciona uma data de nascimento",
                regex: "Data inválida"
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
            } else {
                error.insertAfter(".erro-data");
            }
        }
    });
});