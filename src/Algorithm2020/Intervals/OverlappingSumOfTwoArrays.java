package Algorithm2020.Intervals;

import java.util.Arrays;
import java.util.HashSet;

public class OverlappingSumOfTwoArrays {

    public static void findOverlappingSumOfTwoArrays(int [] A, int [] B){

        System.out.println("A [] : " + Arrays.toString(A));
        System.out.println("B [] : " + Arrays.toString(B));

        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i <A.length ; i++) {
            int key = A[i];
            set.add(key);
        }

        int sum = 0;
        for (int i = 0; i <B.length ; i++) {
            int key = B[i];
            if(set.contains(key))
                sum += key*2;
        }
        System.out.println("Overlapping sum of two arrays: " + sum);
    }

    public static void main(String[] args) {
        int [] A = {6, 5, 1, 9, 2, 8, 3};
        int [] B = {3, 7, 9, 2, 4};
        findOverlappingSumOfTwoArrays(A, B);
    }
}
