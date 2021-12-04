import java.util.ArrayList;

public class Grille extends ArrayList{
    public ArrayList<Ligne> lignes = new ArrayList<>();

    Grille(ArrayList<Ligne> toto){
        this.lignes = toto;
    }
    void ajout (Ligne ligne){
        lignes.add(ligne);
    }

    Grille(){}
}
