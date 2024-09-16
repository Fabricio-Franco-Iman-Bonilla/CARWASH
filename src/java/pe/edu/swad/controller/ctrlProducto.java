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
import pe.com.upn.tablas.Producto;

/**
 *
 * @author MIKI
 */
@WebServlet(name = "ctrlProducto", urlPatterns = {"/ctrlProducto"})
public class ctrlProducto extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

       
        boolean log = false;
        Producto producto = new Producto();

        String cod = "";
        String nom = "";
        String desc = "";
        String cant = "";

        String pag = "";

        if (request.getParameter("codigo") != null) {
            cod = request.getParameter("codigo");
        }
        if (request.getParameter("nombre") != null) {
            nom = request.getParameter("nombre");
        }
        if (request.getParameter("pagina") != null) {
            pag = request.getParameter("pagina");
        }
        if (request.getParameter("descripcion") != null) {
            desc = request.getParameter("descripcion");
        }
        if (request.getParameter("cantidad") != null) {
            cant = request.getParameter("cantidad");
        }

        if (pag.equals("producto_nuevo")) {
            producto.nuevo(cod, nom, desc, cant);
            response.sendRedirect("dashProd.jsp?pagina=producto_listar");
        } else if (pag.equals("producto_eliminar")) {
            producto.eliminar(cod);
            response.sendRedirect("dashProd.jsp?pagina=producto_listar");
        
        } else if (pag.equals("producto_editar")) {
            producto.editar(cod, nom, desc, cant);
            response.sendRedirect("dashProd.jsp?pagina=producto_listar");
        }
    }
}
