package Algo2019;

import java.util.Stack;

public class ReverseStack {

    public void reverse(Stack<Integer> stack){

        if(stack.isEmpty()==false){

            //pop out all the items from the stack and store it in function stack
            int x = stack.pop();
            reverse(stack);

            //now insert the items into stack in reversed order
            //last item popped from the stack
            insert_at_bottom(stack, x);
        }
    }

    public void insert_at_bottom(Stack<Integer> stack, int x){

        //check if stack is empty
        if(stack.isEmpty()){
            stack.push(x);
            return;
        }
        //take out the existing items in stack and keep it in function stack
        int y = stack.pop();
        //push x to the bottom
        insert_at_bottom(stack, x);

        //push back all the items from function stack to stack
        stack.push(y);
    }

    public static void main(String[] args) {
        Stack<Integer> originalStack = new Stack<>();
        originalStack.add(14);
        originalStack.add(9);
        originalStack.add(67);
        originalStack.add(91);
        originalStack.add(101);
        originalStack.add(25);
        System.out.println("Original Stack: " + originalStack);

        ReverseStack r = new ReverseStack();
        r.reverse(originalStack);

        System.out.println("Reversed Stack: " + originalStack);
    }
}
