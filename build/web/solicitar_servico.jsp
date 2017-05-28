<%-- 
    Document   : listaCliente
    Created on : 17/11/2016, 22:13:43
    Author     : rezen
--%>

<%@page import="br.icarwash.model.Servico"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.icarwash.dao.ServicoDAO"%>
<%@page  contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="cabecalho.jsp"%>
<div class="jumbotron">
    <h1>Solicitar Serviço</h1>
</div>
<div class="container" style="max-width: 1000.0px;">
    <form action="ControleSolicitacao" method="post">
        <div class="form-group">
            <input type="hidden" value="cliente">
            <fieldset>
                <legend>Data da Solicitação</legend>
                <div>
                    <div class="input-group date form_datetime col-md-5" data-date-format="dd MM yyyy - HH:ii p">
                        <input class="form-control" size="16" type="text" readonly>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                    </div>
                    <input type="hidden" id="dtp_input1" name="data_solicitacao" value="" /><br/>
                </div>
            </fieldset> 
            <legend>Serviços</legend>
            <div>
                <%  ServicoDAO servicoDAO = new ServicoDAO();
                    ArrayList<Servico> servicos = servicoDAO.listar();
                    for (Servico servico : servicos) {
                        if (servico.isAtivo()) {%>
                <div class="checkbox">
                    <label style="padding-left: 35px;">
                        <input type="checkbox" name="servico" value="<%=servico.getId()%>"><%=servico.getNome() + " R$" + servico.getValor()%>
                    </label>
                </div>
                <%}
                    }

                %>
            </div>
            <fieldset>
                <div>
                    <legend>Tamanho do Veículo</legend>
                    <label class="radio-inline" style="padding-left: 35px;">
                        <input type="radio" name="porte" value="pequeno">Pequeno
                    </label>
                    <label class="radio-inline">
                        <input type="radio" name="porte" value="medio">Médio
                    </label>
                    <label class="radio-inline">
                        <input type="radio" name="porte" value="grande">Grande
                    </label>
                </div>     
            </fieldset> 

        </div>


        <div class="form-group">
            <input class="form-control btn btn-primary" type="submit" name="action" value="Cadastrar"><br>
        </div>
    </form>
</div>

<%@include file="rodape.jsp"%>