package Published.Expressions;

import java.util.Stack;

public class DuplicateParenthesis {

    public static boolean isDuplicate(String expression){
        if(expression==null)
            return false;

        char [] chars = expression.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i <chars.length ; i++) {
            char c = chars[i];

            if(c==')'){
                int elements = 0;
                char x = stack.pop();
                while(x!='('){
                    elements++;
                    x = stack.pop();
                }

                if(elements<=1){
                    //If here means duplicate parenthesis are found,
                    return true;
                }
            }else
                stack.push(c);
        }
        return false;
    }

    public static void main(String[] args) {
        String expression = "A/(B+C)*D";
        System.out.println("Duplicate found in " + expression + " : " + isDuplicate(expression));
        expression = "A/(B+C)*D/((E+F))";
        System.out.println("Duplicate found in " + expression + " : " + isDuplicate(expression));
    }
}
