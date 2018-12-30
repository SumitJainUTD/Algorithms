package MacLaptop.ThirdLot.ShortestPalindrome;


//Given a string s, form a shortest palindrome by appending characters at the start of the string
//
//        abab = babab
//        ananab = bananab
/**
 * Created by sjain on 9/20/17.
 */
public class ShortestPalindrome {

    public String find(String main){

        StringBuilder s = new StringBuilder(main);
        String reverse = s.reverse().toString();

        String total = s + "#" + reverse;

        int [] dp = new int [total.length()];
        //dp[0] = 0;

        for (int i = 1; i <total.length() ; i++) {
            //update prefix boundary to previous match position
            int j = dp[i-1];

            //move to the last prefix boundary match
            while(j>0 && total.charAt(i)!=total.charAt(j))
                j = dp[j-1];

            //if prefix boundary matches suffix boundary,
            //increase prefix length
            if(total.charAt(i) == total.charAt(j)){
                dp[i] = j + 1;
            }
        }

        return reverse.substring(0,main.length()-dp[total.length()-1]) + main;

    }

    public static void main(String[] args) {
        ShortestPalindrome s = new ShortestPalindrome();
        String main = "banana";
        System.out.println(s.find(main));

    }
}
