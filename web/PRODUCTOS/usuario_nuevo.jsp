

<form action="usuario_procesa.jsp" method="post">
    Nombre <br><!-- comment -->
    <input type="text" class="form-control" name="nombre" required> <br>
    Apellido <br><!-- comment -->
    <input type="text" class="form-control" name="apellido" required> <br>
    Correo <br><!-- comment -->
    <input type="text" class="form-control" name="correo" required> <br>
    Telefono <br><!-- comment -->
    <input type="text" class="form-control" name="telefono" required> <br><br>
    <input type="hidden" name="pagina" value="usuario_nuevo">
    <a href="dashboard.jsp?pagina=usuario_listar" class="btn btn-danger">Cancelar</a>
    <input type="submit" class="btn btn-success" value="Aceptar">
</form>

