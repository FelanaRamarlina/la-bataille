/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upmc.game;

import java.util.ArrayList;

/**
 *
 * @author licence
 */
public class Joueur {
    private ArrayList<Carte> paquet;
    private int point;
    private String pseudo;

    public Joueur(String nom){
        this.paquet = new ArrayList<Carte>();
        this.point =0;
        this.pseudo=nom;
    }

    public void tirer(Carte c){
        this.paquet.remove(c);
    }

    public void ajouter(Carte c){
        this.paquet.add(c);
    }

    public void ajouterPoint(int nb){
        this.point = this.point+nb;
    }
    public int getPoints(){
        return this.point;
    }

    public String getPseudo() {
        return this.pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public ArrayList<Carte> getPaquet(){
        return this.paquet;
    }

    public int getPaquetSize(){
        return this.paquet.size();
    }
    public void afficherPaquet(){
        for (int i=0;i<this.getPaquetSize();i++){
            System.out.println(this.paquet.get(i).toString());
        }
    }
}
