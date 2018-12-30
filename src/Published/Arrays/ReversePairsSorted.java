package Published.Arrays;

/**
 * Created by sumi1 on 5/16/2018.
 */
public class ReversePairsSorted {

    public static void findPairs(int [] A){

        int len = A.length-1;
        //find the start index of part two sorted array
        int m=0;
        for (int i = 0; i <len ; i++) {
            if(A[i]>A[i+1]){
                m=i+1;
                break;
            }
        }
        //initialize result
        int result = 0;
        //part one
        int start_partOne = 0;
        int end_partOne = m-1;
        //part two
        int start_partTwo = m;
        int end_partTwo = len-1;

        //take two pointers, at the beginning of both parts

        int i = start_partOne;
        int j = start_partTwo;

        while(i<=end_partOne && j<=end_partTwo){
            if (A[i]<=A[j])
                i++;
            else if(A[i]>A[j]){
                result+=end_partOne-i+1;
                j++;
            }
        }

        System.out.println("No of reversed pair: " + result);
    }

    public static void main(String[] args) {
        int [] A = {4, 6, 8, 9, 0, 1, 2, 5, 10, 11};
        findPairs(A);
    }
}
