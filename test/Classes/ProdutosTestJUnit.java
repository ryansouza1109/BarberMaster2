/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Classes;

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
public class ProdutosTestJUnit {
    
    public ProdutosTestJUnit() {
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

  
    
       @Test
    public void testGetNome() {
        Produtos p = new Produtos("Shampoo", 15.0);
        assertEquals("Shampoo", p.getNome());
    }

    @Test
    public void testGetPreco() {
        Produtos p = new Produtos("Shampoo", 15.0);
        assertEquals(15.0, p.getPreco(), 0.01);
    }

}
