package Arrays.MajorityElement;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by sjain on 8/12/17.
 */
public class MajorityElementHashing {
    public static void find(int [] arrA){
        boolean found = false;
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i <arrA.length ; i++) {
            if(map.containsKey(arrA[i])){
                int count = map.get(arrA[i]);
                map.put(arrA[i],++count);
            }else
                map.put(arrA[i],1);
        }

        Set set = map.keySet();
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()){
            int key = iterator.next();
            if(map.get(key)>arrA.length/2){
                System.out.println("(Hashing)Element appearing more than n/2 times: " + key);
                found = true;
                break;
            }
        }
        if(!found)
            System.out.println("No element appearing more than n/2 times");
    }

    public static void main(String[] args) {
        int [] arrA = {1,3,5,5,5,5,4,1,5};
        find(arrA);
    }
}
