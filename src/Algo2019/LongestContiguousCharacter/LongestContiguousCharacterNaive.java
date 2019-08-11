package Algo2019.LongestContiguousCharacter;

public class LongestContiguousCharacterNaive {

    public void find(String input){

        if(input==null || input.trim().length()==0)
            return;

        int maxCount = 1;
        int currCount = 1;
        char maxChar = input.charAt(0);
        char currChar = input.charAt(0);;
        for (int i = 0; i <input.length(); i++) {
            currChar = input.charAt(i);
            currCount = 1;
            for (int j = i+1; j <input.length() ; j++) {
                if(currChar==input.charAt(j)){
                    currCount++;
                    if(currCount>maxCount){
                        maxCount = currCount;
                        maxChar = currChar;
                    }
                }else{
                    break;
                }
            }
        }

        System.out.println("Input: " + input + ",  Longest Contiguous Character: " + maxChar + " with count: " + maxCount);
    }

    public static void main(String[] args) {

        LongestContiguousCharacterNaive l = new LongestContiguousCharacterNaive();
        String str = "aaaabbaacccccde";
        l.find(str);
        str = "bbbbbbb";
        l.find(str);
        str = "abcdeaab";
        l.find(str);
    }
}
