<%@page import="pe.com.upn.tablas.Pago" %>

<% 
    Integer prod= Integer.parseInt(request.getParameter("pago"));
    Pago a = new Pago();
    a=a.ver(prod);
%>
<form action="ctrlPago" method="post">
    <input type="hidden" name="pagina" value="pago_editar">
    <div class="row">
        <br><br>
        <div class="col-sm-4">            
            ID <br>
            <input type="text" class="form-control" name="codigo" readonly style="width: 90%" value="<%=a.getId_pago()%>"><br>
            DNI <br>
            <input type="text" class="form-control" name="dni" style="width: 90%" value="<%=a.getDni()%>"><br>
            Nombre <br>
            <input type="text" class="form-control" name="nombre" style="width: 90%" value="<%=a.getNombre_completo()%>">
        </div>
        <div class="col-sm-4">
            Placa<br>
            <input type="text" class="form-control" name="placa" style="width: 90%" value="<%=a.getPlaca()%>"> <br>       
            Tipo Lavado<br>
            <input type="text" class="form-control" name="tipoLavado" style="width: 90%" value="<%=a.getTipo_lavado()%>"> <br>
            Tamaña Auto<br>
            <input type="text" class="form-control" name="tamano" style="width: 90%" value="<%=a.getTamano_auto()%>"> <br>
            Precio<br>
            <input type="text" class="form-control" name="precio" style="width: 90%" value="<%=a.getPrecio()%>"> <br>
        </div>
        <div class="col-sm-4"></div>
    </div>
        <a href="dashPagos.jsp?pagina=pago_listar" class="btn btn-danger">Cancelar</a>
    <input type="submit" class="btn btn-success" value="Aceptar">
</form>