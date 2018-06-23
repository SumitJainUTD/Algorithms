package ThirdLot.Graph.MISC;

/**
 * Created by sumi1 on 5/16/2018.
 */
public class ReversePairsUnsorted {

    static int reversePairs=0;

    public void findPairs(int [] A, int start, int end){
        if(start>=end)
            return;

        int mid = start + (end-start)/2;
        findPairs(A, start, mid);
        findPairs(A, mid+1, end);
        sortAndConquer(A, start, mid, end);
    }

    public void sortAndConquer(int [] A, int left, int mid, int right){

        //Find sizes of two subarrays to be merged
        int len1 = mid - left + 1;
        int len2 = right - mid;

        // Create Left[] and Right[] arrays
        int Left[] = new int [len1];
        int Right[] = new int [len2];

        //Copy data to Left[] and Right[] arrays
        for (int i=0; i<len1; ++i)
            Left[i] = A[left + i];
        for (int j=0; j<len2; ++j)
            Right[j] = A[mid + 1+ j];

        //calculate the reverse pairs before we sort the arrays

        reversePairs += findPairsUtil(Left, Right);

        //Now sort the Left[] and Right[] arrays
        int index = left;
        int i = 0, j = 0; //for Left[] and Right[]
        while (i < len1 && j < len2)
        {
            if (Left[i] <= Right[j]) {
                A[index] = Left[i];
                i++;
            }
            else {
                A[index] = Right[j];
                j++;
            }
            index++;
        }

        // Copy remaining elements of Left[]
        while (i < len1) {
            A[index] = Left[i];
            i++;
            index++;
        }

        // Copy remaining elements of Right[]
        while (j < len2) {
            A[index] = Right[j];
            j++;
            index++;
        }
    }

    public static int findPairsUtil(int [] Left, int [] Right){

        //initialize result
        int result = 0;
        //part one
        int start_partOne = 0;
        int end_partOne = Left.length-1;
        //part two
        int start_partTwo = 0;
        int end_partTwo = Right.length-1;

        //take two pointers, at the beginning of both parts

        int i = start_partOne;
        int j = start_partTwo;

        while(i<=end_partOne && j<=end_partTwo){
            if (Left[i]<=Right[j])
                i++;
            else if(Left[i]>Right[j]){
                result+=end_partOne-i+1;
                j++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int A[] = {10, 3, 4, 2, 5, 7, 9, 11};
        new ReversePairsUnsorted().findPairs(A, 0, A.length-1);
        System.out.println("No of reversed pair: " + reversePairs);
    }
}
