package MacLaptop.FourthLot;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by sjain on 10/28/17.
 */
//https://discuss.leetcode.com/topic/107993/java-o-n-solution-sliding-window
public class SubArrayProduct {

    public int find(int [] nums, int k){

        int count = 0;
        int product = nums[0];
        int start = 1;
        Queue<Integer> queue = new LinkedList<Integer>();

        while(start<nums.length){
            if(product>=100){
                int x = queue.remove();
                product = product/x;
            }else{
                product = product * nums[start];
                queue.add(nums[start]);
                start++;
            }
            if(product<100 && queue.size()!=0){
                count++;
            }
        }
        return count;
    }

    public static void main (String[] args) throws Exception{
        int [] nums = new int [] {10, 5, 2, 6};
        int k = 100;

        System.out.println(new SubArrayProduct().find(nums,k));

    }
}
