<%@page import="pe.com.upn.tablas.Cita" %>

<% 
    String prod= request.getParameter("cita");
    Cita a = new Cita();
    a=a.ver(prod);
%>
<form action="ctrlCita" method="post">
    <input type="hidden" name="pagina" value="cita_editar">
    <input type="hidden" name="opcion" value="usr">
    <div class="row">
        <br><br>
        <div class="col-sm-4">            
            Codigo <br><!-- comment -->
            <input type="text" class="form-control" name="codigo_cita" style="width: 90%" readonly value="<%=a.getCodigo()%>"> <br>
            Placa <br><!-- comment -->
            <input type="text" class="form-control" name="placa" style="width: 90%" value="<%=a.getPlaca()%>"><!-- comment --> 
            Fecha <br><!-- comment -->
            <input type="text" class="form-control" name="fecha" style="width: 90%" value="<%=a.getFecha()%>"><!-- comment --> 
            Id Usuario <br><!-- comment -->
            <input type="text" class="form-control" name="usuario_id" style="width: 90%" value="<%=a.getUsuario_id()%>"><!-- comment --> 
            
        </div>
        
        <div class="col-sm-4"></div>
    </div>
          
    <input type="submit" class="btn btn-success" value="Aceptar">
</form>
            
<form action="dashCitasCliente.jsp?pagina=cita_lista" method="post">    
           <input type="submit" class="btn btn-danger" value="cancelar">
           
</form>