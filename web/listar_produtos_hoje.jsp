<%--
    Fazer essa página recuperar a lista dos produtos de acordo com os serviços 
    do Lavador que tenha para a data de hoje.
--%>

<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="br.icarwash.model.Produto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.icarwash.dao.ProdutoDAO"%>
<%@include file="cabecalho.jsp"%>
<div class="jumbotron">
    <h2>Listar produtos para hoje</h2>
</div>
<table class="table table-hover">
    <thead>
        <tr>
            <th></th>
            <th>Nome</th>
            <th>Quantidade</th>
            <th colspan="2"></th>
        </tr>
    </thead>
    <tbody>
        <%
            ArrayList<Produto> listaProduto = (ArrayList<Produto>) request.getAttribute("lista");
            for (Produto produto : listaProduto) {%>  
        <tr>
            <% if(produto.isAtivo()){%>          	
            	<td><div type="button" class="glyphicon glyphicon-ok text-success"></div></td>
            <%}else{%> 
            	<td><div type="button" class="glyphicon glyphicon glyphicon-remove text-danger"></div></td>
            <%}%>
            <td><%= produto.getNome()%></td>
            <td><%= produto.getDescricao()%></td>
            <td><a type="button" class="glyphicon glyphicon-pencil text-info" href="Controle?action=LocalizarPorId&q=produto&id=<%=produto.getId()%>"></a></td>
            <% if(produto.isAtivo()){%>          	
            	<td><a type="button" href="Controle?action=Excluir&q=produto&id=<%=produto.getId()%>">Inativar</a></td>
            <%}else{%> 
            	<td><a type="button" href="Controle?action=Ativar&q=produto&id=<%=produto.getId()%>">Ativar</a></td>
            <%}%>
        </tr>
        <%}%> 
    </tbody>
</table>
<%--
<button type="button" class="btn btn-info" data-toggle="modal" data-target="#myModal">Add Produto</button>

<div class="container">
</div>
<div id="myModal" class="modal fade" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Cadastrar Produto</h4>
            </div>
            <div class="modal-body">
                <form action="Controle" method="post">
                    <div class="form-group">
                        <input type="hidden" name="quem" value="produto">
                        <div class="row">
                            <div class="col-md-6"><label>Nome:</label> <input class="form-control" type="text" name="nome" id="nome"><br></div>
                            <div class="col-md-6"><label>Descrição:</label> <input class="form-control" type="text" name="descricao" id="descricao"><br></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <input class="form-control btn btn-primary" type="submit" name="action" value="Cadastrar"><br>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
            </div>
        </div>
    </div>
</div>
--%>
<%@include file="rodape.jsp"%>