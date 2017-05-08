<%-- 
    Document   : localizar_func
    Created on : 22/11/2016, 14:10:06
    Author     : rezen
--%>

<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="br.icarwash.model.Servico"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.icarwash.dao.ServicoDAO"%>
<%@include file="cabecalho.jsp"%>
        <div class="container">
            <div class="jumbotron">
                <%//recupera a lista do request
                    Servico servico = (Servico) request.getAttribute("servico");%>
                <h1>Alterar Servico</h1>
            </div>
            <form action="Controle" method="post">
                <div class="form-group">
                    <input type="hidden" name="quem" value="servico"/>
                    <input type="hidden" name="txtId" value="<%= servico.getId()%>"/>
                    <label>Nome:</label> <input class="form-control" type="text" name="txtNome" value="<%= servico.getNome()%>"><br>
                    <label>Descricao:</label> <input class="form-control" type="text" name="txtDescricao" value="<%= servico.getDescricao()%>"><br>
                    <label>Valor:</label> <input class="form-control" type="text" name="txtValor" value="<%= servico.getValor()%>"><br>
                    <input class="form-control btn btn-primary" type="submit" name="action" value="Atualizar"><br>
                </div>
            </form>
        </div>
<%@include file="rodape.jsp"%>
