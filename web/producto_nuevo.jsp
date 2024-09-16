
<form action="ctrlProducto" method="post">
    Codigo <br>
    <input type="text" class="form-control" name="codigo" style="width: 30%" required> <br>
    Nombre <br>
    <input type="text" class="form-control" name="nombre" style="width: 30%" required> <br>
    Descripcion <br>
    <input type="text" class="form-control" name="descripcion" style="width: 30%" required> <br>
    Cantidad <br>
    <input type="text" class="form-control" name="cantidad" style="width: 30%" required> <br><br>
    <input type="hidden" name="pagina" value="producto_nuevo">
    <a href="dashProd.jsp?pagina=producto_listar" class="btn btn-danger">Cancelar</a>
    <input type="submit" class="btn btn-success" value="Aceptar">
</form>