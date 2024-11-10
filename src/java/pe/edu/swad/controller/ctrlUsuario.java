package pe.edu.swad.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pe.com.upn.tools.Autentica;
import pe.com.upn.tools.Hash;
import pe.edu.dao.entity.Usuario;
import pe.edu.dao.impl.UsuarioImpl;
import java.sql.Timestamp;
import java.util.Date;
import java.util.concurrent.CompletableFuture;
import javax.servlet.http.Cookie;

/**
 * º
 *
 * @author Juan
 */
@WebServlet(name = "ctrlUsuario", urlPatterns = {"/ctrlUsuario"})

public class ctrlUsuario extends HttpServlet {

    private static final String SECRET_KEY = "6LcOQFYqAAAAANwc9EqBqGBhh0uXi9D7PIX35bmd"; // Cambia por tu clave secreta de Google reCAPTCHA
    private static final String RECAPTCHA_VERIFY_URL = "https://www.google.com/recaptcha/api/siteverify";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Autentica au = new Autentica();

        UsuarioImpl usuario = new UsuarioImpl();
        Usuario usu = new Usuario();

        String id = "";
        String nom = "";
        String apel = "";
        String corre = "";
        String tele = "";
        String contra = "";
        String numDocumento = "";
        String rol = "-1";
        String usuname = "";
        int rolNum = -1;

        String pag = "";

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
        if (request.getParameter("usuario_numDocumento") != null) {
            numDocumento = request.getParameter("usuario_numDocumento");
        }

        Hash h = new Hash();
        contra = h.StringToHash(contra, "SHA-256");

        rolNum = Integer.parseInt(rol);
        usu.setUsuario_nombre(nom);
        usu.setUsuario_tipoDocumento("dsda");
        usu.setUsuario_numDocumento(numDocumento);
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
        } else if (pag.equals("login")) {

            String usr = request.getParameter("usuario");
            String psw = request.getParameter("password");

            int logueado = au.getLogueado(usr, psw);

            // Verificar CAPTCHA antes de proceder
            String gRecaptchaResponse = request.getParameter("g-recaptcha-response");
            boolean captchaVerified = verifyRecaptcha(gRecaptchaResponse);

            if (!captchaVerified) {
                //QUE NO RECARGUE LA PAGINA SOLO QUE MUESTRE QUE SE NECESITA RE VALIDAR EL CAPTCHA O QUE FUE INCORRECTO
                // Si el CAPTCHA no es válido, redirigir a la página de error o mostrar mensaje
                RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
                dispatcher.forward(request, response);
                return; // Termina la ejecución del método aquí si el CAPTCHA no es válido
            }

            // Obtener la sesión
            String usuarioId = String.valueOf(usuario.obtenerUsuarioIdPorUsuario(usr));
            UsuarioImpl u = new UsuarioImpl();
            u.ver(usuarioId);
            HttpSession session = request.getSession();
            // Guardar un dato en la sesión
            session.setAttribute("nombreUsuario", usuarioId);
            session.setAttribute("rol", u.getUsuario_rol());

            Integer intentos = (Integer) session.getAttribute("intentos");
            if (intentos == null) {
                intentos = 0;
            }
            boolean bloqueado = false;

            int limiteIntentos = u.getLimiteIntentos();
            if (usuarioId.contains("-1")) {
                limiteIntentos = 3;
            }

            if (logueado == 1 && !u.getUsuario_cuentabloqueda()) {
                
                logueoExitoso(request, response, session, u);
                RequestDispatcher dispatcher = request.getRequestDispatcher("dashCliente.jsp");
                dispatcher.forward(request, response);
            } else if (logueado == 2 && !u.getUsuario_cuentabloqueda()) {
                
                logueoExitoso(request, response, session, u);
                RequestDispatcher dispatcher = request.getRequestDispatcher("dashboard.jsp");
                dispatcher.forward(request, response);
            } else {
                intentos++;
                session.setAttribute("intentos", intentos);
                usuario.restarIntentos(usuario.obtenerUsuarioIdPorUsuario(usr));

                if (limiteIntentos == 0) {
                    intentos = 0;
                    bloqueado = true;
                    request.setAttribute("bloqueado", bloqueado);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp?error=too_many_attempts");
                    dispatcher.forward(request, response);

                } else {
                    request.setAttribute("bloqueado", false);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp?error=true");
                    dispatcher.forward(request, response);
                }
                session.setAttribute("intentos", limiteIntentos);

            }

        }
    }

    private boolean verifyRecaptcha(String gRecaptchaResponse) {
        if (gRecaptchaResponse == null || gRecaptchaResponse.isEmpty()) {
            return false;
        }
        try {// Conexión a la API de Google reCAPTCHA
            URL url = new URL(RECAPTCHA_VERIFY_URL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);

            // Preparar los datos para enviar
            String postParams = "secret=" + SECRET_KEY + "&response=" + gRecaptchaResponse;

            // Enviar la solicitud POST
            OutputStream os = conn.getOutputStream();
            os.write(postParams.getBytes());
            os.flush();
            os.close();

            // Leer la respuesta de la API
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Convertir la respuesta en String y verificar si contiene "success": true
            String jsonResponse = response.toString();

            // Verificar si el reCAPTCHA fue exitoso
            return jsonResponse.contains("\"success\": true");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private void logueoExitoso(HttpServletRequest request, HttpServletResponse response, HttpSession session, UsuarioImpl u) {
        // Obtener la IP desde la solicitud
        String ipAddress;
        ipAddress = u.obtenerIpPublica();
        session = request.getSession();
        session.setAttribute("usuario", u.getUsuario_usuario());

        // Obtener la fecha y hora actual
        Timestamp timestamp = new Timestamp(new Date().getTime());

        // Llamar al método que actualiza la fecha de inicio de sesión
        u.actualizarFechaInicioSesion(u.obtenerUsuarioIdPorUsuario(u.getUsuario_usuario()), timestamp,
                ipAddress);
        session.removeAttribute("intentos");
        // Suponiendo que tienes la variable `rol` después de la autenticación
        Cookie rolCookie = new Cookie("userRole", String.valueOf(u.getUsuario_rol())); // "admin" o "usuario" basado en el rol
        rolCookie.setMaxAge(1 * 60); // La cookie expira en 30 minutos
        response.addCookie(rolCookie);

    }
}
