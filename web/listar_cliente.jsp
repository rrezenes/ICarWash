<%-- 
    Document   : listaCliente
    Created on : 17/11/2016, 22:13:43
    Author     : rezen
--%>

<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="br.icarwash.model.Cliente"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.icarwash.dao.ClienteDAO"%>
<%@include file="cabecalho.jsp"%>
<div class="jumbotron">
    <h2>Controle de Clientes</h2>
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
            <th>Endereco</th>
            <th colspan=2>Action</th>
        </tr>
    </thead>
    <tbody>
        <%//recupera a lista do request
            DateFormat f = new SimpleDateFormat("dd/MM/yyyy");
            ArrayList<Cliente> listaCliente = (ArrayList<Cliente>) request.getAttribute("lista");
            for (Cliente cliente : listaCliente) {%>  
        <tr>
            <td><%= cliente.getEmail()%></td>
            <td><%= cliente.getNome()%></td>
            <td><%= cliente.getTelefone()%></td>
            <td><%= f.format(cliente.getDataNascimento().getTime())%></td>
            <td><%= cliente.getCPF()%></td>
            <td><%= cliente.getEndereco().getCEP()%></td>
            <td><%= cliente.getEndereco().getEstado()%></td>
            <td><%= cliente.getEndereco().getCidade()%></td>
            <td><%= cliente.getEndereco().getBairro()%></td>
            <td><%= cliente.getEndereco().getEndereco() + " " + cliente.getEndereco().getNumero()%></td>
            <td><a type="button" class="glyphicon glyphicon-search text-info" href="Controle?action=LocalizarPorId&q=cliente&id=<%=cliente.getId()%>"></a></td>
            <td><a type="button" class="glyphicon glyphicon-remove text-danger"  href="Controle?action=Excluir&q=cliente&id=<%=cliente.getId()%>"></a></td>
        </tr>
        <%}%> 
    </tbody>
</table>

<button type="button" class="btn btn-info" data-toggle="modal" data-target="#myModal">Add Cliente</button>

<div class="container">
</div>
<div id="myModal" class="modal fade" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Cadastrar Cliente</h4>
            </div>
            <div class="modal-body">
                <form action="Controle" method="post">
                    <div class="form-group">
                        <input type="hidden" name="quem" value="cliente">
                        <div class="row">
                            <div class="col-md-8"><label>Email:</label> <input class="form-control" type="text" name="txtEmail" id="txtEmail"><br></div>
                        </div>    
                        <div class="row">
                            <div class="col-md-6"><label>Login:</label> <input class="form-control" type="text" name="login"><br></div>
                            <div class="col-md-6"><label>Senha:</label> <input class="form-control" type="password" name="senha"><br></div>
                        </div>
                        <div class="row">
                            <div class="col-md-6"><label>Nome:</label> <input class="form-control" type="text" name="nome"><br></div>
                            <div class="col-md-6"><label>Telefone:</label> <input class="form-control" type="text" name="telefone" id="telefone"><br></div>
                        </div>
                        <div class="row">
                            <div class="col-md-6"><label>Data de Nascimento:</label> <input class="form-control" type="text" name="nascimento" id="nascimento"><br></div>
                            <div class="col-md-6"><label>CPF:</label> <input class="form-control" type="text" name="cpf" id="cpf"><br></div>
                        </div>
                        <div class="row">
                            <div class="col-md-6"><label>CEP:</label> <input class="form-control" type="text" name="cep" id="cep"><br></div>
                            <div class="col-md-6"><label>Estado:</label> <input class="form-control" type="text" name="estado" id="estado"><br></div>
                        </div>
                        <div class="row">
                            <div class="col-md-6"><label>Cidade:</label> <input class="form-control" type="text" name="cidade" id="cidade"><br></div>
                            <div class="col-md-6"><label>Bairro:</label> <input class="form-control" type="text" name="bairro" id="bairro"><br></div>
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