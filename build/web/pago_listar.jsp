<%@page import="pe.edu.dao.impl.ComprobanteImpl"%>
<%@page import="pe.edu.dao.entity.Comprobante"%>
<%@page import="java.util.LinkedList" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    ComprobanteImpl  prd = new ComprobanteImpl();
    LinkedList<Comprobante> lista = new LinkedList<>();
    lista = prd.listar();
%>

<br>
<h3>Pagos</h3><br>
<a href="pago_nuevo.jsp" class="btn btn-primary" style="width: 150px">Nuevo Factura</a><br><br>
<table id="myTable" class="display">
    <thead>
        <tr>
            <th>Codigo Comprobante</th>
            <th>ID USUARIO</th>            
            <th>Fecha de Emisión</th>
            <th>Metodo de pago</th>            
            <th>Subtotal</th>
            <th>Ver</th>
            <th>Editar</th>
            <th>Eliminar</th>
        </tr>
    </thead>
    <tbody>
         <%
            for (Comprobante ux : lista) {
        %>        
        <tr>
            <td>
                <%= ux.getIdComprobante()%>
            </td>
            <td>
                <%= ux.getIdUsuario()%>
            </td>
            <td>
                <%= ux.getFechaEmision()%>
            </td>
            <td>
                <%= ux.getMetodoPago()%>
            </td>
            <td>
                <%= ux.getSubtotal()%>
            </td>
            <td><a href="dashPagos.jsp?pagina=pago_ver&pago=<%= ux.getIdComprobante()%>" class="btn btn-info" style="width: 80px">ver</a></td>
            <td><a href="dashPagos.jsp?pagina=pago_editar&pago=<%= ux.getIdComprobante()%>" class="btn btn-warning" style="width: 80px">Editar</a></td>
            <td><a href="dashPagos.jsp?pagina=pago_eliminar&pago=<%= ux.getIdComprobante()%>" class="btn btn-danger" style="width: 80px">Eliminar</a></td>
        </tr>
        <%
            }
        %>    
    </tbody>
</table>
