public class Bit {
    int numberOfOnes;
    int numberOfZeroes;
    int position;

    Bit(int position){
        this.position = position;
        numberOfOnes = 0;
        numberOfZeroes = 0;
    }

    int mostCommon (){
        return numberOfOnes > numberOfZeroes ? 1 : 0;
    }
    int leastCommon(){
        return numberOfOnes < numberOfZeroes ? 1 : 0;
    }
}
