<%-- 
    Document   : listaCliente
    Created on : 17/11/2016, 22:13:43
    Author     : rezen
--%>

<%@page import="br.icarwash.model.Solicitacao"%>
<%@page import="br.icarwash.dao.SolicitacaoDAO"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page  contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="cabecalho.jsp"%>
<link rel="stylesheet" href="css/star-rating.css">
<div class="jumbotron">
    <h1>Minhas Solicitações</h1>
</div>

<table class="table table-hover">
    <thead>
        <tr>
            <th>ID Solicitação</th>
            <th>Nome</th>
            <th>Lavador</th>
            <th>Porte do Veiculo</th>
            <th>Data Solicitação</th>
            <th>Valor Total</th>
            <th>Status</th>
            <th colspan=2>Action</th>
        </tr>
    </thead>
    <tbody>
        <%  DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm");
            SolicitacaoDAO solicitacaoDAO = new SolicitacaoDAO();
            ArrayList<Solicitacao> solicitacoes = solicitacaoDAO.listarSolicitacaoPorIDCliente(clienteDAO.localizarIdPorIdUsuario(usuario).getId());
            for(Solicitacao solicitacao: solicitacoes){%>  
        <tr>
            <td><%=solicitacao.getId()%></td>
            <td><%=solicitacao.getCliente().getNome()%></td>
            <td><%=solicitacao.getLavador().getId()%></td>
            <td><%=solicitacao.getPorte()%></td>
            <td><%=dateFormat.format(solicitacao.getDataSolicitacao().getTime())%></td>
            <td><%=solicitacao.getValorTotal().doubleValue()%></td>
            <td><%=solicitacao.getEstado()%></td>
            <% if(solicitacao.getEstado().toString().equals("Em Analise") || solicitacao.getEstado().toString().equals("Agendado")){%>
                <td>
                    <form action="CancelarSolicitacao" method="post">
                        <input type="hidden" name="id_solicitacao" value="<%=solicitacao.getId()%>"/> 
                        <input type="submit" value="Cancelar" class="btn btn-danger">
                    </form>                    
                </td>
            <%} else if(solicitacao.getEstado().toString().equals("Finalizado")){%>
                <td>
                    <button type="button" class="btn btn-info" data-toggle="modal" data-target="#myModal">Avaliar</button> 
                    <div id="myModal" class="modal fade" role="dialog">
                        <div class="modal-dialog">
                            <!-- Modal content-->
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                    <h4 class="modal-title">Avaliar Solicitação</h4>
                                </div>
                                <div class="modal-body">
                                    <form action="AvaliarSolicitacao" method="post">
                                        <div class="form-group">
                                            <div class="row">
                                                <input type="hidden" name="id_solicitacao" value="<%=solicitacao.getId()%>"/> 
                                                <label for="pontualidade" class="control-label">Pontualidade</label>
                                                <input id="pontualidade" name="pontualidade" value="0" class="rating-loading"><br>
                                                <label for="servico" class="control-label">Serviço</label>
                                                <input id="servico" name="servico" value="0" class="rating-loading"><br>
                                                <label for="atendimento" class="control-label">Atendimento</label>
                                                <input id="atendimento" name="atendimento" value="0" class="rating-loading"><br>
                                                <label for="agilidade" class="control-label">Agilidade</label>
                                                <input id="agilidade" name="agilidade" value="0" class="rating-loading"><br>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <input class="form-control btn btn-primary" type="submit" name="action" value="Avaliar"><br>
                                        </div>
                                    </form>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <script src="js/star-rating.js"></script>
                    <script src="js/star-rating_locale_pt-BR.js"></script>
                    <script>
                            $('#pontualidade').rating({});
                            $('#servico').rating({});
                            $('#atendimento').rating({});
                            $('#agilidade').rating({});

                    </script>
                </td>

            <%}%> 
        </tr>
        <%}%> 
    </tbody>
</table>
    


<%@include file="rodape.jsp"%>