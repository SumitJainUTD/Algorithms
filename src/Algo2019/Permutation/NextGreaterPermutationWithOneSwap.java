package Algo2019.Permutation;

import java.util.Arrays;

public class NextGreaterPermutationWithOneSwap {

    public int[] previousLargestPermutation(int[] arrA) {

        System.out.println("Given Array: " + Arrays.toString(arrA));

        //find last index (first from iterating right to left) where left element is smaller than right element
        int index = -1;
        for (int i = arrA.length-1;i >0 ; i--) {
            if(arrA[i-1]<arrA[i]) {
                index = i-1;
                break;
            }
        }

        if(index==-1) {
            //the given array is already largest permutation
            System.out.println("Original Array is already largest possible permutation: " + Arrays.toString(arrA));
            return arrA;
        }

        //find the smallest no on the right which is greater than arrA[index]
        int secondIndex = index+1;
        for (int i = index+1; i <arrA.length-1 ; i++) {
            if(arrA[i]>arrA[i+1] && arrA[i+1]>arrA[index])
                secondIndex = i+1;
        }

        //swap elements
        int first = arrA[index];
        int second = arrA[secondIndex];
        arrA[index] = second;
        arrA[secondIndex] = first;

        //sort the rest of array in ascending order
        Arrays.sort(arrA,index+1, arrA.length);
        System.out.println("smallest permutation greater than given array: " + Arrays.toString(arrA));
        return arrA;
    }

    public static void main(String[] args) {
        int [] arrA = {4, 2, 5, 1, 0};
        NextGreaterPermutationWithOneSwap n = new NextGreaterPermutationWithOneSwap();
        n.previousLargestPermutation(arrA);
    }
}
