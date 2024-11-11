package pe.com.upn.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private Connection cnx;

    public Conexion() {
    }

    public Connection conecta() {
        //COMENTARIO PRUEBA JOMICHI
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://node166094-carwashmr.jcloud-ver-jpe.ik-server.com:3306/CAWASH?useSSL=false&connectTimeout=5000&socketTimeout=5000";
            String usr = "root";
            String psw = "hsfex3I21k";
            cnx = DriverManager.getConnection(url, usr, psw);
            String conetao = "EXITOOOOO";
            return cnx;
        } catch (ClassNotFoundException e) {
            System.out.println("Error: Driver de MySQL no encontrado.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    public int pruebaConexion() {
        Connection c = conecta();
        if (c != null) {
            return 1;
        } else {
            return 0;
        }
    }

}
