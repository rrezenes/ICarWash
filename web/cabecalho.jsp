<%@page import="br.icarwash.model.Usuario"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <link rel="shortcut icon" href="img/favicon.ico" />
        <!--Import Google Icon Font-->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        
        <!--Import materialize.css-->
        <link type="text/css" rel="stylesheet" href="css/materialize.css"  media="screen,projection"/>
        <link type="text/css" rel="stylesheet" href="css/estilo.css"/>

        <script type="text/javascript" src="js/jquery-3.1.1.js"></script>
        <script type="text/javascript" src="js/materialize.js"></script>

        <!--Let browser know website is optimized for mobile-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    </head>
    <%  if (session != null && request.getRequestedSessionId() != null && session.getAttribute("user") != null) {
            Usuario usuario = (Usuario) session.getAttribute("user");%>
    <body>
        <nav>
            <div class="nav-wrapper light-blue darken-4">

                <a href="#!" class="center brand-logo">ICarWash</a>
                <a href="#" data-activates="mobile-demo" class="button-collapse"><i class="material-icons">menu</i></a>
                <ul class="side-nav fixed" id="mobile-demo">
                    <li><div class="user-view">
                            <div class="background">
                                <img class="responsive-img" src="img/backgrounds/car-wash-no-water.jpg">
                            </div>
                            <a href="usuario"><img class="circle" src="https://ssl.gstatic.com/images/branding/product/1x/avatar_circle_blue_512dp.png"></a>
                            <a href="#!name"><span class="white-text name"><%= session.getAttribute("nome")%></span></a>
                            <a href="#!email"><span class="white-text email"><%= usuario.getEmail()%></span></a>
                        </div></li>

                    <li><a href="painel">Painel Administrativo</a></li>
                    <li class="no-padding">
                        <%-- /\ /\ NÃO VARIA /\ /\--%>

                        <%if (usuario.getNivel() == 1) {%>
                        <%--Menu do Cliente--%>

                        <ul class="collapsible collapsible-accordion">
                            <li>
                                <a class="collapsible-header waves-effect waves-teal">Solicitações<i class="material-icons">arrow_drop_down</i></a>
                                <div class="collapsible-body">
                                    <ul>
                                        <li><a href="solicitar-servico">Solicitar Serviço</a></li>
                                        <li><a href="solicitacoes-cliente">Minhas Solicitações</a></li>
                                    </ul>
                                </div>
                            </li>
                        </ul>

                        <%--Menu do Lavador---%>

                        <% } else if (usuario.getNivel() == 2) {%>
                        <ul class="collapsible collapsible-accordion">
                            <li>
                                <a class="collapsible-header waves-effect waves-teal">Solicitações<i class="material-icons">arrow_drop_down</i></a>
                                <div class="collapsible-body">
                                    <ul>
                                        <li><a href="solicitacoes-hoje">Para hoje</a></li>
                                        <li><a href="solicitacoes-lavador">Geral</a></li>
                                        
                                    </ul>
                                </div>
                            </li>
                        </ul>
                        <ul class="collapsible collapsible-accordion">
                            <li>
                                <a class="collapsible-header waves-effect waves-teal">Relatórios<i class="material-icons">arrow_drop_down</i></a>
                                <div class="collapsible-body">
                                    <ul>
                                        <li><a href="ListarProdutosHoje">Produtos para hoje</a></li>
                                    </ul>
                                </div>
                            </li>
                        </ul>

                        <%--Menu do Admin---%>
                        <% } else if (usuario.getNivel() == 3) {%>

                        <ul class="collapsible collapsible-accordion">
                            <li>
                                <a class="collapsible-header waves-effect waves-teal">Cadastros Pessoais<i class="material-icons">arrow_drop_down</i></a>
                                <div class="collapsible-body">
                                    <ul>
                                        <li><a href="Controle?action=ListaCommand&listar=cliente">Clientes</a></li>
                                        <li><a href="Controle?action=ListaCommand&listar=lavador">Lavadores</a></li>
                                    </ul>
                                </div>
                            </li>
                        </ul>
                        <ul class="collapsible collapsible-accordion">
                            <li>
                                <a class="collapsible-header waves-effect waves-teal">Cadastros Gerais<i class="material-icons">arrow_drop_down</i></a>
                                <div class="collapsible-body">
                                    <ul>
                                        <li><a href="Controle?action=ListaCommand&listar=produto">Produtos</a></li>
                                        <li><a href="Controle?action=ListaCommand&listar=servico">Serviços</a></li>
                                    </ul>
                                </div>
                            </li>
                        </ul>
                        <ul class="collapsible collapsible-accordion">
                            <li>
                                <a class="collapsible-header waves-effect waves-teal">Solicitações<i class="material-icons">arrow_drop_down</i></a>
                                <div class="collapsible-body">
                                    <ul>
                                        <%--<li><a href="SolicitarServico">Solicitar Serviço</a></li> --%>
                                        <li><a href="ListarSolicitacaoEmAnalise">Aprovar Solicitações</a></li>
                                        <li><a href="Controle?action=ListaCommand&listar=solicitacao">Solicitações</a></li>
                                    </ul>
                                </div>
                            </li>
                        </ul>

                        <% }
                            } else {
                                response.sendRedirect("index.jsp");
                            }

                        %>
                        <%-- \/ NÃO VARIA \/--%>
                    <li><a href="logout">Sair</a></li>
                    </li>
                </ul>
            </div>
        </nav>