package ThirdLot.MISC.Stack;


public class StackUsingArray {
    int size;
    int topIndex = -1;
    int [] stack;

    public StackUsingArray(int size){
        this.size = size;
        stack = new int[size];
    }
    public void push(int num){
        if(topIndex==size-1) {
            System.out.println("Stack overflow, ...cannot insert new element");
            return;
        }
        System.out.println("Inserting " + num +  " into Stack.");
        topIndex = topIndex + 1;
        stack[topIndex] = num;
    }
    public Integer pop(){
        if(topIndex<0) {
            System.out.println("Stack is empty, nothing to pop");
            return null;
        }
        System.out.println("Popping from Stack.");
        Integer x =  stack[topIndex];
        topIndex--;
        return x;
    }
    public Object peek(){
        if(topIndex<0) {
            System.out.println("Stack is empty, nothing to pop");
            return null;
        }
        System.out.println("Popping from Stack.");
        return stack[topIndex];
    }

    public boolean isEmpty(){
        return (topIndex<0);
    }
    public int getSize(){
        return topIndex+1;
    }
    public void displayStack(){
        System.out.print("Stack (top-->bottom): ");
        for (int i = topIndex; i >=0 ; i--) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int size = 4;
        StackUsingArray stack = new StackUsingArray(size);
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
