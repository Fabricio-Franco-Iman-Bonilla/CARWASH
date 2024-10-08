<%-- 
    Document   : dashPagos
    Created on : 12/07/2024, 4:56:04 p. m.
    Author     : MIKI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dashboard</title>
        <%@include file="referencias.jsp" %>
        <script>
            $(document).ready(function(){
                $('#myTable').DataTable();
            });
        </script>
    </head>
    <body>
        <div class="row">
            <div class="col-sm-2 menu" style="background-color: #33B3FF">
                <br>
                <%@include file="menu.jsp"%>
            </div>        
            <div class="col-sm-10 contenido">
                
                <h2 style="text-align: center; padding-top: 50px">Administrador</h2>
                
                <%
                    String pagina = "";

                    if (request.getParameter("pagina") != null) {
                        pagina = request.getParameter("pagina");
                    }

                    if (pagina.equals("pago_listar")) {
                %>
                <%@include file="pago_listar.jsp" %>
                <%                
                    } else if (pagina.equals("pago_nuevo")) {
                %>
                <%@include file="pago_nuevo.jsp" %>
                <%
                } else if (pagina.equals("pago_ver")) {
                %> 
                <%@include file="pago_ver.jsp" %>
                <%
                } else if (pagina.equals("pago_editar")) {
                %> 
                <%@include file="pago_editar.jsp" %>
                <%
                } else if (pagina.equals("pago_eliminar")) {
                %> 
                <%@include file="pago_eliminar.jsp" %>
                <%
                    }
                %>
            </div>
        </div>
    </div>
    </body>
</html>
