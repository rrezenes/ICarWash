<%-- 
    Document   : localizar_func
    Created on : 22/11/2016, 14:10:06
    Author     : rezen
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="cabecalho.jsp"%>

        <div class="container">
            <div class="jumbotron">                
                <h1>Alterar Lavador</h1>
            </div>
            <form action="Controle" method="post">
                <div class="form-group">
                    <input type="hidden" name="quem" value="lavador"/>
                    <input type="hidden" name="DtAdmissao" value="${lavador.dataContrato}">
                    <input type="hidden" name="txtId" value="${lavador.id}"/>
                    <label>Email:</label> <input class="form-control" type="text" name="txtEmail" value="${lavador.email}"><br>
                    <label>Nome:</label> <input class="form-control" type="text" name="txtNome" value="${lavador.nome}"><br>
                    <label>Telefone:</label> <input class="form-control" type="text" name="txtTelefone" value="${lavador.telefone}"><br>
                    <%--Formatar a data antes de exibir na tela--%>
                    <fmt:formatDate value="${lavador.dtNascimento.time}" var="dataNascimento" type="date" pattern="dd/MM/yyyy" />            
                    <label>Data de Nascimento:</label> <input class="form-control" type="text" name="txtDataNascimento" value="${dataNascimento}"><br>
                    <label>CEP:</label> <input class="form-control" type="text" name="txtCEP" value="${lavador.endereco.CEP}"><br>
                    <label>Estado:</label> <input class="form-control" type="text" name="txtEstado" value="${lavador.endereco.estado}"><br>
                    <label>Cidade:</label> <input class="form-control" type="text" name="txtCidade" value="${lavador.endereco.cidade}"><br>
                    <label>Bairro:</label> <input class="form-control" type="text" name="txtBairro" value="${lavador.endereco.bairro}"><br>
                    <label>Endereço:</label> <input class="form-control" type="text" name="txtEndereco" value="${lavador.endereco.endereco}"><br>
                    <label>Número:</label> <input class="form-control" type="text" name="txtNumero" value="${lavador.endereco.numero}"><br>
                    <input class="form-control btn btn-primary" type="submit" name="action" value="Atualizar"><br>
                </div>
            </form>
        </div>
<%@include file="rodape.jsp"%>
