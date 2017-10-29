$.validator.addMethod("letterAndNumbersOnly", function(value, element) {
        return this.optional(element) || /^[-A-Za-z0-9áàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ ]+$/i.test(value);
    }, "Por favor, utilize apenas letras e números");