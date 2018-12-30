package Published.Arrays;

import java.util.Stack;

public class ValidMultipleParentheses {

    static boolean isValid(String input){
        if(input==null)
            return true;

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i <input.length() ; i++) {
            char c = input.charAt(i);
            if(c=='('){
                stack.push(')');
            }
            if(c=='['){
                stack.push(']');
            }
            if(c=='{'){
                stack.push('}');
            }else if (c==')' || c=='}' || c==']' ){
                if(stack.isEmpty() || stack.pop()!=c)
                    return false;
            }
        }
        //if stack is empty at this point, return true
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String input = "()()([]({}))[]";
        System.out.println("is input " + input + " valid: " + isValid(input));
        input = "()({])";
        System.out.println("is input " + input + " valid: " + isValid(input));
        input = "[]{}()";
        System.out.println("is input " + input + " valid: " + isValid(input));
        input = "[(}{)]";
        System.out.println("is input " + input + " valid: " + isValid(input));
    }
}
