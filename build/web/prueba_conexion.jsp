<%-- 
    Document   : pruebaDB
    Created on : 20 may 2024, 1:50:58
    Author     : tokiro
--%>
<%@page import = "pe.com.upn.tools.Conexion" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Conecta Santa Rosita ...</title>
    </head>
    <body>
        <h1>
            <% 
                Conexion c = new Conexion();
                int conectado = c.pruebaConexion();
                if (conectado==1) {
                    %>
                    <h1>Conectado exitosamente</h1>
                    <%
                } else {
                    %>
                    <h1>No Conectado .. revise su codigo</h1>
                    <%
                }
            %>            
        </h1>
    </body>
</html>
