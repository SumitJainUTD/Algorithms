package Published.Arrays;

import java.util.Arrays;

public class FrontAndBackSearch {

    static int search(int [] arr, int x){
        if(arr!=null && arr.length==0)
            return -1;

        int start = 0;
        int end = arr.length-1;

        while(start<end){
            if(arr[start]==x)
                return start;
            if(arr[end]==x)
                return end;

            //if means 'x' is not found so far, increment start and decrement end
            start++;
            end--;
        }
        //if here means , x is not found in array, return -1
        return -1;
    }

    static void printResult(int result, int x){
        if(result==-1)
            System.out.println("Element x = "+x+ " is not found in array");
        else
            System.out.println("Element x = "+x+ " is found in array a index: " + result);
    }

    public static void main(String[] args) {
        int [] arr = {3, 6, 9, 1, 2, 10};
        int x = 6;
        System.out.println(Arrays.toString(arr));

        int result = search(arr, x);
        printResult(result, x);

        x = 2;
        result = search(arr, x);
        printResult(result, x);

        x = 7;
        result = search(arr, x);
        printResult(result, x);

    }
}
