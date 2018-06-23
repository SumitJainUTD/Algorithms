package ThirdLot.Graph.MISC;
/**
 * Created by sumi1 on 5/15/2018.
 */
public class ReplaceVowels {

    public String replaceVowels(String input){
        String result = "";
        char last_visited_non_vowel = '\0';
        for (int i = input.length()-1; i>=0 ; i--) {
            char x = input.charAt(i);
            if(isVowel(x)){
                if(last_visited_non_vowel!='\0') {
                    result = String.valueOf(last_visited_non_vowel) + result;
                }
            }else{
                last_visited_non_vowel = x;
                result = String.valueOf(x) + result;
            }
        }
        return result;
    }

    public boolean isVowel(char x){
        if(x=='a'||x=='e'||x=='i'||x=='o'||x=='u'
                ||x=='A'||x=='E'||x=='I'||x=='O'||x=='U')
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        ReplaceVowels r = new ReplaceVowels();
        String input = "abcdefg";
        System.out.println("Input: " + input + ", Output: " + r.replaceVowels(input));

        input = "aaaabccceee";
        System.out.println("Input: " + input + ", Output: " + r.replaceVowels(input));

        input = "aaaa";
        System.out.println("Input: " + input + ", Output: " + r.replaceVowels(input));
    }
}
