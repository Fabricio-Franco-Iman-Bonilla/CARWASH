<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registro de Usuario</title>
    <link rel="stylesheet" href="path/to/bootstrap.css"> <!-- Cambia el path según tu configuración -->
    <script>
        window.onload = function() {
            document.getElementById('usuario_usuario').value = '';
        };

    </script>
</head>
<body onload="resetForm()">
    <form action="ctrlUsuario" method="post"> 
        <div style="max-width: 600px; margin: auto; padding: 20px; background-color: #f9f9f9; border-radius: 8px; box-shadow: 0 0 15px rgba(0,0,0,0.1);">
            <h2 style="text-align: center; margin-bottom: 20px;">Registro de Usuario</h2>

            <!-- Nombre: solo letras, máximo 255 caracteres -->
            <div class="form-group">
                <label for="usuario_nombre">Nombre</label>
                <input type="text" id="usuario_nombre" class="form-control" name="usuario_nombre" 
                       style="width: 100%" maxlength="255" 
                       oninput="this.value = this.value.replace(/[^A-Za-zÁÉÍÓÚáéíóúÑñ\s]/g, '')" required>
            </div>

            <!-- Apellido: solo letras, máximo 255 caracteres -->
            <div class="form-group">
                <label for="usuario_apellido">Apellido</label>
                <input type="text" id="usuario_apellido" class="form-control" name="usuario_apellido" 
                       style="width: 100%" maxlength="255" 
                       oninput="this.value = this.value.replace(/[^A-Za-zÁÉÍÓÚáéíóúÑñ\s]/g, '')" required>
            </div>

            <!-- Correo: formato de correo válido -->
            <div class="form-group">
                <label for="usuario_correo">Correo Electrónico</label>
                <input type="email" id="usuario_correo" class="form-control" name="usuario_correo" 
                       style="width: 100%" required>
            </div>

            <!-- Teléfono: solo números, máximo 9 caracteres -->
            <div class="form-group">
                <label for="usuario_telefono">Teléfono</label>
                <input type="text" id="usuario_telefono" class="form-control" name="usuario_telefono" 
                       pattern="\d{9}" title="Solo números permitidos" maxlength="9" 
                       style="width: 100%" required 
                       oninput="this.value = this.value.replace(/[^0-9]/g, '')">
            </div>


            <!-- Usuario: máximo 255 caracteres -->
            <div class="form-group">
                <label for="usuario_usuario">Nombre de Usuario</label>
                <input type="text" id="usuario_usuario" class="form-control" name="usuario_usuario" 
                       maxlength="100" style="width: 100%" required value=" " autocomplete="">
            </div>
    
            <!-- Contraseña: máximo 255 caracteres -->
            <div class="form-group">
                <label for="usuario_password">Contraseña</label>
                <input type="password" id="usuario_password" class="form-control" name="usuario_password" 
                       maxlength="255" style="width: 100%" required value="" autocomplete="">
            </div>

            <!-- Rol: Cliente=1, Administrador=2 -->
            <div class="form-group">
                <label for="usuario_rol">Rol</label>
                <select id="usuario_rol" class="form-control" name="usuario_rol" style="width: 100%" required>
                    <option value="1">Cliente</option>
                    <option value="2">Administrador</option>
                </select>
            </div>

            <!-- Número de Documento: solo números, exactamente 8 caracteres -->
            <div class="form-group">
                <label for="usuario_numDocumento">Número de Documento</label>
                <input type="text" id="usuario_numDocumento" class="form-control" name="usuario_numDocumento" 
                       pattern="\d{8}" title="Debe contener exactamente 8 dígitos" maxlength="8" 
                       style="width: 100%" required 
                       oninput="this.value = this.value.replace(/[^0-9]/g, '')">
            </div>

            <input type="hidden" name="pagina" value="usuario_nuevo">
            
            <!-- Botones de acción -->
            <div style="text-align: center; margin-top: 20px;">
                <a href="dashboard.jsp?pagina=usuario_listar" class="btn btn-danger" 
                   style="margin-right: 10px; padding: 10px 20px;">Cancelar</a>
                <input type="submit" class="btn btn-success" value="Aceptar" 
                       style="padding: 10px 20px;">
            </div>
        </div>
    </form>
</body>
</html>
