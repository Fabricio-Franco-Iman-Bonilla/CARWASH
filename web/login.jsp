<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <%@include file="referencias.jsp" %>
        
        <!-- Incluir la librería de Google reCAPTCHA -->
    <script src="https://www.google.com/recaptcha/api.js" async defer></script>
    </head>
    <body>
    <center>
        <div style="width: 400px" class="card loginForm">
            <form action="ctrlUsuario" method="post">                
                <img src="imagenes/Logo Mr Moon 1.png" alt="logo" width="200px"><b>MR.</b>Moon</a>
                <h3>Login</h3><br>
                Usuario<br>
                <input type="text" name="usuario" class="form-control" required> <br>
                Password <br>
                <input  type="password" name="password"  class="form-control" required> <br><br>
                
                 <!-- Google reCAPTCHA -->
                <div style="margin: 20dp;"class="g-recaptcha" data-sitekey="6LcOQFYqAAAAAG_mlirjIXp-pcF7BsR01FPRc9fr"></div><br>
                
                
                <label class="form-control" onclick="window.location.href='registrarse.jsp';
                       " style="cursor: pointer; border: none; color: rgb(100, 100, 255); text-align: right">
                        Registrarme</label> <br>
                <input type="submit" value="Aceptar"  class="btn btn-primary" style="width: 100%" >
                <br><br>
                <input type="button" value="Cancelar" class="btn btn-danger" style="width: 100%" 
                       onclick="cancelar()">
                <input type="hidden" value="login" name="pagina">
                <script>
                    function cancelar() {
                        // Redirigir a la página deseada
                        window.location.href = "indexCliente.jsp";
                    }
                </script>
                
            </form>
        </div>  
    </center>  
</body>
</html>
