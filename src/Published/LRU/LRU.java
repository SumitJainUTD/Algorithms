package Published.LRU;

import java.util.*;

/**
 * Created by sjain on 9/9/17.
 */
public class LRU {
    LinkedHashSet<Integer> set;
    Deque<Integer> cache;
    int capacity;

    public LRU(int capacity) {
        this.capacity = capacity;
        set = new LinkedHashSet<>(capacity);
        cache = new LinkedList<>();
    }

    public void look(int key) {
        //check if it is already present in cache (deque)
        if(set.contains(key)){
            //remove it from cache so that it can be added at front of the cache
            cache.remove(key);
        }else{
            //not already in cache, adding it
            if(cache.size()==capacity){
                //remove the last one from cache
                cache.removeLast();
                set.remove(key);
            }
        }
        //add it to cache
        cache.push(key);
        set.add(key);
        System.out.println("Looking for key: " + key);
        printCache();
    }

    public void printCache(){
        System.out.print("Cache: ");
        Iterator<Integer> iterator = cache.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int capacity = 4;
        LRU lru = new LRU(capacity);
        lru.look(1);
        lru.look(2);
        lru.look(1);
        lru.look(3);
        lru.look(4);
        lru.look(3);
        lru.look(5);
        lru.look(4);
        lru.look(6);
    }
}
