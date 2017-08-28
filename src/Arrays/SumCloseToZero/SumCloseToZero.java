package Arrays.SumCloseToZero;

import java.util.Arrays;

/**
 * Created by sumi1 on 7/4/2017.
 */
public class SumCloseToZero {

    public int findSum(int [] a){
        Arrays.sort(a);
        int i=0;
        int j = a.length-1;
        int positiveClose = Integer.MAX_VALUE;
        int negativeClose = Integer.MIN_VALUE;
        while(i<j){
            int temp = a[i] + a[j];
            //check if temp is greater than 0
            if(temp>0){
                //check if positiveClose needs to be updated
                if(positiveClose>temp){
                    positiveClose = temp;
                }
                //decrement j, in order to reduce the difference, close to 0
                j--;
            }else if(temp<0){
                //check if negative needs to be updated
                if(negativeClose<temp){
                    negativeClose = temp;
                }
                //increment i, in order to reduce the difference, close to 0
                i++;
            }else{
                //means temp is 0, that is the closest to zero we can get, return 0
                return 0;
            }
        }
        //Edge case, if all elements are positive
        if(negativeClose==Integer.MIN_VALUE)
            return positiveClose;
        //Edge case, if all elements are negative
        if(positiveClose==Integer.MAX_VALUE)
            return negativeClose;
        //check the least absolute value in postiveClose and negativeClose
        return Math.min(Math.abs(positiveClose), Math.abs(negativeClose));
    }
    public static void main(String[] args) {
        int a [] = {5,8};
        int closestSum = new SumCloseToZero().findSum(a);
        System.out.println("Sum close to zero in the given array is : " + closestSum);
    }
}

