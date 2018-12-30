package MacLaptop.ArrayProblems.Separate0and1;

import java.util.Arrays;

/**
 * Created by sjain on 8/13/17.
 */
public class Separate0and1UsingIndex {

    public static int[] arrange(int [] arrA){
        int left =0;
        int right = arrA.length-1;

        while(left<right){
            if(arrA[left]==0)
                left++;
            else if(arrA[right]==1)
                right--;
            else{
                //swap left and right elements
                arrA[left] = 0;
                arrA[right] = 1;
                left++;
                right--;
            }
        }
        return arrA;
    }

    public static void main(String[] args) {
        int [] arrA = {1,0,1,0,1,1,0,1};
        System.out.println("Rearranging arrays using left and right indexes");
        arrA = arrange(arrA);
        System.out.println(Arrays.toString(arrA));
    }
}
