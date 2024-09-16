<%@page import="pe.com.upn.tablas.Usuario" %>

<%
    String usr = request.getParameter("usuario");
    Usuario u = new Usuario();
    u = u.ver(usr);
%>

<form action="usuario_procesa.jsp" method="post">
    Usuario <br><!-- comment -->
    <input type="text" class="form-control" name="usuario" readonly value="<%=u.getUsuario()%>"> <br>
    Password <br><!-- comment -->
    <input type="text" class="form-control" name="password" readonly value="<%=u.getPassword()%>"> <br><br><!-- comment -->    
    <input type="hidden" name="pagina" value="usuario_eliminar">
    <a href="dashboard.jsp?pagina=USUARIOS/usuario_listar" class="btn btn-danger">Cancelar</a>
    <input type="submit" class="btn btn-success" value="Aceptar">
</form>