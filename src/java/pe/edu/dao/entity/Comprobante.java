package pe.edu.dao.entity;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import pe.com.upn.tablas.DetalleComprobante;
import pe.com.upn.tools.Conexion;

public class Comprobante {

    protected int idComprobante;
    protected Date fechaEmision;
    protected String metodoPago;
    protected float subtotal;
    protected int idUsuario; // Relacionado con el usuario que emitió el comprobante
    protected List<DetalleComprobante> detalles; // Lista de detalles del comprobante

    public Comprobante() {

    }

    /**
     * @return the idComprobante
     */
    public int getIdComprobante() {
        return idComprobante;
    }

    /**
     * @param idComprobante the idComprobante to set
     */
    public void setIdComprobante(int idComprobante) {
        this.idComprobante = idComprobante;
    }

    /**
     * @return the fechaEmision
     */
    public Date getFechaEmision() {
        return fechaEmision;
    }

    /**
     * @param fechaEmision the fechaEmision to set
     */
    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    /**
     * @return the metodoPago
     */
    public String getMetodoPago() {
        return metodoPago;
    }

    /**
     * @param metodoPago the metodoPago to set
     */
    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    /**
     * @return the subtotal
     */
    public float getSubtotal() {
        return subtotal;
    }

    /**
     * @param subtotal the subtotal to set
     */
    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    /**
     * @return the idUsuario
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * @return the detalles
     */
    public List<DetalleComprobante> getDetalles() {
        return detalles;
    }

    /**
     * @param detalles the detalles to set
     */
    public void setDetalles(List<DetalleComprobante> detalles) {
        this.detalles = detalles;
    }

    

    

    
}
