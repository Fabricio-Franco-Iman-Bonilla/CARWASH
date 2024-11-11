package pe.edu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import pe.com.upn.tablas.CitaInfo;
import pe.com.upn.tablas.DetalleComprobante;
import pe.com.upn.tools.Conexion;
import pe.edu.dao.DAO;
import pe.edu.dao.entity.Cita;
import pe.edu.dao.entity.Comprobante;

/**
 *
 * @author Franzuá
 */
public class ComprobanteImpl extends Comprobante implements DAO<Comprobante> {

    @Override
    public Comprobante ver(String id) {
        try {
            Conexion c = new Conexion();
            Connection cnx = c.conecta();
            String consulta = "SELECT * FROM COMPROBANTE WHERE idComprobante = ?";
            PreparedStatement sentencia = cnx.prepareStatement(consulta);
            sentencia.setString(1, id);
            ResultSet resultado = sentencia.executeQuery();

            if (resultado.next()) {
                Comprobante comprobante = new Comprobante();
                comprobante.setIdComprobante(resultado.getInt("idComprobante"));
                comprobante.setFechaEmision(resultado.getDate("fechaEmision"));
                comprobante.setMetodoPago(resultado.getString("metodoPago"));
                comprobante.setSubtotal(resultado.getFloat("subtotal"));
                comprobante.setIdUsuario(resultado.getInt("idUsuario"));

                // Obtener detalles asociados al comprobante
                comprobante.setDetalles(obtenerDetalles(Integer.parseInt(id), cnx));

                sentencia.close();
                cnx.close();

                return comprobante;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void nuevo(Comprobante comprobante) {
        try {
            Conexion c = new Conexion();
            Connection cnx = c.conecta();
            String consulta = "INSERT INTO COMPROBANTE (fecha_emision, metodo_pago, subtotal, id_usuario) VALUES (?, ?, ?, ?)";
            PreparedStatement sentencia = cnx.prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS);

            sentencia.setDate(1, new java.sql.Date(comprobante.getFechaEmision().getTime()));
            sentencia.setString(2, comprobante.getMetodoPago());
            sentencia.setFloat(3, comprobante.getSubtotal());
            sentencia.setInt(4, comprobante.getIdUsuario());
            sentencia.executeUpdate();

            // Obtener el ID generado para el comprobante
            ResultSet generatedKeys = sentencia.getGeneratedKeys();
            if (generatedKeys.next()) {
                int idComprobanteGenerado = generatedKeys.getInt(1);

                // Guardar cada detalle de comprobante
                for (DetalleComprobante detalle : comprobante.getDetalles()) {
                    guardarDetalle(detalle, idComprobanteGenerado, cnx);
                }
            }

            sentencia.close();
            cnx.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void eliminar(String idComprobante) {
        try {
            Conexion c = new Conexion();
            Connection cnx = c.conecta();
            // Primero eliminar los detalles asociados
            String eliminarDetalles = "DELETE FROM DETALLE_COMPROBANTE WHERE idComprobante = ?";
            PreparedStatement sentenciaDetalles = cnx.prepareStatement(eliminarDetalles);
            sentenciaDetalles.setString(1, idComprobante);
            sentenciaDetalles.executeUpdate();
            sentenciaDetalles.close();

            // Luego eliminar el comprobante
            String consulta = "DELETE FROM COMPROBANTE WHERE idComprobante = ?";
            PreparedStatement sentencia = cnx.prepareStatement(consulta);
            sentencia.setString(1, idComprobante);
            sentencia.executeUpdate();
            sentencia.close();
            cnx.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void editar(Comprobante comprobante) {
        try {
            Conexion c = new Conexion();
            Connection cnx = c.conecta();
            String consulta = "UPDATE COMPROBANTE SET fechaEmision = ?, metodoPago = ?, subtotal = ?, idUsuario = ? WHERE idComprobante = ?";
            PreparedStatement sentencia = cnx.prepareStatement(consulta);

            sentencia.setDate(1, new java.sql.Date(comprobante.getFechaEmision().getTime()));
            sentencia.setString(2, comprobante.getMetodoPago());
            sentencia.setFloat(3, comprobante.getSubtotal());
            sentencia.setInt(4, comprobante.getIdUsuario());
            sentencia.setInt(5, comprobante.getIdComprobante());
            sentencia.executeUpdate();

            // Actualizar los detalles de comprobante asociados
            eliminarDetalles(comprobante.getIdComprobante(), cnx);
            for (DetalleComprobante detalle : comprobante.getDetalles()) {
                guardarDetalle(detalle, comprobante.getIdComprobante(), cnx);
            }

            sentencia.close();
            cnx.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public LinkedList<Comprobante> listar() {
        LinkedList<Comprobante> lista = new LinkedList<>();
        try {
            Conexion c = new Conexion();
            Connection cnx = c.conecta();
            String consulta = "SELECT * FROM COMPROBANTE";
            Statement sentencia = cnx.createStatement();
            ResultSet resultado = sentencia.executeQuery(consulta);

            while (resultado.next()) {
                Comprobante comprobante = new Comprobante();
                comprobante.setIdComprobante(resultado.getInt("id_comprobante"));
                comprobante.setFechaEmision(resultado.getDate("fecha_emision"));
                comprobante.setMetodoPago(resultado.getString("metodo_pago"));
                comprobante.setSubtotal(resultado.getFloat("subtotal"));
                comprobante.setIdUsuario(resultado.getInt("id_usuario"));

                // Obtener detalles asociados
                comprobante.setDetalles(obtenerDetalles(comprobante.getIdComprobante(), cnx));

                lista.add(comprobante);
            }

            sentencia.close();
            cnx.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }

    // Método auxiliar para obtener los detalles de un comprobante específico
    private List<DetalleComprobante> obtenerDetalles(int idComprobante, Connection cnx) throws SQLException {
        String consulta = "SELECT * FROM DETALLE_COMPROBANTE dc JOIN cita c ON dc.idCita = c.idCita WHERE dc.idComprobante = ?";
        PreparedStatement sentencia = cnx.prepareStatement(consulta);
        sentencia.setInt(1, idComprobante);
        ResultSet resultado = sentencia.executeQuery();

        List<DetalleComprobante> detalles = new ArrayList<>();
        while (resultado.next()) {
            DetalleComprobante detalle = new DetalleComprobante();
            detalle.setIdDetalle(resultado.getInt("id_detalle"));

            // Crear el objeto Cita con los datos correspondientes
            CitaInfo cita = new CitaInfo();
            cita.setIdCita(resultado.getInt("id_cita"));
            cita.setPlaca(resultado.getString("placa"));
            cita.setHorario(resultado.getTimestamp("horario").toLocalDateTime());
            cita.setIdUsuario(resultado.getInt("id_usuario"));
            cita.setNombre(resultado.getString("nombre"));
            cita.setApellido(resultado.getString("apellido"));
            // Otros atributos de Cita que sean necesarios

            detalle.setCita(cita);
            detalles.add(detalle);
        }
        sentencia.close();
        return detalles;
    }

    private void guardarDetalle(DetalleComprobante detalle, int idComprobante, Connection cnx) throws SQLException {
        String consulta = "INSERT INTO DETALLE_COMPROBANTE (idComprobante, idCita) VALUES (?, ?)";
        PreparedStatement sentencia = cnx.prepareStatement(consulta);
        sentencia.setInt(1, idComprobante);
        sentencia.setInt(2, detalle.getCita().getIdCita());
        sentencia.executeUpdate();
        sentencia.close();
    }

    private void eliminarDetalles(int idComprobante, Connection cnx) throws SQLException {
        String consulta = "DELETE FROM DETALLE_COMPROBANTE WHERE idComprobante = ?";
        PreparedStatement sentencia = cnx.prepareStatement(consulta);
        sentencia.setInt(1, idComprobante);
        sentencia.executeUpdate();
        sentencia.close();
    }

}
