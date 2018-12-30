package MacLaptop.SixthLot;

import java.util.HashMap;

/**
 * Created by sjain on 9/18/18.
 */
public class LongestSubString {

    public static  int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int maxLength = 0;
        int startIdx = 0;
        for (int endIdx = 0; endIdx < s.length(); endIdx++) {
            char currChar = s.charAt(endIdx);
            if (map.containsKey(currChar)) {
                startIdx = Math.max(startIdx,map.get(currChar)+1);
            }
            map.put(currChar, endIdx);
            maxLength = Math.max(maxLength, endIdx - startIdx + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abba"));
    }
}
