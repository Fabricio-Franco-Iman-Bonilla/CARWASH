<%-- 
    Document   : usuario_editar
    Created on : 25 may. 2024, 12:37:34
    Author     : Estudiante
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar</title>
    </head>
    <body>
        <h1>Editar usuario</h1>
        <form action="usuario_procesa.jsp" method="post">
            Nombre <br><!-- comment -->
            <input type="text" class="form-control" name="nombre" required> <br>
            Apellido <br><!-- comment -->
            <input type="text" class="form-control" name="apellido" required> <br>
            Correo <br><!-- comment -->
            <input type="text" class="form-control" name="correo" required> <br>
            Telefono <br><!-- comment -->
            <input type="text" class="form-control" name="telefono" required> <br><br>
            <input type="hidden" name="pagina" value="usuario_editar">
            <a href="dashboard.jsp?pagina=usuario_listar" class="btn btn-danger">Cancelar</a>
            
            <input type="submit" value="Editar">
        </form>
    </body>
</html>