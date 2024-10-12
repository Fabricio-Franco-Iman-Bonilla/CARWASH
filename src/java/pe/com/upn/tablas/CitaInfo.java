package pe.com.upn.tablas;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.LinkedList;
import pe.com.upn.tools.Conexion;

public class CitaInfo {
    private int idCita;
    private String placa;
    private LocalDateTime horario;
    private int idUsuario;
    private String nombre;
    private String apellido;

    // Constructor
    public CitaInfo(int idCita, String placa, LocalDateTime horario, int idUsuario, String nombre, String apellido) {
        this.idCita = idCita;
        this.placa = placa;
        this.horario = horario;
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
    }
    public CitaInfo() {
        
    }

    // Getters y Setters
    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public LocalDateTime getHorario() {
        return horario;
    }

    public void setHorario(LocalDateTime horario) {
        this.horario = horario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
