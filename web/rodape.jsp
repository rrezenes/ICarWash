<%-- 
    Document   : rodape
    Created on : 21/11/2016, 08:26:39
    Author     : rezen
--%>
</div>
</div>
</div>
</div>
</body>
<footer>

    <script type="text/javascript" src="js/moment.min.js"></script>
    <script type="text/javascript" src="js/bootstrap-datetimepicker.js"></script>
    <script type="text/javascript" src="js/locales/bootstrap-datetimepicker.pt-BR.js"></script>
    <script type="text/javascript">
        $(function () {
            $('.form_datetime').datetimepicker({
                language: 'pt-BR',
                autoclose: 1,
                todayHighlight: 1,
                startView: 2,
                showMeridian: 1,
                daysOfWeekDisabled: [0],
                disabledHours: [0, 1, 2, 3, 4, 5, 6, 7, 8, 19, 20, 21, 22, 23, 24]
            });
        });


    </script>

    <script type="text/javascript">
        jQuery(function ($) {
            $("#nascimento").mask("99/99/9999");
            $("#telefone").mask("(99)99999-9999");
            $("#cpf").mask("999.999.999-99");
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
        });
    </script>
    <br>
    <br>
</footer>
</html>
