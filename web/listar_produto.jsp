
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="cabecalho.jsp"%>
<div class="jumbotron">
    <h1>Controle de Produtos</h1>
</div>
<div class="container">
    <table class="table table-hover">
        <thead>
            <tr>
                <th></th>
                <th>Nome</th>
                <th>Descrição</th>
                <th colspan="2"></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="produto" items="${produtos}">
                <tr>
                    <td>
                        <c:choose>
                            <c:when test="${produto.ativo}">
                                <div type="button" class="glyphicon glyphicon-ok text-success"></div>
                            </c:when> 
                            <c:otherwise>
                                <div type="button" class="glyphicon glyphicon glyphicon-remove text-danger"></div>
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td>${produto.nome}</td>
                    <td>${produto.descricao}</td>
                    <td><a type="button" class="glyphicon glyphicon-pencil text-info" href="Controle?action=LocalizarPorId&q=produto&id=${produto.id}"></a></td>
                    <td>
                        <c:choose>
                            <c:when test="${produto.ativo}">          	
                                <a type="button" href="Controle?action=Excluir&q=produto&id=${produto.id}">Inativar</a>
                            </c:when> 
                            <c:otherwise>
                                <a type="button" href="Controle?action=Ativar&q=produto&id=${produto.id}">Ativar</a>
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <button type="button" class="btn btn-info" data-toggle="modal" data-target="#myModal">Adicionar Produto</button>
</div>
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
                            <div class="col-md-6"><label>Nome:</label> <input class="form-control" type="text" name="nome"><br></div>
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
<%@include file="rodape.jsp"%>