/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bataille;
/**
 *Carte
 * @author licence
 */
public class Carte {
        private int valeur;
        private String couleur;
        
        public Carte(int valeur, String couleur){
            this.valeur = valeur;
            this.couleur = couleur;
        }

        public boolean superieur(Carte carte){
            return this.valeur>carte.valeur;
        }
        public boolean inferieur(Carte carte){
            return this.valeur<carte.valeur;
        }

        public int getValeur(){
            return this.valeur;
        }
        public void setValeur(int val){ this.valeur = val; }
        public String toString() {
            return  "Carte : "+this.valeur+" de "+this.couleur;
        }
}
