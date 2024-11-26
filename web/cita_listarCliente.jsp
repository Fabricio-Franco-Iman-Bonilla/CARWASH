<%@page import="pe.edu.dao.impl.CitaImpl"%>
<%@page import="pe.com.upn.tablas.CitaInfo"%>
<%@page import="pe.edu.dao.entity.Usuario"%>
<%@page import="pe.edu.dao.entity.Cita"%>
<%@page import="java.util.LinkedList" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@include file="referencias.jsp" %>
<%
    // Obtener la sesión
        HttpSession session2 = request.getSession(false);
        CitaImpl cit = new CitaImpl();
        Usuario usr = new Usuario();
        LinkedList<CitaInfo> lista = new LinkedList<>();
        
        if (session2 != null) {
            // Recuperar un dato de la sesión
            String nombreUsuario = (String) session.getAttribute("nombreUsuario");
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
    for (CitaInfo ux : lista) {
%>        
        <tr>
            <td>
<%= ux.getIdCita()%>
            </td>
            <td>
<%= ux.getPlaca()%>
            </td>
            <td>
<%= ux.getHorario()%>
            </td>
            <td>
<%= ux.getIdUsuario()%>
            </td>
            <td>
                <form action="cita_verCliente.jsp" method="get" style="display: inline;">
                    <input type="hidden" name="ver_cita" value="<%=ux.getIdUsuario()%>">
                    <input type="hidden" name="ver_cita2" value="<%=ux.getIdCita()%>">
                    <button type="submit" class="btn btn-info" style="width: 80px;">ver</button>
                    
                </form>
            </td>
            <!--
            <td><a href="dashCitasCliente.jsp?pagina=cita_editar&cita=<%= ux.getIdCita()%>" class="btn btn-warning tabla-boton">Editar</a></td>
            <td><a href="dashCitasCliente.jsp?pagina=cita_eliminar&cita=<%= ux.getIdCita()%>" class="btn btn-danger tabla-boton">Eliminar</a></td>
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
