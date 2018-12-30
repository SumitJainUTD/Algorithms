package Published.Arrays.MaxDifference;

/**
 * Created by sumi1 on 7/26/2017.
 */
public class MaxDifferenceBruteForce {

    public static int maxDifference(int [] A){
        int maxDiff = -1;
        for (int i = 0; i <A.length ; i++) {
            for (int j = i; j <A.length ; j++) {
                if(A[j]>A[i] && (A[j]-A[i]>maxDiff))
                    maxDiff = A[j]-A[i];
            }
        }
        return maxDiff;
    }

    public static void main(String[] args) {
        int [] A = { 2, 5, 1, 7, 3, 4, 9, 4, 5};
        System.out.println("Maximum Difference between two elements A[i] and A[j] and where j > i: " + maxDifference(A));
    }
}
