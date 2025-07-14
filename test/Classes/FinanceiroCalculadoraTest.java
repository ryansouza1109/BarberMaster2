/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Classes;

import negocios.FinanceiroCalculadora;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ryanp
 */
public class FinanceiroCalculadoraTest {
    
    public FinanceiroCalculadoraTest() {
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    FinanceiroCalculadora calc = new FinanceiroCalculadora();
    @Test
    public void testCalcularSaldoFinal() {
        assertEquals(600.0, calc.calcularSaldoFinal(1000.0, 400.0), 0.01);
    }

    @Test
    public void testSomarLucro() {
        assertEquals(700.0, calc.somarLucro(500.0, 200.0), 0.01);
    }

    @Test
    public void testSomarGastos() {
        assertEquals(450.0, calc.somarGastos(300.0, 150.0), 0.01);
    }

    @Test
    public void testResetarValor() {
        assertEquals(0.0, calc.resetarValor(), 0.01);
    }
}
