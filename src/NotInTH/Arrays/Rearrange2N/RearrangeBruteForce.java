package NotInTH.Arrays.Rearrange2N;

/**
 * Created by sumi1 on 10/15/2017.
 */
public class RearrangeBruteForce {

    public void rearrangeArray(int [] A, int n){
        int start = 0;
        int end  = A.length-1;
        int mid = start + (end-start)/2;
        while(start<n && mid<end) {
            int left_index = start + 1;
            int right_index = mid + 1;
            while (left_index < right_index) {
                swap(A, right_index, right_index - 1);
                right_index--;
            }
            start += 2;
            mid += 1;
        }

        for (int i = 0; i <2*n ; i++) {
            System.out.print(A[i] + " ");
        }
    }
    private void swap(int A[],int m, int n){
        int temp = A[m];
        A[m] = A[n];
        A[n] = temp;
    }

    public static void main(String[] args) {
        int [] A = {1,3,5,7,9,2,4,6,8,10};
        int n = 5;
        new RearrangeBruteForce().rearrangeArray(A,n);
    }
}
