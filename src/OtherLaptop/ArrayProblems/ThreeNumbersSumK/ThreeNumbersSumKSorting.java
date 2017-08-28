package OtherLaptop.ArrayProblems.ThreeNumbersSumK;

import java.util.Arrays;

public class ThreeNumbersSumKSorting {

    public static void find(int [] a, int k){
        Arrays.sort(a);
        for (int i = 0; i <a.length ; i++) {
            int x = a[i];
            //now problem is reduced to find two numbers in an array whose sum = M
            //here M = k - x and array from index = 1 to end
            int M = k -x;
            int start = i + 1;
            int end = a.length-1;
            while(start<end){
                int sum = a[start] + a[end];
                if(sum==M){
                    System.out.println("Found 3 elements whose sum is = " +k);
                    System.out.println("Elements are " + a[i] + " " + a[start]+ " " + a[end]);
                    return;
                }else if(sum<M)
                    start++;
                else //sum>M
                    end--;
            }
        }
    }
    public static void main(String[] args) {
        int a [] = { 3,1,7,4,5,9,10};
        int k = 21;
        find(a,k);
    }
}
