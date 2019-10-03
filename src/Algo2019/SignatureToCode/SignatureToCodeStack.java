package Algo2019.SignatureToCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class SignatureToCodeStack {

    public void getCode(String signature){

        System.out.println("Signature: " + signature);
        ArrayList<Integer> list = new ArrayList<>();

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i <signature.length() ; i++) {

            stack.push(i+1); //iteration start with 0 so add 1
            char c = signature.charAt(i);

            if(c=='I') {
                while (!stack.isEmpty())
                    list.add(stack.pop());
            }
        }

        //for element in output , just push the signature size + 1  to stack.
        //it will handle both cases i'D' or 'I'
        stack.push(signature.length()+1);

        //check if stack is not empty, add it to output
        while (!stack.isEmpty())
            list.add(stack.pop());
        System.out.println("Output: " + Arrays.toString(list.toArray()));
        System.out.println("------------------------------------------");
    }

    public static void main(String[] args) {
        SignatureToCodeStack s = new SignatureToCodeStack();
        String signature = "DDIIDDI";
        s.getCode(signature);
        signature = "DDI";
        s.getCode(signature);
        signature = "DIDIDIDI";
        s.getCode(signature);
        signature = "IIIIII";
        s.getCode(signature);
        signature = "DDDDD";
        s.getCode(signature);
    }
}
