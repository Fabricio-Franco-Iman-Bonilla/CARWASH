package pe.edu.dao.impl;

import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import javax.servlet.http.HttpServletRequest;
import pe.com.upn.tools.Conexion;
import pe.com.upn.tools.Funciones;
import pe.com.upn.tools.Hash;
import pe.edu.dao.DAO;
import pe.edu.dao.entity.Usuario;

/**
 *
 * @author tokiro
 */
public class UsuarioImpl extends Usuario implements DAO<Usuario> {

    public UsuarioImpl() {
    }

    @Override
    public Usuario ver(String id) {
        try {
            Conexion c = new Conexion();
            Connection cnx = c.conecta();
            String consulta = "SELECT USUARIO.idUsuario,USUARIO.usuario,USUARIO.contrasena,PERSONA.nombre,PERSONA.apellido,PERSONA.tipoDocumento,PERSONA.numDocumento,PERSONA.telefono,PERSONA.correo,CATE_ROL.nombre AS rolNombre, USUARIO.idRol as ROL\n"
                    + "FROM USUARIO INNER JOIN PERSONA ON USUARIO.idPersona = PERSONA.idPersona INNER JOIN CATE_ROL ON USUARIO.idRol = CATE_ROL.idRol WHERE USUARIO.idUsuario ='" + id + "';";
            Statement sentencia = cnx.createStatement();
            ResultSet resultado = sentencia.executeQuery(consulta);
            resultado.next();
            this.usuario_id = resultado.getInt("idUsuario");
            this.usuario_nombre = resultado.getString("nombre");
            this.usuario_apellido = resultado.getString("apellido");
            this.usuario_correo = resultado.getString("correo");
            this.usuario_telefono = resultado.getString("telefono");
            this.usuario_password = resultado.getString("contrasena");
            this.usuario_usuario = resultado.getString("usuario");
            this.usuario_rol = resultado.getInt("ROL");
            this.usuario_numDocumento = resultado.getString("numDocumento");
            sentencia.close();
            cnx.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public LinkedList<Usuario> listar() {
        try {
            Conexion c = new Conexion();
            Connection cnx = c.conecta();
            String consulta = "SELECT USUARIO.idUsuario,USUARIO.usuario,USUARIO.contrasena,PERSONA.nombre,PERSONA.apellido,PERSONA.tipoDocumento,PERSONA.numDocumento,PERSONA.telefono,PERSONA.correo,CATE_ROL.nombre AS rolNombre, USUARIO.idRol as ROL \n"
                    + "FROM USUARIO INNER JOIN PERSONA ON USUARIO.idPersona = PERSONA.idPersona INNER JOIN CATE_ROL ON USUARIO.idRol = CATE_ROL.idRol;";
            Statement sentencia = cnx.createStatement();
            ResultSet resultado = sentencia.executeQuery(consulta);
            LinkedList<Usuario> lista = new LinkedList<>();
            while (resultado.next()) {
                Usuario usr = new Usuario();
                usr.setUsuario_id(resultado.getInt("idUsuario"));
                usr.setUsuario_nombre(resultado.getString("nombre"));
                usr.setUsuario_apellido(resultado.getString("apellido"));
                usr.setUsuario_correo(resultado.getString("correo"));
                usr.setUsuario_telefono(resultado.getString("telefono"));
                usr.setUsuario_password(resultado.getString("contrasena"));
                usr.setUsuario_rol(resultado.getInt("ROL"));
                usr.setUsuario_usuario(resultado.getString("usuario"));
                usr.setUsuario_numDocumento(resultado.getString("numDocumento"));
                lista.add(usr);
            }
            sentencia.close();
            cnx.close();
            return lista;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void nuevo(Usuario obj) {
        Connection cnx = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Funciones.esNombreUsuarioUnico(obj.getUsuario_usuario());
        try {
            Conexion c = new Conexion();
            cnx = c.conecta();
            //int xd = Integer.parseInt(id);
            // Paso 1: Insertar datos en PERSONA
            String sqlPersona = "INSERT INTO PERSONA (nombre, tipoDocumento, numDocumento,apellido, telefono, correo) VALUES (?, ?, ?, ?, ?, ?)";
            stmt = cnx.prepareStatement(sqlPersona, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, obj.getUsuario_nombre());
            stmt.setString(2, obj.getUsuario_tipoDocumento());
            stmt.setString(3, obj.getUsuario_numDocumento());
            stmt.setString(4, obj.getUsuario_apellido());
            stmt.setString(5, obj.getUsuario_telefono());
            stmt.setString(6, obj.getUsuario_correo());
            stmt.executeUpdate();

            // Obtener el ID generado para PERSONA
            rs = stmt.getGeneratedKeys();
            int idPersona = -1;
            if (rs.next()) {
                idPersona = rs.getInt(1);
            }

            // Paso 3: Insertar datos en USUARIO
            String sqlUsuario = "INSERT INTO USUARIO (usuario, contrasena, idPersona, idRol) VALUES (?, ?, ?, ?)";
            stmt = cnx.prepareStatement(sqlUsuario);
            stmt.setString(1, obj.getUsuario_usuario());
            stmt.setString(2, obj.getUsuario_password());
            stmt.setInt(3, idPersona);
            stmt.setInt(4, obj.getUsuario_rol());
            stmt.executeUpdate();

            rs.close();
            stmt.close();
            cnx.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void eliminar(String id) {
        Connection cnx = null;
        PreparedStatement stmt = null;

        try {
            Conexion c = new Conexion();
            cnx = c.conecta();

            // Iniciar una transacción
            cnx.setAutoCommit(false);
            int x = Integer.parseInt(id);
            // Paso 1: Obtener el idPersona y idRol del usuario
            String sqlGetUser = "SELECT idPersona, idRol FROM USUARIO WHERE idUsuario = ?;";
            stmt = cnx.prepareStatement(sqlGetUser);
            stmt.setInt(1, x);
            ResultSet rs = stmt.executeQuery();

            int idPersona = 0;
            int idRol = 0;

            if (rs.next()) {
                idPersona = rs.getInt("idPersona");
                idRol = rs.getInt("idRol");
            }

            rs.close();
            stmt.close();

            // Paso 2: Eliminar de USUARIO
            String sqlDeleteUser = "DELETE FROM USUARIO WHERE idUsuario = ?";
            stmt = cnx.prepareStatement(sqlDeleteUser);
            stmt.setInt(1, x);
            stmt.executeUpdate();

            // Paso 3: Eliminar de PERSONA
            String sqlDeletePersona = "DELETE FROM PERSONA WHERE idPersona = ?";
            stmt = cnx.prepareStatement(sqlDeletePersona);
            stmt.setInt(1, idPersona);
            stmt.executeUpdate();

            rs.close();
            stmt.close();

            // Confirmar transacción
            cnx.commit();

            cnx.close();
            stmt.close();

        } catch (Exception e) {
            e.printStackTrace();

            // Deshacer cambios en caso de error
            if (cnx != null) {
                try {
                    cnx.rollback();
                } catch (SQLException se) {
                    se.printStackTrace();
                }
            }
        }
    }

    @Override
    public void editar(Usuario obj) {
        
        Connection cnx = null;
        PreparedStatement stmt = null;
        String contraPrevia,contraPreviaHash;
        Hash h=new Hash();

        try {
            Conexion c = new Conexion();
            cnx = c.conecta();
            
            String consulta = "SELECT USUARIO.contrasena "
                    + "FROM USUARIO WHERE USUARIO.idUsuario ='" + obj.getUsuario_id() + "';";
            Statement sentencia = cnx.createStatement();
            ResultSet resultado = sentencia.executeQuery(consulta);
            resultado.next();
            contraPrevia = resultado.getString("contrasena");
            contraPreviaHash = h.StringToHash(contraPrevia, "SHA-256");
            

            // Iniciar una transacción
            cnx.setAutoCommit(false);

            // Paso 1: Actualizar la tabla USUARIO
            String sqlUpdateUser = "UPDATE USUARIO SET usuario = ?, contrasena = ? WHERE idUsuario = ?;";
            stmt = cnx.prepareStatement(sqlUpdateUser);
            stmt.setString(1, obj.getUsuario_usuario());
            if (!obj.getUsuario_password().contains(contraPreviaHash)) {
                stmt.setString(2, obj.getUsuario_password());
            }
            else{
                stmt.setString(2, contraPrevia);
            }
            
            stmt.setInt(3, obj.getUsuario_id());
            stmt.executeUpdate();
            stmt.close();

            // Paso 2: Obtener idPersona relacionado
            String sqlGetPersonaId = "SELECT idPersona FROM USUARIO WHERE idUsuario = ?;";
            stmt = cnx.prepareStatement(sqlGetPersonaId);
            stmt.setInt(1, obj.getUsuario_id());
            ResultSet rs = stmt.executeQuery();
            int idPersona = 0;

            if (rs.next()) {
                idPersona = rs.getInt("idPersona");
            }
            rs.close();
            stmt.close();

            // Paso 3: Actualizar la tabla PERSONA
            String sqlUpdatePersona = "UPDATE PERSONA SET nombre = ?, apellido = ?, correo = ?, telefono = ? WHERE idPersona = ?;";
            stmt = cnx.prepareStatement(sqlUpdatePersona);
            stmt.setString(1, obj.getUsuario_nombre());
            stmt.setString(2, obj.getUsuario_apellido());
            stmt.setString(3, obj.getUsuario_correo());
            stmt.setString(4, obj.getUsuario_telefono());
            stmt.setInt(5, idPersona);
            stmt.executeUpdate();

            // Confirmar la transacción
            cnx.commit();

        } catch (Exception e) {
            e.printStackTrace();

            // Deshacer cambios en caso de error
            if (cnx != null) {
                try {
                    cnx.rollback();
                } catch (SQLException se) {
                    se.printStackTrace();
                }
            }
        } finally {
            // Cerrar recursos
            if (stmt != null) try {
                stmt.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            if (cnx != null) try {
                cnx.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    
    public String obtenerUsuarioIdPorCorreo(String correo) {

        String usuarioId = null;
        Connection cnx = null;
        PreparedStatement stmt = null;
        int idUsuario = -1; // Usamos -1 como valor por defecto si no se encuentra el usuario
        try {
            Conexion c = new Conexion();
            cnx = c.conecta();
            

            // Consulta SQL para obtener el idUsuario basado en el correo
            String sql = "SELECT u.idUsuario FROM USUARIO u JOIN PERSONA p ON u.idPersona = p.idPersona WHERE p.correo = ?;";
            stmt = cnx.prepareStatement(sql);
            stmt.setString(1, correo); // Establecer el correo en la consulta

            ResultSet rs = stmt.executeQuery();

            // Si el correo existe en la base de datos, obtener el idUsuario
            if (rs.next()) {
                idUsuario = rs.getInt("idUsuario");
            }

            rs.close();
            cnx.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return usuarioId;
    }
    public int obtenerUsuarioIdPorUsuario(String usuario) {

        
        Connection cnx = null;
        PreparedStatement stmt = null;
        int idUsuario = -1; // Usamos -1 como valor por defecto si no se encuentra el usuario
        try {
            Conexion c = new Conexion();
            cnx = c.conecta();
            

            // Consulta SQL para obtener el idUsuario basado en el correo
            String sql = "SELECT idUsuario FROM USUARIO WHERE usuario = ?;";
            stmt = cnx.prepareStatement(sql);
            stmt.setString(1, usuario); // Establecer el correo en la consulta

            ResultSet rs = stmt.executeQuery();

            // Si el correo existe en la base de datos, obtener el idUsuario
            if (rs.next()) {
                idUsuario = rs.getInt("idUsuario");
            }

            rs.close();
            cnx.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return idUsuario;
    }
    
    public void actualizarFechaInicioSesion(int userId, Timestamp timestamp, String ipAddress) {
        // Datos de conexión a la base de datos
        
        Connection cnx = null;
        PreparedStatement statement = null;
        
        // Consulta SQL para actualizar la fecha de inicio de sesión en un campo DATETIME
        String sql = "UPDATE usuario SET fechaSesion = ?,ipUltimaSesion=? WHERE idUsuario = ?";
        
        try {
            Conexion c = new Conexion();
            cnx = c.conecta();
            statement = cnx.prepareStatement(sql);

            // Establecer los parámetros en la consulta SQL
            statement.setTimestamp(1, timestamp); // Fecha y hora actual
            statement.setString(2, ipAddress);     // Dirección IP
            statement.setInt(3, userId); // ID del usuario

            // Ejecutar la actualización
            statement.executeUpdate();
            statement.close();

        } catch (SQLException e) {
            System.err.println("Error al actualizar la fecha de inicio de sesión: " + e.getMessage());
        }
    }
    
    public String obtenerDireccionIp(HttpServletRequest request) {
        // Obtener la IP desde el encabezado de la solicitud HTTP
        String ipAddress = request.getHeader("X-Forwarded-For");
        if (ipAddress != null && !ipAddress.isEmpty() && !"unknown".equalsIgnoreCase(ipAddress)) {
            // Si hay múltiples IPs en la cabecera, tomamos la primera
            String[] ipAddresses = ipAddress.split(",");
            return ipAddresses[0].trim(); // Retornamos la primera IP
        }

        // Si no hay cabecera, usamos getRemoteAddr()
        return request.getRemoteAddr();
    }
}
