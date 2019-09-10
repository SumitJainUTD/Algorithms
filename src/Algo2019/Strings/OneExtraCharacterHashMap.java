package Algo2019.Strings;

import java.util.HashMap;

public class OneExtraCharacterHashMap {

    public void getExtraCharacter(String input1, String input2){

        String longerString;
        String shorterString;

        if(input1.length()>input2.length()){
            longerString = input1;
            shorterString = input2;
        }else{
            longerString = input2;
            shorterString = input1;
        }

        System.out.println("String 1: " +  input1 + ", String 2: " + input2);
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i <shorterString.length() ; i++) {
            char c = shorterString.charAt(i);
            if(map.containsKey(c)){
                map.put(c, map.get(c)+1);
            }else
                map.put(c, 1);
        }

        for (int i = 0; i <longerString.length() ; i++) {
            char c = longerString.charAt(i);
            if(map.containsKey(c)){
                int count = map.get(c);
                if(count==0) {
                    System.out.println("Extra character is: " + c);
                    return;
                }
                map.put(c,count-1);
            }else {
                System.out.println("Extra character is: " + c);
                return;
            }
        }
    }

    public static void main(String[] args) {

        OneExtraCharacterHashMap o = new OneExtraCharacterHashMap();

        String input1 = "tutorialhorizon";
        String input2 = "tutorial&horizon";
        o.getExtraCharacter(input1, input2);
        System.out.println("--------------------------------------");
        input1 = "abcdef";
        input2 = "fgabdec";
        o.getExtraCharacter(input1, input2);
    }
}
