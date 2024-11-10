<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registro de Usuario</title>
    <link rel="stylesheet" href="path/to/bootstrap.css"> <!-- Cambia el path seg�n tu configuraci�n -->
    <script>
        function resetForm() {
            document.getElementById('usuario_usuario').value = '';
        }

        function validarFormulario() {
            const nombre = document.getElementById("usuario_nombre").value;
            const apellido = document.getElementById("usuario_apellido").value;
            const telefono = document.getElementById("usuario_telefono").value;
            const documento = document.getElementById("usuario_numDocumento").value;

            // Validaci�n de solo letras en Nombre y Apellido
            const soloLetras = /^[A-Za-z������������\s]+$/;
            if (!soloLetras.test(nombre)) {
                alert("El nombre solo debe contener letras y espacios.");
                return false;
            }
            if (!soloLetras.test(apellido)) {
                alert("El apellido solo debe contener letras y espacios.");
                return false;
            }

            // Validaci�n de 9 d�gitos en Tel�fono
            if (telefono.length !== 9 || isNaN(telefono)) {
                alert("El tel�fono debe tener exactamente 9 d�gitos num�ricos.");
                return false;
            }

            // Validaci�n de 8 d�gitos en N�mero de Documento
            if (documento.length !== 8 || isNaN(documento)) {
                alert("El n�mero de documento debe tener exactamente 8 d�gitos num�ricos.");
                return false;
            }

            return true;
        }
    </script>
</head>
<body onload="resetForm()">
    <form action="ctrlUsuario" method="post" onsubmit="return validarFormulario()"> 
        <div class="container my-5 p-4 bg-light border rounded shadow">
            <h2 class="text-center mb-4">Registro de Usuario</h2>

            <!-- Nombre: solo letras, m�ximo 255 caracteres -->
            <div class="form-group mb-3">
                <label for="usuario_nombre">Nombre</label>
                <input type="text" id="usuario_nombre" class="form-control" name="usuario_nombre" 
                       maxlength="255" required 
                       pattern="^[A-Za-z������������\s]+$" title="Solo se permiten letras y espacios">
            </div>

            <!-- Apellido: solo letras, m�ximo 255 caracteres -->
            <div class="form-group mb-3">
                <label for="usuario_apellido">Apellido</label>
                <input type="text" id="usuario_apellido" class="form-control" name="usuario_apellido" 
                       maxlength="255" required 
                       pattern="^[A-Za-z������������\s]+$" title="Solo se permiten letras y espacios">
            </div>

            <!-- Correo: formato de correo v�lido -->
            <div class="form-group mb-3">
                <label for="usuario_correo">Correo Electr�nico</label>
                <input type="email" id="usuario_correo" class="form-control" name="usuario_correo" 
                       required>
            </div>

            <!-- Tel�fono: solo n�meros, m�ximo 9 caracteres -->
            <div class="form-group mb-3">
                <label for="usuario_telefono">Tel�fono</label>
                <input type="text" id="usuario_telefono" class="form-control" name="usuario_telefono" 
                       pattern="\d{9}" title="Debe contener exactamente 9 d�gitos num�ricos" 
                       maxlength="9" required>
            </div>

            <!-- Usuario: m�ximo 100 caracteres -->
            <div class="form-group mb-3">
                <label for="usuario_usuario">Nombre de Usuario</label>
                <input type="text" id="usuario_usuario" class="form-control" name="usuario_usuario" 
                       maxlength="100" required autocomplete="off">
            </div>

            <!-- Contrase�a: m�ximo 255 caracteres -->
            <div class="form-group mb-3">
                <label for="usuario_password">Contrase�a</label>
                <input type="password" id="usuario_password" class="form-control" name="usuario_password" 
                       maxlength="255" required>
            </div>

            <!-- Rol: Cliente=1, Administrador=2 -->
            <div class="form-group mb-3">
                <label for="usuario_rol">Rol</label>
                <select id="usuario_rol" class="form-control" name="usuario_rol" required>
                    <option value="1">Cliente</option>
                    <option value="2">Administrador</option>
                </select>
            </div>

            <!-- N�mero de Documento: solo n�meros, exactamente 8 caracteres -->
            <div class="form-group mb-3">
                <label for="usuario_numDocumento">N�mero de Documento</label>
                <input type="text" id="usuario_numDocumento" class="form-control" name="usuario_numDocumento" 
                       pattern="\d{8}" title="Debe contener exactamente 8 d�gitos num�ricos" 
                       maxlength="8" required>
            </div>

            <input type="hidden" name="pagina" value="usuario_nuevo">

            <!-- Botones de acci�n -->
            <div class="text-center mt-4">
                <a href="dashboard.jsp?pagina=usuario_listar" class="btn btn-danger me-2">Cancelar</a>
                <button type="submit" class="btn btn-success">Aceptar</button>
            </div>
        </div>
    </form>
</body>
</html>
