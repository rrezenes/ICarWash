<%-- 
    Document   : localizar_func
    Created on : 22/11/2016, 14:10:06
    Author     : rezen
--%>

<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="br.icarwash.model.Produto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.icarwash.dao.ProdutoDAO"%>
<%@include file="cabecalho.jsp"%>
        <div class="container">
            <div class="jumbotron">
                <%//recupera a lista do request
                    DateFormat f = new SimpleDateFormat("dd/MM/yyyy");
                    Produto produto = (Produto) request.getAttribute("produto");%>
                <h1>Alterar Produto</h1>
            </div>
            <form action="Controle" method="post">
                <div class="form-group">
                    <input type="hidden" name="quem" value="produto"/>
                    <input type="hidden" name="txtId" value="<%= produto.getId()%>"/>
                    <label>Nome:</label> <input class="form-control" type="text" name="txtNome" value="<%= produto.getNome()%>"><br>
                    <label>Descricao:</label> <input class="form-control" type="text" name="txtDescricao" value="<%= produto.getDescricao()%>"><br>
                    <input class="form-control btn btn-primary" type="submit" name="action" value="Atualizar"><br>
                </div>
            </form>
        </div>
<%@include file="rodape.jsp"%>
