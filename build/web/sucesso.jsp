<%-- 
    Document   : Sucesso
    Created on : 18/11/2016, 01:12:45
    Author     : rezen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="cabecalho.jsp"%>
        <script>
            setTimeout(function () {
                document.location = "index.jsp";
            }, 1200); // <-- delay
        </script>
        <div class="bg-success center-block alert-success">
            <h1>Cliente cadastrado com sucesso!</h1>
        </div>
<%@include file="rodape.jsp"%>
