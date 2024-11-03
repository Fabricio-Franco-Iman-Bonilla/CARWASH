<% 
    // Verificar si se solicitó el cierre de sesión
    if (request.getParameter("logout") != null) {
        // Invalidar la sesión
        session.invalidate();
        
        // Redirigir al usuario a la página de inicio de sesión
        response.sendRedirect("indexCliente.jsp"); // Cambia esta URL si es necesario
    }
%>
<center>
    <img src="imagenes/Logo Mr Moon 1.png" alt="logo" width="100px"><b>MR.</b>Moon</a>
</center>
<a></a><br><br><br>
<a href="dashboard.jsp?pagina=usuario_listar" class="btn btn-light form-control">Usuarios</a><br>
<a></a><br>
<a href="dashCitas.jsp?pagina=cita_listar" class="btn btn-light form-control">Citas</a><br>
<a></a><br>
<a href="dashProd.jsp?pagina=producto_listar" class="btn btn-light form-control">Productos</a><br>
<a></a><br>
<a href="dashPagos.jsp?pagina=pago_listar" class="btn btn-light form-control">Pagos</a><br>
<a></a><br>
<a href="menu.jsp?logout=true" class="btn btn-light form-control">Cerrar Sesión</a><br>
