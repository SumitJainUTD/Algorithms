package MacLaptop.October2018;

import java.util.Arrays;

/**
 * Created by sjain on 10/21/18.
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 1;
        while(i >= 1 && nums[i] <= nums[i - 1]){
            i--;
        }
        if(i != 0) {
            int j = nums.length - 1;
            while(j >= i && nums[j] <= nums[i-1]){
                j--;
            }
            swap(nums, i - 1, j);
        }
        reverse(nums, i, nums.length - 1);

        System.out.println(Arrays.toString(nums));
    }
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    private void reverse(int[] nums, int i, int j) {
        while(i < j) swap(nums, i++, j--);
    }

    public static void main(String[] args) {
        int nums [] = new int [] {1,3,2};
        NextPermutation n = new NextPermutation();
        n.nextPermutation(nums);
    }
}
