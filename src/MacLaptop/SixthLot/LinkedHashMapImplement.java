package MacLaptop.SixthLot;

import java.util.LinkedHashMap;


public class LinkedHashMapImplement {

    int capacity;
    int size=0;
    LinkedHashMap<Integer, Integer> linkedHashMap;
    public LinkedHashMapImplement(int capacity){
        this.capacity = capacity;
        linkedHashMap = new LinkedHashMap<Integer, Integer>(capacity);
    }

    public int get(int key) {
        if(linkedHashMap.containsKey(key)){
            int value = linkedHashMap.remove(key);
            linkedHashMap.put(key, value);
            size++;
            return value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(size==capacity){

        }else{
            if(linkedHashMap.containsKey(key)){
                linkedHashMap.remove(key);
            }
            linkedHashMap.put(key, value);
        }

    }

    public static void main(String[] args) {
        LinkedHashMapImplement cache = new LinkedHashMapImplement(2);
        cache.put(1, 1);
        cache.put(2, 2);
        int x = cache.get(1);       // returns 1
        System.out.println(x);
        cache.put(3, 3);    // evicts key 2
        x = cache.get(2);       // returns -1 (not found)
        System.out.println(x);
        cache.put(4, 4);    // evicts key 1
        x = cache.get(1);       // returns -1 (not found)
        System.out.println(x);
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4
    }
}
