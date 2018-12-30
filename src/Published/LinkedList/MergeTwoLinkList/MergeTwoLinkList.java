package Published.LinkedList.MergeTwoLinkList;

/**
 * Created by sumi1 on 5/28/2018.
 */
public class MergeTwoLinkList {
    private LinkedListT a;
    private LinkedListT b;

    public MergeTwoLinkList(LinkedListT a, LinkedListT b) {
        this.a = a;
        this.b = b;
    }

    public LinkedListT mergeWithOutRecur() {
        LinkedListT result = new LinkedListT();
        while (a.head != null && b.head != null) {
            // System.out.println(a.head.data + " " + b.head.data);
            if (a.head.data < b.head.data) {
                result.addAtEnd(a.head.data);
                a.head = a.head.next;
            } else {
                result.addAtEnd(b.head.data);
                b.head = b.head.next;
            }
        }
        while (a.head != null) {
            result.addAtEnd(a.head.data);
            a.head = a.head.next;
        }
        while (b.head != null) {
            result.addAtEnd(b.head.data);
            b.head = b.head.next;
        }
        return result;
    }

    public Node recursionMerge(Node nA, Node nB) {
        // base case
        Node result = null;
        if (nA == null)
            return nB;
        else if (nB == null)
            return nA;
        if (nA.data < nB.data) {// Check which node has a smaller value
            result = nA; // add it to the result node
            result.next = recursionMerge(nA.next, nB);// Recursive call and add
            // the return node as
            // result.next
        } else {
            result = nB; // add it to the result node
            result.next = recursionMerge(nA, nB.next); // Recursive call and
            // add the return node
            // as result.next
        }
        return result;
    }

    public void display(Node head) {
        System.out.println("");
        Node currNode = head;
        while (currNode != null) {
            System.out.print("->" + currNode.data);
            currNode = currNode.next;
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        System.out.println("Method : with Recursion");
        LinkedListT a = new LinkedListT();
        a.addAtBegin(8);
        a.addAtBegin(6);
        a.addAtBegin(5);
        LinkedListT b = new LinkedListT();
        b.addAtBegin(9);
        b.addAtBegin(7);
        b.addAtBegin(3);
        b.addAtBegin(1);
        MergeTwoLinkList m = new MergeTwoLinkList(a, b);
        m.display(a.head);
        m.display(b.head);
        Node result;

        result = m.recursionMerge(a.head, b.head);
        m.display(result);
        // method 2
        System.out.println("Method : without Recursion");
        LinkedListT a1 = new LinkedListT();
        a1.addAtBegin(18);
        a1.addAtBegin(6);
        a1.addAtBegin(2);
        LinkedListT b1 = new LinkedListT();
        b1.addAtBegin(19);
        b1.addAtBegin(17);
        b1.addAtBegin(3);
        b1.addAtBegin(1);
        MergeTwoLinkList m1 = new MergeTwoLinkList(a1, b1);
        m1.display(a1.head);
        m1.display(b1.head);

        LinkedListT res = m1.mergeWithOutRecur();
        m1.display(res.head);
    }
}
class Node {
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedListT {
    public Node head;
    public int size;
    public LinkedListT() {
        head = null;
    }
    public void addAtBegin(int data) {
        Node n = new Node(data);
        n.next = head;
        head = n;
        size++;
    }
    public void addAtEnd(int data) {
        if (head == null) {
            addAtBegin(data);
        } else {
            Node n = new Node(data);
            Node currNode = head;
            while (currNode.next != null) {
                currNode = currNode.next;
            }
            currNode.next = n;
            size++;
        }
    }
}