
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
                <%@include file="menu_cliente.jsp"%>
            </div>        
            <div class="col-sm-10 contenido">

                <h2 style="text-align: center; padding-top: 50px">Usuario</h2>
                
                <%
                    String pagina = "";

                    if (request.getParameter("pagina") != null) {
                        pagina = request.getParameter("pagina");
                    }

                    if (pagina.equals("cita_listar")) {
                %>
                <%@include file="cita_listarCliente.jsp" %>
                <%                
                    } else if (pagina.equals("cita_nuevo")) {
                %>
                <%@include file="cita_nuevoCliente.jsp" %>
                <%
                } else if (pagina.equals("cita_ver")) {
                %> 
                <%@include file="cita_verCliente.jsp" %>
                <%
                } else if (pagina.equals("cita_editar")) {
                %> 
                <%@include file="cita_editarCliente.jsp" %>
                <%
                } else if (pagina.equals("cita_eliminar")) {
                %> 
                <%@include file="cita_eliminar.jsp" %>
                <%
                    }
                %>
            </div>
        </div>
    </div>
</body>
</html>