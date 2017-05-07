<%-- 
    Document   : localizar
    Created on : 18/11/2016, 09:40:30
    Author     : rezen
--%>

<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="br.icarwash.model.Cliente"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.icarwash.dao.ClienteDAO"%>
<%@include file="cabecalho.jsp"%>
        <div class="container">
            <div class="jumbotron">
                <%//recupera a lista do request
                    DateFormat f = new SimpleDateFormat("dd/MM/yyyy");
                    Cliente cliente = (Cliente) request.getAttribute("cliente");%>
                <h1>Alterar Cliente</h1>
            </div>
            <form action="Controle" method="post">
                <div class="form-group">
                    <input type="hidden" name="quem" value="cliente"/>
                    <input type="hidden" name="txtId" value="<%= cliente.getId()%>"/>
                    <label>Email:</label> <input class="form-control" type="text" name="txtEmail" value="<%=cliente.getEmail()%>"><br>
                    <label>Nome:</label> <input class="form-control" type="text" name="txtNome" value="<%= cliente.getNome()%>"><br>
                    <label>Telefone:</label> <input class="form-control" type="text" name="txtTelefone" value="<%= cliente.getTelefone()%>"><br>
                    <label>Data de Nascimento:</label> <input class="form-control" type="text" name="txtDataNascimento" value="<%= f.format(cliente.getDataNascimento().getTime())%>"><br>
<!--                    <label>CPF:</label> <input class="form-control" type="text" name="txtCPF" value="<= cliente.getCPF()%>"><br>-->
                    <label>CEP:</label> <input class="form-control" type="text" name="txtCEP" value="<%= cliente.getEndereco().getCEP()%>"><br>
                    <label>Estado</label> <input class="form-control" type="text" name="txtEstado" value="<%= cliente.getEndereco().getEstado()%>"><br>
                    <label>Cidade:</label> <input class="form-control" type="text" name="txtCidade" value="<%= cliente.getEndereco().getCidade()%>"><br>
                    <label>Bairro:</label> <input class="form-control" type="text" name="txtBairro" value="<%= cliente.getEndereco().getBairro()%>"><br>
                    <label>Endereço:</label> <input class="form-control" type="text" name="txtEndereco" value="<%= cliente.getEndereco().getEndereco()%>"><br>
                    <label>Numero:</label> <input class="form-control" type="text" name="txtNumero" value="<%= cliente.getEndereco().getNumero()%>"><br>
                    <input class="form-control btn btn-primary" type="submit" name="action" value="Atualizar"><br>
                </div>
            </form>
        </div>
<%@include file="rodape.jsp"%>
