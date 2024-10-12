<%@page import="java.time.LocalTime"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.util.LinkedList"%>
<%@page import="pe.com.upn.tablas.CitaInfo"%>
<%@page import="pe.edu.dao.impl.CitaImpl"%>

<% 
    
    CitaInfo cit1 =new CitaInfo();
    String prod= request.getParameter("cita");
    CitaImpl a = new CitaImpl();
    a.ver(prod);
    
    cit1=a.listar3(String.valueOf(a.getId()));
    LocalDateTime horario = cit1.getHorario();
    LocalDate fecha = horario.toLocalDate();  // Obtener solo la fecha
    LocalTime hora = horario.toLocalTime();   // Obtener solo la hora
    
%>
<form action="ctrlCita" method="post">
    <input type="hidden" name="pagina" value="cita_editar">
    <input type="hidden" name="opcion" value="adm">
    <div class="row">
        <br><br>
        <div class="col-sm-4">            
            Codigo <br>
            <input type="text" class="form-control" name="codigo_cita" style="width: 90%" readonly value="<%=cit1.getIdCita()%>"> <br>
            Placa <br>
            <input type="text" class="form-control" name="placa" style="width: 90%" value="<%=cit1.getPlaca()%>"> <br>
            Fecha <br>
            <input type="date" class="form-control" name="fecha"  style="width: 90%"  value="<%=fecha%>"> <br>
            Hora <br>
            <input type="time" class="form-control" name="hora" style="width: 90%"  value="<%=hora%>"> <br>
            Id Usuario <br>
            <input type="text" class="form-control" name="usuario_id" style="width: 90%" value="<%=cit1.getIdUsuario()%>">
            ID Vehiculo<br>
            <input type="text" class="form-control" name="idVehiculo" style="width: 100%" value="<%=cit1.getIdUsuario()%>"> <br><br>
            
        </div>        
        <div class="col-sm-4"></div> 
    </div>
    <br>
    <a href="dashCitas.jsp?pagina=cita_listar" class="btn btn-danger">Cancelar</a>
    <input type="submit" class="btn btn-success" value="Aceptar">
</form>
            
//Commit Andre//
