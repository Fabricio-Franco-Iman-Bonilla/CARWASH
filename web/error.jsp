<%-- 
    Document   : error
    Created on : 3 nov 2024, 16:52:31
    Author     : Franzuá
--%>
<% 
    // Verificar si se solicitó el cierre de sesión
    if (request.getParameter("volver") != null) {
        // Invalidar la sesión
        session.invalidate();
        
        // Redirigir al usuario a la página de inicio de sesión
        response.sendRedirect("indexCliente.jsp"); // Cambia esta URL si es necesario
    }
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Acceso Denegado</title>
    <link rel="stylesheet" href="estilos/styles.css">
</head>
<body>
    <div class="container">
        <div class="content">
            <h1>Acceso Denegado</h1>
            <p>No tienes permiso para acceder a esta página.</p>
            <a href="error.jsp?volver=true" class="back-link">Volver a la página principal</a>
        </div>
    </div>
</body>
</html>

