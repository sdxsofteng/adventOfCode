import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Bingo {
    public static ArrayList<ArrayList> grilles = new ArrayList<>();

    public static void main(String[] args) {
        
        File txtInput = new File("input.txt");

        try{

        Scanner scInput = new Scanner(txtInput);

        //Mettre les choix dans un ArrayList.
        String choices = scInput.nextLine();
        ArrayList<Integer> choicesArray = new ArrayList<>();
        Scanner parseChoices = new Scanner(choices);
        parseChoices.useDelimiter(",");
        while(parseChoices.hasNext()){
            choicesArray.add(Integer.parseInt(parseChoices.next()));
        }

        //Creer les grilles
        while(scInput.hasNext()){
            ArrayList<ArrayList> grille = new ArrayList<>();

            scInput.nextLine();

            for(int i = 0; i < 5; i++){
                Scanner ligne = new Scanner(scInput.nextLine());
                ligne.useDelimiter(" ");
                ArrayList<Integer> ligneArr = new ArrayList<>();
                for(int y = 0 ; y < 5; y++){
                    System.out.println(Integer.parseInt(ligne.next()));
                }
                grille.add(ligneArr);
            }
            grilles.add(grille);

        }

        System.out.println("test");

        }catch(FileNotFoundException e){

            System.err.println("no");

        }

    }
}
