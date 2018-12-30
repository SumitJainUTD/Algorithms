package MacLaptop.October2018.LRUCache;

import java.util.HashMap;

/**
 * Created by sjain on 10/5/18.
 */
public class LRUCache {

    Node head = null;
    Node tail = null;
    HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    int capacity;
    public LRUCache(int capacity) {
        head = new Node();
        head.prev = null;

        tail = new Node();
        tail.next = null;

        head.next = tail;
        tail.prev = head;

        this.capacity = capacity;
    }

    public void addNodeToStart(int key, int value){
        Node x = new Node(key, value);
        x.next = head.next;
        x.prev = head;
        head.next.prev = x;
        head.next = x;
        map.put(key, x);
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

        map.remove(y.key);
    }

    public void printList(){
        Node curr = head;
        while(curr.next!=null){
            curr = curr.next;
            if(curr.next!=null)
                System.out.print("key: " + curr.key + " value: " + curr.value + ", ");
        }
        System.out.println();
    }

    public void moveNodeToHead(Node node){
        removeNode(node);
        addNodeToStart(node.key, node.value);
    }

    public int get(int x){
        if(map.containsKey(x)){
            Node node = map.get(x);
            moveNodeToHead(node);
            return node.value;
        }else{
            return -1;
        }
    }

    public void updateValue(int key, int value){
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
        }
    }

    public void put(int key, int value) {
        if (get(key) == -1) {
            //need to add the new node to the list
            if (map.size() == capacity) {
                removeNodeFromEnd();
            }
            addNodeToStart(key, value);
        }else{
            //means node already exist, update its value
            updateValue(key, value);
        }
    }

    public static void main(String[] args) {
        int capacity = 2;
        LRUCache cache = new LRUCache(capacity);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.printList();
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4
    }
}

class Node{
    int key;
    int value;
    Node next;
    Node prev;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public Node() {

    }

}