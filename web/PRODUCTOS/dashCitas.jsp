<%-- 
    Document   : dashCitas
    Created on : 1/06/2024, 7:57:48 a. m.
    Author     : MIKI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Citas</title>
        <%@include file="referencias.jsp" %>
    </head>
    <body>
        <div class="row">
            <div class="col-sm-2 menu">
                <%@include file="menu.jsp"%>
            </div>        
            <div class="col-sm-10 contenido">
                <nav class="navbar navbar-light bg-light">
                    <div class="container-fluid">
                        <a class="navbar-brand">Admin</a>
                        <form class="d-flex">
                            <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                            <button class="btn btn-outline-success" type="submit">Buscar</button>
                        </form>
                    </div>
                </nav>
                <%
                    String pagina = "";

                    if (request.getParameter("pagina") != null) {
                        pagina = request.getParameter("pagina");
                    }

                    if (pagina.equals("cita_listar")) {
                %>
                <%@include file="cita_listar.jsp" %>
                <%                
                    } else if (pagina.equals("cita_nuevo")) {
                %>
                <%@include file="cita_nuevo.jsp" %>
                <%
                } else if (pagina.equals("cita_ver")) {
                %> 
                <%@include file="cita_ver.jsp" %>
                <%
                } else if (pagina.equals("cita_editar")) {
                %> 
                <%@include file="cita_editar.jsp" %>
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
