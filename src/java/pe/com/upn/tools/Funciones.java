/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package pe.com.upn.tools;

import java.sql.Connection;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import pe.com.upn.tablas.Cita;
import java.sql.ResultSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import pe.edu.dao.entity.Producto;
import pe.edu.dao.entity.Usuario;
import pe.edu.dao.impl.UsuarioImpl;

/**
 *
 * @author Franzuá
 */
public class Funciones {

    public static boolean validarContrasena(String contrasena) {
        // Aquí definimos las Reglas de validación
        int longitudMinima = 8;
        boolean tieneMayuscula = false;
        boolean tieneMinuscula = false;
        boolean tieneNumero = false;
        boolean tieneCaracterEspecial = false;

        // Aquí verificamos la longitud de la contraseña
        if (contrasena.length() < longitudMinima) {
            System.out.println("La contraseña debe tener al menos " + longitudMinima + " caracteres.");
            return false;
        }

        // Verificando el contenido de la contraseña
        for (char c : contrasena.toCharArray()) {
            if (Character.isUpperCase(c)) {
                tieneMayuscula = true;
            } else if (Character.isLowerCase(c)) {
                tieneMinuscula = true;
            } else if (Character.isDigit(c)) {
                tieneNumero = true;
            } else if (isCaracterEspecial(c)) {
                tieneCaracterEspecial = true;
            }
        }

        // Verificar que todas mis reglas se están cumpliendo
        if (!tieneMayuscula) {
            System.out.println("La contraseña debe contener al menos una letra mayúscula.");
            return false;
        }
        if (!tieneMinuscula) {
            System.out.println("La contraseña debe contener al menos una letra minúscula.");
            return false;
        }
        if (!tieneNumero) {
            System.out.println("La contraseña debe contener al menos un número.");
            return false;
        }
        if (!tieneCaracterEspecial) {
            System.out.println("La contraseña debe contener al menos un carácter especial.");
            return false;
        }

        // Si pasa todas las reglas
        return true;
    }

    // Método auxiliar que se usa para verificar si un carácter es especial
    private static boolean isCaracterEspecial(char c) {
        String caracteresEspeciales = "!@#$%^&*()-_=+[]{}|;:'\",.<>?/";
        return caracteresEspeciales.indexOf(c) != -1;
    }

    public static boolean esNombreUsuarioUnico(String nombreUsuario) {

        UsuarioImpl usr = new UsuarioImpl();
        LinkedList<Usuario> usuariosExistentes = new LinkedList<>();
        usuariosExistentes = usr.listar();
        for (Usuario usuario : usuariosExistentes) {
            if (usuario.getUsuario_usuario().equals(nombreUsuario)) {
                return false; // El nombre de usuario ya existe
            }
        }
        return true; // El nombre de usuario es único
    }

    
    public static boolean validarTelefono(String numero){
        char primerDigito = numero.charAt(0);
        if(primerDigito == '9'){
            if(numero.length()== 9){
                return true;
            }
            else{
                System.out.println("El número de teléfono debe contener 9 dígitos.");
                return false;
            }
        }
        else{
            System.out.println("El primer dígito del número de teléfono debe ser 9.");
            return false;
        }
    }
    
    public static boolean validarUsuarioRol(Usuario usuario){
        int rol = usuario.getUsuario_rol();
        if(rol == 1 || rol == 2)
            return true;
        else{
            System.out.println("El usuario no tiene rol");
            return false;
        }
    }
    public static void validarProducto(Producto obj) throws IllegalArgumentException {
        if (obj.getNombre() == null || obj.getNombre().isEmpty()) {
            throw new IllegalArgumentException("El nombre del producto no puede estar vacío.");
        }

        if (obj.getStock() < 0) {
            throw new IllegalArgumentException("El stock no puede ser negativo.");
        }

        if (obj.getPrecio() <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor a 0.");
        }

        if (obj.getStockMinimo() < 0) {
            throw new IllegalArgumentException("El stock mínimo no puede ser negativo.");
        }

        if (obj.getIdProveedor() <= 0) {
            throw new IllegalArgumentException("El ID del proveedor no puede ser nulo.");
        }
    }
    
     public static boolean verificarCitasAgendadas(Cita[] citas, LocalDateTime nuevoHorario) {
        int count = 0;

        for (Cita cita : citas) {
            // Comparar el nuevo horario con los horarios ya agendados
            if (cita.getFecha().equals(nuevoHorario)) {
                count++;
            }
        }
        // Permitir máximo 2 citas en el mismo horario
        return count < 2;
    }
    
    // Función para verificar si un proveedor existe en la base de datos
    public static boolean verificarExistenciaProveedor( int idProveedor) throws SQLException {
        Conexion c = new Conexion();
        Connection cnx = c.conecta();
        String query = "SELECT COUNT(*) FROM Proveedor WHERE idProveedor = ?";
        try (PreparedStatement statement = cnx.prepareStatement(query)) {
            statement.setInt(1, idProveedor);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0;  // Retorna true si el proveedor existe
                }
            }
        }
        return false;
    }
    
     // Método para validar precios
    public boolean validarPrecio(double precio) {
        // El precio debe ser positivo
        if (precio <= 0) {
            return false;
        }
        // El precio debe tener máximo dos decimales
        if (Math.round(precio * 500.0) / 500.0 != precio) {
            return false;
        }
        return true;
    }
    
    // Método para validar el stock
    public boolean esStockValido(int stock) {
        // El stock debe ser mayor o igual a 0
        if (stock < 0) {
            return false;
        }
        // Cambia el límite máximo de stock de 1200
        if (stock > 1200) {
            return false;
        }
        return true;
    }
    
    // Función para validar el formato del correo electrónico
    public static boolean validarFormatoCorreo(String correo) {
        // Expresión regular para validar un correo electrónico
        String regex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        
        // Compilamos la expresión regular en un patrón
        Pattern pattern = Pattern.compile(regex);
        
        // Comparamos el correo con el patrón
        Matcher matcher = pattern.matcher(correo);
        
        // Retornamos true si el correo coincide con el formato
        return matcher.matches();
    }
    
    

   
}
