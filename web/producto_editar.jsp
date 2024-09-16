<%@page import="pe.edu.dao.impl.ProductoImpl"%>

<% 
    String prod= request.getParameter("producto");
    ProductoImpl a = new ProductoImpl();
    a.ver(prod);
%>
<form action="ctrlProducto" method="post">
    <input type="hidden" name="pagina" value="producto_editar">
    <div class="row">
        <br><br>
        <div class="col-sm-4">            
            Codigo <br>
            <input type="text" class="form-control" name="codigo" style="width: 90%" readonly value="<%=a.getCodigo()%>"> <br>
            Producto <br>
            <input type="text" class="form-control" name="nombre" style="width: 90%" value="<%=a.getNombre()%>">   
        </div>
        <div class="col-sm-4">
            Descripcion<br>
            <input type="text" class="form-control" name="descripcion" style="width: 90%" value="<%=a.getDescripcion()%>"> <br>       
            Cantidad<br>
            <input type="number" class="form-control" name="cantidad" style="width: 90%" value="<%=a.getCantidad()%>"><br><br>
        </div>
        <div class="col-sm-4"></div>
    </div>
        <a href="dashProd.jsp?pagina=producto_listar" class="btn btn-danger">Cancelar</a>
    <input type="submit" class="btn btn-success" value="Aceptar">
</form>