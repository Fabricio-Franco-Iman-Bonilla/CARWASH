<%@page import="pe.com.upn.tablas.Cita" %>

<% 
    String prod= request.getParameter("cita");
    Cita a = new Cita();
    a=a.ver(prod);
%>
<form action="ctrlCita" method="post">
    <input type="hidden" name="pagina" value="cita_editar">
    <input type="hidden" name="opcion" value="adm">
    <div class="row">
        <br><br>
        <div class="col-sm-4">            
            Codigo <br>
            <input type="text" class="form-control" name="codigo_cita" style="width: 90%" readonly value="<%=a.getCodigo()%>"> <br>
            Placa <br>
            <input type="text" class="form-control" name="placa" style="width: 90%" value="<%=a.getPlaca()%>"> <br>
            Fecha <br>
            <input type="text" class="form-control" name="fecha" style="width: 90%" value="<%=a.getFecha()%>"> <br>
            Id Usuario <br>
            <input type="text" class="form-control" name="usuario_id" style="width: 90%" value="<%=a.getUsuario_id()%>">
            
        </div>        
        <div class="col-sm-4"></div> 
    </div>
    <br>
    <a href="dashCitas.jsp?pagina=cita_listar" class="btn btn-danger">Cancelar</a>
    <input type="submit" class="btn btn-success" value="Aceptar">
</form>