package Algo2019;

import java.util.Arrays;

public class SumOfSubsets {

    public static void subsetSum(int [] input){
        System.out.println("Given Input: " + Arrays.toString(input));
        subsetSumUtil(input, 0, 0);
    }

    public static void subsetSumUtil(int [] input, int currIndex, int sum){

        //base case
        if(currIndex==input.length) {
            System.out.print(sum + " ");
            return;
        }

        //include the element at current index
        subsetSumUtil(input, currIndex+1, sum+ input[currIndex]);

        //does not include the element at current index
        subsetSumUtil(input, currIndex+1, sum);
    }

    public static void main(String[] args) {
        int [] input = {2, 4, 6};
        subsetSum(input);
    }
}
