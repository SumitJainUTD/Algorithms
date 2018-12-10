package SortingAlgorithms;

import java.util.Arrays;

public class SelectionSort {

    void sort(int [] arrA) {
        System.out.println("Original Array: " + Arrays.toString(arrA));
        for (int i = 0; i < arrA.length; i++) {

            //get the index of minimum element in unsorted array
            int minIndex = getMinIndex(i, arrA);

            //swap the min element with the left most element in the unsorted list.

            int temp = arrA[minIndex];
            arrA[minIndex] = arrA[i];
            arrA[i] = temp;
        }
        System.out.println("(Selection Sort)- Sorted Array: " +  Arrays.toString(arrA));
    }

    int getMinIndex(int startIndex, int [] arrA){
        int minIndex = startIndex;
        for (int i = startIndex+1; i <arrA.length ; i++) {
            if(arrA[minIndex]>arrA[i])
                minIndex = i;
        }
        return minIndex;
    }

    public static void main(String[] args) {
        int [] arrA = {5, 1, 9, 3, 2, 10, 4, 7};
        new SelectionSort().sort(arrA);
    }
}
