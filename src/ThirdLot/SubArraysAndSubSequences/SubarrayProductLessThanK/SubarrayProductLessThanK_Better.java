package ThirdLot.SubArraysAndSubSequences.SubarrayProductLessThanK;

public class SubarrayProductLessThanK_Better {
    public int countSubArraysProudctLessThanK(int [] arr, int k){
        int start = 0;
        int end = 1;
        long product = arr[0];
        int count = 0;
        while (start <= end && end <= arr.length) {
            if (product < k) {
                count += end - start;
                if (end < arr.length) product *= arr[end];
                end++;
            } else {
                product /= arr[start++];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        SubarrayProductLessThanK_Better s = new SubarrayProductLessThanK_Better();
        int [] nums = {10,4,2,6};
        int k = 100;
        System.out.println("No of sub arrays has sum less than k="+k+" are: " +
                s.countSubArraysProudctLessThanK(nums,k));
    }
}

