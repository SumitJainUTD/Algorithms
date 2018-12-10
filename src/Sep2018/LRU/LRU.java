package Sep2018.LRU;

import java.util.*;

/**
 * Created by sjain on 9/9/17.
 */
public class LRU {
    int capacity;
    LinkedHashMap<Integer,Integer> cache;
    Queue<Integer> queue;

    public LRU(int capacity) {
        this.capacity = capacity;
        cache = new LinkedHashMap<Integer,Integer>(capacity);
        queue = new LinkedList<Integer>();
    }

    public int get(int key) {
        if(cache.containsKey(key)){
            queue.remove(key);
            queue.add(key);
            return cache.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if(cache.size()==capacity){
            int oldestKey = queue.poll();
            cache.remove(oldestKey);
        }else{
            queue.add(key);
        }
        cache.put(key,value);
    }

    public void print(){
        Set set = cache.keySet();
        Iterator<Integer> iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int capacity = 3;
        LRU lru = new LRU(capacity);
        lru.put(1,1);
        lru.put(2,2);
        System.out.println(lru.get(2));
        lru.put(3,3);
//        lru.print();
        lru.put(4,4);
        lru.print();
        lru.get(3);
        lru.put(5,5);
        lru.print();
    }
}
