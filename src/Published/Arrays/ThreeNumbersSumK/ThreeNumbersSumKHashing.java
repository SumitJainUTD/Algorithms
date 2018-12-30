package Published.Arrays.ThreeNumbersSumK;

import java.util.HashSet;
public class ThreeNumbersSumKHashing {

    public static void find(int [] a, int k){
        for (int i = 0; i <a.length ; i++) {
            int x = a[i];
            //now problem is reduced to find two numbers in an array whose sum = M
            //here remainSum = k - x and array from index = 1 to end
            int M = k - x;
            int start = i + 1;
            int end = a.length - 1;
            HashSet<Integer> map = new HashSet<>(); //assume all array elements are less than 99999

            for (int j=start; j<=end; j++) {
                int remain = M-a[j];

                // checking for condition
                if (remain>=0 && map.contains(remain)==true) {
                    System.out.println("Found 3 elements whose sum is = " +k);
                    System.out.println("Elements are " + a[i] + " " + a[j]+ " " + remain);
                    return;
                }
                map.add(a[j]);
            }
        }
    }
    public static void main(String[] args) {
        int a [] = { 3,1,7,7,5,9,10};
        int k = 22;
        find(a,k);
    }
}

