package Published.String;

import java.util.Stack;

public class ReverseStringStack {

    static void reverse(String input){
        StringBuffer output = new StringBuffer();
        if(input==null || input.isEmpty())
            return;

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i <input.length() ; i++) {
            stack.add(input.charAt(i));
        }

        //traverse through stack, pop the characters and add it to StringBUffer
        while (stack.empty()==false){
            output.append(stack.pop());
        }

        System.out.println("Original String: " +  input);
        System.out.println("Reverse String: " + output);
    }

    public static void main(String[] args) {
        String input = "tutorial horizon";
        reverse(input);
    }
}
