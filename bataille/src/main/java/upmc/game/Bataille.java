// Copyright 2017 Pierre Talbot (IRCAM)

// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at

//     http://www.apache.org/licenses/LICENSE-2.0

// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package upmc.game;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Bataille
{
  public static void main(String[] args)
  {
    /*System.out.println("C'est le jeu de la bataille!\n");
    System.out.print("Veuillez entrer un choix : ");
    System.out.flush();
    Scanner console = new Scanner(System.in);
    String choice = console.nextLine();
    System.out.println("\nL'utilisateur a choisi : \"" + choice + "\"");
    System.out.println("C'est terminé :-(\n\nIl n'y a pas beaucoup de fonctionnalités...");*/

    JeuPrincipal jeu = new JeuPrincipal();
    jeu.attaque();
    jeu.afficherVainqueur();
  }
}
