package MacLaptop.October2018;

/**
 * Created by sjain on 10/5/18.
 */
public class DoublyLinkedList {

    Node head = null;
    Node tail = null;
    public DoublyLinkedList() {
        head = new Node();
        head.prev = null;

        tail = new Node();
        tail.next = null;

        head.next = tail;
        tail.prev = head;
    }

    public void addNodeToStart(int data){
        Node x = new Node(data);
        x.next = head.next;
        x.prev = head;
        head.next.prev = x;
        head.next = x;
    }

    public Node removeNodeFromEnd(){
        Node x = tail.prev;
        removeNode(x);
        return x;
    }

    public void removeNode(Node y){
        Node prevNode = y.prev;
        Node nextNode = y.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    public void printList(){
        Node curr = head;
        while(curr.next!=null){
            curr = curr.next;
            if(curr.next!=null)
                System.out.print(curr.data + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DoublyLinkedList d = new DoublyLinkedList();
        d.addNodeToStart(1);
        d.addNodeToStart(2);
        d.addNodeToStart(3);
        d.printList();
        d.removeNodeFromEnd();
        d.printList();
        d.addNodeToStart(4);
        d.addNodeToStart(5);
        d.addNodeToStart(6);
        d.addNodeToStart(7);
        d.printList();

    }
}

class Node{
    int data;
    Node next;
    Node prev;

    public Node(int data) {
        this.data = data;
    }

    public Node() {

    }

}
