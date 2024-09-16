<%@page import="pe.com.upn.tablas.Pago" %>

<%
    Integer prod= Integer.parseInt(request.getParameter("pago"));
    Pago p = new Pago();
    p = p.ver(prod);
%>

<form action="dashPagos.jsp?pagina=pago_listar" method="post">
    Codigo Factura <br>
    <input type="text" class="form-control" name="codigo" style="width: 30%" readonly value="<%=p.getId_pago()%>"> <br>
    DNI <br>
    <input type="text" class="form-control" name="dni" style="width: 30%" readonly value="<%=p.getDni()%>"> <br>
    Nombre <br>
    <input type="text" class="form-control" name="nombre" style="width: 30%" readonly value="<%=p.getNombre_completo()%>"> <br>
    PLACA <br>
    <input type="text" class="form-control" name="placa" style="width: 30%" readonly value="<%=p.getPlaca()%>"> <br>
    TIPO LAVADO <br>
    <input type="text" class="form-control" name="tipoLavado" style="width: 30%" readonly value="<%=p.getTipo_lavado()%>"> <br>
    TAMANO <br>
    <input type="text" class="form-control" name="tamano" style="width: 30%" readonly value="<%=p.getTamano_auto()%>"> <br> 
    PRECIO <br>
    <input type="text" class="form-control" name="precio" style="width: 30%" readonly value="<%=p.getPrecio()%>"> <br><br> 
    <input type="submit" class="btn btn-success" value="Aceptar">
</form>