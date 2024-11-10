package pe.edu.swad.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.edu.dao.entity.Comprobante;
import pe.edu.dao.impl.ComprobanteImpl;

@WebServlet(name = "ctrlPago", urlPatterns = {"/ctrlPago"})
public class ctrlPago extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ComprobanteImpl pago = new ComprobanteImpl();

        Integer id_p = 0;
        String dni = "";
        String nom = "";
        String pla = "";
        String tip_lav = "";
        String tam_auto = "";
        Double prec = null;

        String pag = "";

        if (request.getParameter("codigo") != null) {
            id_p = Integer.parseInt(request.getParameter("codigo"));
        }
        if (request.getParameter("dni") != null) {
            dni = request.getParameter("dni");
        }
        if (request.getParameter("nombre") != null) {
            nom = request.getParameter("nombre");
        }
        if (request.getParameter("placa") != null) {
            pla = request.getParameter("placa");
        }
        if (request.getParameter("tipoLavado") != null) {
            tip_lav = request.getParameter("tipoLavado");
        }
        if (request.getParameter("tamano") != null) {
            tam_auto = request.getParameter("tamano");
        }
        if (request.getParameter("precio") != null) {
            prec = Double.parseDouble(request.getParameter("precio"));
        }
        if (request.getParameter("pagina") != null) {
            pag = request.getParameter("pagina");
        }

        //FALTA EGULAR MAÑANA
        if ("pago_nuevo".equals(pag)) {
            System.out.println(id_p + " " + dni + " " + nom + " " + pla + " " + tip_lav + " " + tam_auto + " " + prec);
            pago.nuevo(pago);

            response.sendRedirect("dashPagos.jsp?pagina=pago_listar");

        } else if ("pago_eliminar".equals(pag)) {
            pago.eliminar(String.valueOf(id_p));
            response.sendRedirect("dashPagos.jsp?pagina=pago_listar");
        } else if ("pago_editar".equals(pag)) {
            pago.editar(pago);
            response.sendRedirect("dashPagos.jsp?pagina=pago_listar");
        }
    }
}
