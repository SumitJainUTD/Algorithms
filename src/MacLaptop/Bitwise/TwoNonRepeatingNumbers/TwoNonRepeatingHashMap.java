package MacLaptop.Bitwise.TwoNonRepeatingNumbers;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by sjain on 8/16/17.
 */
public class TwoNonRepeatingHashMap {

    public void find(int [] arrA){
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i <arrA.length ; i++) {
           if(map.containsKey(arrA[i])){
               int count = map.get(arrA[i]);
               map.put(arrA[i],++count);
           }else
               map.put(arrA[i],1);
        }

        //print the elements which has count = 1
        Set set = map.keySet();
        Iterator<Integer> iterator = set.iterator();
        while(iterator.hasNext()){
            int key = iterator.next();
            if(map.get(key)==1)
                System.out.println("Non Repeating Element: " + key);
        }


    }

    public static void main(String[] args) {
        TwoNonRepeatingHashMap t = new TwoNonRepeatingHashMap();
        int [] arrA = {6,3,1,1,2,3,5,7,7,5};
        t.find(arrA);
    }
}
