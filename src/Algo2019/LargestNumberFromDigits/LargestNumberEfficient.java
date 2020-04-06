package Algo2019.LargestNumberFromDigits;

import java.util.Arrays;

public class LargestNumberEfficient {

    public static void largestNumber(int [] digits){

        System.out.println("Given Digits: " +  Arrays.toString(digits));

        int [] count = new int[10];
        Arrays.fill(count, 0);

        for (int i = 0; i <digits.length ; i++) {
            count[digits[i]]++;
        }

        int result = 0;
        for (int i = count.length-1; i >=0 ; i--) {
            int repeat = count[i];
            while(repeat>0) {
                result = result * 10 + i;
                repeat--;
            }
        }
        System.out.println("largest number: " + result);
    }

    public static void main(String[] args) {
        int [] digits = {8, 1, 2, 5, 6, 7};
        largestNumber(digits);
    }
}
