package MacLaptop.October2018;

import java.util.Arrays;

/**
 * Created by sjain on 10/18/18.
 */
public class RotateArray {

    public static void rotate(int[] nums, int k) {
        int x = nums[0];
        int count = 0;
        int index = 0;
        while (count < nums.length && k > 0) {
            int target = index + k;
            while (target > nums.length - 1) {
                target = target - (nums.length);
            }
            int y = nums[target];
            nums[target] = x;
            x = y;
            index = target;
            count++;
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        rotate(new int [] {1,2,3,4,5,6},2);
    }
}
