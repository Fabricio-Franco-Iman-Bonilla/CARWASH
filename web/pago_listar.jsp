<%@page import="pe.com.upn.tablas.Pago" %>
<%@page import="java.util.LinkedList" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    Pago prd = new Pago();
    LinkedList<Pago> lista = new LinkedList<>();
    lista = prd.listar();
%>

<br>
<h3>Pagos</h3><br>
<a href="pago_nuevo.jsp" class="btn btn-primary" style="width: 150px">Nuevo Factura</a><br><br>
<table id="myTable" class="display">
    <thead>
        <tr>
            <th>Codigo Factura</th>
            <th>DNI</th>            
            <th>Placa</th>
            <th>Tipo de Lavado</th>            
            <th>Precio</th>
            <th>Ver</th>
            <th>Editar</th>
            <th>Eliminar</th>
        </tr>
    </thead>
    <tbody>
         <%
            for (Pago ux : lista) {
        %>        
        <tr>
            <td>
                <%= ux.getId_pago()%>
            </td>
            <td>
                <%= ux.getDni()%>
            </td>
            <td>
                <%= ux.getPlaca()%>
            </td>
            <td>
                <%= ux.getTipo_lavado()%>
            </td>
            <td>
                <%= ux.getPrecio()%>
            </td>
            <td><a href="dashPagos.jsp?pagina=pago_ver&pago=<%= ux.getId_pago()%>" class="btn btn-info" style="width: 80px">ver</a></td>
            <td><a href="dashPagos.jsp?pagina=pago_editar&pago=<%= ux.getId_pago()%>" class="btn btn-warning" style="width: 80px">Editar</a></td>
            <td><a href="dashPagos.jsp?pagina=pago_eliminar&pago=<%= ux.getId_pago()%>" class="btn btn-danger" style="width: 80px">Eliminar</a></td>
        </tr>
        <%
            }
        %>    
    </tbody>
</table>