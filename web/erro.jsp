<%-- 
    Document   : erro
    Created on : 17/11/2016, 22:11:13
    Author     : rezen
--%>

<%@include file="cabecalho.jsp"%>
        <div class="col-md-12"><font color="red" size="7"><br/>
            Contate o administrador do sistema e informe a seguinte mensagem de erro:<br />
            <%= ((Exception) request.getAttribute("erro")).getLocalizedMessage()%></font></div>
<%@include file="rodape.jsp"%>
