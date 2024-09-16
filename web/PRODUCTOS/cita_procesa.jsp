<%@page import="pe.com.upn.tablas.Cita" %>
<%
    String pagina = "";    
    String placa = "";
    String operario = "";
    String nombreCli = "";
    String fecha = "";
    String hora = "";
    Cita p = new Cita();
    
    if (request.getParameter("placa")!=null) {
        placa = request.getParameter("placa");
    }
    if (request.getParameter("operario")!=null) {
        operario = request.getParameter("operario");
    } 
    if (request.getParameter("nombreCli")!=null) {
        nombreCli = request.getParameter("nombreCli");
    }
    if (request.getParameter("fecha")!=null) {
        fecha = request.getParameter("fecha");
    } 
    if (request.getParameter("hora")!=null) {
        hora = request.getParameter("hora");
    } 
    if (request.getParameter("pagina")!=null) {
        pagina = request.getParameter("pagina");
    }
    
    if (pagina.equals("cita_nuevo")) {
        p.nuevo(placa, operario,nombreCli,fecha,hora);
        response.sendRedirect("dashCita.jsp?pagina=cita_listar");
    } else if (pagina.equals("cita_eliminar")) {
        p.eliminar(placa);
        response.sendRedirect("dashCita.jsp?pagina=cita_listar");
    }

%>