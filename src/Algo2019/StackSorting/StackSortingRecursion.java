package Algo2019.StackSorting;

import java.util.Stack;

public class StackSortingRecursion {

    public Stack<Integer> sorting(Stack<Integer> original) {

        if(original.size()>0){

            ////pop out all the items from the stack and store it in function stack
            int x = original.pop();
            sorting(original);

            //now insert the items into stack in sorted order
            sortUtil(original, x);
        }

        return original;
    }

    public void sortUtil(Stack<Integer> stack, int x){

        //if stack is empty OR top of stack element is greater than the element x
        //push item to stack, this will maintain the sorted order.
        if(stack.size()==0 || stack.peek()>x){
            stack.push(x);
            return;
        }
        //if here means insertion of new element is breaking the sorted order,
        //so pop it out for so that element x can be pushed to its right position

        int y = stack.pop();
        sortUtil(stack, x);

        //once element x is placed then push y back to stack
        stack.push(y);
    }


    public static void main(String args[]) {

        StackSortingRecursion s = new StackSortingRecursion();
        Stack<Integer> originalStack = new Stack<>();
        originalStack.add(4);
        originalStack.add(9);
        originalStack.add(6);
        originalStack.add(8);
        originalStack.add(10);
        originalStack.add(5);
        System.out.println("Original Stack: " + originalStack);
        Stack<Integer> sortedStack = s.sorting(originalStack);
        System.out.println("Sorted Stack is:" + sortedStack);

    }
}
