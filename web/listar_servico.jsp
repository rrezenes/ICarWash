
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="cabecalho.jsp"%>
<div class="jumbotron">
    <h1>Controle de Serviços</h1>
</div>
<div class="container">
    <table class="table table-hover">
        <thead>
            <tr>
                <th>Nome</th>
                <th>Descrição</th>
                <th>Valor</th>
                <th colspan="2"></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="servico" items="${servicos}">
                <tr>
                    <td>${servico.nome}</td>
                    <td>${servico.descricao}</td>
                    <td>${servico.valor}</td>
                    <td><a type="button" class="glyphicon glyphicon-pencil text-info" href="Controle?action=LocalizarPorId&q=servico&id=${servico.id}"></a></td>
                    <td>
                        <c:choose>
                            <c:when test="${servico.ativo}">
                                <a type="button" href="Controle?action=Excluir&q=servico&id=${servico.id}">Inativar</a>
                            </c:when>
                            <c:otherwise>
                                <a type="button" href="Controle?action=Ativar&q=servico&id=${servico.id}">Ativar</a>
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
            </c:forEach>   
        </tbody>
    </table>

    <button type="button" class="btn btn-info" data-toggle="modal" data-target="#myModal">Adicionar Serviço</button>
</div>
<div class="container">
</div>
<div id="myModal" class="modal fade" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Cadastrar Serviço</h4>
            </div>
            <div class="modal-body">
                <form action="Controle" method="post">
                    <div class="form-group">
                        <input type="hidden" name="quem" value="servico">
                        <div class="row">
                            <div class="col-md-12"><label>Nome:</label> <input class="form-control" type="text" name="nome"><br></div>
                            <div class="col-md-12"><label>Descrição:</label> <input class="form-control" type="text" name="descricao" id="descricao"><br></div>
                            <div class="col-md-12"><label>Valor:</label> <input class="form-control" type="text" name="valor" id="valor"><br></div>
                                <jsp:useBean id="produtoDao" class="br.icarwash.dao.ProdutoDAO"/>
                            <div class="col-md-7" style="padding-bottom: 2px"><b>Selecione os Produtos:</b></div>
                            <div class="col-md-5" style="padding-bottom: 2px"><b>Selecione a quantidade:</b></div>
                            <legend></legend>
                            <c:forEach var="produto" items="${produtoDao.listar()}">
                                <c:if test = "${produto.ativo}">
                                    <div class="form-inline">
                                        <div class="checkbox col-md-7">
                                            <label style="padding-left: 10px"><input type="checkbox" value="${produto.id}" name="produtos" onclick="document.ElementById('${produto.id}').disabled = !this.checked;">${produto.nome}</label>
                                        </div>
                                        <div class="col-md-5" style="padding: 0 0 2px 25px">
                                            <select class="form-control" name="combo${produto.id}" id="${produto.id}" disabled="disabled">
                                                <option value="1"></option>
                                                <option value="1">1</option>
                                                <option value="2">2</option>
                                                <option value="3">3</option>
                                                <option value="4">4</option>
                                                <option value="5">5</option>
                                            </select>
                                        </div>
                                    </div>    
                                </c:if>
                            </c:forEach>
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