package Algo2019.Microsoft.identicalpairs;

import java.util.*;

public class IdenticalPairsUsingMap {

    public void getIdenticalPairs(int [] input){
        int result = 0;
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i <input.length ; i++) {
            int num = input[i];
            if(map.containsKey(num)) {
                int count = map.get(num);
                map.put(num, count+1);
            }
            else
                map.put(num, 1);
        }

        //count pairs
        Set<Integer> set = map.keySet();
        Iterator<Integer> iterator = set.iterator();
        while(iterator.hasNext()){
            int key = iterator.next();
            int count = map.get(key);
            result += count*(count-1)/2;
        }
        System.out.println("Given array: " + Arrays.toString(input) + ", Identical Pairs: " + result);
    }
    public static void main(String[] args) {
        int input[] = { 1, 1, 2, 1, 1, 1, 2, 3, 3};
        IdenticalPairsUsingMap i = new IdenticalPairsUsingMap();
        i.getIdenticalPairs(input);
    }
}
