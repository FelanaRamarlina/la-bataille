package bataille;
import java.util.ArrayList;
import java.util.Collections;

public class Paquet {
    private ArrayList<Carte> paquetCarte;

    public Paquet() {
        this.paquetCarte = new ArrayList<Carte>();
        int j=0;
        int k=1;
        for (int i=1;i<53;i++){
            if(j<=12){
                Carte carteCoeur= new Carte(k,"coeur");
                this.paquetCarte.add(carteCoeur);
            }else if(j<=25){
                Carte carteTrefle= new Carte(k,"trefle");
                this.paquetCarte.add(carteTrefle);
            }else if(j<=38){
                Carte carteCarreaux = new Carte(k,"carreaux");
                this.paquetCarte.add(carteCarreaux);
            }else {
                Carte cartePique = new Carte(k, "pique");
                this.paquetCarte.add(cartePique);
            }
            j++;
            if (k<13) {
                k++;
            }else {
                k = 1;
            }
        }
    }

    public void melanger(){
        Collections.shuffle(this.paquetCarte);
    }

    public Carte indexCarte(int i)
    {
        return this.paquetCarte.get(i);
    }

    public void afficherPaquet(){
        for (int i=0;i<52;i++){
            System.out.println(this.paquetCarte.get(i).toString());
        }
    }


}
