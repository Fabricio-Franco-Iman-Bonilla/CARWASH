<%@page import="pe.edu.dao.impl.UsuarioImpl"%>

<%
    String usr = request.getParameter("usuario");
    UsuarioImpl u = new UsuarioImpl();
    u.ver(usr);
%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Eliminar Usuario</title>
    <link rel="stylesheet" href="path/to/bootstrap.css"> <!-- Cambia el path según tu configuración -->
    <style>
        body {
            background-color: #e9ecef; /* Fondo gris claro */
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; /* Tipografía moderna */
        }
        .container {
            max-width: 800px; /* Ancho máximo del contenedor */
            margin: 50px auto; /* Centrar el contenedor */
            padding: 20px;
            background-color: #ffffff; /* Fondo blanco para el contenedor */
            border-radius: 10px; /* Bordes redondeados */
            box-shadow: 0 4px 20px rgba(0, 0, 0, 0.1); /* Sombra suave */
        }
        h2 {
            text-align: center;
            margin-bottom: 30px;
            color: #343a40; /* Color de texto */
            font-weight: 600; /* Negrita para el título */
        }
        .form-group label {
            font-weight: bold; /* Negrita para las etiquetas */
            color: #495057; /* Color de texto para las etiquetas */
            font-size: 0.9rem; /* Tamaño de fuente más pequeño para las etiquetas */
        }
        .form-control {
            background-color: #f7f9fc; /* Fondo claro para los campos */
            border: 1px solid #ced4da; /* Borde suave */
            border-radius: 5px; /* Bordes redondeados */
            padding: 10px; /* Espaciado interno */
            font-size: 1rem; /* Tamaño de fuente más grande */
        }
        .form-control:disabled {
            background-color: #e9ecef; /* Fondo más oscuro para campos deshabilitados */
        }
        .btn {
            padding: 10px 20px; /* Espaciado del botón */
            border: none; /* Sin borde */
            border-radius: 5px; /* Bordes redondeados */
            font-size: 1rem; /* Tamaño de fuente del botón */
            font-weight: 600; /* Negrita en el texto del botón */
            cursor: pointer; /* Cambia el cursor al pasar sobre el botón */
            transition: all 0.3s; /* Transición suave para hover */
            margin-top: 20px; /* Espaciado superior para los botones */
            width: 100%; /* Botón ocupa todo el ancho */
        }
        .btn-success {
            background-color: #28a745; /* Color de fondo del botón */
            color: white; /* Color de texto blanco */
        }
        .btn-danger {
            background-color: #dc3545; /* Color de fondo del botón de cancelar */
            color: white; /* Color de texto blanco */
        }
        .btn-success:hover {
            background-color: #218838; /* Color más oscuro al pasar el mouse */
        }
        .btn-danger:hover {
            background-color: #c82333; /* Color más oscuro al pasar el mouse */
        }
    </style>
</head>
<body>
    <div class="container">
        <form action="ctrlUsuario" method="post">
            <h2>Eliminar Usuario</h2>

            <div class="form-group">
                <label for="usuario_id">ID</label>
                <input type="text" id="usuario_id" class="form-control" name="usuario_id" readonly value="<%=u.getUsuario_id()%>">
            </div>

            <div class="form-group">
                <label for="usuario_nombre">Nombre</label>
                <input type="text" id="usuario_nombre" class="form-control" name="usuario_nombre" readonly value="<%=u.getUsuario_nombre()%>">
            </div>

            <div class="form-group">
                <label for="usuario_apellido">Apellido</label>
                <input type="text" id="usuario_apellido" class="form-control" name="usuario_apellido" readonly value="<%=u.getUsuario_apellido()%>">
            </div>

            <div class="form-group">
                <label for="usuario_correo">Correo</label>
                <input type="text" id="usuario_correo" class="form-control" name="usuario_correo" readonly value="<%=u.getUsuario_correo()%>">
            </div>

            <div class="form-group">
                <label for="usuario_telefono">Teléfono</label>
                <input type="text" id="usuario_telefono" class="form-control" name="usuario_telefono" readonly value="<%=u.getUsuario_telefono()%>">
            </div>

            <div class="form-group">
                <label for="usuario_password">Contraseña</label>
                <input type="text" id="usuario_password" class="form-control" name="usuario_password" readonly value="<%=u.getUsuario_password()%>">
            </div>

            <div class="form-group">
                <label for="usuario_rol">Rol</label>
                <input type="text" id="usuario_rol" class="form-control" name="usuario_rol" readonly value="<%=u.getUsuario_rol()%>">
            </div>

            <input type="hidden" name="pagina" value="usuario_eliminar">
            <a href="dashboard.jsp?pagina=usuario_listar" class="btn btn-danger">Cancelar</a>
            <input type="submit" class="btn btn-success" value="Aceptar">
        </form>
    </div>
</body>
</html>
