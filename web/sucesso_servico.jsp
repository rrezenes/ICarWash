<%-- 
    Document   : sucesso_lavador
    Created on : 25/03/2017, 11:38:03
    Author     : rezen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="cabecalho.jsp"%>
        <script>
            setTimeout(function () {
                document.location = "Controle?action=Listar&listar=servico";
            }, 1200); // <-- delay
        </script>
        <div class="bg-success center-block alert-success">
            <h1>Serviço cadastrado com sucesso!</h1>
        </div>
<%@include file="rodape.jsp"%>
