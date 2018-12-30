package Published.MISC;

import java.util.HashMap;
import java.util.Set;

public class DuplicateCaharcters {

    static void findDuplicates(String input){
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i <input.length() ; i++) {
            char chr = input.charAt(i);
            if(map.containsKey(chr)){
                int count = map.get(chr);
                map.put(chr, ++count);
            }else{
                map.put(chr, 1);
            }
        }

        //iterate through Hash Map and print all the duplicates chars
        Set<Character> set = map.keySet();
        System.out.println("Duplicate Characters: ");
        for (Character chr: set){
            int count = map.get(chr);
            if(count>1){
                System.out.println(chr + " - " + count);
            }
        }
    }

    public static void main(String[] args) {
        String input = "tutorial horizon";
        findDuplicates(input);
    }
}
