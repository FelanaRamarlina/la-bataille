/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upmc.game;

import static com.sun.xml.internal.ws.dump.LoggingDumpTube.Position.Before;
import upmc.game.Carte;
import junit.framework.TestCase;

/**
 *
 * @author licence
 */
public class CarteTest extends TestCase {
    private Carte carte;
    
    public void nouvelleCarte() {
      carte = new Carte(2,"Pique");
    }
    
    public void testSuperieur() {
        this.nouvelleCarte();
        System.out.println("superieur");
        Carte carteSup = new Carte(5,"Pique");                
        assertTrue(carteSup.superieur(this.carte));
        assertFalse(this.carte.superieur(carteSup));
        assertFalse(carteSup == this.carte);
    }

    public void testGetValeur() {
        this.nouvelleCarte();
        assertEquals(this.carte.getValeur(),2);
    }
    
    public void testSetValeur() {
        this.nouvelleCarte();
        this.carte.setValeur(1);
        assertFalse(this.carte.getValeur() == 2);
    }
    
}
