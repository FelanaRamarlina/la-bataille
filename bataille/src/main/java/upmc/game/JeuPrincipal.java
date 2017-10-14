package upmc.game;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class JeuPrincipal {
    private Joueur joueur1;
    private Joueur joueur2;
    private Paquet paquet;
    private int choix;
    private int tour;
    private int attack;
            
    public JeuPrincipal() {
        /*initialisation*/
        this.choix=0;
        this.tour=1;
        this.attack=0;
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
    
    /*Cette méthode sera appelée à chaque fois que l'un des joueurs devra soit tirer une carte ou quitter le Jeu*/
    public void actionJoueur(){
        if(this.tour%2!=0){
            System.out.println("C'est à "+this.joueur1.getPseudo()+" de jouer");
        }else {
            System.out.println("C'est à "+this.joueur2.getPseudo()+" de jouer");
        }
        if(this.choix!=2 && this.choix !=1 && this.choix!=0)
            erreur("Saisie incorrecte ! ");
        System.out.println("1. Tirer la prochaine carte ");
        System.out.println("2. Quitter");
        System.out.flush();
        Scanner console = new Scanner(System.in);
        this.choix = console.nextInt();
        System.out.println("- -");
    }
    
    /*Lancement Menu*/
    public void menu(){ 
        /*Tant qu'un des joueurs n'a pas décidé de quitter la partie,
        ou que les paquets des joueurs ne sont pas vide, la partie continue*/
        while(this.choix !=2 && this.choix!=1 && this.joueur1.getPaquet().isEmpty() ==false && this.joueur2.getPaquet().isEmpty() ==false) {
            System.out.print(attack);
            this.actionJoueur();            
            this.partie();   
        }
       this.finDuJeu();
    }
    
    /*Début de la partie*/
    public void partie() {
        Carte carteRetiree1 = new Carte(0,"");
        Carte carteRetiree2 = new Carte(0,"");
        /*On tire une carte du joueur 1 ou 2 selon le tour*/
        if(this.choix==1) {
            if (this.tour % 2 != 0) {
                carteRetiree1 = this.joueur1.getPaquet().get(0);
                this.joueur1.tirer(carteRetiree1);
                System.out.println(carteRetiree1.toString() + "\n");
                this.choix = 0;
                this.attack++;
            }else {
                carteRetiree2 = this.joueur2.getPaquet().get(0);
                this.joueur2.tirer(carteRetiree2);
                System.out.println(carteRetiree2.toString() + "\n");
                this.choix = 0;
                this.attack++;
            }
            carteRetiree1.setValeur(1);
            carteRetiree2.setValeur(1);
            /*On compare les cartes si les deux joueurs ont tiré une carte*/
            if (this.attack % 2 == 0) {
               
                this.gagnerPoint(carteRetiree1,carteRetiree2);
                /*bataille*/
                if(carteRetiree1==carteRetiree2) {
                    this.bataille(carteRetiree1,carteRetiree2);
                }
            }
            this.tour++;
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
      
        /*tant que les cartes tirés des joueurs sont identiques, la bataille continue*/
        while (this.choix !=2 && this.choix!=1 && c1.getValeur() == c2.getValeur() && this.tour%2!=0) {
            this.actionJoueur();
            if (this.choix == 1) {
                if (this.tour % 2 != 0) {
                    c1 = this.joueur1.getPaquet().get(0);
                    this.joueur1.tirer(c1);
                    System.out.println(c1.toString() + "\n");
                    stock.add(c1);
                    this.choix = 0;
                } else {
                    c2 = this.joueur2.getPaquet().get(0);
                    this.joueur2.tirer(c2);
                    System.out.println(c2.toString() + "\n");
                    stock.add(c1);
                    this.choix = 0;
                    if(c2.getValeur()==c2.getValeur()) {
                        this.tour++;
                    } else{
                        this.tour=1;
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
            for (int i = 0; i < stock.size(); i++) {
                this.joueur1.ajouter(stock.get(i));
            }
        }
        
        this.finDuJeu();
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
    
    /*La partie s'arrête si le joueur a fait le choix 2*/
    public void finDuJeu(){
         /*Fin du jeu*/
        if(this.choix==2) {
            System.out.println("Fin de la partie");
        }
    }

}
