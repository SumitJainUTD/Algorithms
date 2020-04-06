package Algorithm2020.Arrays.pairs.CountPairsWithGivenXOR;

import java.util.*;

public class CountPairsWithGivenXORUsingMap {

    public static void countPairs(int [] input, int xor){
        System.out.println("Input: " + Arrays.toString(input) +", xor = " + xor);
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <input.length ; i++) {
            int first = input[i];
            int second = first^xor;
            if(map.containsKey(second)){
                int count = map.get(second);
                result = result + count;
            }
            if(map.containsKey(first)){
                int count = map.get(first);
                map.put(first, count+1);
            } else
                map.put(first, 1);
        }
        System.out.println("Number of pairs with given xor = " + xor + " are: " + result);
    }

    public static void main(String[] args) {
        int input[] = {1, 3, 5, 7, 9, 1, 3, 5, 7, 9};
        int xor = 4;
        countPairs(input, xor);
    }
}
