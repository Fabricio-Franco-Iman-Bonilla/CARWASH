
package pe.com.upn.tablas;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import pe.com.upn.tools.Conexion;

public class Producto {
    private String codigo;
    private String nombre;
    private String descripcion;
    private String cantidad;
    
    public Producto() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

   
    
    
    public LinkedList<Producto> listar() {        
        try {
            Conexion c = new Conexion();
            Connection cnx = c.conecta();            
            String consulta = "Select * from productos ";
            Statement sentencia = cnx.createStatement();
            ResultSet resultado = sentencia.executeQuery(consulta);
            LinkedList<Producto> lista = new LinkedList<>();            
            while(resultado.next()) {
                Producto prd = new Producto();
                prd.codigo = resultado.getString("codigo_producto");
                prd.nombre = resultado.getString("nombre_producto");
                prd.descripcion = resultado.getString("descripcion_producto");
                prd.cantidad = resultado.getString("cantidad_producto");
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
    
    public Producto ver(String prd) {        
        try {
            Conexion c = new Conexion();
            Connection cnx = c.conecta();            
            String consulta = "Select * from productos where codigo_producto='" + prd + "';";
            Statement sentencia = cnx.createStatement();
            ResultSet resultado = sentencia.executeQuery(consulta);
            Producto p = new Producto();
            resultado.next();
            p.codigo = resultado.getString("codigo_producto");
            p.nombre = resultado.getString("nombre_producto");
            p.descripcion = resultado.getString("descripcion_producto");
            p.cantidad = resultado.getString("cantidad_producto");
            sentencia.close();
            cnx.close();
            return p;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    public void nuevo(String cod, String nom, String desc, String can){
        try {
            Conexion c = new Conexion();
            Connection cnx = c.conecta();            
            String consulta = "insert into productos values(?,?,?,?);";
            PreparedStatement sentencia = cnx.prepareStatement(consulta);
            sentencia.setString(1, cod);
            sentencia.setString(2, nom);
            sentencia.setString(3, desc);
            sentencia.setString(4, can);
            sentencia.executeUpdate();
            sentencia.close();
            cnx.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
        
    public void eliminar(String prd) {        
        try {
            Conexion c = new Conexion();
            Connection cnx = c.conecta();            
            String consulta = "delete from productos where codigo_producto=?;";
            PreparedStatement sentencia = cnx.prepareStatement(consulta);
            sentencia.setString(1, prd);
            sentencia.executeUpdate();
            sentencia.close();
            cnx.close();            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void editar(String cod, String nom, String desc, String can) {
        try {
            Conexion c = new Conexion();
            Connection cnx = c.conecta();            
            String consulta = "update productos ";
            consulta += "set nombre_producto=?, descripcion_producto=?, ";
            consulta += "cantidad_producto=? where codigo_producto=?";
            PreparedStatement sentencia = cnx.prepareStatement(consulta);
            sentencia.setString(1, nom);            
            sentencia.setString(2, desc);
            sentencia.setString(3, can);
            sentencia.setString(4, cod);            
            sentencia.executeUpdate();
            sentencia.close();
            cnx.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
