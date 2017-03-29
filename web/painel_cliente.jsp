<%-- 
    Document   : painel_cliente
    Created on : 16/02/2017, 08:00:59
    Author     : rezen
--%>

<%@page  contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="cabecalho.jsp"%>
        <%
            if (session != null) {
                if (Integer.parseInt(session.getAttribute("acesso").toString()) == 1) {
                    String name = (String) session.getAttribute("user");
        %>
                    <div class="jumbotron">
                        <h1>ICarWash - Cliente Login</h1>
        <%      }else{
                  response.sendRedirect("index.jsp");   
                } 
            }   
        %>            

    </body>
    <footer>
        <br>
        <br>
    </footer>
</html>
