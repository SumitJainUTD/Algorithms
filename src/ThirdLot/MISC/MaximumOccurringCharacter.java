package ThirdLot.MISC;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by sumi1 on 5/31/2018.
 */
public class MaximumOccurringCharacter {

    static void findMaximumOccurring(String input){
        int maxCount =0;
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars = input.toCharArray();
        for (int i = 0; i <chars.length ; i++) {
            char c = chars[i];
            if(map.containsKey(c)){
                int count = map.get(c);
                count++;
                if(maxCount<count)
                    maxCount++;
                map.put(c, count);
            }else{
                map.put(c, 1);
            }
        }

        Set set = map.keySet();
        Iterator<Character> iterator = set.iterator();
        while(iterator.hasNext()){
            char key = iterator.next();
            //check count
            if(map.get(key)==maxCount){
                System.out.println("Character: " + key + " has occurred max times:  " +  maxCount);
            }
        }
    }

    public static void main(String[] args) {
        String input = "tutorial horizon";
        System.out.println("Input- " + input);
        findMaximumOccurring(input);
        System.out.println("----------------------");
        String input2 = "abcabcdefabcab";
        System.out.println("Input- " + input2);
        findMaximumOccurring(input2);
    }
}
