<% 
    // Verificar si se solicit� el cierre de sesi�n
    if (request.getParameter("logout") != null) {
        // Invalidar la sesi�n
        request.getSession().invalidate();
        //session.invalidate();
        
        // Redirigir al usuario a la p�gina de inicio de sesi�n
        response.sendRedirect("indexCliente.jsp"); // Cambia esta URL si es necesario
    }
%>
<center>
    <img src="imagenes/Logo Mr Moon 1.png" alt="logo" width="100px" ><b>MR.</b>Moon</a>

</center>
<a></a><br><br><br>
<a href="dashCitasCliente.jsp?pagina=cita_listar" class="btn btn-light form-control">Citas</a><br>
<a></a><br>
<a href="menu_cliente.jsp?logout=true" class="btn btn-light form-control">Cerrar Sesion</a><br>
