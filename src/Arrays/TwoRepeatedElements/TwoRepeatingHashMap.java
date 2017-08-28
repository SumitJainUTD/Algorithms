package Arrays.TwoRepeatedElements;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by sumi1 on 7/22/2017.
 */
public class TwoRepeatingHashMap {
    //this solution will work even if all the numbers are not in the range of 1 to n
    //keep the count of each element in the Hash Map
    //Print the elements which has count = 2
    public static void twoElements(int [] A){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <A.length ; i++) {
            if(map.containsKey(A[i])){
                int count = map.get(A[i]);
                map.put(A[i],++count);
            }else
                map.put(A[i],1);

        }
        System.out.print("Repeated Elements are : ");
        Set set = map.keySet();
        Iterator<Integer> iterator = set.iterator();
        while(iterator.hasNext()){
            int key = iterator.next();
            if(map.get(key)==2){
                System.out.print(key + " ");
            }
        }
    }
    public static void main(String[] args) {
        int [] A = {1,5,2,4,8,9,3,1,4,0};
        twoElements(A);
    }
}
