/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upmc.game;

import upmc.game.Carte;
import junit.framework.TestCase;

/**
 *
 * @author licence
 */
public class CarteTest extends TestCase {
    
    public CarteTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of superieur method, of class Carte.
     */
    public void testSuperieur() {
        System.out.println("superieur");
        Carte carteSup = new Carte(5,"Pique");                
        Carte carte = new Carte(2,"Pique");
        assertFalse(carte.superieur(carteSup));
    }

    /*
  
    public void testInferieur() {
        System.out.println("inferieur");
        Carte carte = null;
        Carte instance = null;
        boolean expResult = false;
        boolean result = instance.inferieur(carte);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

 
    public void testGetValeur() {
        System.out.println("getValeur");
        Carte instance = null;
        int expResult = 0;
        int result = instance.getValeur();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public void testSetValeur() {
        System.out.println("setValeur");
        int val = 0;
        Carte instance = null;
        instance.setValeur(val);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    
    public void testToString() {
        System.out.println("toString");
        Carte instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */
}
