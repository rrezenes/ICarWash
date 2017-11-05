function avaliar(pontualidade, servico, atendimento, agilidade, solicitacao) {
        var dataString = 'pontualidade=' + pontualidade + '&servico=' + servico + '&atendimento=' + atendimento + '&agilidade=' + agilidade + '&id_solicitacao=' + solicitacao;
        $.ajax({
            type: "POST",
            url: "AvaliarSolicitacao",
            data: dataString,
            cache: false,
            success: function (result) {
                location.reload();
            }
        });
    }
    
    $(document).ready(function () {
        let searchParams = new URLSearchParams(window.location.search);
        if (searchParams.has('ok')) {
            Materialize.toast('Solicitacao Efetuada', 6000, 'rounded');
        } else if (searchParams.has('x')) {
            Materialize.toast('Solicitacao Cancelada', 6000, 'rounded');
        }
    });