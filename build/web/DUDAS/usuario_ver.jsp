<%@page import="pe.com.upn.tablas.Usuario" %>

<%
    String usr = request.getParameter("usuario");
    Usuario u = new Usuario();
    u = u.ver(usr);
%>

<form action="dashboard.jsp?pagina=usuario_listar" method="post">
    Usuario <br><!-- comment -->
    <input type="text" class="form-control" name="usuario" readonly value="<%=u.getUsuario()%>"> <br>
    Password <br><!-- comment -->
    <input type="text" class="form-control" name="password" readonly value="<%=u.getPassword()%>"> <br><br><!-- comment -->    
    <input type="submit" class="btn btn-success" value="Aceptar">
</form>
