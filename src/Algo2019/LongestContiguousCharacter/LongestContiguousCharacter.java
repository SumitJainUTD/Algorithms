package Algo2019.LongestContiguousCharacter;

public class LongestContiguousCharacter {

    public static void find(String input){
        if(input==null || input.trim().length()==0)

        if(input==null || input.trim().length()==0)
            return;

        int maxCount = 1;
        int currCount = 1;
        char maxChar = input.charAt(0);
        char currChar = input.charAt(0);;
        for (int i = 1; i <input.length() ; i++) {
            if(currChar==input.charAt(i)){
                currCount++;
                if(currCount>maxCount){
                    maxCount = currCount;
                    maxChar = currChar;
                }
            }else{
                currCount=1;
                currChar = input.charAt(i);
            }
        }

        System.out.println("Input: " + input + ",  Longest Contiguous Character: " + maxChar + " with count: " + maxCount);
    }

    public static void main(String[] args) {
        LongestContiguousCharacter l = new LongestContiguousCharacter();
        String str = "aaaabbaacccccde";
        l.find(str);
        str = "bbbbbbb";
        l.find(str);
        str = "abcdeaab";
        l.find(str);
    }
}
