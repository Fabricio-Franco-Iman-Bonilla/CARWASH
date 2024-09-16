<%@page import="pe.edu.dao.entity.Usuario"%>
<%@page import="pe.edu.dao.impl.UsuarioImpl"%>

<%@page import="java.util.LinkedList" %>

<%
    UsuarioImpl usr = new UsuarioImpl();
    LinkedList<Usuario> lista = new LinkedList<>();
    lista = usr.listar();
%>

<br>
<h3>Usuarios</h3><br>
<a href="dashboard.jsp?pagina=usuario_nuevo" class="btn btn-primary" style="width: 150px">Nuevo Usuario</a><br><br>
<table id="myTable" class="display">
    <thead>
        <tr>
            <th>Id</th>
            <th>Nombre</th>
            <th>Apellido</th>
            <th>Correo</th>
            <th>Telefono</th>
            <th>Contraseña</th>
            <th>Rol</th>
            
            <th>Ver</th>
            <th>Editar</th>
            <th>Eliminar</th>
        </tr>
    </thead>
    <tbody>
        <%
            for (Usuario ux : lista) {
        %>        
        <tr>
            <td>
                <%= ux.getUsuario_id()%>
            </td>
            <td>
                <%= ux.getUsuario_nombre()%>
            </td>
            <td>
                <%= ux.getUsuario_apellido()%>
            </td>
            <td>
                <%= ux.getUsuario_correo()%>
            </td>
            <td>
                <%= ux.getUsuario_telefono()%>
            </td>
            <td>
                <%= ux.getUsuario_password()%>
            </td>
            <td>
                <%= ux.getUsuario_rol()%>
            </td>
            <td><a href="dashboard.jsp?pagina=usuario_ver&usuario=<%= ux.getUsuario_id()%>" class="btn btn-info" style="width: 80px">ver</a></td>
            <td><a href="dashboard.jsp?pagina=usuario_editar&usuario=<%= ux.getUsuario_id()%>" class="btn btn-warning" style="width: 80px">Editar</a></td>
            <td><a href="dashboard.jsp?pagina=usuario_eliminar&usuario=<%= ux.getUsuario_id()%>" class="btn btn-danger" style="width: 80px">Eliminar</a></td>
        </tr>
        <%
            }
        %>        
    </tbody>
</table>