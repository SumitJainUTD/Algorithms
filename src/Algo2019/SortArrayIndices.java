package Algo2019;

import java.util.Arrays;
import java.util.Comparator;

public class SortArrayIndices {

    public static void sortIndices(int [] input){

        Integer [] indices = new Integer[input.length];

        for (int i = 0; i <input.length ; i++)
            indices[i]=i;

        Arrays.sort(indices, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return input[o1]-input[o2];
            }
        });

        System.out.println("Input Array: " + Arrays.toString(input));
        System.out.println("Sorted indices as per input array: " + Arrays.toString(indices));
    }

    public static void main(String[] args) {
        int [] input = {5, 6, 1, 2, 8, 4, 3, 0};
        sortIndices(input);
    }
}
