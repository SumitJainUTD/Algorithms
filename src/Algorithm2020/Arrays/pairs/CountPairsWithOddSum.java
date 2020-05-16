package Algorithm2020.Arrays.pairs;

import java.util.Arrays;

public class CountPairsWithOddSum {

    public static void countPairs(int [] input){

        System.out.println("Given Input: " + Arrays.toString(input));

        int evenCount=0;
        int oddCount=0;

        for (int i = 0; i <input.length ; i++) {
            if(input[i]%2==0)
                evenCount++;
            else
                oddCount++;
        }

        int evenPairs = evenCount*oddCount;
        System.out.println("Number of odd pairs: " + evenPairs);
    }

    public static void main(String[] args) {
        int [] input = {6, 7, 1, 3, 2, 5, 4};
        countPairs(input);
    }
}
