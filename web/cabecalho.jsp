<%-- 
    Document   : cabecalho
    Created on : 21/11/2016, 08:26:50
    Author     : rezen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link href="css/navbar-fixed-side.css" rel="stylesheet" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery-3.1.1.js"></script>
        <script src="js/jquery.maskedinput.min.js"></script>
        <title>ICarWash</title>
    </head>
    <body>
    <body>
        <%
            if (session != null && request.getRequestedSessionId() != null) {
                if (Integer.parseInt(session.getAttribute("acesso").toString()) == 3) {
                    //String name = (String) session.getAttribute("user");
        %>
        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-3 col-lg-2">
                    <nav class="navbar navbar-default navbar-fixed-side">
                        <div class="container">
                            <div class="navbar-header">
                                <button class="navbar-toggle" data-target=".navbar-collapse" data-toggle="collapse">
                                </button>
                                <a class="navbar-brand" href="./">Gerencia ICarWash</a>
                            </div>
                            <div class="collapse navbar-collapse">
                                <ul class="nav navbar-nav">
                                    <li class="dropdown">
                                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Cadastros Gerais <b class="caret"></b></a>
                                        <ul class="dropdown-menu">
                                            <li><a href="Controle?action=Listar&listar=cliente">Clientes</a></li>
                                            <li><a href="Controle?action=Listar&listar=funcionario">Funcionarios</a></li>
                                        </ul>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </nav>
                </div>
                <div class="col-sm-9 col-lg-10 exibelista">
        <%
                } else if (Integer.parseInt(session.getAttribute("acesso").toString()) == 1) {%>
        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-3 col-lg-2">
                    <nav class="navbar navbar-default navbar-fixed-side">
                        <div class="container">
                            <div class="navbar-header">
                                <button class="navbar-toggle" data-target=".navbar-collapse" data-toggle="collapse">
                                </button>
                                <a class="navbar-brand" href="./">Cliente ICarWash</a>
                            </div>
                            <div class="collapse navbar-collapse">
                                <ul class="nav navbar-nav">
                                    <li class="dropdown">
                                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Cadastros Gerais <b class="caret"></b></a>
                                        <ul class="dropdown-menu">
                                            <li><a href="#">Fazer Pedido</a></li>
                                        </ul>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </nav>
                </div>
                <div class="col-sm-9 col-lg-10 exibelista">
                <%  } else {
                            response.sendRedirect("index.jsp");

                    }                
            }else{
                 response.sendRedirect("index.jsp");
            }
                    %>
