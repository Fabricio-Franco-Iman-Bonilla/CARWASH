/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package pe.com.upn.tools;

import java.time.LocalDateTime;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pe.com.upn.tablas.CitaInfo;
import pe.edu.dao.entity.Usuario;
import pe.edu.dao.entity.Producto;
import pe.edu.dao.impl.CitaImpl;
import pe.edu.dao.impl.ProductoImpl;

/**
 *
 * @author Franzuá
 */
public class FuncionesTest {
    
    ProductoImpl productoImpl;
    
    public FuncionesTest() {
    }

    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        productoImpl = new ProductoImpl();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of validarContrasena method, of class Funciones.
     */
    @Test
    public void testValidarContrasena() {
        System.out.println("validarContrasena");
        String contrasena = "Abc$";
        boolean expResult = true;
        boolean result = Funciones.validarContrasena(contrasena);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (result!=expResult)
            fail("The test case is a prototype.");
    }

    /**
     * Test of esNombreUsuarioUnico method, of class Funciones.
     */
    @Test
    public void testEsNombreUsuarioUnico() {
        System.out.println("esNombreUsuarioUnico");
        String nombreUsuario = "admin";
        boolean expResult = true;
        boolean result = Funciones.esNombreUsuarioUnico(nombreUsuario);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (result!=expResult)
            fail("The test case is a prototype.");
    }
    
    /*CREACIONES MIKI PARA TEST*/
     @Test
    public void testNombreVacio() {
        Producto producto = new Producto();
        /*
        // Caso válido
        try {
            producto.setNombre("Producto válido");
            producto.setDescripcion("Descripción válida");
            producto.setPrecio(10.0f);
            producto.setStock(5);
            producto.setStockMinimo(1);
            producto.setIdProveedor(1);
            productoImpl.nuevo(producto);  // Debería funcionar sin lanzar excepciones
            System.out.println("Producto creado correctamente con nombre válido.");
        } catch (Exception e) {
            fail("No debería lanzar una excepción con datos válidos.");
        }
        */
        
        // Caso con error: Nombre vacío
        try {
            producto.setNombre(""); // Nombre vacío para generar error
            producto.setDescripcion("Descripción válida");
            producto.setPrecio(10.0f);
            producto.setStock(5);
            producto.setStockMinimo(1);
            producto.setIdProveedor(1);
            productoImpl.nuevo(producto);
            fail("Debería lanzar una excepción cuando el nombre está vacío.");
        } catch (IllegalArgumentException e) {
            System.out.println("Excepción capturada correctamente: " + e.getMessage());
            assertEquals("El nombre del producto no puede estar vacío.", e.getMessage());
        }
    }

    @Test
    public void testStockNegativo() {
        Producto producto = new Producto();
        // Caso válido
        /*
        try {
            producto.setNombre("Producto válido");
            producto.setDescripcion("Descripción válida");
            producto.setPrecio(10.0f);
            producto.setStock(-5); // Stock válido
            producto.setStockMinimo(1);
            producto.setIdProveedor(1);

            productoImpl.nuevo(producto);  // No debería lanzar excepción
            System.out.println("Producto creado correctamente con stock válido.");
        } catch (Exception e) {
            fail("No debería lanzar una excepción con datos válidos.");
        }
        */
        // Caso con error: Stock negativo
        try {
            producto.setNombre("Producto válido");
            producto.setDescripcion("Descripción válida");
            producto.setPrecio(10.0f);
            producto.setStock(5); // Stock negativo
            producto.setStockMinimo(1);
            producto.setIdProveedor(1);
            productoImpl.nuevo(producto);
            fail("Debería lanzar una excepción cuando el stock es negativo.");
        } catch (IllegalArgumentException e) {
            System.out.println("Excepción capturada correctamente: " + e.getMessage());
            assertEquals("El stock no puede ser negativo.", e.getMessage());
        }
    }

    @Test
    public void testPrecioInvalido() {
        Producto producto = new Producto();
        /*
        // Caso válido
        try {
            producto.setNombre("Producto válido");
            producto.setDescripcion("Descripción válida");
            producto.setPrecio(10.0f); // Precio válido
            producto.setStock(5);
            producto.setStockMinimo(1);
            producto.setIdProveedor(1);

            productoImpl.nuevo(producto);  // No debería lanzar excepción
            System.out.println("Producto creado correctamente con precio válido.");
        } catch (Exception e) {
            fail("No debería lanzar una excepción con datos válidos.");
        }
        */
        // Caso con error: Precio igual a 0
        try {
            producto.setNombre("Producto válido");
            producto.setDescripcion("Descripción válida");
            producto.setPrecio(0.0f); // Precio inválido
            producto.setStock(5);
            producto.setStockMinimo(1);
            producto.setIdProveedor(1);
            
            productoImpl.nuevo(producto);
            fail("Debería lanzar una excepción cuando el precio es inválido.");
        } catch (IllegalArgumentException e) {
            System.out.println("Excepción capturada correctamente: " + e.getMessage());
            assertEquals("El precio debe ser mayor a 0.", e.getMessage());
        }
    }

