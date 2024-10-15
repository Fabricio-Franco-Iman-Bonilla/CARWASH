<%@page import="pe.edu.dao.impl.UsuarioImpl"%>

<% 
    String usua= request.getParameter("usuario");
    UsuarioImpl a = new UsuarioImpl();
    a.ver(usua);
%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Editar Usuario</title>
    <link rel="stylesheet" href="path/to/bootstrap.css"> <!-- Cambia el path según tu configuración -->
    <style>
        body {
            background-color: #f8f9fa;
        }
        .form-container {
            max-width: 600px;
            margin: auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.1);
        }
    </style>
</head>
<body>
    <div class="form-container">
        <h2 class="text-center mb-4">Editar Usuario</h2>
        <form action="ctrlUsuario" method="post">
            <input type="hidden" name="pagina" value="usuario_editar">

            <div class="form-group">
                <label for="usuario_id">ID</label>
                <input type="text" class="form-control" name="usuario_id" readonly value="<%=a.getUsuario_id()%>">
            </div>

            <div class="form-group">
                <label for="usuario_nombre">Nombre</label>
                <input type="text" class="form-control" name="usuario_nombre" required maxlength="255" 
                       value="<%=a.getUsuario_nombre()%>" 
                       oninput="this.value = this.value.replace(/[^A-Za-zÁÉÍÓÚáéíóúÑñ\s]/g, '')">
            </div>

            <div class="form-group">
                <label for="usuario_apellido">Apellido</label>
                <input type="text" class="form-control" name="usuario_apellido" required maxlength="255" 
                       value="<%=a.getUsuario_apellido()%>" 
                       oninput="this.value = this.value.replace(/[^A-Za-zÁÉÍÓÚáéíóúÑñ\s]/g, '')">
            </div>

            <div class="form-group">
                <label for="usuario_correo">Correo Electrónico</label>
                <input type="email" class="form-control" name="usuario_correo" required 
                       value="<%=a.getUsuario_correo()%>">
            </div>

            <div class="form-group">
                <label for="usuario_telefono">Teléfono</label>
                <input type="text" class="form-control" name="usuario_telefono" required maxlength="9" 
                       value="<%=a.getUsuario_telefono()%>" 
                       oninput="this.value = this.value.replace(/[^0-9]/g, '')">
            </div>

            <div class="form-group">
                <label for="usuario_usuario">Nombre de Usuario</label>
                <input type="text" class="form-control" name="usuario_usuario" required maxlength="100" 
                       value="<%=a.getUsuario_usuario()%>" autocomplete="off">
            </div>

            <div class="form-group">
                <label for="usuario_password">Contraseña</label>
                <input type="password" class="form-control" name="usuario_password" required 
                       value="<%=a.getUsuario_password()%>" autocomplete="off">
            </div>

            <div class="form-group">
                <label for="usuario_rol">Rol</label>
                <select id="usuario_rol" class="form-control" name="usuario_rol" required>
                    <option value="1" <%= a.getUsuario_rol() == 1 ? "selected" : "" %>>Cliente</option>
                    <option value="2" <%= a.getUsuario_rol() == 2 ? "selected" : "" %>>Administrador</option>
                </select>
            </div>

            <div class="text-center mt-4">
                <a href="dashboard.jsp?pagina=usuario_listar" class="btn btn-danger me-2">Cancelar</a>
                <input type="submit" class="btn btn-success" value="Aceptar">
            </div>
        </form>
    </div>
</body>
</html>
