<%@page import="pe.com.upn.tablas.Cita" %>

<%
    String cit = request.getParameter("cita");
    Cita c = new Cita();
    c = c.ver(cit);
%>

<form action="cita_procesa.jsp" method="post">
    Placa <br><!-- comment -->
    <input type="text" class="form-control" name="codigo" readonly value="<%=c.getPlaca()%>"> <br>
    Operario <br><!-- comment -->
    <input type="text" class="form-control" name="nombre" readonly value="<%=c.getOperario()%>"> <br><br><!-- comment -->
    Nombre Cliente <br><!-- comment -->
    <input type="text" class="form-control" name="descripcion" readonly value="<%=c.getNombreClien()%>"> <br>
    Fecha <br><!-- comment -->
    <input type="text" class="form-control" name="cantidad" readonly value="<%=c.getFecha()%>"> <br><br><!-- comment -->    
    Hora <br><!-- comment -->
    <input type="text" class="form-control" name="cantidad" readonly value="<%=c.getHora()%>"> <br><br><!-- comment -->    
    <input type="hidden" name="pagina" value="cita_eliminar">
    <a href="dashCitas.jsp?pagina=cita_listar" class="btn btn-danger">Cancelar</a>
    <input type="submit" class="btn btn-success" value="Aceptar">
</form>
