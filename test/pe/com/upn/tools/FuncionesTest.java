/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package pe.com.upn.tools;

import java.time.LocalDateTime;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pe.com.upn.tablas.Cita;
import pe.edu.dao.entity.Usuario;
import pe.edu.dao.entity.Producto;
import pe.edu.dao.impl.ProductoImpl;
import pe.edu.dao.entity.*;
import pe.edu.dao.impl.UsuarioImpl;

/**
 *
 * @author Franzuá
 */
public class FuncionesTest {
    
    private ProductoImpl productoImpl;
    
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
        String contrasena = "Abc1233$";
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
        String nombreUsuario = "tokiro";
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
        
        /*
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
        }*/
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
     * Test of validarTelefono method, of class Funciones.
     */
    @Test
    public void testValidarTelefono() {    
        System.out.println("validarTelefono");
        String numero = "987654321";
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
        usuario.setUsuario_rol(1);
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
        Cita cita1 =new Cita();
        Cita cita2= new Cita();
        Cita cita3= new Cita();
        cita1.setFecha(LocalDateTime.of(2024, 9, 20, 10, 0));
        cita2.setFecha(LocalDateTime.of(2024, 9, 20, 10, 0));
        cita3.setFecha(LocalDateTime.of(2024, 9, 20, 11, 0));
        
        Cita[] citas = {cita1,cita2,cita3};
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
    
    
    
    
    
    
    
    
}
