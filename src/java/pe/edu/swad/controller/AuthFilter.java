package pe.edu.swad.controller;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class AuthFilter implements Filter {

    private List<String> excludedPaths;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Define las rutas que no requieren autenticación
        excludedPaths = Arrays.asList(
                "/CarWash-develop/login.jsp",
                "/CarWash-develop/indexCliente.jsp",
                "/CarWash-develop/registrarse.jsp",
                "/CarWash-develop/error.jsp"
        );
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession(false);

        // Obtiene el rol del usuario de la sesión (si está autenticado)
        Object rolObject = (session != null) ? session.getAttribute("rol") : null;
        String rol = null;

        if (rolObject != null) {
            if (rolObject instanceof Integer) {
                // Si el rol es Integer, conviértelo a String
                rol = String.valueOf(rolObject);
            } else if (rolObject instanceof String) {
                // Si ya es String, úsalo directamente
                rol = (String) rolObject;
            }
        }

        String requestURI = httpRequest.getRequestURI();

        boolean isAdminPath = !(requestURI.contains("Cliente") || requestURI.contains("cliente"));
        boolean isUserPath = (requestURI.contains("Cliente") || requestURI.contains("cliente"));
        
        // Verifica si la sesión ya está activa y manda de frente a pantalla principal
        if (requestURI.equals("/CarWash-develop/login.jsp") && "2".equals(rol)) {
            
            httpResponse.sendRedirect("dashboard.jsp"); // Cambia esto a tu página de error
            return;
        } else if (requestURI.equals("/CarWash-develop/login.jsp") && "1".equals(rol)) {
            // Si es una ruta de usuario, verificar que el rol sea "user" o "admin"
            httpResponse.sendRedirect("dashCliente.jsp");
            return;
        }
        // Verifica si la ruta actual está en la lista de exclusiones
        if (excludedPaths.stream().anyMatch(requestURI::endsWith)) {
            // Si está en la lista, continúa con la solicitud
            chain.doFilter(request, response);
            return;
        }
        if (requestURI.equals("/CarWash-develop/indexCliente.jsp")
                || requestURI.equals("/CarWash-develop/login.jsp")
                || requestURI.equals("/CarWash-develop/")
                || requestURI.equals("/CarWash-develop/registrarse.jsp")
                || requestURI.equals("/CarWash-develop/error.jsp")) {
            chain.doFilter(request, response); // Permitir acceso
            return;
        }

        // Verifica si el usuario está autenticado
        if (session == null || session.getAttribute("usuario") == null) {
            // Si no está autenticado, redirige a la página de inicio de sesión
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/login.jsp");
            return;
        }

        // Verifica si el usuario está autenticado como admin para su respectiva pagina
        if (isAdminPath && !"2".equals(rol)) {
            // Redirigir a una página de error o login si el usuario no es admin
            httpResponse.sendRedirect("error.jsp"); // Cambia esto a tu página de error
            return;
        } else if (isUserPath && !"1".equals(rol) && !"admin".equals(rol)) {
            // Si es una ruta de usuario, verificar que el rol sea "user" o "admin"
            httpResponse.sendRedirect("error.jsp");
            return;
        }
        
        

        // Si está autenticado correctamente, continúa con la solicitud
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // Limpieza si es necesario
    }
}
