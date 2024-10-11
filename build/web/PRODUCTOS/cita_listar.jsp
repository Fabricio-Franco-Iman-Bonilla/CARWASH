<%@page import="pe.com.upn.tablas.Cita" %>
<%@page import="java.util.LinkedList" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    Cita cit = new Cita();
    LinkedList<Cita> lista = new LinkedList<>();
    lista = cit.listar();
%>

<br>
<h3>Productos</h3>
<a href="dashCitas.jsp?pagina=cita_nuevo" class="btn btn-primary">Nuevo Cita</a>
<table class="table table-light table-hover table-striped">
    <thead>
        <tr>
            <th>Placa</th>
            <th>Operario</th>
            <th>Nombre Cliente</th>
            <th>Fecha</th>
            <th>Hora</th>
            <th>Ver</th>
            <th>Editar</th>
            <th>Eliminar</th>
        </tr>
    </thead>
    <tbody>
        <%
            for (Cita ux : lista) {
        %>        
        <tr>
            <td>
                <%= ux.getPlaca()%>
            </td>
            <td>
                <%= ux.getOperario()%>
            </td>
            <td>
                <%= ux.getNombreClien()%>
            </td>
            <td>
                <%= ux.getFecha()%>
            </td>
            <td>
                <%= ux.getHora()%>
            </td>
            <td><a href="dashCitas.jsp?pagina=cita_ver&cita=<%= ux.getPlaca()%>" class="btn btn-info">ver</a></td>
            <td><a href="dashCitas.jsp?pagina=cita_editar&cita=<%= ux.getPlaca()%>" class="btn btn-warning">Editar</a></td>
            <td><a href="dashCitas.jsp?pagina=cita_eliminar&cita=<%= ux.getPlaca()%>" class="btn btn-danger">Eliminar</a></td>
        </tr>
        <%
            }
        %>        
    </tbody>
</table>
