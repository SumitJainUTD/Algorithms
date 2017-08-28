package Arrays.MaximumSubArray;

/**
 * Created by sumi1 on 7/27/2017.
 */
public class MaximumSubArray {

    public int maxSubArray(int [] A){
        if(A.length==0)//if length  = 0, return 0
            return 0;
        else
            return maxSubArray(A, 0, A.length-1);
    }

    public int maxSubArray(int [] A, int start, int end){
        if(start==end){
            return A[start]; //if only one element, return that
        }
        int mid = start + (end-start)/2;
        int leftMaxSum = maxSubArray(A, start, mid);
        int rightMaxSum = maxSubArray(A, mid+1, end);
        //lets calculate the part in which sub array will start in the left half and ends in right half
        int sum = 0;
        int leftMidMax =0;
        for (int i = mid; i >=start ; i--) {
            sum += A[i];
            if(sum>leftMidMax)
                leftMidMax = sum;
        }
        sum = 0;
        int rightMidMax =0;
        for (int i = mid+1; i <=end ; i++) {
            sum += A[i];
            if(sum>rightMidMax)
                rightMidMax = sum;
        }
        int centerSum = leftMidMax + rightMidMax;
        return Math.max(centerSum, Math.max(leftMaxSum, rightMaxSum));
    }
    public static void main(String[] args) {
        int [] A = {-2, 12, -5, 10, -1, -6, 4};
        MaximumSubArray m =  new MaximumSubArray();
        System.out.println("Maximum Sub Array sum is : " + m.maxSubArray(A));
    }
}
