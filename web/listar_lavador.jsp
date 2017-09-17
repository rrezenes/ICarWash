<%-- 
    Document   : listaCliente
    Created on : 17/11/2016, 22:13:43
    Author     : rezen
--%>

<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="br.icarwash.model.Lavador"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.icarwash.dao.LavadorDAO"%>
<%@include file="cabecalho.jsp"%>
<div class="jumbotron">
    <h2>Controle de Lavadores</h2>
</div>
<table class="table table-hover">
    <thead>
        <tr>
            <th>Email</th>
            <th>Nome</th>
            <th>Telefone</th>
            <th>Data Nascimento</th>
            <th>CPF</th>
            <th>CEP</th>
            <th>Estado</th>
            <th>Cidade</th>
            <th>Bairro</th>
            <th>Endereço</th>
            <th>Admissão</th>
            <th colspan="2"></th>
        </tr>
    </thead>
    <tbody>
        <%  DateFormat f = new SimpleDateFormat("dd/MM/yyyy");
            ArrayList<Lavador> listaLavadores = (ArrayList<Lavador>) request.getAttribute("lista"); //recupera a lista do request
            for (Lavador lavador : listaLavadores) {%>  
        <tr>
            <td><%= lavador.getEmail()%></td>
            <td><%= lavador.getNome()%></td>
            <td><%= lavador.getTelefone()%></td>
            <td><%= f.format(lavador.getDataNascimento().getTime())%></td>
            <td><%= lavador.getCPF()%></td>
            <td><%= lavador.getEndereco().getCEP()%></td>
            <td><%= lavador.getEndereco().getEstado()%></td>
            <td><%= lavador.getEndereco().getCidade()%></td>
            <td><%= lavador.getEndereco().getBairro()%></td>
            <td><%= lavador.getEndereco().getEndereco() + " " + lavador.getEndereco().getNumero()%></td>
            <td><%= f.format(lavador.getDataContrato().getTime())%></td>
            <td><a type="button" class="glyphicon glyphicon-pencil text-info" href="Controle?action=LocalizarPorId&q=lavador&id=<%=lavador.getId()%>"></a></td>
            <td><a type="button" class="glyphicon glyphicon-remove text-danger" href="Controle?action=Excluir&q=lavador&id=<%=lavador.getId()%>"></a></td>
        </tr>
        <%}%> 
    </tbody>
</table>

<button type="button" class="btn btn-info" data-toggle="modal" data-target="#myModal">Adicionar Lavador</button>

<div class="container">
</div>
<div id="myModal" class="modal fade" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Cadastrar Lavadores</h4>
            </div>
            <div class="modal-body">
                <form action="Controle" method="post">
                    <div class="form-group">
                        <input type="hidden" name="quem" value="lavador">
                        <label>Email:</label> <input class="form-control" type="email" name="email" id="email"><br>
                        <div class="row">
                            <div class="col-md-6"><label>Login:</label> <input class="form-control" type="text" name="login"><br></div>
                            <div class="col-md-6"><label>Senha:</label> <input class="form-control" type="password" name="senha"><br></div>
                        </div>
                        <label>Nome:</label> <input class="form-control" type="text" name="nome"><br>                        
                        <div class="row">
                            <div class="col-md-6"><label>Telefone:</label> <input class="form-control" type="text" name="telefone" id="telefone"><br></div>
                            <div class="col-md-6"><label>Data de Nascimento:</label> <input class="form-control" type="text" name="nascimento" id="nascimento"><br></div>
                        </div>
                        <label>CPF:</label> <input class="form-control" type="text" name="cpf" id="cpf"><br>
                        <label>CEP:</label> <input class="form-control" type="text" name="cep" id="cep"><br>
                        <div class="row">
                            <div class="col-md-4"><label>Estado:</label> <input class="form-control" type="text" name="estado" id="estado"><br></div>
                            <div class="col-md-4"><label>Cidade:</label> <input class="form-control" type="text" name="cidade" id="cidade"><br></div>
                            <div class="col-md-4"><label>Bairro:</label> <input class="form-control" type="text" name="bairro" id="bairro"><br></div>
                        </div>
                        <div class="row">
                            <div class="col-md-8"><label>Endereço:</label> <input class="form-control" type="text" name="endereco" id="endereco"><br></div>
                            <div class="col-md-4"><label>Numero:</label> <input class="form-control" type="text" name="numero" id="numero"><br></div>
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