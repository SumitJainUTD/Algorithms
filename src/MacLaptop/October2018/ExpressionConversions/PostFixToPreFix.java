package MacLaptop.October2018.ExpressionConversions;

import java.util.Stack;

/**
 * Created by sjain on 10/15/18.
 */
public class PostFixToPreFix {

    static boolean isOperator(char x){
        switch (x){
            case '-':
            case '+':
            case '/':
            case '*':
            case '^':
                return true;
        }
        return false;
    }

    public static String convert(String expression){

        Stack<String> stack = new Stack<String>();
        for (int i = 0; i <expression.length() ; i++) {

            char c = expression.charAt(i);

            if(isOperator(c)){
                String s1 = stack.pop();
                String s2 = stack.pop();
                String temp = c + s2 + s1;
                stack.push(temp);
            }else{
                stack.push(c+"");
            }
        }

        String result = "";
        for (int i = 0; i <stack.size() ; i++) {
            result += stack.pop();
        }

        return result;
    }

    public static void main(String[] args) {
        String postfix = "ABC/-AK/L-*";
        System.out.println(convert(postfix));
    }

}
