import java.lang.reflect.Array;
import java.util.ArrayList;

public class Ligne{
    public ArrayList<Element> elements = new ArrayList<>();

    Ligne(ArrayList<Element> toto){
        elements = toto;
    }

    void ajout(Element element){
        elements.add(element);
    }

    Ligne(){

    }
}
