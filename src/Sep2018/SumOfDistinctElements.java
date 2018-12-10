package Sep2018;

import java.util.*;

/**
 * Created by sumi1 on 12/2/2018.
 */
public class SumOfDistinctElements {

    public static void sumOfDistinct_Sorting(int [] arrA){

        //sort the given array
        Arrays.sort(arrA);

        //all the duplicates elements are together now
        //Navigate the array and add the distinct elements,
        // skip the element if it is same as previous elements

        int current = arrA[0];
        int sum = arrA[0];
        for (int i = 1; i <arrA.length ; i++) {
            if(current!=arrA[i]) {
                sum += arrA[i];
                current = arrA[i];
            }
        }
        System.out.println("Sum of all Unique elements (Sorting Method): " +  sum);
    }

    public static void sumOfDistinct_HashSet(int [] arrA) {

        //Create a HashSet of array elements, it will remove all the duplicates
        HashSet<Integer> hashSet = new HashSet<>();
        int sum = 0;
        for (int i = 0; i <arrA.length ; i++) {
            if(!hashSet.contains(arrA[i])){
                sum += arrA[i];
                hashSet.add(arrA[i]);
            }
        }
        System.out.println("Sum of all Unique elements (HashSet Method: " +  sum);
    }

    public static void main(String[] args) {
        int [] arrA = {1, 6, 4, 3, 2, 2, 3, 8, 1};
        sumOfDistinct_Sorting(arrA);
        sumOfDistinct_HashSet(arrA);
    }

}
