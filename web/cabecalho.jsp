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

        <%
//allow access only if session exists
            String user = (String) session.getAttribute("usuario");
            String nomeDeUsuario = null;
            String sessionID = null;
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("usuario")) {
                        nomeDeUsuario = cookie.getValue();
                    }
                    if (cookie.getName().equals("JSESSIONID")) {
                        sessionID = cookie.getValue();
                    }
                }
            }
        %>


        <!--    <body>-->
        <%--  <%
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
                                            <li><a href="Controle?action=Listar&listar=lavador">Lavadores</a></li>
                                        </ul>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </nav>
                </div>
                <div class="col-sm-9 col-lg-10 exibelista">
        <%
                } else if (Integer.parseInt(session.getAttribute("acesso").toString()) == 1) {%>--%>
        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-3 col-lg-2">
                    <nav class="navbar navbar-default navbar-fixed-side">
                        <div class="container">
                            <div class="navbar-header">
                                <button class="navbar-toggle" data-target=".navbar-collapse" data-toggle="collapse">
                                </button>
                                <a class="navbar-brand" href="painel_admin.jsp"><%=user%>, ICarWash</a>
                            </div>
                            <div class="collapse navbar-collapse">
                                <ul class="nav navbar-nav">
                                    <li class="dropdown">
                                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Cadastros Pessoais<b class="caret"></b></a>
                                        <ul class="dropdown-menu">
                                            <li><a href="Controle?action=Listar&listar=cliente">Clientes</a></li>
                                            <li><a href="Controle?action=Listar&listar=lavador">Lavadores</a></li>
                                        </ul>
                                    <li class="dropdown">
                                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Cadastros Gerais<b class="caret"></b></a>
                                        <ul class="dropdown-menu">
                                            <li><a href="Controle?action=Listar&listar=produto">Produtos</a></li>
                                            <li><a href="Controle?action=Listar&listar=servico">Serviços</a></li>
                                        </ul>
                                    </li>
                                    <li class="dropdown">
                                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Solicitações<b class="caret"></b></a>
                                        <ul class="dropdown-menu">
                                            <li><a href="solicitar_servico.jsp">Solicitar Serviço</a></li>
                                            <li><a href="minha_solicitacao.jsp">Minhas Solicitações</a></li>
                                        </ul>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </nav>
                </div>
                <div class="col-sm-9 col-lg-10 exibelista">
                    <%--<%  } else {
                                response.sendRedirect("index.jsp");

                    }                
            }else{
                 response.sendRedirect("index.jsp");
            }
                    %>--%>
