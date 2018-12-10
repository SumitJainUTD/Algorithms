package Sep2018;

/**
 * Created by sumi1 on 9/22/2018.
 */
public class LongestValidParenthesis {

        public int longestValidParentheses(String s){
            int[] counts = new int[s.length() + 1];
            int i =0;
            int max = 0;
            int openCount = 0;
            for (char chr : s.toCharArray()) {
                i++;
                if (chr == '(') {
                    openCount++;
                } else if (chr == ')' && openCount > 0) {
                    openCount--;
                    int prevCount = counts[i - 1];
                    counts[i] = prevCount + counts[i - prevCount - 2] + 2;
                    max = Math.max(max, counts[i]);
                }
            }
            return max;
        }

    public static void main(String[] args) {
            LongestValidParenthesis l = new LongestValidParenthesis();
            String input = ")()(()())))";
            String result = "Longest valid parenthesis length in input "+ input + " is: " + l.longestValidParentheses(input);
            System.out.println(result);
    }
}
