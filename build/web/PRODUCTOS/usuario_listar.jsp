<%@page import="pe.com.upn.tablas.Clientes" %>
<%@page import="java.util.LinkedList" %>

<%
    Clientes usr = new Clientes();
    LinkedList<Clientes> lista = new LinkedList<>();
    lista = usr.listar();
%>

<br>
<h3>Clientes</h3>
<a href="dashboard.jsp?pagina=usuario_nuevo" class="btn btn-primary">Nuevo Cliente</a>
<table class="table table-light table-hover table-striped">
    <thead>
        <tr>
            <th>Nombre</th>
            <th>Apellido</th>
            <th>Correo</th>
            <th>Telefono</th>
            <th>Ver</th>
            <th>Editar</th>
            <th>Eliminar</th>
        </tr>
    </thead>
    <tbody>
        <%
            for (Clientes ux : lista) {
        %>        
        <tr>
            <td>
                <%= ux.getNombre()%>
            </td>
            <td>
                <%= ux.getApellido()%>
            </td>
            <td>
                <%= ux.getCorreo()%>
            </td>
            <td>
                <%= ux.getTelefono()%>
            </td>
            <td><a href="dashboard.jsp?pagina=usuario_ver&usuario=<%= ux.getNombre()%>" class="btn btn-info">ver</a></td>
            <td><a href="dashboard.jsp?pagina=usuario_editar&usuario=<%= ux.getNombre()%>" class="btn btn-warning">Editar</a></td>
            <td><a href="dashboard.jsp?pagina=usuario_eliminar&usuario=<%= ux.getNombre()%>" class="btn btn-danger">Eliminar</a></td>
        </tr>
        <%
            }
        %>        
    </tbody>
</table>