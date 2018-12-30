package Published.LinkedList;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLinkedList {

    static ListNode merge(ListNode [] heads){
        ListNode resultHead=null;
        ListNode current = null;

        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.data-o2.data;
            }
        });

        //insert all heads into priority queue
        for (int i = 0; i <heads.length ; i++) {
            if(heads[i]!=null){
                pq.offer(heads[i]);
            }
        }

        while (!pq.isEmpty()) {
            //extract the min from priority queue
            ListNode node = pq.poll();

            //add it to result Head
            if(resultHead==null){
                resultHead = node;
                current = node;
            }else {
                current.next = node;
                current = current.next;
            }

            //add next List Node to priority queue
            if(node.next!=null){
                pq.add(node.next);
            }
        }
        return resultHead;
    }
    static class ListNode{
        int data;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
        }
    }

    static void print(ListNode node){
        ListNode current = node;
        while(current!=null){
            System.out.print("-->"+ current.data );
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(5);
        print(list1);

        ListNode list2 = new ListNode(4);
        list2.next = new ListNode(8);
        print(list2);

        ListNode list3 = new ListNode(4);
        list3.next = new ListNode(6);
        list3.next.next = new ListNode(9);
        print(list3);

        ListNode list4 = new ListNode(2);
        list4.next = new ListNode(7);
        list4.next.next = new ListNode(10);
        print(list4);

        ListNode [] heads = new ListNode [] {list1, list2, list3, list4};
        ListNode result = merge(heads);
        System.out.println("Merged Linked List: ");
        print(result);
    }
}
