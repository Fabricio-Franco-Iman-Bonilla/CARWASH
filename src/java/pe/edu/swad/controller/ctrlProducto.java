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
import pe.edu.dao.impl.ProductoImpl;

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
        ProductoImpl producto = new ProductoImpl();

        int id = -1;
        String nom = "";
        String desc = "";
        int stock = -1;
        int idProveedor = -1;

        String pag = "";

        if (request.getParameter("id") != null) {
            id = Integer.parseInt(request.getParameter("id"));
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
            stock = Integer.parseInt(request.getParameter("cantidad"));
        }
        if (request.getParameter("idProveedor") != null) {
            idProveedor = Integer.parseInt(request.getParameter("idProveedor"));
        }

        producto.setId(id);
        producto.setNombre(nom);
        producto.setDescripcion(desc);
        producto.setStock(stock);
        producto.setIdProveedor(idProveedor);

        if (pag.equals("producto_nuevo")) {
            String sessionToken = (String) request.getSession().getAttribute("csrfToken");
            String requestToken = request.getParameter("csrfToken");

            if (sessionToken == null || !sessionToken.equals(requestToken)) {
                response.sendError(HttpServletResponse.SC_FORBIDDEN, "CSRF Token inválido o ausente");
                return;
            }
            producto.nuevo(producto);
            response.sendRedirect("dashProd.jsp?pagina=producto_listar");
        } else if (pag.equals("producto_eliminar")) {
            producto.eliminar(String.valueOf(id));
            response.sendRedirect("dashProd.jsp?pagina=producto_listar");

        } else if (pag.equals("producto_editar")) {
            producto.editar(producto);
            response.sendRedirect("dashProd.jsp?pagina=producto_listar");
        }
    }
}
