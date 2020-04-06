package Algorithm2020.Arrays.pairs.CountPairsWithGivenXOR;

public class CountPairsWithGivenXORBruteForce {

    public static void countPairs(int [] input, int xor){
        int count = 0;

        for (int i = 0; i <input.length ; i++) {
            for (int j = i+1; j <input.length ; j++) {
                if(xor==(input[i]^input[j]))
                    count++;
            }
        }
        System.out.println("Number of pairs with given xor=" + xor + " are: " + count);
    }

    public static void main(String[] args) {
        int input[] = {1, 3, 5, 7, 9};
        int xor = 4;
        countPairs(input, xor);
    }
}
