package Published.String;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class ValidateOutputString {

    static boolean  validate(String input1, String input2, String output){

        System.out.println("input1: " + input1 + " input2: " + input2 + " Output String: " + output);
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i <input1.length() ; i++) {
            char c = input1.charAt(i);
            if(map.containsKey(c)){
                int count = map.get(c);
                map.put(c, count+1);
            }else{
                map.put(c, 1);
            }
        }

        for (int i = 0; i <input2.length() ; i++) {
            char c = input2.charAt(i);
            if(map.containsKey(c)){
                int count = map.get(c);
                map.put(c, count+1);
            }else{
                map.put(c, 1);
            }
        }

        //now validate the output string with Hash Map
        for (int i = 0; i <output.length() ; i++) {
            char c = output.charAt(i);
            if(map.containsKey(c)){
                int count = map.get(c);
                map.put(c, count-1);
            }else{
                return false;
            }
        }

        //iterate through Hash Map and check the count of each character
        Set<Character> set = map.keySet();
        Iterator<Character> iterator = set.iterator();
        while (iterator.hasNext()){
            Character key = iterator.next();
            if(map.get(key)!=0)
                return false;
        }

        //if here means all the validations are passed, return true
        return true;
    }

    public static void main(String[] args) {
        String input1 = "boy";
        String input2 = "girl";
        String output = "gboilry";
        System.out.println(validate(input1, input2, output));
        output = "gboily";
        System.out.println(validate(input1, input2, output));
    }
}
