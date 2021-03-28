package Algorithms2021.arrays.arithmeticprogression;

import java.util.Arrays;

public class isArithmeticProgression {

    public static boolean checkArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        Integer d = null;
        int prev = arr[0];
        for(int i=1;i<arr.length;i++){
            if(d==null){
                d = arr[i]-prev;
            }
            else if((arr[i]-prev)!=d){
                return false;
            }
            prev = arr[i];
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkArithmeticProgression(new int []{3, 5, 1, 7}));
        System.out.println(checkArithmeticProgression(new int []{4, 1, 0, 5}));
    }
}
