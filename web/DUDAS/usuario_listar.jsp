<%@page import="pe.com.upn.tablas.Usuario" %>
<%@page import="java.util.LinkedList" %>

<%
    Usuario usr = new Usuario();
    LinkedList<Usuario> lista = new LinkedList<>();
    lista = usr.listar();
%>

<br>
<h3>Clientes</h3>
<a href="dashboard.jsp?pagina=usuario_nuevo" class="btn btn-primary">Nuevo Cliente</a>
<table class="table table-light table-hover table-striped">
    <thead>
        <tr>
            <th>Nombres</th>
            <th>Telefono</th>
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
                <%= ux.getUsuario()%>
            </td>
            <td>
                <%= ux.getPassword()%>
            </td>
            <td><a href="dashboard.jsp?pagina=usuario_ver&usuario=<%= ux.getUsuario()%>" class="btn btn-info">ver</a></td>
            <td><a href="dashboard.jsp?pagina=usuario_editar&usuario=<%= ux.getUsuario()%>" class="btn btn-warning">Editar</a></td>
            <td><a href="dashboard.jsp?pagina=usuario_eliminar&usuario=<%= ux.getUsuario()%>" class="btn btn-danger">Eliminar</a></td>
        </tr>
        <%
            }
        %>        
    </tbody>
</table>