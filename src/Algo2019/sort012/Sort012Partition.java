package Algo2019.sort012;

import java.util.Arrays;

public class Sort012Partition {

    public static void sort(int[] input) {

        System.out.println("Given array: " + Arrays.toString(input));
        int low = 0;
        int mid = 0;
        int high = input.length-1;

        while (mid<=high){
            switch (input[mid]){
                case 0:
                    input[mid] = input[low];
                    input[low]=0;
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    input[mid] = input[high];
                    input[high]=2;
                    high--;
                    break;
            }
        }
        System.out.println("Sorted array: " + Arrays.toString(input));
    }
    public static void main(String[] args) {
        int [] input = {0, 0, 2, 0, 2, 0, 0, 1, 2};
        sort(input);
    }
}
