<form action="cita_procesa.jsp" method="post">
    Placa <br><!-- comment -->
    <input type="text" class="form-control" name="placa" required> <br>
    Operario <br><!-- comment -->
    <input type="text" class="form-control" name="operario" required> <br><br><!-- comment -->
    Nombre Cliente <br><!-- comment -->
    <input type="text" class="form-control" name="nombreCliente" required> <br>
    Fecha <br><!-- comment -->
    <input type="text" class="form-control" name="fecha" required> <br><br><!-- comment -->
    Hora <br><!-- comment -->
    <input type="text" class="form-control" name="hora" required> <br><br><!-- comment -->
    <input type="hidden" name="pagina" value="producto_nuevo">
    <a href="dashCitas.jsp?pagina=cita_listar" class="btn btn-danger">Cancelar</a>
    <input type="submit" class="btn btn-success" value="Aceptar">
</form>