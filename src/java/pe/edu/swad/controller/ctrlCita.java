/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package pe.edu.swad.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.com.upn.tablas.CitaInfo;
import pe.edu.dao.impl.CitaImpl;
import pe.edu.dao.impl.UsuarioImpl;

/**
 *
 * @author tokiro
 */
@WebServlet(name = "ctrlCita", urlPatterns = {"/ctrlCita"})

public class ctrlCita extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        CitaImpl cita = new CitaImpl();
        UsuarioImpl usr = new UsuarioImpl();

        int id = -1;
        String pla = "";
        String fec = "";
        int usuario_id = -1;
        int idPersona = -1;
        int idVehiculo = -1;
        String estado = "";
        String hora = "";
        LocalDateTime fechaHora = null;

        String pag = "";

        if (request.getParameter("codigo_cita") != null) {
            id = Integer.parseInt(request.getParameter("codigo_cita"));
        }
        if (request.getParameter("estado") != null) {
            estado = request.getParameter("estado");
        }
        if (request.getParameter("hora") != null) {
            hora = request.getParameter("hora");
        }

        if (request.getParameter("placa") != null) {
            pla = request.getParameter("placa");
        }
        if (request.getParameter("fecha") != null) {
            fec = request.getParameter("fecha");
        }
        if (request.getParameter("usuario_id") != null) {
            usuario_id = Integer.parseInt(request.getParameter("usuario_id"));
        }

        if (request.getParameter("idVehiculo") != null) {
            idVehiculo = Integer.parseInt(request.getParameter("idVehiculo"));
        }
        if (request.getParameter("pagina") != null) {
            pag = request.getParameter("pagina");
        }
        if (fec != null && !fec.isEmpty() && hora != null && !hora.isEmpty()) {
            // Combinar la fecha y la hora en un solo String
            String fechaHoraStr = fec + "T" + hora;  // Ejemplo: "2024-10-05T14:30"

            // Convertir el String a LocalDateTime
            fechaHora = LocalDateTime.parse(fechaHoraStr);

        }
        idPersona = usr.obteneriIdPersonaPorIdUsuario(usuario_id);

        cita.setId(id);
        cita.setEstado(estado);
        cita.setHorario(fechaHora);
        cita.setIdUsuario(usuario_id);
        cita.setIdPersona(idPersona);
        cita.setIdVehiculo(idVehiculo);

        if (pag.equals("cita_nuevo")) {
            String sessionToken = (String) request.getSession().getAttribute("csrfToken");
            String requestToken = request.getParameter("csrfToken");

            if (sessionToken == null || !sessionToken.equals(requestToken)) {
                response.sendError(HttpServletResponse.SC_FORBIDDEN, "CSRF Token inválido o ausente");
                return;
            }

            String y = request.getParameter("opcion");
            if (y.equals("usr")) {
                cita.nuevo(cita);
                response.sendRedirect("dashCitasCliente.jsp?pagina=cita_listar");
            } else if (y.equals("adm")) {
                cita.nuevo(cita);
                response.sendRedirect("dashCitas.jsp?pagina=cita_listar");
            }
        } else if (pag.equals("cita_eliminar")) {
            cita.eliminar(String.valueOf(id));
            response.sendRedirect("dashCitas.jsp?pagina=cita_listar");
        } else if (pag.equals("cita_editar")) {
            String y = request.getParameter("opcion");
            if (y.equals("usr")) {
                cita.editar(cita);
                response.sendRedirect("dashCitasCliente.jsp");

            } else if (y.equals("adm")) {
                cita.editar(cita);
                response.sendRedirect("dashCitas.jsp?pagina=cita_listar");
            }
        }
    }
}
