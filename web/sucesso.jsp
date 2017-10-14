<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="cabecalho.jsp"%>
        <script>
            setTimeout(function () {
                document.location = "Controle?action=Listar&listar=cliente";
            }, 1200); // <-- delay
        </script>
        <div class="bg-success center-block alert-success">
            <h1>Cliente cadastrado com sucesso!</h1>
        </div>
<%@include file="rodape.jsp"%>
