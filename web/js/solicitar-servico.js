
var diaSemana = ['Domingo', 'Segunda-Feira', 'Terca-Feira', 'Quarta-Feira', 'Quinta-Feira', 'Sexta-Feira', 'Sabado'];
var mesAno = ['Janeiro', 'Fevereiro', 'Marco', 'Abril', 'Maio', 'Junho', 'Julho', 'Agosto', 'Setembro', 'Outubro', 'Novembro', 'Dezembro'];
//var data = new Date();
//var hoje = data.getDay() + ', ' + mesAno[data.getMonth()] + ' de ' + data.getFullYear();

//$("#dataNascimento").attr("value", hoje);

var amanha = new Date();
amanha.setDate(amanha.getDate() + 1);
$(".datepicker").pickadate({
    monthsFull: mesAno,
    monthsShort: ['Jan', 'Fev', 'Mar', 'Abr', 'Mai', 'Jun', 'Jul', 'Ago', 'Set', 'Out', 'Nov', 'Dez'],
    weekdaysFull: diaSemana,
    weekdaysShort: ['Dom', 'Seg', 'Ter', 'Qua', 'Qui', 'Sex', 'Sab'],
    weekdaysLetter: ['D', 'S', 'T', 'Q', 'Q', 'S', 'S'],
    selectMonths: true,
    selectYears: false,
    clear: false,
    format: 'dd/mm/yyyy',
    today: "Hoje",
    close: "Fechar",
    min: amanha,
    max: +90,
    closeOnSelect: true,
    disable: [1, 7],
    onClose: function () {
        popularSelect();
    }
});

$("#dataNascimento").click(function (event) {
    event.stopPropagation();
    $(".datepicker").first().pickadate("picker").open();
});


function popularSelect() {
    $("#selectHora").empty();
    var checkData = {data: $('#data_solicitacao').val()};
    $.getJSON("CheckSolicitacaoData", checkData, function (dataVal) {
        $.each(dataVal, function (index, item) {
            $('#selectHora').append($('<option></option>').val(item).html(item));
        });
        $('#selectHora').material_select();
    });
}

$("#confirmar").click(function () {
    var servico = $('input[name=servico]').is(':checked');
    var porte = $('input[name=porte]').is(':checked');
    var data = $('#data_solicitacao').val() !== '';
    var hora = $('#selectHora').val() !== ' ';
    

    if (servico && porte && data && hora) {
        var form = document.solicitarServico;
        var dataString = $(form).serialize();
        // AJAX Code To Submit Form.
        $.ajax({
            type: "POST",
            url: "ControleSolicitacao",
            data: dataString,
            cache: false,
            success: function (result) {       
                window.location = result;                
            }
        });
    } else {
        Materialize.toast('Por favor preencha todos os campos.', 3000, 'rounded');
    }
    return false;
});