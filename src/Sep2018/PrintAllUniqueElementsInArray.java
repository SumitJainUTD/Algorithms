package Sep2018;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by sumi1 on 12/2/2018.
 */
public class PrintAllUniqueElementsInArray {

    public static void printAllUniqueElements_Sorting(int [] arrA){
        Arrays.sort(arrA);
        int current = arrA[0];
        System.out.print("Distinct Or Unique elements are: " + current + " ");
        for (int i = 1; i <arrA.length ; i++) {
            if(current!=arrA[i]){
                System.out.print(arrA[i] + " ");
                current = arrA[i];
            }
        }
    }

    public static void printAllUniqueElements_HashSet(int [] arrA){
        HashSet<Integer> hashSet = new HashSet<>();
        System.out.print("Distinct Or Unique elements are: ");
        for (int i = 0; i <arrA.length ; i++) {
            if(!hashSet.contains(arrA[i])){
                System.out.print(arrA[i] + " ");
                hashSet.add(arrA[i]);
            }
        }
    }

    public static void main(String[] args) {
        int [] arrA = {1, 6, 4, 3, 2, 2, 3, 8, 1};
        printAllUniqueElements_Sorting(arrA);
        System.out.println();
        printAllUniqueElements_HashSet(arrA);
    }
}
