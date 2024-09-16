
package pe.edu.swad.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pe.com.upn.tools.Autentica;
import pe.edu.dao.entity.Usuario;
import pe.edu.dao.impl.UsuarioImpl;

/**
 *
 * @author Juan
 */
@WebServlet(name = "ctrlUsuario", urlPatterns = {"/ctrlUsuario"})

public class ctrlUsuario extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Autentica au = new Autentica();
        
        UsuarioImpl usuario = new UsuarioImpl();
        Usuario usu = new Usuario();
        
        String id="";
        String nom="";
        String apel="";
        String corre="";
        String tele="";
        String contra="";
        String rol="-1";
        String usuname="";
        int rolNum=-1;
        
        
        String pag ="";
        
        
        if (request.getParameter("usuario_id") != null) {
            id = request.getParameter("usuario_id");
        }
        if (request.getParameter("usuario_nombre") != null) {
            nom = request.getParameter("usuario_nombre");
        }
        if (request.getParameter("usuario_apellido") != null) {
            apel = request.getParameter("usuario_apellido");
        }
        if (request.getParameter("usuario_correo") != null) {
            corre = request.getParameter("usuario_correo");
        }
        if (request.getParameter("usuario_telefono") != null) {
            tele = request.getParameter("usuario_telefono");
        }
        if (request.getParameter("usuario_usuario") != null) {
            usuname = request.getParameter("usuario_usuario");
        }
        if (request.getParameter("pagina") != null) {
            pag = request.getParameter("pagina");
        }
        if (request.getParameter("usuario_password") != null) {
            contra = request.getParameter("usuario_password");
        }
        if (request.getParameter("usuario_rol") != null) {
            rol = request.getParameter("usuario_rol");
        }
        
        rolNum=Integer.parseInt(rol);
        usu.setUsuario_nombre(nom);
        usu.setUsuario_tipoDocumento("dsda");
        usu.setUsuario_numDocumento("dsa");
        usu.setUsuario_apellido(apel);
        usu.setUsuario_telefono(tele);
        usu.setUsuario_correo(corre);
        usu.setUsuario_usuario(usuname);
        usu.setUsuario_password(contra);
        usu.setUsuario_rol(rolNum);
        
        
        if (pag.equals("usuario_nuevo")) {
            usuario.nuevo(usu);
            response.sendRedirect("dashboard.jsp?pagina=usuario_listar");
        } else if (pag.equals("usuario_eliminar")) {
            
            usuario.eliminar(id);
            response.sendRedirect("dashboard.jsp?pagina=usuario_listar");
        
        } else if (pag.equals("usuario_editar")) {
            usu.setUsuario_id(Integer.parseInt(id));
            usuario.editar(usu);
            response.sendRedirect("dashboard.jsp?pagina=usuario_listar");
        }else if (pag.equals("login")) {
            
            String usr = request.getParameter("usuario");
            String psw = request.getParameter("password");

            int logueado = au.getLogueado(usr, psw);
            if(logueado == 1){
                    // Obtener la sesión
                String usuarioId = usuario.obtenerUsuarioIdPorCorreo(usr);
                HttpSession session = request.getSession();
                // Guardar un dato en la sesión
                session.setAttribute("nombreUsuario", usuarioId);

                RequestDispatcher dispatcher = request.getRequestDispatcher("dashCliente.jsp");
                dispatcher.forward(request, response);
            }else if(logueado == 2){
                RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard.jsp");
                dispatcher.forward(request, response);
            }else {
                RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
                dispatcher.forward(request, response);
            }
        }
    }
}
