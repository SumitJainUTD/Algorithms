package Algo2019;

import java.util.Arrays;
import java.util.HashSet;

public class LongestStringAtMostKUniqueCharacters {
    public void find(String input, int k){

        System.out.println("Input: " + input);

        //first check if at least 2 unique chars are present in string
        HashSet<Character> set = new HashSet<>();

        for (int i = 0; i <input.length() ; i++) {
            char c = input.charAt(i);
            set.add(c);
        }

        if(set.size()<k) {
            System.out.println("Not enough unique character is present in the input string");
            return;
        }

        int max_Start = 0;
        int max_Length = 0;
        int curr_Start=0;
        int curr_End = 0;
        int alphaCounts[] = new int[26];
        Arrays.fill(alphaCounts, 0);

        for (int i = 0; i <input.length() ; i++) {
            int index = input.charAt(i)-'a';
            alphaCounts[index]++;
            curr_End++;

            //check if new char is added or unique chars count is at most k in the window
            while(!isValid(alphaCounts, k)){
                alphaCounts[input.charAt(curr_Start)-'a']--;
                curr_Start++;
            }

            //check if max_length needs to be updated
            if(curr_End-curr_Start>max_Length){
                max_Start = curr_Start;
                max_Length = curr_End-curr_Start;
            }
        }
        System.out.println("Longest substring with "+k+" most unique characters is : "
                + input.substring(max_Start, max_Start+max_Length)
                + " with length " + max_Length);
    }

    public boolean isValid(int alphaCounts[], int k){
        int uniqueChars = 0;
        for (int i = 0; i <alphaCounts.length ; i++) {
            if(alphaCounts[i]>0)
                uniqueChars++;
        }

        if(uniqueChars>k)
            return false;

        return true;
    }

    public static void main(String[] args) {
        LongestStringAtMostKUniqueCharacters l = new LongestStringAtMostKUniqueCharacters();
        String input = "aabbaacdeeeeddded";
        int k = 4;
        l.find(input, k);
    }
}
