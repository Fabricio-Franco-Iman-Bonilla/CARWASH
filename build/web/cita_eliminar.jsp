<%@page import="pe.com.upn.tablas.Cita" %>

<%
    String cit = request.getParameter("cita");
    Cita c = new Cita();
    c = c.ver(cit);
%>

<form action="ctrlCita" method="post">
    
    Codigo <br>
    <input type="text" class="form-control" name="codigo_cita" style="width: 30%" readonly value="<%=c.getCodigo()%>"> <br>
    Placa <br>
    <input type="text" class="form-control" name="placa" style="width: 30%" readonly value="<%=c.getPlaca()%>"> <br>
    Fecha <br>
    <input type="text" class="form-control" name="fecha" style="width: 30%" readonly value="<%=c.getFecha()%>"> <br> 
    ID Usuario <br>
    <input type="text" class="form-control" name="usuario_id" style="width: 30%" readonly value="<%=c.getUsuario_id()%>"> <br>

    <input type="hidden" name="pagina" value="cita_eliminar">
    <a href="dashCitas.jsp?pagina=cita_listar" class="btn btn-danger">Cancelar</a>
    <input type="submit" class="btn btn-success" value="Aceptar">
</form>
