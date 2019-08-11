package Algo2019;
import java.util.*;

public class AnagramGrouping {

    public HashMap<String, ArrayList<String>> anagrams(String [] input){
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

        for (int i = 0; i <input.length ; i++) {
            String str = input[i];
            char [] chrs = str.toCharArray();
            Arrays.sort(chrs);
            String mapKey = String.valueOf(chrs);
            if(map.containsKey(mapKey)){
                ArrayList<String> list = map.get(mapKey);
                list.add(str);
                map.put(mapKey, list);
            }else{
                ArrayList<String> list = new ArrayList<>();
                list.add(str);
                map.put(mapKey, list);
            }
        }
        return map;
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
        AnagramGrouping anagramsGroups = new AnagramGrouping();
        String [] input = new String [] {"rat", "art", "cat", "act", "dog", "god", "tar", "pat"};
        System.out.println("Input: " + Arrays.toString(input));
        HashMap<String, ArrayList<String>> result = anagramsGroups.anagrams(input);
        anagramsGroups.printResult(result);
    }
}

