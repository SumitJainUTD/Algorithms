package Arrays.MaxDifference;

/**
 * Created by sumi1 on 7/26/2017.
 */
public class MaxDifferenceDandC {

    public int maxDifference(int [] A, int start, int end){
        if(start>=end){
            return -1;
        }
        int mid = start +  (end-start)/2;
        int leftDiff = maxDifference(A,start,mid);
        int rightDiff = maxDifference(A,mid+1,end);
        int minLeft = getMin(A, start, mid);
        int maxRight = getMax(A, mid, end);
        int centerDiff = maxRight - minLeft;
        return Math.max(centerDiff, Math.max(leftDiff,rightDiff));
    }

    public int getMin(int [] A, int i, int j){
        int min = A[i];
        for (int k = i+1; k <=j ; k++) {
            if(A[k]<min)
                min = A[k];
        }
        return min;
    }
    public int getMax(int [] A, int i, int j){
        int max = A[i];
        for (int k = i+1; k <=j ; k++) {
            if(A[k]>max)
                max = A[k];
        }
        return max;
    }

    public static void main(String[] args) {
        MaxDifferenceDandC m = new MaxDifferenceDandC();
        int [] A = { 2, 5, 1, 7, 3, 4, 9, 4, 5};
        int start = 0;
        int end = A.length-1;
        System.out.println("Maximum Difference between two elements A[i] and A[j] and where j > i: " +
                m.maxDifference(A, start, end));
    }
}
