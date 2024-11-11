package pe.edu.dao.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.concurrent.CompletableFuture;
import javax.servlet.http.HttpServletRequest;
import pe.com.upn.tablas.CitaInfo;
import pe.com.upn.tools.Conexion;
import pe.com.upn.tools.Funciones;
import pe.com.upn.tools.Hash;
import pe.edu.dao.DAO;
import pe.edu.dao.entity.Cita;

public class CitaImpl extends Cita implements DAO<Cita> {

    public CitaImpl() {
    }

    @Override
    public Cita ver(String id) {
        try {
            Conexion c = new Conexion();
            Connection cnx = c.conecta();
            String consulta = "Select * from CITA where idCita='" + id + "';";
            Statement sentencia = cnx.createStatement();
            ResultSet resultado = sentencia.executeQuery(consulta);
            
            resultado.next();
            this.id=resultado.getInt("idCita");
            this.idVehiculo=resultado.getInt("idVehiculo");
            this.estado=resultado.getString("estado");
            this.horario=resultado.getTimestamp("horario").toLocalDateTime();
            this.idUsuario=resultado.getInt("idUsuario");
            this.idPersona=resultado.getInt("idPersona");
            sentencia.close();
            cnx.close();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    //Continuar corrigiendo desde aquí
    @Override
    public LinkedList<Cita> listar() {
        //RER
        try {
            Conexion c = new Conexion();
            Connection cnx = c.conecta();
            String consulta = "Select * from CITA ";
            Statement sentencia = cnx.createStatement();
            ResultSet resultado = sentencia.executeQuery(consulta);
            LinkedList<Cita> lista = new LinkedList<>();
            while (resultado.next()) {
                Cita ct = new Cita();
                ct.setId(resultado.getInt("idCita"));
                ct.setIdVehiculo(resultado.getInt("idVehiculo"));
                ct.setEstado(resultado.getString("estado"));
                ct.setHorario(resultado.getTimestamp("horario").toLocalDateTime());
                ct.setIdUsuario(resultado.getInt("idUsuario"));
                ct.setIdPersona(resultado.getInt("idPersona"));
                lista.add(ct);
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
    public void nuevo(Cita obj) {
        try {
            Conexion c = new Conexion();
            Connection cnx = c.conecta();
            LocalDateTime horario = obj.getHorario();
            Timestamp timestamp = Timestamp.valueOf(horario);

            String consulta = "insert into CITA (estado,horario,idUsuario,idPersona,idVehiculo) values(?,?,?,?,?);";
            PreparedStatement sentencia = cnx.prepareStatement(consulta);
            sentencia.setString(1, obj.getEstado());
            sentencia.setTimestamp(2, timestamp);
            sentencia.setInt(3, obj.getIdUsuario());
            sentencia.setInt(4, obj.getIdPersona());
            sentencia.setInt(5, obj.getIdVehiculo());
            sentencia.executeUpdate();
            sentencia.close();
            cnx.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void eliminar(String id) {
        try {
            Conexion c = new Conexion();
            Connection cnx = c.conecta();
            String consulta = "delete from CITA where idCita=?;";
            PreparedStatement sentencia = cnx.prepareStatement(consulta);
            sentencia.setString(1, id);
            sentencia.executeUpdate();
            sentencia.close();
            cnx.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void editar(Cita obj) {
        try {
            Conexion c = new Conexion();
            Connection cnx = c.conecta();
            LocalDateTime horario = obj.getHorario();
            Timestamp timestamp = Timestamp.valueOf(horario);
            
            String consulta = "update CITA ";
            consulta += "set estado=?, horario=?, ";
            consulta += "idUsuario=?, idPersona=?, idVehiculo=?  where idCita=?";
            PreparedStatement sentencia = cnx.prepareStatement(consulta);

            sentencia.setString(1, obj.getEstado());
            sentencia.setTimestamp(2, timestamp);
            sentencia.setInt(3, obj.getIdUsuario());
            sentencia.setInt(4, obj.getIdPersona());
            sentencia.setInt(5, obj.getIdVehiculo());
            sentencia.setInt(6, obj.getId());
            sentencia.executeUpdate();
            sentencia.close();
            cnx.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public LinkedList<CitaInfo> listar2(String ID) {
        LinkedList<CitaInfo> lista = new LinkedList<>();

        try {
            Conexion c = new Conexion();
            Connection cnx = c.conecta();
            int x = Integer.parseInt(ID);

            String consulta = "SELECT C.idCita, V.placa, C.horario, U.idUsuario, P.nombre, P.apellido "
                    + "FROM CITA C "
                    + "INNER JOIN VEHICULO V ON C.idVehiculo = V.idVehiculo "
                    +"INNER JOIN USUARIO U ON C.idUsuario = U.idUsuario "
                    +"INNER JOIN PERSONA P ON U.idPersona = P.idPersona "
                    + "WHERE u.idUsuario = ?";
            PreparedStatement sentencia = cnx.prepareStatement(consulta);
            sentencia.setInt(1, x);
            ResultSet resultado = sentencia.executeQuery();

            while (resultado.next()) {
                CitaInfo cit = new CitaInfo();
                cit.setIdCita(resultado.getInt("idCita"));
                cit.setPlaca(resultado.getString("placa"));
                cit.setHorario(resultado.getTimestamp("horario").toLocalDateTime());
                cit.setIdUsuario(resultado.getInt("idUsuario"));
                cit.setNombre(resultado.getString("nombre"));
                cit.setApellido(resultado.getString("apellido"));
                lista.add(cit);
            }
            resultado.close();
            sentencia.close();
            cnx.close();

            return lista;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error en la conversión del ID: " + e.getMessage());
        }
        return null;
    }

    public CitaInfo listar3(String ID) {
        CitaInfo cit = new CitaInfo();

        try {
            Conexion c = new Conexion();
            Connection cnx = c.conecta();

            String consulta = "SELECT C.idCita, V.placa, C.horario, U.idUsuario, P.nombre, P.apellido "
                    + "FROM CITA C "
                    + "INNER JOIN VEHICULO V ON C.idVehiculo = V.idVehiculo "
                    +"INNER JOIN USUARIO U ON C.idUsuario = U.idUsuario "
                    +"INNER JOIN PERSONA P ON U.idPersona = P.idPersona "
                    + " WHERE C.idCita = ?";

            PreparedStatement sentencia = cnx.prepareStatement(consulta);
            sentencia.setString(1, ID);

            ResultSet resultado = sentencia.executeQuery();

            resultado.next();
                
                cit.setIdCita(resultado.getInt("idCita"));
                cit.setPlaca(resultado.getString("placa"));
                cit.setHorario(resultado.getTimestamp("horario").toLocalDateTime());
                cit.setIdUsuario(resultado.getInt("idUsuario"));
                cit.setNombre(resultado.getString("nombre"));
                cit.setApellido(resultado.getString("apellido"));
                
            

            resultado.close();
            sentencia.close();
            cnx.close();

            return cit;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error en la conversión del ID: " + e.getMessage());
        }
        return null;
    }
}
