package upmc.game;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class JeuPrincipal {
    private Joueur joueur1;
    private Joueur joueur2;
    private Paquet paquet;

    public JeuPrincipal(){
        /*initialisation*/
        System.out.println("* Jeu de la Bataille *\n");

         /*Saisie des noms*/
        System.out.print("Pseudo du joueur 1: ");
        System.out.flush();
        Scanner console = new Scanner(System.in);
        String pseudo1 = console.nextLine();
        this.joueur1 = new Joueur(pseudo1);

        System.out.print("\nPseudo du joueur 2: ");
        System.out.flush();
        String pseudo2 = console.nextLine();
        this.joueur2 = new Joueur(pseudo2);

        System.out.println();

        /*on mélange le paquet*/
        this.paquet = new Paquet();
        this.paquet.melanger();

        /*on distribue*/
        int j=1;
        for(int i=0;i<52;i++){
            if(j<=26)
                this.joueur1.getPaquet().add(paquet.indexCarte(i));
            else
                this.joueur2.getPaquet().add(paquet.indexCarte(i));
            j++;
        }
    }

    public Joueur getJoueur1(){
        return this.joueur1;
    }

    public Joueur getJoueur2() {
        return this.joueur2;
    }

    /*Jeu de bataille*/
    public void attaque(){
        int choix=0;
        int tour=1;
        int attack=0;
        Carte carteRetiree1 = new Carte(0,"");
        Carte carteRetiree2 = new Carte(0,"");

        /*Menu Tirer une carte ou Quitter*/
        while(choix !=2 && choix!=1 && this.joueur1.getPaquet() != null && this.joueur2.getPaquet() !=null) {
            this.afficherScore();
            if(tour%2!=0){
                System.out.println("C'est à "+this.joueur1.getPseudo()+" de jouer");
            }else {
                System.out.println("C'est à "+this.joueur2.getPseudo()+" de jouer");
            }
            if(choix!=2 && choix !=1 && choix!=0)
                erreur("Saisie incorrecte ! ");
            System.out.println("1. Tirer la prochaine carte ");
            System.out.println("2. Quitter");
            System.out.flush();

            Scanner console = new Scanner(System.in);
            choix = console.nextInt();
            System.out.println("- -");
            /*On retire les cartes*/
            if(choix==1) {
                if (tour % 2 != 0) {
                    carteRetiree1 = this.joueur1.getPaquet().get(0);
                    this.joueur1.tirer(carteRetiree1);
                    System.out.println(carteRetiree1.toString() + "\n");
                    choix = 0;
                    attack++;
                } else {
                    carteRetiree2 = this.joueur2.getPaquet().get(0);
                    this.joueur2.tirer(carteRetiree2);
                    System.out.println(carteRetiree2.toString() + "\n");
                    choix = 0;
                    attack++;
                }
                /*On commence l'attaque si les deux joueurs ont tiré une carte*/
                if (attack % 2 == 0) {
                    carteRetiree1.setValeur(1);
                    carteRetiree2.setValeur(1);
                    this.gagnerPoint(carteRetiree1,carteRetiree2);

                    /*bataille*/
                   if(carteRetiree1==carteRetiree2) {
                        this.bataille(carteRetiree1,carteRetiree2);
                   }
                }
                tour++;
            }
        }

        /*Fin du jeu*/
        if(choix==2) {
            System.out.println("Fin de la partie");
        }
    }

    public void gagnerPoint(Carte c1, Carte c2){
        if (c1.superieur(c2)) {
            this.joueur1.ajouter(c1);
            this.joueur1.ajouter(c2);
            this.joueur1.addPoint();
        } else if (c1.inferieur(c2)) {
            this.joueur2.ajouter(c1);
            this.joueur2.ajouter(c2);
            this.joueur2.addPoint();
        }
    }

    /*bataille*/
    public void bataille(Carte c1, Carte c2){
        System.out.println("Bataille!");
        ArrayList<Carte> stock = new ArrayList<Carte>();
        stock.add(c1);
        stock.add(c2);
        int tour=1;
                        /*tant que les cartes tirés des joueurs sont identiques la bataille continue*/
        while (c1.getValeur() == c2.getValeur() && tour%2!=0) {
            if (tour % 2 != 0) {
                System.out.println("C'est à " + this.joueur1.getPseudo() + " de jouer");
            } else {
                System.out.println("C'est à " + this.joueur2.getPseudo() + " de jouer");
            }
            System.out.println("1. Tirer la prochaine carte ");
            System.out.flush();
            Scanner console = new Scanner(System.in);
            int choix2 = console.nextInt();
            if (choix2 == 1) {
                if (tour % 2 != 0) {
                    c1 = this.joueur1.getPaquet().get(0);
                    this.joueur1.tirer(c1);
                    System.out.println(c1.toString() + "\n");
                    stock.add(c1);
                    choix2 = 0;
                } else {
                    c2 = this.joueur2.getPaquet().get(0);
                    this.joueur2.tirer(c2);
                    System.out.println(c2.toString() + "\n");
                    stock.add(c1);
                    choix2 = 0;
                    if(c2.getValeur()==c2.getValeur()) {
                        tour++;
                    } else{
                        tour=1;
                    }

                }
            }
        }
                        /*Gagnant de la bataille*/
        if (c1.superieur(c2)) {
            System.out.println(this.joueur1.getPseudo() + " a gagné la bataille!");
            for (int i = 0; i < stock.size(); i++) {
                this.joueur1.ajouter(stock.get(i));
            }
        } else {
            System.out.println(this.joueur1.getPseudo() + " a gagné la bataille!");
            System.out.println(c1);
            System.out.println(c2);
            for (int i = 0; i < stock.size(); i++) {
                this.joueur1.ajouter(stock.get(i));
            }
        }
    }

    public void afficherScore(){
        System.out.println("");
        System.out.println("- Score -");
        System.out.println(this.joueur1.getPseudo()+": "+this.joueur1.getPoints()+" "+this.joueur2.getPseudo()+": "+this.joueur2.getPoints());
        System.out.println("");
    }
    public void afficherVainqueur(){
        if(this.joueur1.getPoints()>this.joueur2.getPoints())
            System.out.println("Le vainqueur de la partie est le Joueur 1! Bravo!");
        else
            System.out.println("Le vainqueur de la partie est le Joueur 2! Bravo!");
    }
    /*message erreur*/
    public void erreur(String libelle){
        System.out.println(libelle);
    }

}
