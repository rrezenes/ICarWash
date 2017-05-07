<%-- 
    Document   : localizar_func
    Created on : 22/11/2016, 14:10:06
    Author     : rezen
--%>

<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="br.icarwash.model.Lavador"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.icarwash.dao.LavadorDAO"%>
<%@include file="cabecalho.jsp"%>
        <div class="container">
            <div class="jumbotron">
                <%//recupera a lista do request
                    DateFormat f = new SimpleDateFormat("dd/MM/yyyy");
                    Lavador lavador = (Lavador) request.getAttribute("lavador");%>
                <h1>Alterar Lavador</h1>
            </div>
            <form action="Controle" method="post">
                <div class="form-group">
                    <input type="hidden" name="quem" value="lavador"/>
                    <input type="hidden" name="DtAdmissao" value="<%= lavador.getDataContrato()%>">
                    <input type="hidden" name="txtId" value="<%= lavador.getId()%>"/>
                    <label>Email:</label> <input class="form-control" type="text" name="txtEmail" value="<%= lavador.getEmail()%>"><br>
                    <label>Nome:</label> <input class="form-control" type="text" name="txtNome" value="<%= lavador.getNome()%>"><br>
                    <label>Telefone:</label> <input class="form-control" type="text" name="txtTelefone" value="<%= lavador.getTelefone()%>"><br>
                    <label>Data de Nascimento:</label> <input class="form-control" type="text" name="txtDataNascimento" value="<%= f.format(lavador.getDataNascimento().getTime())%>"><br>
                    <label>CEP:</label> <input class="form-control" type="text" name="txtCEP" value="<%= lavador.getEndereco().getCEP()%>"><br>
                    <label>Estado</label> <input class="form-control" type="text" name="txtEstado" value="<%= lavador.getEndereco().getEstado()%>"><br>
                    <label>Cidade:</label> <input class="form-control" type="text" name="txtCidade" value="<%= lavador.getEndereco().getCidade()%>"><br>
                    <label>Bairro:</label> <input class="form-control" type="text" name="txtBairro" value="<%= lavador.getEndereco().getBairro()%>"><br>
                    <label>Endereço:</label> <input class="form-control" type="text" name="txtEndereco" value="<%= lavador.getEndereco().getEndereco()%>"><br>
                    <label>Numero:</label> <input class="form-control" type="text" name="txtNumero" value="<%= lavador.getEndereco().getNumero()%>"><br>
                    <input class="form-control btn btn-primary" type="submit" name="action" value="Atualizar"><br>
                </div>
            </form>
        </div>
<%@include file="rodape.jsp"%>
