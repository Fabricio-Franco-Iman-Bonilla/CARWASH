
<%@page import="java.time.LocalTime"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="pe.edu.dao.impl.CitaImpl"%>
<%@page import="pe.com.upn.tablas.CitaInfo"%>
<%@page import="java.util.LinkedList"%>
<%@page import="java.util.LinkedList"%>
<% 
    LinkedList<CitaInfo> citInf=new LinkedList<>();
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
    <input type="hidden" name="opcion" value="usr">
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
          
    <input type="submit" class="btn btn-success" value="Aceptar">
</form>
            
<form action="dashCitasCliente.jsp?pagina=cita_lista" method="post">    
           <input type="submit" class="btn btn-danger" value="cancelar">
           
</form>
