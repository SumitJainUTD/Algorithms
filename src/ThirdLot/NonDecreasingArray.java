package ThirdLot;

import java.util.Arrays;

//https://leetcode.com/problems/non-decreasing-array/description/
public class NonDecreasingArray {

    public static boolean check(int [] arr){
        if(arr.length==0||arr.length==1)
            return true;

        int x=-1;
        int y=-1;

        int modifyCount = 0;
        for (int i = 1; i <arr.length ; i++) {
            int prev = arr[i-1];
            int current = arr[i];
            if(current>prev){
                continue;
            }else if(modifyCount==0){
                x = current;
                y = prev;
                arr[i] = prev;
                modifyCount++;
            }else{
                System.out.println("You can't get a non-decreasing array by modify at most one element.");
                return false;
            }
        }
        System.out.println(Arrays.toString(arr));
        if(x!=-1 && y!=-1 )
            System.out.println("can be modified by changing "+ x + " to " + y);
        return true;
    }

    public static boolean checkPossibility(int[] nums) {
        int n = nums.length, count = 0;

        for (int i = 0; i + 1 < n; i++) {
            if (nums[i] > nums[i + 1]) {
                count++;
                if (i > 0 && nums[i + 1] < nums[i - 1])
                    nums[i + 1] = nums[i];
                else
                    nums[i] = nums[i + 1];
            }
        }
        return count <= 1;
    }


    public static void main(String[] args) {
        int [] arr = {1,2,3,4, 1, 3};
        check(arr);
        System.out.println(checkPossibility(arr));
    }
}
