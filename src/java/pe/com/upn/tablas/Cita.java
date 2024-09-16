package pe.com.upn.tablas;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import pe.com.upn.tools.Conexion;

public class Cita {

    private String codigo;
    private String placa;
    private String fecha;
    private String usuario_id;
    private String usuario_nombre;
    private String usuario_apellido;
    
    public Cita() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(String usuario_id) {
        this.usuario_id = usuario_id;
    }    
        public String getUsuario_nombre() {
        return usuario_nombre;
    }

    public void setUsuario_nombre(String usuario_nombre) {
        this.usuario_nombre = usuario_nombre;
    }

    public String getUsuario_apellido() {
        return usuario_apellido;
    }

    public void setUsuario_apellido(String usuario_apellido) {
        this.usuario_apellido = usuario_apellido;
    }


    public LinkedList<Cita> listar() {        
        try {
            Conexion c = new Conexion();
            Connection cnx = c.conecta();            
            String consulta = "Select * from citas ";
            Statement sentencia = cnx.createStatement();
            ResultSet resultado = sentencia.executeQuery(consulta);
            LinkedList<Cita> lista = new LinkedList<>();            
            while(resultado.next()) {
                Cita cit = new Cita();
                cit.codigo = resultado.getString("codigo_cita");
                cit.placa = resultado.getString("placa");                
                cit.fecha = resultado.getString("fecha");
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
    
    public void nuevo(String cod, String plc, String fech, String id){
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
    
    public Cita ver(String cit) {        
        try {
            Conexion c = new Conexion();
            Connection cnx = c.conecta();            
            String consulta = "Select * from citas where codigo_cita='" + cit + "';";
            Statement sentencia = cnx.createStatement();
            ResultSet resultado = sentencia.executeQuery(consulta);
            Cita ct = new Cita();
            resultado.next();
            ct.codigo = resultado.getString("codigo_cita");
            ct.placa = resultado.getString("placa");
            ct.fecha = resultado.getString("fecha");
            ct.usuario_id = resultado.getString("usuario_id");
            sentencia.close();
            cnx.close();
            return ct;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    public void editar(String cod, String plac ,String fec, String id) {
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
        }    }
        
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
            
    public LinkedList<Cita> listar2(String ID) {
    LinkedList<Cita> lista = new LinkedList<>();
    
    try {
        Conexion c = new Conexion();
        Connection cnx = c.conecta();
        int x = Integer.parseInt(ID);
        
        String consulta = "SELECT c.codigo_cita, c.placa, c.fecha, c.usuario_id, u.usuario_nombre, u.usuario_apellido " +
                          "FROM usuario u " +
                          "INNER JOIN citas c ON c.usuario_id = u.usuario_id " +
                          "WHERE u.usuario_id = ?";        
        PreparedStatement sentencia = cnx.prepareStatement(consulta);
        sentencia.setInt(1, x);        
        ResultSet resultado = sentencia.executeQuery();
        
        while (resultado.next()) {
            Cita cit = new Cita();
            cit.codigo = resultado.getString("codigo_cita");
            cit.placa = resultado.getString("placa");
            cit.fecha = resultado.getString("fecha");
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
        
        
        String consulta = "SELECT  c.placa, c.fecha, c.usuario_id, u.usuario_nombre, u.usuario_apellido " +
                          "FROM usuario u " +
                          "INNER JOIN citas c ON c.usuario_id = u.usuario_id " +
                          "WHERE c.codigo_cita = ?";
        
        PreparedStatement sentencia = cnx.prepareStatement(consulta);
        sentencia.setString(1, ID);
        
        ResultSet resultado = sentencia.executeQuery();
        
        while (resultado.next()) {
            Cita cit = new Cita();
            
            cit.placa = resultado.getString("placa");
            cit.fecha = resultado.getString("fecha");
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
