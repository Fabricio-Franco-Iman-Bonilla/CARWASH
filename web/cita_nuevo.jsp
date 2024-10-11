

<form action="ctrlCita" method="post">
    
    <input type="hidden" name="pagina" value="cita_nuevo">
    <input type="hidden" name="opcion" value="adm">
    
    Codigo <br>    
    <input type="text" class="form-control" name="codigo_cita" style="width: 30%" required> <br>
    Placa <br>
    <input type="text" class="form-control" name="placa" style="width: 30%" required> <br>    
    Fecha <br>
    <input type="date" class="form-control" name="fecha" style="width: 30%" required> <br>    
    ID Usuario<br>
    <input type="text" class="form-control" name="usuario_id" style="width: 30%" required> <br><br>
    
    <input type="hidden" name="pagina" value="cita_nuevo">
    
    <a href="dashCitas.jsp?pagina=cita_listar" class="btn btn-danger">Cancelar</a>
    
    <input type="submit" class="btn btn-success" value="Aceptar">
</form>
