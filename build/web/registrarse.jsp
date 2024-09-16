<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <link rel="stylesheet" href="estilos/registro.css">
        <title>Registro</title>
    </head>
    <body>    
        <div class="register-container">
            <form action="register" method="post">
                <img src="imagenes/Logo Mr Moon 1.png" alt="logo" width="200px">
                <h3>Registrate</h3>            
                Nombre<br>
                <input type="text" class="form-control" name="usuario_nombre" required><br>
                Apellido<br>
                <input type="text" class="form-control" name="usuario_apellido" required> <br>
                Correo <br><!-- comment -->
                <input type="text" class="form-control" name="usuario_correo" required> <br>
                Telefono <br><!-- comment -->
                <input type="text" class="form-control" name="usuario_telefono" required><br>
                Contraseña <br><!-- comment -->
                <input type="text" class="form-control" name="usuario_password" required>                
                <br>
                <input type="submit" value="Aceptar" class="btn btn-primary" style="width: 100%">
                <br><br>
                <input type="button" value="Cancelar" class="btn btn-danger" style="width: 100%"
                       onclick="window.location.href = 'login.jsp'">                
            </form>
        </div>
</body>
</html>
