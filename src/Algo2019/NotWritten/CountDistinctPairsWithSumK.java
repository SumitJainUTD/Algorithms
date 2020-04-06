package Algo2019.NotWritten;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class CountDistinctPairsWithSumK {
    public static void countPairs(int [] input, int k){

        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i <input.length ; i++) {
            int key = input[i];
            if(!set.contains(key))
                set.add(key);
        }

        int count = 0;
        // check if we can find A and B so that A + B = k in set
        Iterator<Integer> iterator = set.iterator();
        while(iterator.hasNext()){
            int A = iterator.next();
            int B = k-A;
            if(set.contains(B))
                count += 1;
        }

        //until here we have counted all the pairs but twice
        count = count/2;
        System.out.println("Given Input: " + Arrays.toString(input) + ", k = " + k);
        System.out.println("Number of pairs with sum K: " + count);
    }

    public static void main(String[] args) {
        int input [] = {2, 6, 1, 5, 4, 3, 7, 1, 3};
        int k = 8;
        countPairs(input, k);
    }
}
