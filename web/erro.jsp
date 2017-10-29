<%@include file="cabecalho.jsp"%>
        <div class="col-md-12"><font color="red" size="7"><br/>
            Contate o administrador do sistema e informe a seguinte mensagem de erro:<br />
            <%= ((Exception) request.getAttribute("erro")).getLocalizedMessage()%></font></div>
<%@include file="rodape.jsp"%>
