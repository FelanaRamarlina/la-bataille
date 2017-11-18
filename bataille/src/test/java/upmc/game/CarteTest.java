package upmc.game;
import upmc.game.Carte;
import junit.framework.TestCase;

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
