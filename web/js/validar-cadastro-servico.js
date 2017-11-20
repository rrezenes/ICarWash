$("#confirmar").click(function () {
    var produto = $('input[name=produtos]').is(':checked');
    
    if (produto) {
        var form = document.listarServico;
        var dataString = $(form).serialize();
        // AJAX Code To Submit Form.
        $.ajax({
            type: "POST",
            url: "Controle",
            data: dataString,
            cache: false,
            success: function (result) {       
                window.location = "Controle?action=ListaCommand&listar=servico&ok";
            }
        });
    } else {
        Materialize.toast('Por favor preencha todos os campos.', 3000, 'rounded');
    }
    return false;
});