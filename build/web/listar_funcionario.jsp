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
                        <h2>Controle de Funcionarios</h2>
                    </div>
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>Nome</th>
                                <th>Telefone</th>
                                <th>Data Nascimento</th>
                                <th>CPF</th>
                                <th>CEP</th>
                                <th>Estado</th>
                                <th>Cidade</th>
                                <th>Bairro</th>
                                <th>Endereco</th>
                                <th>Admissão</th>
                                <th colspan=2>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                DateFormat f = new SimpleDateFormat("dd/MM/yyyy");
                                ArrayList<Lavador> listaFuncionario = (ArrayList<Lavador>) request.getAttribute("lista"); //recupera a lista do request
                                for (Lavador func : listaFuncionario) {%>  
                            <tr>
                                <td><%= func.getNome()%></td>
                                <td><%= func.getTelefone()%></td>
                                <td><%= f.format(func.getDataNascimento().getTime())%></td>
                                <td><%= func.getCPF()%></td>
                                <td><%= func.getEndereco().getCEP()%></td>
                                <td><%= func.getEndereco().getEstado()%></td>
                                <td><%= func.getEndereco().getCidade()%></td>
                                <td><%= func.getEndereco().getBairro()%></td>
                                <td><%= func.getEndereco().getEndereco() + " " + func.getEndereco().getNumero()%></td>
                                <td><%= f.format(func.getDataContrato().getTime())%></td>
                                <td><a type="button" class="glyphicon glyphicon-search text-info" href="Controle?action=LocalizarPorId&q=f&id=<%=func.getId()%>"></a></td>
                                <td><a type="button" class="glyphicon glyphicon-remove text-danger"  href="Controle?action=Excluir&q=f&id=<%=func.getId()%>"></a></td>
                            </tr>
                            <%}%> 
                        </tbody>
                    </table>

                    <button type="button" class="btn btn-info" data-toggle="modal" data-target="#myModal">Add Funcionario</button>

                    <div class="container">
                    </div>
                    <div id="myModal" class="modal fade" role="dialog">
                        <div class="modal-dialog">
                            <!-- Modal content-->
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                    <h4 class="modal-title">Cadastrar Funcionario</h4>
                                </div>
                                <div class="modal-body">
                                    <form action="Controle" method="post">
                                        <div class="form-group">
                                            <input type="hidden" name="quem" value="funcionario">
                                            <label>Nome:</label> <input class="form-control" type="text" name="nome"><br>
                                            <label>Email:</label> <input class="form-control" type="email" name="email" id="email"><br>
                                            <label>Telefone:</label> <input class="form-control" type="text" name="telefone" id="telefone"><br>
                                            <label>Data de Nascimento:</label> <input class="form-control" type="text" name="nascimento" id="nascimento"><br>
                                            <label>CPF:</label> <input class="form-control" type="text" name="cpf" id="cpf"><br>
                                            <label>CEP:</label> <input class="form-control" type="text" name="cep" id="cep"><br>
                                            <label>Estado:</label> <input class="form-control" type="text" name="estado" id="estado"><br>
                                            <label>Cidade:</label> <input class="form-control" type="text" name="cidade" id="cidade"><br>
                                            <label>Bairro:</label> <input class="form-control" type="text" name="bairro" id="bairro"><br>
                                            <label>Endereço:</label> <input class="form-control" type="text" name="endereco" id="endereco"><br>
                                            <label>Numero:</label> <input class="form-control" type="text" name="numero" id="numero"><br>
                                            </form
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