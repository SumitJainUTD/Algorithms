package Algo2019.StackSorting;

import java.util.Stack;
public class StackSorting {

    public Stack<Integer> sorting(Stack<Integer> original) {
        //create a temporary stack
        Stack<Integer> temporaryStack = new Stack<>();

        while(!original.isEmpty()) {
            // pop out the first element from the original stack
            int x = original.pop();

            // while temporary stack is not empty and top of temporary stack is greater than x
            while(!temporaryStack.isEmpty() && temporaryStack.peek() > x) {
                // pop from temporary stack and push it to the original stack
                original.push(temporaryStack.pop());
            }

            // At this point either temporary stack is empty or top of temporary stack is <= x
            // push x in temporary of stack
            temporaryStack.push(x);
        }
        return temporaryStack;
    }

    public static void main(String args[]) {

        StackSorting s = new StackSorting();
        Stack<Integer> originalStack = new Stack<>();
        originalStack.add(14);
        originalStack.add(9);
        originalStack.add(67);
        originalStack.add(91);
        originalStack.add(101);
        originalStack.add(25);
        System.out.println("Original Stack: " + originalStack);
        Stack<Integer> sortedStack= s.sorting(originalStack);
        System.out.println("Sorted Stack is:" + sortedStack);
    }
}
