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
            while(sc.hasNextLine()){
                String temp = sc.nextLine();
                oxy.add(temp);
                co2.add(temp);
            }
            for(int x = 0; x < maxNumber; x++){
                if(oxy.size() == 1){
                    break;
                }
                Bit newBit = new Bit(x);
                for(int y = 0; y < oxy.size(); y++){
                    if(oxy.get(y).charAt(x) == '1'){
                        newBit.numberOfOnes++;
                    }else{
                        newBit.numberOfZeroes++;
                    }
                }
                int e = 0;
                while(e < oxy.size()){
                    if(Character.getNumericValue(oxy.get(e).charAt(x)) != newBit.mostCommon()){
                        oxy.remove(e);
                    }else{
                        e++;
                    }
                }

            }

            for(int x = 0; x < maxNumber; x++){
                if(co2.size() == 1){
                    break;
                }
                Bit newBit = new Bit(x);
                for(int y = 0; y < co2.size(); y++){
                    if(co2.get(y).charAt(x) == '1'){
                        newBit.numberOfOnes++;
                    }else{
                        newBit.numberOfZeroes++;
                    }
                }
                int e = 0;
                while(e < co2.size()){
                    if(Character.getNumericValue(co2.get(e).charAt(x)) != newBit.leastCommon()){
                        co2.remove(e);
                    }else{
                        e++;
                    }
                }

            }
        } catch (FileNotFoundException e){
            System.out.println();
        }
    }
}