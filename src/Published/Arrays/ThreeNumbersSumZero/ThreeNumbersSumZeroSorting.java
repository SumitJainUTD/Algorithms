package Published.Arrays.ThreeNumbersSumZero;

import java.util.Arrays;
public class ThreeNumbersSumZeroSorting {

    //need to find a + b + c = 0
    //OR we can reduce the problem to b + c = -a
    public static void find(int [] x){
        Arrays.sort(x);
        for (int i = 0; i <x.length ; i++) {
            int a = x[i];
            //now problem is reduced to find two numbers in an array whose sum = -a

            int sum = -a;
            int start = i + 1;
            int end = x.length-1;
            while(start<end){
                int tempSum = x[start] + x[end];
                if(tempSum==sum){
                    System.out.println("Found 3 elements whose sum is = 0");
                    System.out.println("Elements are " + a + " " + x[start]+ " " + x[end]);
                    return;
                }else if(tempSum<sum)
                    start++;
                else //tempSum>sum
                    end--;
            }
        }
    }
    public static void main(String[] args) {
        int a [] = { 3,-1,-7,-4,-5,9,10};
        find(a);
    }
}
