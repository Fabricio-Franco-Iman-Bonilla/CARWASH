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
            String consulta = "Select * from cita where idCita='" + id + "';";
            Statement sentencia = cnx.createStatement();
            ResultSet resultado = sentencia.executeQuery(consulta);
            Cita ct = new Cita();
            resultado.next();
            ct.setId(resultado.getInt("idCita"));
            ct.setIdVehiculo(resultado.getInt("idVehiculo"));
            ct.setEstado(resultado.getString("estado"));
            ct.setHorario(LocalDateTime.parse(resultado.getString("horario")));
            ct.setIdUsuario(resultado.getInt("idUsuario"));
            ct.setIdPersona(resultado.getInt("idPersona"));
            sentencia.close();
            cnx.close();
            return ct;
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
            String consulta = "Select * from citas ";
            Statement sentencia = cnx.createStatement();
            ResultSet resultado = sentencia.executeQuery(consulta);
            LinkedList<Cita> lista = new LinkedList<>();
            while (resultado.next()) {
                Cita cit = new Cita();
                cit.codigo = resultado.getString("codigo_cita");
                cit.placa = resultado.getString("placa");
                cit.horario = LocalDateTime.parse(resultado.getString("fecha"));
                cit.usuario_id = resultado.getString("usuario_id");
                lista.add(cit);
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
            int xd = Integer.parseInt(id);

            String consulta = "insert into citas values(?,?,?,?);";
            PreparedStatement sentencia = cnx.prepareStatement(consulta);
            sentencia.setString(1, cod);
            sentencia.setString(2, plc);
            sentencia.setString(3, fech);
            sentencia.setInt(4, xd);
            sentencia.executeUpdate();
            sentencia.close();
            cnx.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void eliminar(String cod) {
        try {
            Conexion c = new Conexion();
            Connection cnx = c.conecta();
            String consulta = "delete from citas where codigo_cita=?;";
            PreparedStatement sentencia = cnx.prepareStatement(consulta);
            sentencia.setString(1, cod);
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
            String consulta = "update citas ";
            consulta += "set placa=?, fecha=?, ";
            consulta += "usuario_id=? where codigo_cita=?";
            PreparedStatement sentencia = cnx.prepareStatement(consulta);

            sentencia.setString(1, plac);
            sentencia.setString(2, fec);
            sentencia.setString(3, id);
            sentencia.setString(4, cod);
            sentencia.executeUpdate();
            sentencia.close();
            cnx.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public LinkedList<Cita> listar2(String ID) {
        LinkedList<Cita> lista = new LinkedList<>();

        try {
            Conexion c = new Conexion();
            Connection cnx = c.conecta();
            int x = Integer.parseInt(ID);

            String consulta = "SELECT c.codigo_cita, c.placa, c.fecha, c.usuario_id, u.usuario_nombre, u.usuario_apellido "
                    + "FROM usuario u "
                    + "INNER JOIN citas c ON c.usuario_id = u.usuario_id "
                    + "WHERE u.usuario_id = ?";
            PreparedStatement sentencia = cnx.prepareStatement(consulta);
            sentencia.setInt(1, x);
            ResultSet resultado = sentencia.executeQuery();

            while (resultado.next()) {
                Cita cit = new Cita();
                cit.codigo = resultado.getString("codigo_cita");
                cit.placa = resultado.getString("placa");
                cit.horario = LocalDateTime.parse(resultado.getString("fecha"));
                cit.usuario_id = resultado.getString("usuario_id");
                cit.usuario_nombre = resultado.getString("usuario_nombre");
                cit.usuario_apellido = resultado.getString("usuario_apellido");
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
    
    public LinkedList<Cita> listar3(String ID) {
        LinkedList<Cita> lista = new LinkedList<>();

        try {
            Conexion c = new Conexion();
            Connection cnx = c.conecta();

            String consulta = "SELECT  c.placa, c.fecha, c.usuario_id, u.usuario_nombre, u.usuario_apellido "
                    + "FROM usuario u "
                    + "INNER JOIN citas c ON c.usuario_id = u.usuario_id "
                    + "WHERE c.codigo_cita = ?";

            PreparedStatement sentencia = cnx.prepareStatement(consulta);
            sentencia.setString(1, ID);

            ResultSet resultado = sentencia.executeQuery();

            while (resultado.next()) {
                Cita cit = new Cita();

                cit.placa = resultado.getString("placa");
                cit.horario = LocalDateTime.parse(resultado.getString("fecha"));
                cit.usuario_id = resultado.getString("usuario_id");
                cit.usuario_nombre = resultado.getString("usuario_nombre");
                cit.usuario_apellido = resultado.getString("usuario_apellido");
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
}
