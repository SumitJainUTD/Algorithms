package Algo2019.Microsoft.identicalpairs;

import java.util.Arrays;
public class IdenticalPairsUsingSorting {
    public void getIdenticalPairs(int [] input){
        int result = 0;
        Arrays.sort(input);
        //count pairs
        int current = input[0];
        int count = 1;
        for (int i = 1; i <input.length ; i++) {
            if(current==input[i])
                count++;
            else {
                result += count * (count - 1) / 2;
                count = 1;
                current = input[i];
            }
        }
        //for last element
        if(count>0)
            result += count * (count - 1) / 2;

        System.out.println("Given array: " + Arrays.toString(input) + ", Identical Pairs: " + result);
    }
    public static void main(String[] args) {
        int input[] = { 1, 1, 2, 1, 1, 1, 2, 3, 3};
        IdenticalPairsUsingSorting i = new IdenticalPairsUsingSorting();
        i.getIdenticalPairs(input);
    }
}
