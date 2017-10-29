<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="br.icarwash.model.Produto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.icarwash.dao.ProdutoDAO"%>
<%@include file="cabecalho.jsp"%>
<%//recupera a lista do request
    DateFormat f = new SimpleDateFormat("dd/MM/yyyy");
    Produto produto = (Produto) request.getAttribute("produto");%>

<div class="row">
    <p class="titulo-controle">Alterar Produto</p>
    <div class="divider"></div>
</div>
<div class="container">
    <form id="FormValidate" action="Controle" method="post">
        <div class="form-group">
            <input type="hidden" name="quem" value="produto"/>
            <input type="hidden" name="txtId" value="<%= produto.getId()%>"/>
            <div class="input-field col s6">
                <label>Nome</label> 
                <input class="form-control erro-nome" type="text" name="nome" value="<%= produto.getNome()%>"><br>
            </div>
            <div class="input-field col s6">
                <label>Descri��o</label> 
                <input class="form-control erro-descricao" type="text" name="descricao" value="<%= produto.getDescricao()%>"><br>
            </div>
            <input class="form-control btn btn-primary" type="submit" name="action" value="Atualizar"><br>
        </div>
    </form>
</div>

<script src="js/jquery.validate.js"></script>
<script src="js/inicializar-validate.js"></script>
<script src="js/validar-apenas-letras-numeros.js"></script>
<script src="js/validar-apenas-letras.js"></script>

<%@include file="rodape.jsp"%>
