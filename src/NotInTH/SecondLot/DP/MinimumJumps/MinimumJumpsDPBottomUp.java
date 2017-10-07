package NotInTH.SecondLot.DP.MinimumJumps;

/**
 * Created by sjain on 8/25/17.
 */

//http://www.geeksforgeeks.org/minimum-number-of-jumps-to-reach-end-of-a-given-array/
public class MinimumJumpsDPBottomUp {
    // Returns minimum number of jumps to reach arr[n-1] from arr[0]
    public int findJumps(int arr[]) {

        int size = arr.length;
        int[] jumps = new int[size]; // jumps[size-1] will hold the result
        int i, j;

        //base case
        if (size == 0 || arr[0] == 0)
            return Integer.MAX_VALUE;

        //base case....destination is 0 then 0 jumps are required
        jumps[0] = 0;

        //Jumps[i] => minimum no of jumps required to reach arr[i] from arr[0]
        for (i = 1; i < size; i++) {
            jumps[i] = Integer.MAX_VALUE;
            for (j = 0; j < i; j++) {
                if (i <= j + arr[j]) {
                    if (jumps[j] != Integer.MAX_VALUE) { // check if path from jumps[j] is not blocked, means arr[j]!=0, skip it if so
                        jumps[i] = Math.min(jumps[i], jumps[j] + 1);
                        break;
                    }
                }
            }
        }
        return jumps[size - 1];
    }

    public static void main(String[] args) {
        MinimumJumpsDPBottomUp m = new MinimumJumpsDPBottomUp();
        int arr[] = {9, 0, 0, 22, 0, 0, 39, 11, 3, 0, 0, 24, 1, 0, 50, 23, 3, 44, 0, 23, 2, 8, 20, 35, 0, 40, 34, 26, 36, 0, 35, 19, 20, 18, 11, 43, 19, 21, 40, 0, 14, 0, 14, 0, 0, 25, 35, 24, 49, 15, 13, 3, 0, 10, 31, 25, 27, 37, 27, 43, 44, 27, 8, 43, 0, 0, 33, 25, 19, 47, 0, 29, 5, 2, 12, 8, 7, 0, 16, 36, 0, 6, 17, 35, 36, 21, 0, 9, 1, 0, 43, 29, 39, 15, 18, 0, 34, 26, 48, 0, 34, 35, 7, 10, 0, 0, 15, 5, 12, 26, 0, 37, 30, 33, 27, 34, 9, 37, 22, 0, 0, 24, 30, 0, 0, 38, 23, 25, 0, 30, 39, 24, 31, 0, 6, 19, 25, 0, 28, 15, 8, 0, 48, 0, 35, 41, 0, 24, 1, 41, 31, 0, 35, 21, 15, 26, 15, 27, 4, 0, 8, 4, 0, 0, 2, 42, 18, 0, 28, 18, 49, 34, 5, 10, 41, 48, 26, 14, 45, 44, 9, 0, 49, 50, 24, 0, 0, 0, 23, 0, 17, 0, 47, 31, 0, 42, 0, 0, 0, 40, 46, 22, 50, 32, 20, 3, 44, 22, 0, 37, 25, 0, 19, 26, 14, 23, 27, 41, 0, 1, 13, 0, 48, 20, 37, 8, 0, 18, 0, 26, 12, 19, 32, 19, 22, 0, 0, 0, 0, 0, 16, 0, 0, 43, 0, 10, 5, 0, 6, 26, 0, 24, 40, 29, 0, 43, 18, 27, 0, 0, 37, 0, 46, 35, 17, 0, 20, 44, 29, 29, 40, 33, 22, 27, 0, 0, 38, 21, 4, 0, 0, 15, 31, 48, 36, 10, 0, 41, 0, 45, 39, 0, 11, 9, 3, 38, 16, 0, 11, 22, 37, 0, 3, 44, 10, 12, 47, 22, 32, 7, 24, 1, 0, 22, 25, 0, 14, 0, 0, 0, 23, 0, 36, 1, 42, 46, 0, 48, 0, 33, 5, 27, 45, 0, 15, 29, 0, 50, 2, 31, 25, 6, 36, 19, 10, 23, 0, 37, 4, 1, 7, 12, 0, 0, 49};
//        int arr[] = {1, 3, 5, 3, 3, 1, 1, 1, 1, 1, 1, 1, 1, 4};
        long startTime = System.currentTimeMillis();
        System.out.println("Minimum Jumps required: " + m.findJumps(arr));
        long end = System.currentTimeMillis();
        System.out.println("Time taken: " + (end - startTime) / 1000 + " seconds");
    }
}
