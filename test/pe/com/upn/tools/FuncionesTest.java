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
import pe.edu.dao.impl.UsuarioImpl;

/**
 *
 * @author Franzuá
 */
public class FuncionesTest {
    
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

    
}
