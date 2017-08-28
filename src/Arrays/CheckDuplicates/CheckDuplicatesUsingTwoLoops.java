package Arrays.CheckDuplicates;

import java.util.Arrays;

public class CheckDuplicatesUsingTwoLoops {
    public void hasDuplicates2ForLoops(int [] arrA) {

        for (int i = 0; i < arrA.length; i++) {
            for (int j = i+1; j < arrA.length; j++) {
                if(arrA[i]==arrA[j]){
                    System.out.println("Array has duplicates : " + arrA[i]);
                }
            }
        }
    }
    public static void main(String[] args) {
        int a [] = {1, 6, 5, 2, 3, 3, 2};
        new CheckDuplicatesUsingTwoLoops().hasDuplicates2ForLoops(a);
    }
}
