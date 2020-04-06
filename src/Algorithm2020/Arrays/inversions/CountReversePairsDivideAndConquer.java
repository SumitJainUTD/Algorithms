package Algorithm2020.Arrays.inversions;

import java.util.Arrays;

public class CountReversePairsDivideAndConquer {

    public void countReversePairsDivideAndConquer(int [] input){
        System.out.println("Input[] : " + Arrays.toString(input));
        int totalInversions = divide(input, 0, input.length-1);
        System.out.println("Inversions count: " + totalInversions);
    }

    public int divide(int [] input, int low, int high){

        if(low >= high)
            return 0;

        int mid = low + (high-low)/2;

        int leftInversions = divide(input, low, mid);

        int rightInversions = divide(input, mid+1, high);

        int mergeInversions = conquerAndCount(input, low, mid, high);

        return leftInversions + rightInversions + mergeInversions;
    }

    public int conquerAndCount(int [] input, int leftIndex, int midIndex, int rightIndex){
        // temporary left sub array
        int[] left = Arrays.copyOfRange(input, leftIndex, midIndex + 1);

        // temporary right sub array
        int[] right = Arrays.copyOfRange(input, midIndex + 1, rightIndex + 1);

        int i = 0, j = 0, k = leftIndex, inversions = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j])
                input[k++] = left[i++];
            else {
                input[k++] = right[j++];
                //count the inversions
                int count = (midIndex+1)-(leftIndex+i);
                inversions +=count;
            }
        }

        //fill rest of the elements from left array if any
        while(i<left.length)
            input[k++] = left[i++];

        //fill rest of the elements from right array if any
        while(j<right.length)
            input[k++] = right[j++];

        return inversions;
    }

        public static void main(String[] args){
            int input[] = {10, 3, 4, 2, 5, 7, 9, 11};
            CountReversePairsDivideAndConquer c = new CountReversePairsDivideAndConquer();
            c.countReversePairsDivideAndConquer(input);
        }
}
