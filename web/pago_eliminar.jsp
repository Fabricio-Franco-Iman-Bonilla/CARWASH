<%@page import="pe.edu.dao.impl.ComprobanteImpl"%>
<%@page import="pe.edu.dao.entity.Comprobante"%>

<%
    Integer prod= Integer.parseInt(request.getParameter("pago"));
    Comprobante p = new Comprobante();
    ComprobanteImpl x = new ComprobanteImpl();
    p = x.ver(String.valueOf(prod));
%>

<form action="ctrlPago" method="post">
    ID <br>
    <input type="text" class="form-control" name="codigo" style="width: 30%" readonly value="<%=p.getIdComprobante()%>"> <br>
    DNI <br>
    <input type="text" class="form-control" name="dni" style="width: 30%" readonly value="<%=p.getIdUsuario()%>"> <br>
    Nombre Apellido <br>
    <input type="text" class="form-control" name="nombre" style="width: 30%" readonly value="<%=p.getFechaEmision()%>"> <br>
    Placa <br>
    <input type="text" class="form-control" name="placa" style="width: 30%" readonly value="<%=p.getMetodoPago()%>"> <br>
    Tamaño de Auto <br>
    <input type="text" class="form-control" name="tamano" style="width: 30%" readonly value="<%=p.getSubtotal()%>"> <br>
    Tipo de Lavado <br>
    <input type="text" class="form-control" name="tipoLavado" style="width: 30%" readonly value="<%=p.getSubtotal()%>"> <br>
    Precio <br>
    <input type="text" class="form-control" name="precio" style="width: 30%" readonly value="<%=p.getSubtotal()%>"> <br><br>
    
    <input type="hidden" name="pagina" value="pago_eliminar">
    <a href="dashPagos.jsp?pagina=pago_listar" class="btn btn-danger">Cancelar</a>
    <input type="submit" class="btn btn-success" value="Aceptar">
</form>
