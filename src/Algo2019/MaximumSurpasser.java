package Algo2019;

import java.util.Arrays;

public class MaximumSurpasser {

    public static void maxSurpasser(int [] input) {

        int size = input.length;
        //arrSortedIndex will have current indexes of input array when input array is sorted
       int [] arrSortedIndex = new int [size];
       int [] arrSurpass = new int [size];

       //put indexes in index array
        for (int i = 0; i <size ; i++) {
            arrSortedIndex[i] = i;
        }

        //do the merge sort on input array but instead of modifying original array,
        //adjust the respective indexes in index array
        mergeSort(0, size-1, input, arrSortedIndex, arrSurpass);

        //find the maximum surpass among all
        int max = arrSurpass[0];
        for (int i = 1; i <size ; i++) {
            if(max<arrSurpass[i])
                max = arrSurpass[i];
        }
        System.out.println("Given Array: " + Arrays.toString(input));
        System.out.println("All surpasses: " + Arrays.toString(arrSurpass));
        System.out.println("Maximum Surpass: " +  max);
    }

    public static void mergeSort(int left, int right, int [] input, int [] arrSortedIndex, int [] arrSurpass ){

        //base case
        if(left<right) {
            int mid = left + (right - left) / 2;
            //make calls to left half and right half
            mergeSort(left, mid, input, arrSortedIndex, arrSurpass);
            mergeSort(mid + 1, right, input, arrSortedIndex, arrSurpass);
            //do merge
            merge(left, mid, right, input, arrSortedIndex, arrSurpass);
        }
    }

    public static void merge(int left, int mid, int right, int [] input, int [] arrIndex, int [] arrSurpass ){

        //create temp array for copy
        int [] temp = new int [input.length];

        int i = left;
        int j = mid+1;
        int k = left;

        while (i<=mid && j<=right){
            //check for elements in input array for indexes in arrIndex
            if(input[arrIndex[i]]<input[arrIndex[j]]){
                //increase the surpasses
                arrSurpass[arrIndex[i]] += right-j+1;
                temp[k] = arrIndex[i++];
            }else
                temp[k] = arrIndex[j++];
            k++;
        }

        //copy if there are any remaining in left laf or right half
        while (i<=mid)
            temp[k] = arrIndex[i++];

        while (j<=right)
            temp[k] = arrIndex[j++];

        //copy temp to arrIndex for next merge
        for (int l = left; l <=right ; l++)
            arrIndex[l] = temp[l];
    }

    public static void main(String[] args) {
        int [] input = {2, 7, 5, 5, 2, 7, 0, 8};
        maxSurpasser(input);
    }
}
