package MacLaptop.SixthLot.ReverseLinkedList;

/**
 * Created by sjain on 9/16/18.
 */
public class ReverseLinkedList {

    static Node newHead = null;
    public static Node reverse(Node head){
        //base
        if(head.next==null) {
            newHead = head;
            return head;
        }

        //reverse
        Node x = reverse(head.next);
        x.next = head;
        head.next = null;
        return head;
    }

    public static void print(Node head){
        Node curr = head;
        while(curr!=null){
            System.out.print("->"+curr.data);
            curr = curr.next;
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next= new Node(3);
        head.next.next.next= new Node(4);
        print(head);
        reverse(head);
        print(newHead);
    }


    static class Node{
        int data;
        public Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
}
