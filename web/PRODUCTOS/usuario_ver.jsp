<%@page import="pe.com.upn.tablas.Clientes" %>

<%
    String usr = request.getParameter("usuario");
    Clientes u = new Clientes();
    u = u.ver(usr);
%>

<form action="dashboard.jsp?pagina=usuario_listar" method="post">
    Nombre <br><!-- comment -->
    <input type="text" class="form-control" name="nombre" readonly value="<%=u.getNombre()%>"> <br>
    Apellido <br><!-- comment -->
    <input type="text" class="form-control" name="apellido" readonly value="<%=u.getApellido()%>"> <br>
    Correo <br><!-- comment -->
    <input type="text" class="form-control" name="correo" readonly value="<%=u.getCorreo()%>"> <br>
    Telefono <br><!-- comment -->
    <input type="text" class="form-control" name="telefono" readonly value="<%=u.getTelefono()%>"> <br><br>  
    <input type="submit" class="btn btn-success" value="Aceptar">
</form>
