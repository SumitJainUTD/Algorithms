package Algo2019.NextGreaterElement;

import java.util.Arrays;
import java.util.Stack;

public class NextLargerNode {

    static class Node {
        int value;
        Node next;
        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }
    int [] result;
    public void nextGreaterNodes(Node head) {
        System.out.print("Linked List: ");
        Stack<Integer> stack = new Stack<>();
        nextGreaterNodeUtil(head, 0, stack);
        System.out.println();
        System.out.println("Greater Array: " + Arrays.toString(result));
    }

     void nextGreaterNodeUtil(Node node, int index, Stack<Integer> stack) {
         if (node == null) {
             result = new int[index];
             return;
         }

         //recursive call
         System.out.print("->"+node.value);
         nextGreaterNodeUtil(node.next, index + 1, stack);

         //tail recursion, will move from right to left
         int current = node.value;
         while (!stack.isEmpty() && stack.peek() < current)
             stack.pop();

         int greater = (stack.isEmpty() == false) ? stack.peek() : 0;
         result[index] = greater;
         stack.push(current);
     }

    public static void main(String[] args) {
        Node head = new Node(6);
        head.next = new Node(2);
        head.next.next = new Node(4);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(10);
        head.next.next.next.next.next.next = new Node(6);

        NextLargerNode n = new NextLargerNode();
        n.nextGreaterNodes(head);

    }
}
