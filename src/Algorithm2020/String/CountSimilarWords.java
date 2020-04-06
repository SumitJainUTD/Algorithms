package Algorithm2020.String;

import java.util.HashMap;
import java.util.Map;

public class CountSimilarWords {

    public static void countWords(String [] input){

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i <input.length ; i++) {
            String word = input[i];

            //remove spaces if present
            word = word.trim().replace(" ", "");
            //ignore cases
            word = word.toLowerCase();
            //remove if any special character present
            word = word.replaceAll("[^a-zA-Z0-9]", "");

            //insert into map
            if(map.containsKey(word)){
                //increment the count
                int count = map.get(word);
                map.put(word, count+1);
            } else
                map.put(word, 1);

        }
        //print the result
        for(String key:map.keySet()){
            System.out.println(key + " -- " + map.get(key));
        }
    }

    public static void main(String[] args) {
        String [] input = {"Apple", "Bat", "apple", "A%^%ppLE", "BA  T", " C A T", "cAt "};
        countWords(input);
    }
}
