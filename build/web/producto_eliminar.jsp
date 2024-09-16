<%@page import="pe.edu.dao.impl.ProductoImpl"%>

<%
    String prd = request.getParameter("producto");
    ProductoImpl p = new ProductoImpl();
    p.ver(prd);
%>

<form action="ctrlProducto" method="post">
    Codigo <br>
    <input type="text" class="form-control" name="codigo" style="width: 30%" readonly value="<%=p.getCodigo()%>"> <br>
    Nombre <br>
    <input type="text" class="form-control" name="nombre" style="width: 30%" readonly value="<%=p.getNombre()%>"> <br>
    Descripcion <br>
    <input type="text" class="form-control" name="descripcion" style="width: 30%" readonly value="<%=p.getDescripcion()%>"> <br>
    Cantidad <br>
    <input type="text" class="form-control" name="cantidad" style="width: 30%" readonly value="<%=p.getCantidad()%>"> <br><br><!-- comment -->    
    <input type="hidden" name="pagina" value="producto_eliminar">
    <a href="dashProd.jsp?pagina=producto_listar" class="btn btn-danger">Cancelar</a>
    <input type="submit" class="btn btn-success" value="Aceptar">
</form>