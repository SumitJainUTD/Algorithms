package Sep2018.LRU;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by sjain on 9/9/17.
 */
public class LRUCache {

    HashMap<Integer,Node> cache;
    int capacity;
    Node head;
    Node tail;
    int size;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<Integer, Node>();
    }

    public void addToHead(Node node){
        if(size==0){
            head = node;
            tail = node;
        }else{
            node.next = head;
            head.prev = node;
            head = node;
        }
        size++;
    }

    public void deleteNode(Node node){
        if(node.prev!=null) //boundary condition for start
            node.prev.next = node.next;
        if(node.next!=null) //boundary condition for end
            node.next.prev = node.prev;
    }

    public int get(int key) {
        if(cache.containsKey(key)){
            Node valNode = cache.get(key);
            deleteNode(valNode);
            printDLL();
            addToHead(valNode);
            return valNode.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(cache.containsKey(key)){
            get(key);
        }else if(cache.size() == capacity){
            Node newNode = new Node(key,value);
            deleteNode(tail);
            cache.remove(tail.key);
            cache.put(key, newNode);
            addToHead(newNode);
        }else{
            Node newNode = new Node(key,value);
            cache.put(key,newNode);
            addToHead(newNode);
        }
    }

    public void print(){
        Set set = cache.keySet();
        Iterator<Integer> iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }

    public void printDLL(){
        Node start = head;
        while(start!=null){
            System.out.print(start.key + " ");
            start = start.next;
        }
    }
    public static void main(String[] args) {
        int capacity = 3;
        LRUCache lru = new LRUCache(capacity);
        lru.put(1,1);
        lru.put(2,2);
        System.out.println(lru.get(2));
//        lru.put(3,3);
//        lru.print();
        lru.printDLL();
        lru.put(4,4);
        lru.print();
        lru.get(3);
        lru.put(5,5);
        lru.print();
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
        this.next= null;
        this.prev = null;
    }
}
