package MacLaptop.ArrayProblems;
//TH
import java.util.HashMap;

/**
 * Created by sjain on 3/6/17.
 */
public class LastRepeatingCharacter {
    public static Character getCharacter(String input){
        //remove all the spaces
        input = input.replaceAll(" ", "");
        Character rptChar = null;
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
        //Iterate the string from end to start and return the character for which the count is > 1 in map
        for (int i = input.length()-1; i >=0 ; i--) {
            if(map.get(input.charAt(i))>1){
                rptChar = input.charAt(i);
                break;
            }
        }
        return rptChar;
    }

    public static void main(String[] args) {
        String input = "tutorial horizon";
        Character result = getCharacter(input);
        if(result!=null){
            System.out.println("Last Repeating Character in '"+input+"' is: " + result);
        }else{
            System.out.println("No Repeating Character found");
        }
    }
}

