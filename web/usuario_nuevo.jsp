

<form action="ctrlUsuario" method="post">
   
    
    Nombre <br>
    <input type="text" class="form-control" name="usuario_nombre" style="width: 30%" required> <br>
    Apellido <br>
    <input type="text" class="form-control" name="usuario_apellido" style="width: 30%" required> <br>
    Correo <br>
    <input type="text" class="form-control" name="usuario_correo" style="width: 30%" required> <br>
    Telefono <br>
    <input type="text" class="form-control" name="usuario_telefono" style="width: 30%" required> <br>
    Usuario <br>
    <input type="text" class="form-control" name="usuario_usuario" style="width: 30%" required> <br>
    Contraseña <br>
    <input type="text" class="form-control" name="usuario_password" style="width: 30%" required> <br>
    Rol <br>
    <input type="text" class="form-control" name="usuario_rol" style="width: 30%" required> <br>
    
    <input type="hidden" name="pagina" value="usuario_nuevo">
    
    <a href="dashboard.jsp?pagina=usuario_listar" class="btn btn-danger">Cancelar</a>
    <input type="submit" class="btn btn-success" value="Aceptar">
</form>

