<%@page import="pe.com.upn.tablas.Cita" %>
<%@page import="java.util.LinkedList" %>
<%@include file="referencias.jsp" %>
<%
    String x = request.getParameter("ver_cita");
    String z = request.getParameter("ver_cita2");
    Cita cit = new Cita();
    LinkedList<Cita> lista = new LinkedList<>();
    if (x != null) {
        lista = cit.listar3(z);
    }
%>

<div class="row">
    <div class="col-sm-2 menu" style="background-color: #33B3FF">
        <br>
        <%@include file="menu_cliente.jsp"%>
    </div>        
    <div class="col-sm-3 contenido">

        <h2 style="text-align: center; padding-top: 50px">Usuario</h2>

        <form action="dashCitasCliente.jsp?pagina=cita_listar" method="post">
            <%
                for (Cita ux : lista) {
            %>
            <div>
                Placa <br>
                <input type="text" class="form-control" name="placa" style="width: 100%" readonly value="<%=ux.getPlaca()%>"> <br>
                Fecha <br>
                <input type="text" class="form-control" name="fecha" style="width: 100%" readonly value="<%=ux.getFecha()%>"> <br>
                ID Usuario <br>
                <input type="text" class="form-control" name="usuario_id" style="width: 100%"  readonly value="<%=ux.getUsuario_id()%>"> <br>
                Nombre <br>
                <input type="text" class="form-control" name="usuario_nombre" style="width: 100%" readonly value="<%=ux.getUsuario_nombre()%>"> <br>
                Apellido <br>
                <input type="text" class="form-control" name="usuario_apellido" style="width: 100%" readonly value="<%=ux.getUsuario_apellido()%>"> <br><br>
            </div>
            <%
                }
            %>
            <a href="dashCitasCliente.jsp?pagina=cita_listar" class="btn btn-success">Aceptar</a>
        </form>
    </div>

    <div class="col-sm-7 contenido">
        <center style="margin-top: 80px">
            <img src="imagenes/lavador.jpg" alt="logo" width="800px" >
        </center>
    </div>
</div>
