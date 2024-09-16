package pe.com.upn.tablas;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import pe.com.upn.tools.Conexion;


public class Pago {
    private Integer id_pago ;
    private String dni;
    private String nombre_completo;
    private String placa;
    private String tipo_lavado;
    private String tamano_auto;
    private Double precio;
    public Pago() {
        
    }
    public Integer getId_pago() {
        return id_pago;
    }

    public void setId_pago(Integer id_pago) {
        this.id_pago = id_pago;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre_completo() {
        return nombre_completo;
    }

    public void setNombre_completo(String nombre_completo) {
        this.nombre_completo = nombre_completo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getTipo_lavado() {
        return tipo_lavado;
    }

    public void setTipo_lavado(String tipo_lavado) {
        this.tipo_lavado = tipo_lavado;
    }

    public String getTamano_auto() {
        return tamano_auto;
    }

    public void setTamano_auto(String tamano_auto) {
        this.tamano_auto = tamano_auto;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    
    
    public LinkedList<Pago> listar() {        
        try {
            Conexion c = new Conexion();
            Connection cnx = c.conecta();            
            String consulta = "Select * from pagos ";
            Statement sentencia = cnx.createStatement();
            ResultSet resultado = sentencia.executeQuery(consulta);
            LinkedList<Pago> lista = new LinkedList<>();            
            while(resultado.next()) {
                Pago prd = new Pago();
                prd.id_pago = resultado.getInt("id_pago");
                prd.dni = resultado.getString("dni");
                prd.nombre_completo = resultado.getString("nombre_completo");
                prd.placa = resultado.getString("placa");
                prd.tipo_lavado = resultado.getString("tipo_lavado");
                prd.tamano_auto = resultado.getString("tamano_auto");                
                prd.precio = resultado.getDouble("precio");
                lista.add(prd);
            }  
            sentencia.close();
            cnx.close();
            return lista;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    public Pago ver(Integer prd) {        
        try {
            Conexion c = new Conexion();
            Connection cnx = c.conecta();            
            String consulta = "Select * from pagos where id_pago='" + prd + "';";
            Statement sentencia = cnx.createStatement();
            ResultSet resultado = sentencia.executeQuery(consulta);
            Pago p = new Pago();
            resultado.next();
            p.id_pago = resultado.getInt("id_pago");
            p.dni = resultado.getString("dni");
            p.nombre_completo = resultado.getString("nombre_completo");
            p.placa = resultado.getString("placa");
            p.tipo_lavado = resultado.getString("tipo_lavado");
            p.tamano_auto = resultado.getString("tamano_auto");                
            p.precio = resultado.getDouble("precio");
            sentencia.close();
            cnx.close();
            return p;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    public boolean nuevo(Integer id, String dni, String nomb, String placa, String tip_lav, String tam_auto, Double precio) {
    try {
        Conexion c = new Conexion();
        Connection cnx = c.conecta();
        
        // Insertar valores omitiendo el id_pago, ya que es auto_increment
        String consulta = "INSERT INTO pagos (dni, nombre_completo, placa, tipo_lavado, tamano_auto, precio) VALUES (?, ?, ?, ?, ?, ?);";
        PreparedStatement sentencia = cnx.prepareStatement(consulta);
        
        sentencia.setString(1, dni);
        sentencia.setString(2, nomb);
        sentencia.setString(3, placa);
        sentencia.setString(4, tip_lav);
        sentencia.setString(5, tam_auto);
        sentencia.setDouble(6, precio);
        
        sentencia.executeUpdate();
        sentencia.close();
        cnx.close();
        
        return true;
    } catch (SQLException e) {
        System.out.println(e.getMessage());
        return false;
    }
}
    public void eliminar(Integer prd) {        
        try {
            Conexion c = new Conexion();
            Connection cnx = c.conecta();            
            String consulta = "delete from pagos where id_pago=?;";
            PreparedStatement sentencia = cnx.prepareStatement(consulta);
            sentencia.setInt(1, prd);
            sentencia.executeUpdate();
            sentencia.close();
            cnx.close();            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void editar(Integer id, String dni, String nomb, String placa,String tip_lav,String tam_auto,Double precio) {
        try {
            Conexion c = new Conexion();
            Connection cnx = c.conecta();            
            String consulta = "update pagos ";
            consulta += "set dni=?, nombre_completo=?, ";
            consulta += "placa=?,tipo_lavado=?,tamano_auto=?,precio=? where id_pago=?";
            PreparedStatement sentencia = cnx.prepareStatement(consulta);
            sentencia.setString(1, dni);
            sentencia.setString(2, nomb);
            sentencia.setString(3, placa);
            sentencia.setString(4, tip_lav);
            sentencia.setString(5, tam_auto);
            sentencia.setDouble(6, precio);
            sentencia.setInt(7, id);          
            sentencia.executeUpdate();
            sentencia.close();
            cnx.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
