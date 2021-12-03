import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class SubmarinePower{
    static int maxNumber = 12;
    public static void main(String[] args) {
        ArrayList<Bit> bits = new ArrayList<>();
        ArrayList<String> oxy = new ArrayList<>();
        ArrayList<String> co2 = new ArrayList<>();
        File input = new File("input.txt");
        try{
            Scanner sc = new Scanner(input);
            for(int i = 0; i < maxNumber; i ++){
                bits.add(new Bit(i));
            }
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                oxy.add(line);
                co2.add(line);
                for(int i = 0; i < maxNumber; i++){
                    char analchar = line.charAt(i);
                    if(analchar == '0'){
                        bits.get(i).numberOfZeroes++;
                    }else{
                        bits.get(i).numberOfOnes++;
                    }
                }
            }
        } catch (FileNotFoundException e){
            System.out.println("coco");
        }



    }
}