import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Principale {

    public static void main(String[] args) {

        File toto = new File("input.txt");
        int horizontalPos = 0;
        int verticalPos = 0;
        int aim = 0;

        try{
        Scanner scan = new Scanner(toto);
        String analysing;
        while(scan.hasNext()){
            analysing = scan.next();
            switch(analysing){
                case "forward":
                    int temp = Integer.parseInt(scan.next());
                    horizontalPos += temp;
                    if (aim > 0){
                        verticalPos += temp * aim;
                    }else if (aim < 0){
                        verticalPos -= temp * aim;
                    }
                    break;
                case "down":
                    aim +=  Integer.parseInt(scan.next());
                    break;
                case "up":
                    aim -= Integer.parseInt(scan.next());
                    break;
            }
        }
        }catch(FileNotFoundException e){
            System.out.println("nope");
        }

        System.out.println(horizontalPos * verticalPos);

    }
}