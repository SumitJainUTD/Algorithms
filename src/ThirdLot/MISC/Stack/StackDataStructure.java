package ThirdLot.MISC.Stack;

import java.util.LinkedList;

public class StackDataStructure {

    private LinkedList<Object> lst;

    public StackDataStructure(){
        lst = new LinkedList();
    }
    public void push(Object j){
        System.out.println("Inserting " + j +  " into Stack.");
        lst.addFirst(j);
    }
    public Object pop(){
        System.out.println("Popping from Stack.");
        return lst.removeFirst();
    }
    public Object peek(){
        return lst.get(0);
    }
    public boolean isEmpty(){
        return (lst.isEmpty());
    }
    public int getSize(){
        return lst.size();
    }
    public void displayStack(){
        System.out.print("Stack (top-->bottom): ");
        for (int i = 0; i <lst.size() ; i++) {
            System.out.print(lst.get(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StackDataStructure stack = new StackDataStructure();
        System.out.println("Is Stack Empty: " + stack.isEmpty());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.displayStack();
        System.out.println("Popped Element: " + stack.pop());
        System.out.println("Popped Element: " + stack.pop());
        stack.displayStack();
        stack.push(6);
        System.out.println("Peeking Element: " + stack.peek());
        stack.displayStack();
        System.out.println("Is Stack Empty: " + stack.isEmpty());
        System.out.println("Stack Size: " + stack.getSize());
    }
}
