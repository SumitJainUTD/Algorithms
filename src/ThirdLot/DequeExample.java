package ThirdLot;


import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class DequeExample {

    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<>();

        //add methods
        System.out.println("ADD Operations...");
        deque.add("Tail-1");
        deque.addLast("Tail-2");
        deque.offer("Tail-3");
        deque.offerLast("Tail-4");

        deque.addFirst("Head-1");
        deque.offerFirst("Head-2");
        deque.offerFirst("Head-3");


        System.out.println("Deque is: " +  deque);

        //Iterations
        System.out.println("ITERATOR....");
        Iterator<String> iterator = deque.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println("REVERSE ITERATOR....");
        Iterator<String> reverseIterator = deque.descendingIterator();
        while(reverseIterator.hasNext()){
            System.out.println(reverseIterator.next());
        }

        //peek
        System.out.println("Peek : " +  deque.peek());
        System.out.println("Peek First : " +  deque.peekFirst());
        System.out.println("Peek Last: " +  deque.peekLast());

        //push pop - acct like stack
        System.out.println("Stack operations: Push");
        deque.push("Head-4");
        System.out.println("Deque: " + deque);
        System.out.println("Stack operations: Pop");
        deque.pop();
        System.out.println("Deque: " + deque);

        //remove operations
        System.out.println("REMOVE Operations...");
        deque.remove();
        deque.removeFirst();
        deque.removeLast();
        System.out.println("Deque: " + deque);

        //Contains
        System.out.println("Deque Contains 'AAAAA': " + deque.contains("AAA"));
        System.out.println("Deque Contains 'Tail-1': " + deque.contains("Tail-1"));



    }
}
