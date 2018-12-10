package Sep2018;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by sumi1 on 12/2/2018.
 */
public class PrintSortedDistinctElements {

    public static void printsortedUniqueElements(Integer [] arrA){

        Set<Integer> treeSet = new TreeSet<>();

        //Add all elements from array to tree set
        Collections.addAll(treeSet, arrA);

        //Print all the elements from TreeSet
        System.out.println(treeSet);
    }

    public static void main(String[] args) {
        Integer [] arrA = {1, 2, 6, 2, 5, 9, 10, 3, 10, 3};
        printsortedUniqueElements(arrA);
    }
}
