package MacLaptop.ArrayProblems.Separate0and1;

import java.util.Arrays;

/**
 * Created by sjain on 8/13/17.
 */
public class Separate0and1Counting {

    public static int[] arrange(int [] arrA){
        //count number of 0's
        int countOs=0;
        int size = arrA.length;
        for (int i = 0; i <arrA.length ; i++) {
            if(arrA[i]==0)
                countOs++;
        }
        for (int i = 0; i <arrA.length ; i++) {
            if(countOs>0) {
                arrA[i] = 0;
                countOs--;
            }
            else
                arrA[i]=1;
        }
        return arrA;
    }

    public static void main(String[] args) {
        int [] arrA = {1,0,1,0,1,1,0,0,0,0,1};
        System.out.println("Rearranging arrays using counting..");
        arrA = arrange(arrA);
        System.out.println(Arrays.toString(arrA));
    }
}