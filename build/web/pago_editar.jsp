<%@page import="pe.edu.dao.impl.ComprobanteImpl"%>
<%@page import="pe.edu.dao.entity.Comprobante"%>

<% 
    Integer prod= Integer.parseInt(request.getParameter("pago"));
    Comprobante p = new Comprobante();
    ComprobanteImpl x = new ComprobanteImpl();
    p = x.ver(String.valueOf(prod));
%>
<form action="ctrlPago" method="post">
    <input type="hidden" name="pagina" value="pago_editar">
    <div class="row">
        <br><br>
        <div class="col-sm-4">            
            ID <br>
            <input type="text" class="form-control" name="codigo" readonly style="width: 90%" value="<%=p.getIdComprobante()%>"><br>
            DNI <br>
            <input type="text" class="form-control" name="dni" style="width: 90%" value="<%=p.getIdUsuario()%>"><br>
            Nombre <br>
            <input type="text" class="form-control" name="nombre" style="width: 90%" value="<%=p.getFechaEmision()%>">
        </div>
        <div class="col-sm-4">
            Placa<br>
            <input type="text" class="form-control" name="placa" style="width: 90%" value="<%=p.getMetodoPago()%>"> <br>       
            Tipo Lavado<br>
            <input type="text" class="form-control" name="tipoLavado" style="width: 90%" value="<%=p.getSubtotal()%>"> <br>
            Tamaña Auto<br>
            <input type="text" class="form-control" name="tamano" style="width: 90%" value="<%=p.getSubtotal()%>"> <br>
            Precio<br>
            <input type="text" class="form-control" name="precio" style="width: 90%" value="<%=p.getSubtotal()%>"> <br>
        </div>
        <div class="col-sm-4"></div>
    </div>
        <a href="dashPagos.jsp?pagina=pago_listar" class="btn btn-danger">Cancelar</a>
    <input type="submit" class="btn btn-success" value="Aceptar">
</form>
