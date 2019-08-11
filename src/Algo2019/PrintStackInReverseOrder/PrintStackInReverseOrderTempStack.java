package Algo2019.PrintStackInReverseOrder;

import java.util.Stack;

public class PrintStackInReverseOrderTempStack {

    public void reversePrint(Stack<Integer> stack) {

        //base case
        if (stack.isEmpty())
            return;

        //create temporary stack
        Stack<Integer> temporaryStack = new Stack<>();

        //copy all the elements from given stack to temporary stack
        while(stack.size()>0){
            temporaryStack.push(stack.pop());
        }

        //now print all the elements from temporary stack
        //and while doing that restore all elements to given stack

        while(temporaryStack.size()>0){

            int x = temporaryStack.pop();

            System.out.print(x + " ");

            stack.push(x);
        }
    }

    public static void main(String args[]) {

        PrintStackInReverseOrderTempStack s = new PrintStackInReverseOrderTempStack();
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