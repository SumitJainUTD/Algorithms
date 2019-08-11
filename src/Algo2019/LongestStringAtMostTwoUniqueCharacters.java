package Algo2019;

import java.util.HashSet;

public class LongestStringAtMostTwoUniqueCharacters {

    public void find(String input){

        System.out.println("Input: " + input);

        //first check if at least 2 unique chars are present in string
        HashSet<Character> set = new HashSet<>();

        for (int i = 0; i <input.length() ; i++) {
            char c = input.charAt(i);
            set.add(c);
        }

        if(set.size()<2) {
            System.out.println("Only one unique character is present in the input string");
            return;
        }

        int max_Start = 0;
        int max_Length = 0;
        int curr_Start=0;
        int curr_End = 0;
        int alphaCounts[] = new int[26];

        for (int i = 0; i <input.length() ; i++) {
            int index = input.charAt(i)-'a';
            alphaCounts[index]++;
            curr_End++;
            //check if new char is added or unique chars count is at most 2 in the window
            while(!isValid(alphaCounts)){
                //More than 2 unique characters in substring, moving curr_start to right
                alphaCounts[input.charAt(curr_Start)-'a']--;
                curr_Start++;
            }

            //check if max_length needs to be updated
            if(curr_End-curr_Start>max_Length){
                max_Start = curr_Start;
                max_Length = curr_End-curr_Start;
            }
        }
        System.out.println("Longest substring with two most unique characters is : "
                + input.substring(max_Start, max_Start+max_Length)
                + " with length " + max_Length);
    }

    public boolean isValid(int alphaCounts[]){
        int uniqueChars = 0;
        for (int i = 0; i <alphaCounts.length ; i++) {
            if(alphaCounts[i]>0) {
                uniqueChars++;
            }
        }
        if(uniqueChars>2)
            return false;

        return true;
    }

    public static void main(String[] args) {
        LongestStringAtMostTwoUniqueCharacters l = new LongestStringAtMostTwoUniqueCharacters();
        String input = "aabcd";
        l.find(input);
        input = "aaaaa";
        l.find(input);
    }
}
