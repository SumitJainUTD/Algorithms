package Published.Expressions.ExpressionConversions;

import java.util.Stack;
public class PrefixtoPostFix {

    boolean isOperator(char x){
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
    
    public String convert(String expression){

        Stack<String> stack = new Stack<String>();
        for (int i = expression.length()-1; i >=0 ; i--) {

            char c = expression.charAt(i);

            if(isOperator(c)){
                String s1 = stack.pop();
                System.out.println(stack);
                String s2 = stack.pop();
                System.out.println(stack);
                String temp = s1 + s2 + c;
                stack.push(temp);
            }else{
                stack.push(c+"");
            }
            System.out.println(stack);
        }

        String result = stack.pop();
        return result;
    }

    public static void main(String[] args) {
        String prefix = "*-A/BC-/AKL";
        System.out.println("Prefix Expression: " + prefix);
        System.out.println("Postfix Expression: " + new PrefixtoPostFix().convert(prefix));
    }
}
