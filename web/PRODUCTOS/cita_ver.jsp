<%@page import="pe.com.upn.tablas.Cita" %>

<%
    String cit = request.getParameter("cita"); //varia siempre para el tipo de devolucion 
    Cita p = new Cita();
    p = p.ver(cit);
%>

<form action="dashCita.jsp?pagina=cita_listar" method="post">
    Placa <br><!-- comment -->
    <input type="text" class="form-control" name="plac" readonly value="<%=p.getPlaca()%>"> <br>
    Operario <br><!-- comment -->
    <input type="text" class="form-control" name="operario" readonly value="<%=p.getOperario()%>"> <br><br><!-- comment -->
    Nombre Cliente <br><!-- comment -->
    <input type="text" class="form-control" name="nombreCliente" readonly value="<%=p.getNombreClien()%>"> <br><br>
    Fecha <br><!-- comment -->
    <input type="text" class="form-control" name="fecha" readonly value="<%=p.getFecha()%>"> <br><br><!-- comment -->    
    Hora <br><!-- comment -->
    <input type="text" class="form-control" name="hora" readonly value="<%=p.getHora()%>"> <br><br><!-- comment -->    
    <input type="submit" class="btn btn-success" value="Aceptar">
</form>