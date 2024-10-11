<%@page import="pe.com.upn.tablas.Cita, pe.com.upn.tablas.Usuario" %>
<%@page import="java.util.LinkedList" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@include file="referencias.jsp" %>
<%
    // Obtener la sesión
        HttpSession session2 = request.getSession(false);
        
        if (session2 != null) {
            // Recuperar un dato de la sesión
            String nombreUsuario = (String) session.getAttribute("nombreUsuario");
    
    
    Cita cit = new Cita();
    Usuario usr = new Usuario();
    LinkedList<Cita> lista = new LinkedList<>();
    
    lista = cit.listar2(nombreUsuario);
    
%>


<br>
<h3>Citas</h3><br>
<a href="dashCitasCliente.jsp?pagina=cita_nuevo" class="btn btn-primary" style="width: 150px">Nuevo Cita</a><br><br>
<table id="myTable" class="display">
    <thead>
        <tr>
            <th>Codigo</th>
            <th>Placa</th>
            <th>Fecha</th>
            <th>ID Usuario</th>
            <th>Ver</th>
        </tr>
    </thead>
    <tbody>
        <%
            for (Cita ux : lista) {
        %>        
        <tr>
            <td>
                <%= ux.getCodigo()%>
            </td>
            <td>
                <%= ux.getPlaca()%>
            </td>
            <td>
                <%= ux.getFecha()%>
            </td>
            <td>
                <%= ux.getUsuario_id()%>
            </td>
            <td>
                <form action="cita_verCliente.jsp" method="get" style="display: inline;">
                    <input type="hidden" name="ver_cita" value="<%=ux.getUsuario_id()%>">
                    <input type="hidden" name="ver_cita2" value="<%=ux.getCodigo()%>">
                    <button type="submit" class="btn btn-info" style="width: 80px;">ver</button>
                    
                </form>
            </td>
            <!--
            <td><a href="dashCitasCliente.jsp?pagina=cita_editar&cita=<%= ux.getCodigo()%>" class="btn btn-warning tabla-boton">Editar</a></td>
            <td><a href="dashCitasCliente.jsp?pagina=cita_eliminar&cita=<%= ux.getCodigo()%>" class="btn btn-danger tabla-boton">Eliminar</a></td>
            -->
            </tr>
            
        <%
            }
        %>        
    </tbody>
    
</table>
   <%
    }
    %>