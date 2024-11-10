/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package pe.com.upn.tablas;

import pe.edu.dao.entity.Cita;

/**
 *
 * @author Franzuá
 */
public class DetalleComprobante {
    protected int idDetalle;
    protected CitaInfo cita; // Referencia a la cita asociada con este detalle

    /**
     * @return the idDetalle
     */
    public int getIdDetalle() {
        return idDetalle;
    }

    /**
     * @param idDetalle the idDetalle to set
     */
    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    /**
     * @return the cita
     */
    public CitaInfo getCita() {
        return cita;
    }

    /**
     * @param cita the cita to set
     */
    public void setCita(CitaInfo cita) {
        this.cita = cita;
    }
    public DetalleComprobante() {

    }
}
