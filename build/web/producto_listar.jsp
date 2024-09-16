<%@page import="pe.edu.dao.entity.Producto"%>
<%@page import="pe.edu.dao.impl.ProductoImpl"%>
<%@page import="java.util.LinkedList" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    ProductoImpl prd = new ProductoImpl();
    LinkedList<Producto> lista = new LinkedList<>();
    lista = prd.listar();
%>

<br>
<h3>Productos</h3><br>
<a href="dashProd.jsp?pagina=producto_nuevo" class="btn btn-primary" style="width: 150px">Nuevo Producto</a><br><br>
<table id="myTable" class="display">
    <thead>
        <tr>
            <th>Codigo</th>
            <th>Nombre</th>
            <th>Descripcion</th>
            <th>Cantidad</th>
            <th>Ver</th>
            <th>Editar</th>
            <th>Eliminar</th>
        </tr>
    </thead>
    <tbody>
        <%
            for (Producto ux : lista) {
        %>        
        <tr>
            <td>
                <%= ux.getCodigo()%>
            </td>
            <td>
                <%= ux.getNombre()%>
            </td>
            <td>
                <%= ux.getDescripcion()%>
            </td>
            <td>
                <%= ux.getCantidad()%>
            </td>
            <td><a href="dashProd.jsp?pagina=producto_ver&producto=<%= ux.getCodigo()%>" class="btn btn-info" style="width: 80px">ver</a></td>
            <td><a href="dashProd.jsp?pagina=producto_editar&producto=<%= ux.getCodigo()%>" class="btn btn-warning" style="width: 80px">Editar</a></td>
            <td><a href="dashProd.jsp?pagina=producto_eliminar&producto=<%= ux.getCodigo()%>" class="btn btn-danger" style="width: 80px">Eliminar</a></td>
        </tr>
        <%
            }
        %>        
    </tbody>
</table>
