package Published.Arrays.MaxDifference;

/**
 * Created by sumi1 on 7/26/2017.
 */
public class MaxDifferenceDynamicProgramming {
    public static int maxDifference(int [] A){
        int size = A.length;
        int maxDiff = -1;
        int max_so_far = A[size-1]; //assign the last element
        for (int i = size - 2 ; i >0 ; i--) {
            if(max_so_far<A[i])
                max_so_far = A[i];
            else if(max_so_far>A[i])
                maxDiff = Math.max(maxDiff,max_so_far-A[i]);
        }
        return maxDiff;
    }

    public static void main(String[] args) {
        int [] A = { 12, 5, 1, 7, 3, 9, 5};
        System.out.println("Maximum Difference between two elements A[i] and A[j] and where j > i: " + maxDifference(A));
    }
}
