package upmc.game;

import java.util.ArrayList;
import junit.framework.TestCase;

/**
 *
 * @author Felana
 */
public class JoueurTest extends TestCase {
    Joueur joueur;
    
    public void nouveauJoueur() {
        this.joueur = new Joueur("Julie");       
    }
    
    public void testAjouter() {
        this.nouveauJoueur();
        Carte c = new Carte(2,"As");
        this.joueur.ajouter(c);
        boolean trouve = false;
        for(int i=0 ; i<this.joueur.getPaquetTaille() ; i++){
            if(this.joueur.getPaquet().get(i)== c){
                trouve = true;
            }
        }
        assertTrue(trouve);
    }

    public void testTirer() {
        this.nouveauJoueur();
        Carte c = new Carte(2,"As");
        this.joueur.ajouter(c);
        this.joueur.tirer(c);
        boolean supprime = true;
        for(int i=0 ; i<this.joueur.getPaquetTaille() ; i++){
            if(this.joueur.getPaquet().get(i)== c){
                supprime = false;
            }
        }
        assertTrue(supprime);
    }

     
    public void testAjouterPoint() {
        this.nouveauJoueur();
        this.joueur.ajouterPoint(1);
        assertEquals(this.joueur.getPoints(),1);
    }

    public void testGetPseudo() {
        this.nouveauJoueur();
        assertEquals(this.joueur.getPseudo(),"Julie");
    }

   
    public void testSetPseudo() {
        this.nouveauJoueur();
        this.joueur.setPseudo("Johanna");
        assertEquals(this.joueur.getPseudo(),"Johanna");
    }

  
    public void testGetPaquet() {
        this.nouveauJoueur();
        ArrayList<Carte> paquet = new ArrayList<Carte>();
        Carte c = new Carte(2,"Coeur");
        this.joueur.ajouter(c);
        paquet.add(c);
        assertEquals(this.joueur.getPaquet(),paquet);
    }

  
    public void testGetPaquetTaille() {
        this.nouveauJoueur();
        Carte c = new Carte(2,"Coeur");
        this.joueur.ajouter(c);
        assertEquals(this.joueur.getPaquetTaille(),1);
    }
    
}