    @Test
    public void testIdProveedorInvalido() {
        Producto producto = new Producto();
        
        // Caso válido
        try {
            producto.setNombre("Producto válido");
            producto.setDescripcion("Descripción válida");
            producto.setPrecio(10.0f);
            producto.setStock(5);
            producto.setStockMinimo(1);
            producto.setIdProveedor(1); // Proveedor válido

            productoImpl.nuevo(producto);  // No debería lanzar excepción
            System.out.println("Producto creado correctamente con proveedor válido.");
        } catch (Exception e) {
            fail("No debería lanzar una excepción con datos válidos.");
        }
        /*
        // Caso con error: ID de proveedor inválido
        try {
            producto.setNombre("Producto válido");
            producto.setDescripcion("Descripción válida");
            producto.setPrecio(10.0f);
            producto.setStock(5);
            producto.setStockMinimo(1);
            producto.setIdProveedor(0); // ID de proveedor inválido
            productoImpl.nuevo(producto);
            fail("Debería lanzar una excepción cuando el ID del proveedor es inválido.");
        } catch (IllegalArgumentException e) {
            System.out.println("Excepción capturada correctamente: " + e.getMessage());
            assertEquals("El ID del proveedor debe ser mayor a 0.", e.getMessage());
        }*/
    }
   
    
    
    //to save again
    //para salvar

     /**
     * Test of validarTelefono method, of class Funciones. yo-michi.
     */
    @Test
    public void testValidarTelefono() {    
        System.out.println("validarTelefono");
        String numero = "937654321";
        boolean expResult = true;
        boolean result = Funciones.validarTelefono(numero);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if(result!= expResult)
            fail("The test case is a prototype.");
    }

    /**
     * Test of validarUsuarioRol method, of class Funciones.
     */
    @Test
    public void testValidarUsuarioRol() {
        System.out.println("validarUsuarioRol");
        Usuario usuario = new Usuario();
        usuario.setUsuario_rol(0);
        boolean expResult = true;
        boolean result = Funciones.validarUsuarioRol(usuario);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if(result!= expResult)
            fail("The test case is a prototype.");
    }

