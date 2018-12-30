package MacLaptop.ArrayProblems;
//TH
import java.util.HashMap;

/**
 * Created by sjain on 3/6/17.
 */
public class FirstNonRepeatingCharacter {
    public static Character getCharacter(String input){
        //remove all the spaces
        input = input.replaceAll(" ", "");
        Character nonRptChar = null;
        //Will store each character and it's count
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i <input.length(); i++) {
            Character chr = input.charAt(i);
            if(map.containsKey(chr)){
                map.put(chr,map.get(chr)+1);
            }else{
                map.put(chr, 1);
            }
        }
        //Iterate the string and return the character for which the count is 1 in map
        for (int i = 0; i <input.length() ; i++) {
            if(map.get(input.charAt(i))==1){
                nonRptChar = input.charAt(i);
                break;
            }
        }
        return nonRptChar;
    }

    public static void main(String[] args) {
        String input = "tutorial horizon";
        Character result = getCharacter(input);
        if(result!=null){
            System.out.println("First Non Repeating Character in '"+input+"' is: " + result);
        }else{
            System.out.println("No Non Repeating Character found");
        }
    }
}

