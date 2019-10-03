package Algo2019.Permutation;

import java.util.Arrays;

public class NextSmallerPermutationWithOneSwap {

    public int[] previousLargestPermutation(int[] arrA) {

        System.out.println("Given Array: " + Arrays.toString(arrA));

        //find first decreasing point
        int index = -1;
        for (int i = arrA.length-1;i >0 ; i--) {
            if(arrA[i-1]>arrA[i]) {
                index = i-1;
                break;
            }
        }

        if(index==-1) {
            //the given array is already smallest permutation
            System.out.println("Original Array is already smallest permutation: " + Arrays.toString(arrA));
            return arrA;
        }

        int first_number = arrA[index];
        //find the index to swap
        int secondIndex = index+1;
        for (int i = index+1; i <arrA.length-1 ; i++) {
            if(arrA[i]<arrA[i+1] && arrA[i+1]<arrA[index])
                secondIndex = i+1;
        }

        //swap elements
        int second_number = arrA[secondIndex];
        arrA[index] = second_number;
        arrA[secondIndex] = first_number;

        System.out.println("Largest permutation smaller than given array: " + Arrays.toString(arrA));
        return arrA;
    }

    public static void main(String[] args) {
        int [] arrA = {1, 7, 3, 4, 5};
        NextSmallerPermutationWithOneSwap n = new NextSmallerPermutationWithOneSwap();
        n.previousLargestPermutation(arrA);
    }
}
