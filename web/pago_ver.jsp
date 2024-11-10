<%@page import="pe.edu.dao.entity.Comprobante"%>
<%@page import="pe.edu.dao.impl.ComprobanteImpl"%>

<%
    Integer prod= Integer.parseInt(request.getParameter("pago"));
    Comprobante p = new Comprobante();
    ComprobanteImpl x = new ComprobanteImpl();
    p = x.ver(String.valueOf(prod));
%>

<form action="dashPagos.jsp?pagina=pago_listar" method="post">
    Codigo Factura <br>
    <input type="text" class="form-control" name="codigo" style="width: 30%" readonly value="<%=p.getIdComprobante()%>"> <br>
    DNI <br>
    <input type="text" class="form-control" name="dni" style="width: 30%" readonly value="<%=p.getIdUsuario()%>"> <br>
    Nombre <br>
    <input type="text" class="form-control" name="nombre" style="width: 30%" readonly value="<%=p.getFechaEmision()%>"> <br>
    PLACA <br>
    <input type="text" class="form-control" name="placa" style="width: 30%" readonly value="<%=p.getMetodoPago()%>"> <br>
    TIPO LAVADO <br>
    <input type="text" class="form-control" name="tipoLavado" style="width: 30%" readonly value="<%=p.getSubtotal()%>"> <br>
    TAMANO <br>
    <input type="text" class="form-control" name="tamano" style="width: 30%" readonly value="<%=p.getSubtotal()%>"> <br> 
    PRECIO <br>
    <input type="text" class="form-control" name="precio" style="width: 30%" readonly value="<%=p.getSubtotal()%>"> <br><br> 
    <input type="submit" class="btn btn-success" value="Aceptar">
</form>
