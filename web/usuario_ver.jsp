<%@page import="pe.edu.dao.impl.UsuarioImpl"%>

<%
    String usr = request.getParameter("usuario");
    UsuarioImpl u = new UsuarioImpl();
    u.ver(usr);
%>

<form action="dashboard.jsp?pagina=usuario_listar" method="post">
    ID <br>
    <input type="text" class="form-control" name="usuario_id" style="width: 30%" readonly value="<%=u.getUsuario_id()%>"> <br>
    Nombre <br>
    <input type="text" class="form-control" name="usuario_nombre" style="width: 30%" readonly value="<%=u.getUsuario_nombre()%>"> <br>
    Apellido <br>
    <input type="text" class="form-control" name="usuario_apellido" style="width: 30%" readonly value="<%=u.getUsuario_apellido()%>"> <br>
    Correo <br>
    <input type="text" class="form-control" name="usuario_correo" style="width: 30%" readonly value="<%=u.getUsuario_correo()%>"> <br>
    Telefono <br>
    <input type="text" class="form-control" name="usuario_telefono" style="width: 30%" readonly value="<%=u.getUsuario_telefono()%>"> <br>
    Contraseña <br>
    <input type="text" class="form-control" name="usuario_contraseña" style="width: 30%" readonly value="<%=u.getUsuario_password()%>"> <br>
    Rol <br>
    <input type="text" class="form-control" name="usuario_rol" style="width: 30%" readonly value="<%=u.getUsuario_rol()%>"> <br><br>  
    
    <input type="submit" class="btn btn-success" value="Aceptar">
</form>
