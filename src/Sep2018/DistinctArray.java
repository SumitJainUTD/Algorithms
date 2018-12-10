package Sep2018;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by sumi1 on 12/2/2018.
 */
public class DistinctArray {

    public static void isDistinctArray(Integer [] arrA){

        //Create HashMap with all the elements in the array
        Set set = new HashSet(Arrays.asList(arrA));

        //since Set cannot contain duplicates, so if array size and
        // HashSet size then it can be concluded that array has all
        //distinct or unique elements otherwise its not
        if(arrA.length==set.size()){
            System.out.println("Given array has all unique or distinct elements " + Arrays.toString(arrA));
        }else{
            System.out.println("Given array does not contains all unique elements, and contains duplicate elements " + Arrays.toString(arrA));
        }
    }

    public static void main(String[] args) {
        Integer [] arrA = { 1, 2, 3, 6, 4, 9, 8};
        isDistinctArray(arrA);
        Integer [] arrB = { 1, 2, 3, 6, 4, 9, 8, 2};
        isDistinctArray(arrB);
    }
}
