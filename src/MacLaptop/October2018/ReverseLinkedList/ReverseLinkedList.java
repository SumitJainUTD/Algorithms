package MacLaptop.October2018.ReverseLinkedList;

/**
 * Created by sjain on 10/22/18.
 */
public class ReverseLinkedList {


    static Node  nHead = null;
    public static Node reverse(Node head){
        if(head==null)
            return null;

        if(head.next==null){
            nHead =  head;
            return nHead;
        }
        Node x = reverse(head.next);
        x.next = head;
        head.next=null;
        return head;
    }

    public static Node reverse2(Node head){

        if(head==null || head.next==null)
            return head;
        Node nextNode=head.next;
        Node newHead=reverse2(nextNode);
        nextNode.next=head;
        head.next=null;
        return newHead;
    }

    public static void print(Node head){
        Node curr = head;
        while(curr!=null){
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        print(head);
//        reverse(head);
//        print(nHead);
        Node newHead = reverse2(head);
        print(newHead);

    }


}

class Node{
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }
}
