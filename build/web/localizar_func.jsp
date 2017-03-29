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
                    Lavador funcionario = (Lavador) request.getAttribute("funcionario");%>
                <h1>Alterar Funcionario</h1>
            </div>
            <form action="Controle" method="post">
                <div class="form-group">
                    <input type="hidden" name="quem" value="funcionario"/>
                    <input type="hidden" name="DtAdmissao" value="<%= funcionario.getDataContrato()%>">
                    <input type="hidden" name="txtId" value="<%= funcionario.getId()%>"/>
                    <label>Nome:</label> <input class="form-control" type="text" name="txtNome" value="<%= funcionario.getNome()%>"><br>
                    <label>Telefone:</label> <input class="form-control" type="text" name="txtTelefone" value="<%= funcionario.getTelefone()%>"><br>
                    <label>Data de Nascimento:</label> <input class="form-control" type="text" name="txtDataNascimento" value="<%= f.format(funcionario.getDataNascimento().getTime())%>"><br>
                    <label>CPF:</label> <input class="form-control" type="text" name="txtCPF" value="<%= funcionario.getCPF()%>"><br>
                    <label>CEP:</label> <input class="form-control" type="text" name="txtCEP" value="<%= funcionario.getEndereco().getCEP()%>"><br>
                    <label>Estado</label> <input class="form-control" type="text" name="txtEstado" value="<%= funcionario.getEndereco().getEstado()%>"><br>
                    <label>Cidade:</label> <input class="form-control" type="text" name="txtCidade" value="<%= funcionario.getEndereco().getCidade()%>"><br>
                    <label>Bairro:</label> <input class="form-control" type="text" name="txtBairro" value="<%= funcionario.getEndereco().getBairro()%>"><br>
                    <label>Endereço:</label> <input class="form-control" type="text" name="txtEndereco" value="<%= funcionario.getEndereco().getEndereco()%>"><br>
                    <label>Numero:</label> <input class="form-control" type="text" name="txtNumero" value="<%= funcionario.getEndereco().getNumero()%>"><br>
                    <input class="form-control btn btn-primary" type="submit" name="action" value="Atualizar"><br>
                </div>
            </form>
        </div>
<%@include file="rodape.jsp"%>
