package Arrays.MaxRepeaingElement;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MaxRepeatingUsingHashMap {
    public void maxRepeatingElementUsingMap(int [] arrA){
        //Will store each character and it's count
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <arrA.length; i++) {
            if(map.containsKey(arrA[i])){
                map.put(arrA[i],map.get(arrA[i])+1);
            }else{
                map.put(arrA[i], 1);
            }
        }

        //traverse the map and track the element which has max count
        Iterator entries = map.entrySet().iterator();
        int maxCount = 0;
        int element =arrA[0];
        while(entries.hasNext()){
            Map.Entry entry = (Map.Entry) entries.next();
            int count = (Integer)entry.getValue();
            if(maxCount<count){
                maxCount = count;
                element = (Integer)entry.getKey();
            }
        }
        System.out.println("Element repeating maximum no of times: " + element + ", maximum count: " + maxCount);
    }
    public static void main(String[] args) {
        int [] arrA = {4, 1, 5, 2, 1, 5, 9, 8, 6, 5, 3, 2, 4, 7};
        MaxRepeatingUsingHashMap m = new MaxRepeatingUsingHashMap();
        m.maxRepeatingElementUsingMap(arrA);
    }
}
