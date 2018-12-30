package Published.Arrays.CheckDuplicates;

import java.util.Arrays;

public class CheckDuplicatesUsingSorting {
    public void hasDuplicatesUsingSorting(int [] arrA) {
        Arrays.sort(arrA);
        for (int i = 0; i < arrA.length-1; i++) {
            if(arrA[i]==arrA[i+1]){
                System.out.println("Array has duplicates : " + arrA[i]);
            }
        }
    }
    public static void main(String[] args) {
        int a [] = {1, 6, 5, 2, 3, 3, 2};
        new CheckDuplicatesUsingSorting().hasDuplicatesUsingSorting(a);
    }
}
