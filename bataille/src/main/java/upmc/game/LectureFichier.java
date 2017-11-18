/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upmc.game;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class LectureFichier implements LecturePseudo{
    FileReader fileReader;
    ArrayList<String> pseudos;
    
    public LectureFichier(){
        this.pseudos = new ArrayList<String>();
    }
    public void demanderFichier(){
        Scanner console = new Scanner(System.in);
        System.out.print("Veuillez saisir le nom de fichier à lire : ");
        String nomFichier = console.nextLine();
        try{
            File fichier = new File(nomFichier+".txt");
            FileReader fileReader = new FileReader(fichier);
            BufferedReader buffReader = new BufferedReader(fileReader);
            BufferedReader br = new BufferedReader(new FileReader(fichier));
            String line;
            while ((line = br.readLine()) != null) {
                this.pseudos.add(line+"\n");
            }
            buffReader.close();
            fileReader.close();
        }
        catch(FileNotFoundException e){
            System.out.println("Le fichier spécifié n'existe pas");
        }
        catch(IOException e){
            System.out.println("Une erreur c'est produite lors de la lecture : "+e.getMessage());
        }
    }
    public ArrayList<String> lirePseudo() {
        return this.pseudos;
    }
    
}
