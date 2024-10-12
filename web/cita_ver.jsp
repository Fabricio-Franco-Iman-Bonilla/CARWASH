
<%@page import="java.time.LocalTime"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="pe.com.upn.tablas.CitaInfo"%>
<%@page import="pe.edu.dao.impl.CitaImpl"%>
<%@page import="pe.edu.dao.entity.Cita"%>
<%@page import="java.util.LinkedList" %>
<%@include file="referencias.jsp" %>
<%
    String x = request.getParameter("ver_cita");
    String z = request.getParameter("ver_cita2");
    
    CitaImpl cit = new CitaImpl();
    CitaInfo citi= new CitaInfo();
    citi = cit.listar3(z);
    
    LocalDateTime horario = citi.getHorario();
    LocalDate fecha = horario.toLocalDate();  // Obtener solo la fecha
    LocalTime hora = horario.toLocalTime();   // Obtener solo la hora
    

    
    
%>

<div class="row">
    <div class="col-sm-2 menu" style="background-color: #33B3FF">
        <br>
<%@include file="menu.jsp"%>
    </div>     

    <div class="col-sm-3 contenido">

        <h2 style="text-align: center; padding-top: 50px">Administrador</h2>

        <form action="dashCitas.jsp?pagina=cita_listar" method="post">
            
            <div>
                Codigo <br>
                <input type="text" class="form-control" name="codigo_cita" style="width: 100%" readonly value="<%=z%>"> <br>
                Placa <br>
                <input type="text" class="form-control" name="placa" readonly style="width: 100%"  value="<%=citi.getPlaca()%>"> <br>
                Fecha <br>
                <input type="date" class="form-control" name="fecha" readonly style="width: 100%"  value="<%=fecha%>"> <br>
                Hora <br>
                <input type="time" class="form-control" name="hora" readonly style="width: 100%"  value="<%=hora%>"> <br>
                ID Usuario <br>
                <input type="text" class="form-control" name="usuario_id" readonly style="width: 100%"  value="<%=citi.getIdUsuario()%>"> <br>
                 ID Vehiculo<br>
                <input type="text" class="form-control" name="idVehiculo" readonly style="width: 100%" value="<%=citi.getIdCita()%>"> <br><br>
                Nombre <br>
                <input type="text" class="form-control" name="usuario_nombre" readonly style="width: 100%"  value="<%=citi.getNombre()%>"> <br>
                Apellido <br>
                <input type="text" class="form-control" name="usuario_apellido" readonly style="width: 100%" value="<%=citi.getApellido()%>"> <br><br>
            </div>
            
            <a href="dashCitas.jsp?pagina=cita_listar" class="btn btn-success">Aceptar</a>
        </form>
    </div>

    <div class="col-sm-7 contenido">
        <center style="margin-top: 80px">
            <img src="imagenes/OIG4.png" alt="logo" width="700px" >
        </center>
    </div>
</div>

