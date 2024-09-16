package pe.edu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import pe.com.upn.tools.Conexion;
import pe.edu.dao.DAO;
import pe.edu.dao.entity.Producto;

/**
 *
 * @author tokiro
 */
public class ProductoImpl extends Producto implements DAO<Producto> {

    public ProductoImpl() {
    }
    
    @Override
    public Producto ver(String prd) {
        try {
            Conexion c = new Conexion();
            Connection cnx = c.conecta();            
            String consulta = "Select * from productos where codigo_producto='" + prd + "';";
            Statement sentencia = cnx.createStatement();
            ResultSet resultado = sentencia.executeQuery(consulta);            
            resultado.next();
            this.codigo = resultado.getString("codigo_producto");
            this.nombre = resultado.getString("nombre_producto");
            this.descripcion = resultado.getString("descripcion_producto");
            this.cantidad = resultado.getString("cantidad_producto");
            sentencia.close();
            cnx.close();            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public LinkedList<Producto> listar() {
        try {
            Conexion c = new Conexion();
            Connection cnx = c.conecta();            
            String consulta = "Select * from productos ";
            Statement sentencia = cnx.createStatement();
            ResultSet resultado = sentencia.executeQuery(consulta);
            LinkedList<Producto> lista = new LinkedList<>();            
            while(resultado.next()) {
                Producto pro = new Producto();
                pro.setCodigo(resultado.getString("codigo_producto"));
                pro.setNombre(resultado.getString("nombre_producto"));
                pro.setDescripcion(resultado.getString("descripcion_producto"));
                pro.setCantidad(resultado.getString("cantidad_producto"));
                lista.add(pro);
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
    public void nuevo(Producto obj) {
        try {
            Conexion c = new Conexion();
            Connection cnx = c.conecta();            
            String consulta = "insert into productos values(?,?,?,?);";
            PreparedStatement sentencia = cnx.prepareStatement(consulta);
            sentencia.setString(1, obj.getCodigo());
            sentencia.setString(2, obj.getNombre());
            sentencia.setString(3, obj.getDescripcion());
            sentencia.setString(4, obj.getCantidad());
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
            String consulta = "delete from productos where codigo_producto=?;";
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
    public void editar(Producto obj) {
        try {
            Conexion c = new Conexion();
            Connection cnx = c.conecta();            
            String consulta = "update productos ";
            consulta += "set nombre_producto=?, descripcion_producto=?, ";
            consulta += "cantidad_producto=? where codigo_producto=?";
            PreparedStatement sentencia = cnx.prepareStatement(consulta);
            sentencia.setString(1, obj.getNombre());            
            sentencia.setString(2, obj.getDescripcion());
            sentencia.setString(3, obj.getCantidad());
            sentencia.setString(4, obj.getCodigo());            
            sentencia.executeUpdate();
            sentencia.close();
            cnx.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String obtenerUsuarioIdPorCorreo(String correo) {
        return null;
    }
    
}
