package Algo2019.Microsoft;

import java.util.Arrays;

public class MinimumIncrementsToMakeArrayUnique {

    public static void minimumIncrements(int [] input){

        System.out.println("Given Input: " + Arrays.toString(input));

        int previous = input[0];
        int minimumIncrements = 0;
        for (int i = 1; i <input.length ; i++) {
            if(input[i] <= previous){
                int temp = input[i];
                input[i] = previous;
                input[i]++;
                minimumIncrements += input[i]-temp;
            }
            previous = input[i];
        }

        System.out.println("Unique Array: " + Arrays.toString(input) + ", Minimum Increments: "+ minimumIncrements);
    }

    public static void main(String[] args) {
        int input[] = { 1, 1, 1, 1 };
        minimumIncrements(input);
    }
}
