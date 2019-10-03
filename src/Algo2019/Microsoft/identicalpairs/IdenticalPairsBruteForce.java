package Algo2019.Microsoft.identicalpairs;

import java.util.Arrays;

public class IdenticalPairsBruteForce {

    public void getIdenticalPairs(int [] input){
        int result = 0;
        for (int i = 0; i <input.length-1 ; i++) {
            for (int j = i+1; j <input.length ; j++) {
                if(input[i]==input[j])
                    result++;
            }
        }
        System.out.println("Given array: " + Arrays.toString(input) + ", Identical Pairs: " + result);
    }

    public static void main(String[] args) {
        int input[] = { 1, 2, 5, 2, 1, 1};
        IdenticalPairsBruteForce i = new IdenticalPairsBruteForce();
        i.getIdenticalPairs(input);
    }
}
