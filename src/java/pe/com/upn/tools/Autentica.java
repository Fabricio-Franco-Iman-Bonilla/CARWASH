package pe.com.upn.tools;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
        
public class Autentica {
  
    private int logueado;

    public Autentica() {
    }

    public void setLogueado(int logueado) {
        this.logueado = logueado;
    }
    
    public int getLogueado(String usr, String psw) {
        
        try {
            Conexion c = new Conexion();
            Connection cnx = c.conecta();
            //int contador = 0;
            
            String consulta = "Select idRol from usuario where usuario='"+
                    usr+"' and contrasena='"+psw+"';";
            
            Statement sentencia = cnx.createStatement();
            ResultSet resultado = sentencia.executeQuery(consulta);
            
            if(resultado.next()) {
                logueado = resultado.getInt("idRol");
            }
            return logueado;
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return -1;
    }
}
