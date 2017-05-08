<%-- 
    Document   : listaCliente
    Created on : 17/11/2016, 22:13:43
    Author     : rezen
--%>

<%@page import="br.icarwash.model.Servico"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.icarwash.dao.ServicoDAO"%>
<%@page  contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="cabecalho.jsp"%>
<!--        < %
            if (session != null) {
//                if (Integer.parseInt(session.getAttribute("acesso").toString()) == 3) {
                    String name = (String) session.getAttribute("user");
        %>-->
<div class="jumbotron">
    <h1>Solicitar Serviço</h1>
</div>
<form action="ControleSolicitarServico" method="post">
    <div class="form-group">
        <input type="hidden" name="quem" value="cliente">
        <label>Serviços:</label>
        
            <%
                ServicoDAO servicoDAO = new ServicoDAO();
                
                ArrayList<Servico> servicos = servicoDAO.listar();
                
                for (Servico servico: servicos) {
                    if(servico.isAtivo()){%>
                    <div class="checkbox">
                        <label style="padding-left: 35px;"><input type="checkbox" name="servico" value="<%=servico.getId()%>"><%=servico.getNome() + " R$" + servico.getValor()%></label>
                    </div>
               <%}
                }

            %>
        <div class="row">    
            <label style=" padding-left: 19px;">Porte:</label>
            <label class="radio-inline" style=" padding-left: 35px;">
                <input type="radio" name="porte" value="pequeno">Pequeno
            </label>
            <label class="radio-inline">
                <input type="radio" name="porte" value="medio">Médio
            </label>
            <label class="radio-inline">
                <input type="radio" name="porte" value="grande">Grande
            </label>
            
        </div>     
    </div>
    <div class="form-group">
        <input class="form-control btn btn-primary" type="submit" name="action" value="Cadastrar"><br>
    </div>
</form>

<!--    < % //      }else{
//                  response.sendRedirect("index.jsp");   
//                } 
        }
    %>-->
<%@include file="rodape.jsp"%>