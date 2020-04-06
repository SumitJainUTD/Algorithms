package Algorithm2020.Arrays.pairs.CountPairsWithGivenXOR;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CountPairsWithGivenXORUsingSet {

    public static void countPairs(int [] input, int xor){
        System.out.println("Input: " + Arrays.toString(input) +", xor = " + xor);
        int count = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i <input.length ; i++) {
            int first = input[i];
            int second = first^xor;
            if(set.contains(second))
                count++;
            set.add(first);
        }
        System.out.println("Number of pairs with given xor = " + xor + " are: " + count);
    }

    public static void main(String[] args) {
        int input[] = {1, 3, 5, 7, 9};
        int xor = 4;
        countPairs(input, xor);
    }
}
