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
    public Producto ver(String id) {
        try {
            Conexion c = new Conexion();
            Connection cnx = c.conecta();            
            String consulta = "Select * from producto where idProducto='" + id + "';";
            Statement sentencia = cnx.createStatement();
            ResultSet resultado = sentencia.executeQuery(consulta);            
            resultado.next();
            this.id = resultado.getInt("idProducto");
            this.nombre=resultado.getString("nombre");
            this.descripcion=(resultado.getString("descripcion"));
            this.precio = resultado.getFloat("precio");
            this.stock = resultado.getInt("stock");
            this.stockMinimo = resultado.getInt("stockMinimo");
            this.idProveedor = resultado.getInt("idProveedor");
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
            String consulta = "Select * from producto";
            Statement sentencia = cnx.createStatement();
            ResultSet resultado = sentencia.executeQuery(consulta);
            LinkedList<Producto> lista = new LinkedList<>();            
            while(resultado.next()) {
                Producto pro = new Producto();
                pro.setId(resultado.getInt("idProducto"));
                pro.setNombre(resultado.getString("nombre"));
                pro.setDescripcion(resultado.getString("descripcion"));
                pro.setPrecio(resultado.getFloat("precio"));
                pro.setStock(resultado.getInt("stock"));
                pro.setStockMinimo(resultado.getInt("stockMinimo"));
                pro.setIdProveedor(resultado.getInt("idProveedor"));
                
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
            String consulta = "insert into producto (nombre,descripcion,precio,stock,stockMinimo,idProveedor)  values(?,?,?,?,?,?);";
            PreparedStatement sentencia = cnx.prepareStatement(consulta);
            sentencia.setString(1, obj.getNombre());
            sentencia.setString(2, obj.getDescripcion());
            sentencia.setFloat(3, obj.getPrecio());
            sentencia.setInt(4, obj.getStock());
            sentencia.setInt(5, obj.getStockMinimo());
            sentencia.setInt(6, obj.getIdProveedor());
            
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
            String consulta = "delete from producto where idProducto=?;";
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
            String consulta = "UPDATE PRODUCTO SET nombre = ?, descripcion = ?, precio = ?, stock = ?,stockMinimo=?, idProveedor = ? WHERE idProducto = ?";
            PreparedStatement sentencia = cnx.prepareStatement(consulta);
            sentencia.setString(1, obj.getNombre());            
            sentencia.setString(2, obj.getDescripcion());
            sentencia.setFloat(3, obj.getPrecio());
            sentencia.setInt(4, obj.getStock());     
            sentencia.setInt(5, obj.getStockMinimo()); 
            sentencia.setInt(6, obj.getIdProveedor()); 
            sentencia.setInt(7, obj.getId()); 
            sentencia.executeUpdate();
            sentencia.close();
            cnx.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

   
    
}
