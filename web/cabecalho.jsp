<%-- 
    Document   : cabecalho
    Created on : 21/11/2016, 08:26:50
    Author     : rezen
--%>

<%@page import="br.icarwash.dao.ClienteDAO"%>
<%@page import="br.icarwash.model.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" href="img/favicon.ico" />
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/bootstrap-datetimepicker.min.css">
        <link rel="stylesheet" href="css/bootstrap-datetimepicker.css">
        <link href="css/navbar-fixed-side.css" rel="stylesheet" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery-3.1.1.js"></script>
        <script src="js/jquery.maskedinput.min.js"></script>
        <title>ICarWash</title>
    </head>
    <body>
        <%--Menu de Cliente--%>
        <%
            //allow access only if session exists
            Usuario usuario = (Usuario) session.getAttribute("user");
            ClienteDAO clienteDAO = new ClienteDAO();
            if (session != null && request.getRequestedSessionId() != null && session.getAttribute("acesso") != null) {
                if (Integer.parseInt(session.getAttribute("acesso").toString()) == 1) {
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
                                <a class="navbar-brand" href="./"><%=usuario.getUsuario()%>, ICarWash</a>
                            </div>
                            <div class="collapse navbar-collapse">
                                <ul class="nav navbar-nav">
                                    <li class="dropdown">
                                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Solicitações<b class="caret"></b></a>
                                        <ul class="dropdown-menu">
                                            <li><a href="SolicitarServico">Solicitar Serviço</a></li>
                                            <li><a href="ListarSolicitacaoCliente">Minhas Solicitações</a></li>
                                        </ul>
                                    </li>
                                    <li class="dropdown">
                                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Logout<b class="caret"></b></a>
                                        <ul class="dropdown-menu">
                                            <li><a href="logout">Sair</a></li>
                                        </ul>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </nav>
                </div>
        <%--Menu de Lavador--%>
                <div class="col-sm-9 col-lg-10 exibelista">
                    <% } else if (Integer.parseInt(session.getAttribute("acesso").toString()) == 2) {
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
                                            <a class="navbar-brand" href="./"><%=usuario.getUsuario()%>, ICarWash</a>
                                        </div>
                                        <div class="collapse navbar-collapse">
                                            <ul class="nav navbar-nav">
                                                <li class="dropdown">
                                                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">Solicitações<b class="caret"></b></a>
                                                    <ul class="dropdown-menu">
                                                        <li><a href="solicitacao_lavador.jsp">Minhas Solicitações</a></li>
                                                    </ul>
                                                </li>
                                                <li class="dropdown">
                                                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">Relatórios<b class="caret"></b></a>
                                                    <ul class="dropdown-menu">
                                                        <li><a href="listar_produtos_hoje.jsp">Produtos para hoje</a></li>
                                                    </ul>
                                                </li>
                                                <li class="dropdown">
                                                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">Logout<b class="caret"></b></a>
                                                    <ul class="dropdown-menu">
                                                        <li><a href="logout">Sair</a></li>
                                                    </ul>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                </nav>
                            </div>
        <%--Menu de Gerente--%>
                            <div class="col-sm-9 col-lg-10 exibelista">
                                <%
                                } else if (Integer.parseInt(session.getAttribute("acesso").toString()) == 3) {%>
                                <div class="container-fluid">
                                    <div class="row">
                                        <div class="col-sm-3 col-lg-2">
                                            <nav class="navbar navbar-default navbar-fixed-side">
                                                <div class="container">
                                                    <div class="navbar-header">
                                                        <button class="navbar-toggle" data-target=".navbar-collapse" data-toggle="collapse">
                                                        </button>
                                                        <a class="navbar-brand" href="painel_admin.jsp"><%=usuario.getUsuario()%>, ICarWash</a>
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
                                                                <a href="Controle?action=Listar&listar=solicitacao" class="dropdown-toggle" data-toggle="dropdown" href="#">Solicitações<b class="caret"></b></a>
                                                                <ul class="dropdown-menu">
                                                                    <li><a href="SolicitarServico">Solicitar Serviço</a></li>
                                                                    <li><a href="solicitacoes.jsp">Aprovar Solicitações</a></li>
                                                                    <li><a href="Controle?action=Listar&listar=solicitacao">Solicitações</a></li>
                                                                </ul>
                                                            </li>
                                                            <li class="dropdown">
                                                                <a class="dropdown-toggle" data-toggle="dropdown" href="#">Logout<b class="caret"></b></a>
                                                                <ul class="dropdown-menu">
                                                                    <li><a href="logout">Sair</a></li>
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
                                                } else {
                                                    response.sendRedirect("index.jsp");
                                                }
                                            %>
