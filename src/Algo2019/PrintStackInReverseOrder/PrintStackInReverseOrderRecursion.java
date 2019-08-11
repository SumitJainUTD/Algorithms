package Algo2019.PrintStackInReverseOrder;

import java.util.Stack;

public class PrintStackInReverseOrderRecursion {


    public void reversePrint(Stack<Integer> stack){

        //base case
        if(stack.isEmpty())
            return;

        int x = stack.pop();
        reversePrint(stack);

        System.out.print(x + " ");

        //push elements back to stack
        stack.push(x);
    }

    public static void main(String args[]) {

        PrintStackInReverseOrderRecursion s = new PrintStackInReverseOrderRecursion();
        Stack<Integer> originalStack = new Stack<>();
        originalStack.add(4);
        originalStack.add(9);
        originalStack.add(6);
        originalStack.add(8);
        originalStack.add(10);
        originalStack.add(5);
        s.reversePrint(originalStack);
    }
}
