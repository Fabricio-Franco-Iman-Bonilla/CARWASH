<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login</title>
    <%@include file="referencias.jsp" %>
    
    <script src="https://www.google.com/recaptcha/api.js" async defer></script>
    <script>
        const bloqueoTiempo = 30; // en segundos
        let tiempoRestante = bloqueoTiempo;

        function mostrarError(mensaje) {
            document.getElementById('mensajeError').innerText = mensaje;
            document.getElementById('mensajeError').style.display = 'block';
        }

        function bloquearCampos() {
            document.getElementById('usuario').disabled = true;
            document.getElementById('password').disabled = true;
            document.getElementById('loginButton').disabled = true;

            mostrarError('Demasiados intentos fallidos. Espere '+ tiempoRestante+' segundos para intentar de nuevo.');

            const interval = setInterval(() => {
                tiempoRestante--;
                document.getElementById('mensajeError').innerText = 'Demasiados intentos fallidos. Espere '+ tiempoRestante+' segundos para intentar de nuevo.';

                if (tiempoRestante <= 0) {
                    clearInterval(interval);
                    desbloquearCampos();
                }
            }, 1000);
        }

        function desbloquearCampos() {
            document.getElementById('usuario').disabled = false;
            document.getElementById('password').disabled = false;
            document.getElementById('loginButton').disabled = false;
            document.getElementById('mensajeError').style.display = 'none';
            tiempoRestante = bloqueoTiempo; // Reiniciar el tiempo
        }

        function verificarBloqueo() {
            const bloqueado = '<%= request.getAttribute("bloqueado") != null ? request.getAttribute("bloqueado") : "false" %>';
            if (bloqueado === 'true') {
                bloquearCampos();
            }
        }

        window.onload = verificarBloqueo;
    </script>
</head>
<body>
    <center>
        <div style="width: 400px" class="card loginForm">
            <div id="mensajeError" style="color: red; display: none;"></div>
            <form action="ctrlUsuario" method="post">
                <img src="imagenes/Logo Mr Moon 1.png" alt="logo" width="200px"><b>MR.</b>Moon
                <h3>Login</h3><br>
                Usuario<br>
                <input type="text" id="usuario" name="usuario" class="form-control" required> <br>
                Password <br>
                <input type="password" id="password" name="password" class="form-control" required> <br><br>
                
                <!-- Google reCAPTCHA -->
                <div class="g-recaptcha" data-sitekey="6LcOQFYqAAAAAG_mlirjIXp-pcF7BsR01FPRc9fr"></div><br>
                
                <label class="form-control" onclick="window.location.href='registrarse.jsp';" style="cursor: pointer; border: none; color: rgb(100, 100, 255); text-align: right">
                    Registrarme
                </label> <br>
                <input type="submit" id="loginButton" value="Aceptar" class="btn btn-primary" style="width: 100%">
                <br><br>
                <input type="button" value="Cancelar" class="btn btn-danger" style="width: 100%" onclick="cancelar()">
                <input type="hidden" value="login" name="pagina">
                <script>
                    function cancelar() {
                        window.location.href = "indexCliente.jsp";
                    }
                </script>
            </form>

            <% 
            // Manejo de errores
            if (request.getParameter("error") != null) { 
            %>
                <script>
                    mostrarError('Usuario o Contraseña incorrectos. Por favor, intente de nuevo.');
                </script>
            <%
            } 
            %>
        </div>  
    </center>  
</body>
</html>
