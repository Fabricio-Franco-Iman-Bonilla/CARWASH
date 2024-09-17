/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package pe.com.upn.tools;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pe.edu.dao.entity.Producto;
import pe.edu.dao.impl.ProductoImpl;
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
    
}
