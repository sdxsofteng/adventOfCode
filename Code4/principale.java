import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class principale{
    public static void main(String[] args) {
        File input = new File("input.txt");
        try{

            Scanner sc = new Scanner(input);
            sc.useDelimiter(",");
            boolean newlineFound = false;
            String inputText = sc.nextLine();
            Scanner inputTextScanner =  new Scanner(inputText);
            inputTextScanner.useDelimiter(",");
            ArrayList<String> inputArray = new ArrayList<>();
            while(inputTextScanner.hasNext()){
                inputArray.add(inputTextScanner.next());
            }
            ArrayList<Grille> grilles = new ArrayList<>();
            do{
                sc.nextLine();

                Grille grille = new Grille();
                Scanner ligne = new Scanner(sc.nextLine());
                ligne.useDelimiter(" ");
                Ligne ligmaballs = new Ligne();
                while(ligne.hasNext()){
                    ligmaballs.ajout(new Element(Integer.parseInt(ligne.next())));
                }
                Scanner ligne2 = new Scanner(sc.nextLine());
                ligne2.useDelimiter(" ");
                Ligne ligmaballs2 = new Ligne();
                while(ligne2.hasNext()){
                    ligmaballs2.ajout(new Element(Integer.parseInt(ligne2.next())));
                }
                Scanner ligne3 = new Scanner(sc.nextLine());
                ligne3.useDelimiter(" ");
                Ligne ligmaballs3 = new Ligne();
                while(ligne3.hasNext()){
                    ligmaballs3.ajout(new Element(Integer.parseInt(ligne3.next())));
                }
                Scanner ligne4 = new Scanner(sc.nextLine());
                ligne4.useDelimiter(" ");
                Ligne ligmaballs4 = new Ligne();
                while(ligne4.hasNext()){
                    ligmaballs4.ajout(new Element(Integer.parseInt(ligne4.next())));
                }
                Scanner ligne5 = new Scanner(sc.nextLine());
                ligne5.useDelimiter(" ");
                Ligne ligmaballs5 = new Ligne();
                while(ligne5.hasNext()){
                    ligmaballs5.ajout(new Element(Integer.parseInt(ligne5.next())));
                }
                grille.add(ligmaballs);
                grille.add(ligmaballs2);
                grille.add(ligmaballs3);
                grille.add(ligmaballs4);
                grille.add(ligmaballs5);

                grilles.add(grille);

            }while(sc.hasNext());

            System.out.println("toto");

        }catch (FileNotFoundException e){
            System.err.println("Fuck off");
        }
    }
}