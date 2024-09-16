<%@page import="pe.edu.dao.impl.UsuarioImpl"%>

<%
    String usr = request.getParameter("usuario");
    UsuarioImpl u = new UsuarioImpl();
    u.ver(usr);
%>

<form action="ctrlUsuario" method="post">
    Id <br>
    <input type="text" class="form-control" name="usuario_id" style="width: 30%" readonly value="<%=u.getUsuario_id()%>"> <br>
    Nombre <br>
    <input type="text" class="form-control" name="usuario_nombre" style="width: 30%" readonly value="<%=u.getUsuario_nombre()%>"> <br>
    Apellido <br>
    <input type="text" class="form-control" name="usuario_apellido" style="width: 30%" readonly value="<%=u.getUsuario_apellido()%>"> <br>
    Correo <br>
    <input type="text" class="form-control" name="usuario_correo" style="width: 30%" readonly value="<%=u.getUsuario_correo()%>"> <br>
    Telefono <br>
    <input type="text" class="form-control" name="usuario_telefono" style="width: 30%" readonly value="<%=u.getUsuario_telefono()%>"> <br> 
    Nombre <br>
    <input type="text" class="form-control" name="usuario_password" style="width: 30%" readonly value="<%=u.getUsuario_password()%>"> <br>
    Nombre <br>
    <input type="text" class="form-control" name="usuario_rol" style="width: 30%" readonly value="<%=u.getUsuario_rol()%>"> <br>
    
    <input type="hidden" name="pagina" value="usuario_eliminar">
    <a href="dashboard.jsp?pagina=usuario_listar" class="btn btn-danger">Cancelar</a>
    <input type="submit" class="btn btn-success" value="Aceptar">
</form>