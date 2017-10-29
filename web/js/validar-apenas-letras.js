jQuery.validator.addMethod("lettersonly", function (value, element) {
        return this.optional(element) || /^[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ ]+$/i.test(value);
    }, "Por favor, utilize apenas letras");