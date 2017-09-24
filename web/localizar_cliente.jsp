<%-- 
    Document   : localizar
    Created on : 18/11/2016, 09:40:30
    Author     : rezen
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="cabecalho.jsp"%>

        <div class="container">
            <div class="jumbotron">
                <h1>Alterar Cliente</h1>
            </div>
            <form action="Controle" method="post">
                <div class="form-group">
                    <input type="hidden" name="quem" value="cliente"/>
                    <input type="hidden" name="txtId" value="${cliente.id}"/>
                    <label>Email:</label> <input class="form-control" type="text" name="txtEmail" value="${cliente.email}"><br>
                    <label>Nome:</label> <input class="form-control" type="text" name="txtNome" value="${cliente.nome}"><br>
                    <label>Telefone:</label> <input class="form-control" type="text" name="txtTelefone" value="${cliente.telefone}"><br>
                    <%--Formatar a data antes de exibir na tela--%>
                    <fmt:formatDate value="${cliente.dtNascimento.time}" var="dataNascimento" type="date" pattern="dd/MM/yyyy" />            
                    <label>Data de Nascimento:</label> <input class="form-control" type="text" name="txtDataNascimento" value="${dataNascimento}"><br>
                    <label>CEP:</label> <input class="form-control" type="text" name="txtCEP" value="${cliente.endereco.CEP}"><br>
                    <label>Estado</label> <input class="form-control" type="text" name="txtEstado" value="${cliente.endereco.estado}"><br>
                    <label>Cidade:</label> <input class="form-control" type="text" name="txtCidade" value="${cliente.endereco.cidade}"><br>
                    <label>Bairro:</label> <input class="form-control" type="text" name="txtBairro" value="${cliente.endereco.bairro}"><br>
                    <label>Endereço:</label> <input class="form-control" type="text" name="txtEndereco" value="${cliente.endereco.endereco}"><br>
                    <label>Número:</label> <input class="form-control" type="text" name="txtNumero" value="${cliente.endereco.numero}"><br>
                    <input class="form-control btn btn-primary" type="submit" name="action" value="Atualizar"><br>
                </div>
            </form>
        </div>
<%@include file="rodape.jsp"%>
