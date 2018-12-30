package Published.Arrays;

import java.util.Arrays;
import java.util.HashSet;

public class ProductOfDistinctElements {
    public static void productOfDistinct_Sorting(int [] arrA){

        //sort the given array
        Arrays.sort(arrA);

        //all the duplicates elements are together now
        //Navigate the array and add the distinct elements,
        // skip the element if it is same as previous elements

        int current = arrA[0];
        int product = arrA[0];
        for (int i = 1; i <arrA.length ; i++) {
            if(current!=arrA[i]) {
                product *= arrA[i];
                current = arrA[i];
            }
        }
        System.out.println("Product of all Unique elements (Sorting Method): " +  product);
    }

    public static void productOfDistinct_HashSet(int [] arrA) {

        //Create a HashSet of array elements, it will remove all the duplicates
        HashSet<Integer> hashSet = new HashSet<>();
        int product = 1;
        for (int i = 0; i <arrA.length ; i++) {
            if(!hashSet.contains(arrA[i])){
                product *= arrA[i];
                hashSet.add(arrA[i]);
            }
        }
        System.out.println("Product of all Unique elements (HashSet Method: " +  product);
    }

    public static void main(String[] args) {
        int [] arrA = {1, 6, 4, 3, 2, 2, 3, 8, 1};
        productOfDistinct_Sorting(arrA);
        productOfDistinct_HashSet(arrA);
    }
}
