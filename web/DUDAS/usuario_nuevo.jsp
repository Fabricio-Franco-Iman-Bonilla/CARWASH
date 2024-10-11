<form action="usuario_procesa.jsp" method="post">
    Nombres <br><!-- comment -->
    <input type="text" class="form-control" name="usuario" required> <br>
    Telefono <br><!-- comment -->
    <input type="text" class="form-control" name="password" required> <br><br><!-- comment -->
    <input type="hidden" name="pagina" value="usuario_nuevo">
    <a href="dashboard.jsp?pagina=usuario_listar" class="btn btn-danger">Cancelar</a>
    <input type="submit" class="btn btn-success" value="Aceptar">
</form>

