<%@page import="pe.com.upn.tablas.Pago" %>

<%
    Integer prod= Integer.parseInt(request.getParameter("pago"));
    Pago p = new Pago();
    p = p.ver(prod);
%>

<form action="ctrlPago" method="post">
    ID <br>
    <input type="text" class="form-control" name="codigo" style="width: 30%" readonly value="<%=p.getId_pago()%>"> <br>
    DNI <br>
    <input type="text" class="form-control" name="dni" style="width: 30%" readonly value="<%=p.getDni()%>"> <br>
    Nombre Apellido <br>
    <input type="text" class="form-control" name="nombre" style="width: 30%" readonly value="<%=p.getNombre_completo()%>"> <br>
    Placa <br>
    <input type="text" class="form-control" name="placa" style="width: 30%" readonly value="<%=p.getPlaca()%>"> <br>
    Tamaño de Auto <br>
    <input type="text" class="form-control" name="tamano" style="width: 30%" readonly value="<%=p.getTamano_auto()%>"> <br>
    Tipo de Lavado <br>
    <input type="text" class="form-control" name="tipoLavado" style="width: 30%" readonly value="<%=p.getTipo_lavado()%>"> <br>
    Precio <br>
    <input type="text" class="form-control" name="precio" style="width: 30%" readonly value="<%=p.getPrecio()%>"> <br><br>
    
    <input type="hidden" name="pagina" value="pago_eliminar">
    <a href="dashPagos.jsp?pagina=pago_listar" class="btn btn-danger">Cancelar</a>
    <input type="submit" class="btn btn-success" value="Aceptar">
</form>