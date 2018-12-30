package MacLaptop.October2018.ExpressionConversions;

import java.util.Stack;

/**
 * Created by sjain on 10/15/18.
 */
public class PostFixToInfix {

    public String convert(String expression){

        Stack<String> stack = new Stack<String>();
        for (int i = 0; i <expression.length() ; i++) {
            char c = expression.charAt(i);

            if(c=='*'||c=='/'||c=='^'||c=='+'||c=='-' ){
                String s1 = stack.pop();
                String s2 = stack.pop();
                String temp = "("+s2+c+s1+")";
                stack.push(temp);
            }else{
                stack.push(c+"");
            }
        }

        String result="";
        for (int i = 0; i <stack.size() ; i++) {
            result += stack.pop();
        }

        return result;
    }

    public static void main(String[] args) {
        String exp = "ABC/-AK/L-*";
        System.out.println(new PostFixToInfix().convert(exp));
    }

}
