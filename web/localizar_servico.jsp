<%-- 
    Document   : localizar_func
    Created on : 22/11/2016, 14:10:06
    Author     : rezen
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="cabecalho.jsp"%>
        <div class="container">
            <div class="jumbotron">
                <h1>Alterar Serviço</h1>
            </div>
            <form action="Controle" method="post">
                <div class="form-group">
                    <input type="hidden" name="quem" value="servico"/>
                    <input type="hidden" name="txtId" value="${servico.id}"/>
                    <label>Nome:</label> <input class="form-control" type="text" name="txtNome" value="${servico.nome}"><br>
                    <label>Descrição:</label> <input class="form-control" type="text" name="txtDescricao" value="${servico.descricao}"><br>
                    <label>Valor:</label> <input class="form-control" type="text" name="txtValor" value="${servico.valor}"><br>
                    <input class="form-control btn btn-primary" type="submit" name="action" value="Atualizar"><br>
                </div>
            </form>
        </div>
<%@include file="rodape.jsp"%>
