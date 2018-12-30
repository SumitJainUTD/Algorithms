package MacLaptop.ArrayProblems.EveryElementsRepeatedButOne;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by sjain on 8/12/17.
 */
public class EveryElementsRepeatedButOne {

    public static void findBruteForce(int [] a){
        boolean [] visited = new boolean[a.length];
        for (int i = 0; i <a.length ; i++) {
            int x = a[i];
            if(visited[i]==false) {
                boolean isDuplicate = false;
                for (int j = i + 1; j < a.length; j++) {
                    if (x == a[j]) {
                        isDuplicate = true;
                        visited[j] = true;
                    }
                }
                if (!isDuplicate)
                    System.out.println("Element appear only once in array - " + x);
            }
        }
    }

    public static void findByHashing(int [] a){
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i <a.length ; i++) {
            if(map.containsKey(a[i])) {
                int count = map.get(a[i]);
                map.put(a[i],++count);
            }else
                map.put(a[i],1);
        }
        Set<Integer> set = map.keySet();
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()){
            int key = iterator.next();
            if(map.get(key)==1){
                System.out.println("Element appear only once in array - " + key);
            }
        }
    }

    public static void findUsingXOR(int [] a){
        if(a.length==0)
            return;
        int xor = a[0];
        for (int i = 1; i <a.length ; i++) {
            xor ^= a[i];
        }
        System.out.println("Element appear only once in array - " + xor);
    }

    public static void main(String[] args) {
        int [] a = { 1,5,6,2,1,6,4,3,2,5,3};
        findBruteForce(a);
        findByHashing(a);
        findUsingXOR(a);
    }
}