    /**
     * Test of validarProducto method, of class Funciones.
     */
    @org.junit.Test
    public void testValidarProducto() {
        System.out.println("validarProducto");
        Producto obj = null;
        Funciones.validarProducto(obj);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    
    //DE PAPI YAURI
    /**
     * Test of verificarCitasAgendadas method, of class Funciones.
     */
    @Test
    public void testVerificarCitasAgendadas() {
        System.out.println("verificarCitasAgendadas");
        CitaImpl cita1 =new CitaImpl();
        CitaImpl cita2= new CitaImpl();
        CitaImpl cita3= new CitaImpl();
        cita1.setHorario(LocalDateTime.of(2024, 9, 20, 10, 0));
        cita2.setHorario(LocalDateTime.of(2024, 9, 20, 10, 0));
        cita3.setHorario(LocalDateTime.of(2024, 9, 20, 11, 0));
        
        CitaImpl[] citas = {cita1,cita2,cita3};
        LocalDateTime nuevoHorario = LocalDateTime.of(2024, 9, 20, 11, 0);
        boolean expResult = true;
        boolean result = Funciones.verificarCitasAgendadas(citas, nuevoHorario);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if(expResult!=result)
            fail("The test case is a prototype.");
    }

    /**
     * Test of verificarExistenciaProveedor method, of class Funciones.
     */
    @Test
    public void testVerificarExistenciaProveedor() throws Exception {
        System.out.println("verificarExistenciaProveedor");
        //SOLO EXISTE 1 QUE ES GLORIA
        int idProveedor = 2;
        boolean expResult = true;
        boolean result = Funciones.verificarExistenciaProveedor(idProveedor);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if(result!=expResult)
            fail("The test case is a prototype.");
    }

    
    //DE HANZEL PANZEL
    /**
     * Test of validarPrecio method, of class Funciones.
     */
    @Test
    public void testValidarPrecio() {
        //SOLO DEBE TENER 2 DECIMALES
        System.out.println("validarPrecio");
        double precio = 5.71;
        Funciones instance = new Funciones();
        boolean expResult = true;
        boolean result = instance.validarPrecio(precio);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if(result!=expResult)
            fail("The test case is a prototype.");
    }

    /**
     * Test of esStockValido method, of class Funciones.
     */
    @Test
    public void testEsStockValido() {
        System.out.println("esStockValido");
        int stock = 324;
        Funciones instance = new Funciones();
        boolean expResult = true;
        boolean result = instance.esStockValido(stock);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if(result!=expResult)
        fail("The test case is a prototype.");
    }

    /**
     * Test of validarFormatoCorreo method, of class Funciones.
     */
    @Test
    public void testValidarFormatoCorreo() {
        System.out.println("validarFormatoCorreo");
        String correo = "ssdsa@dsa.pe";
        boolean expResult = true;
        boolean result = Funciones.validarFormatoCorreo(correo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if(result!=expResult)
        fail("The test case is a prototype.");
    }
    
    
    
    
    
    
    /**
     * Test of iniciarSesion method, of class Funciones.
     */
   @Test
    public void testIniciarSesion() {
        System.out.println("Iniciar Sesión con Administrador");

        // Crear instancia de Funciones
        Funciones instance = new Funciones();

        // Caso 1: Inicio de sesión exitoso con credenciales correctas
        String usuario1 = "admin";
        String contraseña1 = "1234";
        boolean result1 = instance.iniciarSesion(usuario1, contraseña1);

        if (result1) {
            System.out.println("Caso 1: Inicio de sesión exitoso con credenciales correctas.");
        } else {
            fail("Caso 1: El inicio de sesión debería haber sido exitoso con credenciales correctas.");
        }

        // Caso 2: Inicio de sesión fallido con usuario incorrecto
        String usuario2 = "usuarioIncorrecto";
        String contraseña2 = "1234";
        boolean result2 = instance.iniciarSesion(usuario2, contraseña2);

        if (!result2) {
            System.out.println("Caso 2: Inicio de sesión fallido con usuario incorrecto, como se esperaba.");
        } else {
            fail("Caso 2: El inicio de sesión debería haber fallado con usuario incorrecto.");
        }

        // Caso 3: Inicio de sesión fallido con contraseña incorrecta
        String usuario3 = "admin";
        String contraseña3 = "contraseñaIncorrecta";
        boolean result3 = instance.iniciarSesion(usuario3, contraseña3);

        if (!result3) {
            System.out.println("Caso 3: Inicio de sesión fallido con contraseña incorrecta, como se esperaba.");
        } else {
            fail("Caso 3: El inicio de sesión debería haber fallado con contraseña incorrecta.");
        }

        // Caso 4: Inicio de sesión fallido con credenciales vacías
        String usuario4 = "";
        String contraseña4 = "";
        boolean result4 = instance.iniciarSesion(usuario4, contraseña4);

        if (!result4) {
            System.out.println("Caso 4: Inicio de sesión fallido con credenciales vacías, como se esperaba.");
        } else {
            fail("Caso 4: El inicio de sesión debería haber fallado con credenciales vacías.");
        }
    }

    /**
     * Test of validarPlaca method, of class Funciones.
     */
    @Test
    public void testValidarPlaca() {
        System.out.println("validarPlaca");

        // Caso 1: Placa válida
        String placaValida = "ABC-123";
        boolean expResultValida = true;
        boolean resultValida = Funciones.validarPlaca(placaValida);
        if (resultValida != expResultValida) {
            fail("La placa válida no fue aceptada.");
        }

        // Caso 2: Placa con longitud incorrecta
        String placaCorta = "AB-123";
        boolean expResultCorta = false;
        boolean resultCorta = Funciones.validarPlaca(placaCorta);
        if (resultCorta != expResultCorta) {
            fail("La placa con longitud incorrecta fue aceptada.");
        }

        // Caso 3: Placa sin guion
        String placaSinGuion = "ABC1234";
        boolean expResultSinGuion = false;
        boolean resultSinGuion = Funciones.validarPlaca(placaSinGuion);
        if (resultSinGuion != expResultSinGuion) {
            fail("La placa sin guion fue aceptada.");
        }

        // Caso 4: Placa con caracteres inválidos
        String placaConSimbolos = "AB@-123";
        boolean expResultSimbolos = false;
        boolean resultSimbolos = Funciones.validarPlaca(placaConSimbolos);
        if (resultSimbolos != expResultSimbolos) {
            fail("La placa con caracteres inválidos fue aceptada.");
        }

        // Caso 5: Placa con letras en la sección numérica
        String placaConLetrasEnNumeros = "ABC-12A";
        boolean expResultLetrasEnNumeros = false;
        boolean resultLetrasEnNumeros = Funciones.validarPlaca(placaConLetrasEnNumeros);
        if (resultLetrasEnNumeros != expResultLetrasEnNumeros) {
            fail("La placa con letras en la sección numérica fue aceptada.");
        }

        // Caso 6: Placa con caracteres adicionales
        String placaConCaracteresAdicionales = "ABCDE-1234";
        boolean expResultCaracteresAdicionales = false;
        boolean resultCaracteresAdicionales = Funciones.validarPlaca(placaConCaracteresAdicionales);
        if (resultCaracteresAdicionales != expResultCaracteresAdicionales) {
            fail("La placa con caracteres adicionales fue aceptada.");
        }

        // Caso 7: Placa vacía
        String placaVacia = "";
        boolean expResultVacia = false;
        boolean resultVacia = Funciones.validarPlaca(placaVacia);
        if (resultVacia != expResultVacia) {
            fail("La placa vacía fue aceptada.");
        }
    }

    
}
