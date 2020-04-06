package Algo2019.LargestNumberFromDigits;

import java.util.Arrays;
import java.util.Collections;

public class LargestNumberFromGivenDigitsUsingSorting {

    public static void largestNumber(int [] digits){

        System.out.println("Given Digits: " +  Arrays.toString(digits));

        Integer[] integers = Arrays.stream(digits).boxed().toArray(Integer[]::new);

        Arrays.sort(integers, Collections.reverseOrder());

        int result = 0;
        for (int i = 0; i <integers.length ; i++) {
            result = result*10 + integers[i];
        }
        System.out.println("largest number: " + result);
    }

    public static void main(String[] args) {
        int [] digits = {9, 1, 9, 2, 8, 4, 2};
        largestNumber(digits);
    }
}
