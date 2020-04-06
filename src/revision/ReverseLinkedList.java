package revision;

public class ReverseLinkedList {

    static class Node{
        Node next;
        int data;

        public Node(int data) {
            this.data = data;
        }
    }
    static Node newHead = null;
    public static Node reverse(Node head){

        if(head==null)
            return null;

        Node x = reverse(head.next);
        if(x==null){
            newHead = head;
            return newHead;
        }else{
            head.next = null;
            x.next = head;
        }
        return head;
    }

    public static void print(Node head){
        Node x = head;
        while (x!=null) {
            System.out.print("-->" + x.data);
            x = x.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        print(head);
        reverse(head);
        print(newHead);
    }
}
