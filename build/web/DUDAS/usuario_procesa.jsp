
<%@page import="pe.com.upn.tablas.Usuario" %>
<%
    String pagina = "";    
    String usuario = "";
    String password = "";
    Usuario u = new Usuario();
    
    if (request.getParameter("usuario")!=null) {
        usuario = request.getParameter("usuario");
    }
    if (request.getParameter("password")!=null) {
        password = request.getParameter("password");
    }    
    if (request.getParameter("pagina")!=null) {
        pagina = request.getParameter("pagina");
    }
    
    if (pagina.equals("usuario_nuevo")) {
        u.nuevo(usuario, password);
        response.sendRedirect("dashboard.jsp?pagina=usuario_listar");
    } else if (pagina.equals("usuario_eliminar")) {
        u.eliminar(usuario);
        response.sendRedirect("dashboard.jsp?pagina=usuario_listar");
    }

%>
