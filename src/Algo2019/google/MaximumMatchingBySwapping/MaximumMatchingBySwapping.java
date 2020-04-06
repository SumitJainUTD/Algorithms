package Algo2019.google.MaximumMatchingBySwapping;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MaximumMatchingBySwapping {

    public void findMaximumMatching(String s1, String s2){

        if(s1==null||s2==null){
            System.out.println("No matching can be found");
            return;
        }
        System.out.println("Given Inputs: " + s1 + " and " + s2);

        String larger;
        String smaller;

        if(s1.length()>s2.length()){
            larger = s1;
            smaller = s2;
        }else{
            larger = s2;
            smaller = s1;
        }

        int maxMatching = 0;
        Map<Character, Integer> maplarger = new HashMap<>();
        Map<Character, Integer> mapsmaller = new HashMap<>();

        int i =0;

        while(i<smaller.length()){
            if(smaller.charAt(i)==larger.charAt(i)){
                maxMatching++;
            }else{
                char keyL = larger.charAt(i);
                char keyS = smaller.charAt(i);
                if(!maplarger.containsKey(keyL)){
                    maplarger.put(keyL, 0);
                }
                maplarger.put(keyL, maplarger.get(keyL)+1);

                if(!mapsmaller.containsKey(keyS)){
                    mapsmaller.put(keyS, 0);
                }
                mapsmaller.put(keyS, mapsmaller.get(keyS)+1);
            }
            i++;
        }

        //check if larger one is over
        while(i<larger.length()){
            char keyL = larger.charAt(i);
            if(!maplarger.containsKey(keyL)){
                maplarger.put(keyL, 0);
            }
            maplarger.put(keyL, maplarger.get(keyL)+1);
            i++;
        }

        //if char is present in both the maps, pick the minimum
        Iterator<Character> iterator = maplarger.keySet().iterator();
        while(iterator.hasNext()){
            char key = iterator.next();
            if(mapsmaller.containsKey(key))
                maxMatching += Math.min(maplarger.get(key), mapsmaller.get(key));
        }

        System.out.println("Maximum Matching: " + maxMatching);
        System.out.println("-------------------------------------------------");
    }

    public static void main(String[] args) {
        String s1 = "ABCDEFGH";
        String s2 = "ABDCHHGX";

        MaximumMatchingBySwapping m = new MaximumMatchingBySwapping();
        m.findMaximumMatching(s1, s2);

        s1 = "abcd";
        s2 = "bdac";

        m = new MaximumMatchingBySwapping();
        m.findMaximumMatching(s1, s2);

        s1 = "abcd";
        s2 = "acbb";

        m = new MaximumMatchingBySwapping();
        m.findMaximumMatching(s1, s2);
    }
}
