package Algo2019.NotWritten;

//https://www.geeksforgeeks.org/count-pairs-with-given-sum/
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.HashMap;

public class CountPairsWithSumK {

    public static void countPairs(int [] input, int k){

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i <input.length ; i++) {
            int key = input[i];
            if(map.containsKey(key)){
                map.put(key,map.get(key) + 1);
            }else{
                map.put(key, 1);
            }
        }

        int count = 0;
        // check if we can find A and B so that A + B = k
        for (int i = 0; i <input.length ; i++) {
            int A = input[i];
            int B = k-A;
            if(map.containsKey(B))
                count += map.get(B);
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
