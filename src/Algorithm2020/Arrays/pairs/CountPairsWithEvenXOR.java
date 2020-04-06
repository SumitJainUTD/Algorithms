package Algorithm2020.Arrays.pairs;

import java.util.Arrays;

public class CountPairsWithEvenXOR {

    public static void countOddXOR(int [] input){

        int oddCount=0;
        int evenCount=0;

        for (int i = 0; i <input.length ; i++) {
            int x = input[i];
            if(x%2==0)
                evenCount++;
            else
                oddCount++;
        }
        //no of ways to choose 2 elements out of n = nC2= n*(n-1)/2;
        int totalPairsWithEvenXOR = evenCount*(evenCount-1)/2+oddCount*(oddCount-1)/2;
        System.out.println("Given Input[] " + Arrays.toString(input));
        System.out.println("Pairs with even XOR: " + totalPairsWithEvenXOR);
    }

    public static void main(String[] args) {
        int [] input = {2, 1, 5, 6, 9, 12, 11, 10, 3};
        countOddXOR(input);
    }
}
