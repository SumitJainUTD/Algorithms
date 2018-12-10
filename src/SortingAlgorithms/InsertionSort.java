package SortingAlgorithms;

import java.util.Arrays;

public class InsertionSort {

    static void sort(int [] arrA){

        System.out.println("Original Array: " + Arrays.toString(arrA));
        for (int i = 0; i <arrA.length ; i++) {
            int j = i;
            while(j>0){
                //check if current element is smaller than previous element
                if(arrA[j]<arrA[j-1]){
                    //swap the elements
                    int temp = arrA[j];
                    arrA[j] = arrA[j-1];
                    arrA[j-1] = temp;
                }
                j--;
            }
        }
        System.out.println("(Insertion Sort)- Sorted Array: " +  Arrays.toString(arrA));
    }

    public static void main(String[] args) {
        int [] arrA = {5, 1, 9, 3, 2, 10};
        sort(arrA);
    }
}
