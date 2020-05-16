package Algorithm2020.Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MostFrequentWord {

    public static String findFrequentWord(String [] input){

        System.out.println("Input: " + Arrays.toString(input));
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i <input.length ; i++) {
            String word = input[i];
            int count = map.getOrDefault(word, 0);
            map.put(word, count+1);
        }
        String frequentWord=null;
        int count = 0;
        for (String key:map.keySet()){
            if(count<map.get(key)){
                count = map.get(key);
                frequentWord = key;
            }
        }
        return frequentWord;
    }

    public static void main(String[] args) {
        String [] input = {"Algorithms", "String", "Integer", "Integer",
                "Algorithms", "String", "Integer",
                "Algorithms", "String", "Algorithms"};
        System.out.println("Most frequent word: " + findFrequentWord(input));
    }
}
