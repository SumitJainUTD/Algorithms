package MacLaptop.October2018.ExpressionConversions;

import java.util.Stack;

/**
 * Created by sjain on 10/15/18.
 */
public class PreFixToInFix {
    public String convert(String expression){

        Stack<String> stack = new Stack<String>();
        for (int i = expression.length()-1; i >=0 ; i--) {
            char c = expression.charAt(i);

            if(isOperator(c)){
                String s1 = stack.pop();
                String s2 = stack.pop();
                String temp = "("+s1+c+s2+")";
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

    boolean isOperator(char x) {
        switch (x) {
            case '+':
            case '-':
            case '/':
            case '*':
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String exp = "*-A/BC-/AKL";
        System.out.println(new PreFixToInFix().convert(exp));
    }
}
