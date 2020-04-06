package Algo2019;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumberFromArray {

    public static void constructLargestNumber(Integer [] input){

        System.out.println("Given Input: " + Arrays.toString(input));
        StringBuilder result = new StringBuilder();

        Arrays.sort(input, new Comparator<Integer>() {
            @Override
            public int compare(Integer A, Integer B) {
                String AB = String.valueOf(A)+String.valueOf(B)+"";
                String BA = String.valueOf(B)+String.valueOf(A)+"";
                return  AB.compareTo(BA)>0 ? -1 : 1;
            }
        });

        for (int i = 0; i <input.length ; i++) {
            result.append(input[i]);
        }

        System.out.println("Largest Number Possible: " + result.toString());
    }

    public static void main(String[] args) {
        Integer[] input = {7, 78};
        constructLargestNumber(input);
    }
}
