/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package pe.edu.swad.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.com.upn.tablas.Cita;

/**
 *
 * @author tokiro
 */
@WebServlet(name = "ctrlCita", urlPatterns = {"/ctrlCita"})

public class ctrlCita extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Cita cita = new Cita();
        
        String cod = "";
        String pla = "";
        String fec = "";
        String usuario_id = "";
        
        String pag ="";
        
        
        if (request.getParameter("codigo_cita") != null) {
            cod = request.getParameter("codigo_cita");
        }
        if (request.getParameter("placa") != null) {
            pla = request.getParameter("placa");
        }
        if (request.getParameter("fecha") != null) {
            fec = request.getParameter("fecha");
        }
        if (request.getParameter("usuario_id") != null) {
            usuario_id = request.getParameter("usuario_id");
        }
        if (request.getParameter("pagina") != null) {
            pag = request.getParameter("pagina");
        }        
        if (pag.equals("cita_nuevo")) {
            
            String y = request.getParameter("opcion");
            if (y.equals("usr")) {
                cita.nuevo(cod, pla, fec, usuario_id);
                response.sendRedirect("dashCitasCliente.jsp?pagina=cita_listar");                
            }else if(y.equals("adm")){
                cita.nuevo(cod, pla, fec, usuario_id);
                response.sendRedirect("dashCitas.jsp?pagina=cita_listar");
            }
        } else if (pag.equals("cita_eliminar")) {
            cita.eliminar(cod);
            response.sendRedirect("dashCitas.jsp?pagina=cita_listar");
        } else if (pag.equals("cita_editar")) {
            String y = request.getParameter("opcion");
            if (y.equals("usr")) {
                cita.editar(cod, pla, fec, usuario_id);
                response.sendRedirect("dashCitasCliente.jsp");
                
            }else if(y.equals("adm")){
                cita.editar(cod, pla, fec, usuario_id);
                response.sendRedirect("dashCitas.jsp?pagina=cita_listar");
            }        
        }
    }
}
