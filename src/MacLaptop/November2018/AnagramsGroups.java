package MacLaptop.November2018;

import java.util.*;

/**
 * Created by sjain on 11/10/18.
 */
public class AnagramsGroups {

    public HashMap<String, ArrayList<String>> anagrams(String [] input){
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

        for (int i = 0; i <input.length ; i++) {
            String str = input[i];

            int [] charsCount = fillChars(str);

            String mapKey = getString(charsCount);

            if(map.containsKey(mapKey)){
                ArrayList<String> list = map.get(mapKey);
                list.add(str);
                map.put(mapKey, list);
            }else{
                ArrayList<String> list = new ArrayList<String>();
                list.add(str);
                map.put(mapKey, list);
            }
        }
        return map;
    }

    public int [] fillChars(String str){
        int [] charsCount  = new int [26];
        for (int i = 0; i <str.length() ; i++) {
            char x = str.charAt(i);
            int position = x-'a';
            charsCount[position] += 1;
        }
        return charsCount;
    }

    public String getString(int [] chars){
        String output = "";
        for (int i = 0; i <chars.length ; i++) {
            int count = chars[i];
            for (int j = 0; j <count ; j++) {
                output += 'a'+i;
            }
        }
        return output;
    }

    public void printResult(HashMap<String, ArrayList<String>> result){
        Set<String> set = result.keySet();
        Iterator<String> iterator = set.iterator();
        while(iterator.hasNext()){
            String key = iterator.next();
            ArrayList<String> list = result.get(key);
            System.out.println(Arrays.toString(list.toArray()));
        }
    }

    public static void main(String[] args) {
        AnagramsGroups anagramsGroups = new AnagramsGroups();
        String [] input = new String [] {"rat", "art", "cat", "act", "dog", "god", "tar", "pat"};
        HashMap<String, ArrayList<String>> result = anagramsGroups.anagrams(input);
        anagramsGroups.printResult(result);
    }
}
