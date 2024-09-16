
<%@page import="pe.com.upn.tablas.Clientes" %>
<%
    String pagina = "";    
    String nombre = "";
    String apellido = "";
    String correo = "";
    String telefono = "";
    Clientes u = new Clientes();
    
    if (request.getParameter("nombre")!=null) {
        nombre = request.getParameter("nombre");
    }
    if (request.getParameter("apellido")!=null) {
        apellido = request.getParameter("apellido");
    }    
    if (request.getParameter("correo")!=null) {
        correo = request.getParameter("correo");
    } 
    if (request.getParameter("telefono")!=null) {
        telefono = request.getParameter("telefono");
    } 
    if (request.getParameter("pagina")!=null) {
        pagina = request.getParameter("pagina");
    }
    
    if (pagina.equals("usuario_nuevo")) {
        u.nuevo(nombre, apellido, correo, telefono);
        response.sendRedirect("dashboard.jsp?pagina=usuario_listar");
    } else if (pagina.equals("usuario_eliminar")) {
        u.eliminar(nombre);
        response.sendRedirect("dashboard.jsp?pagina=usuario_listar");
    }
%>
