package Algo2019;

import java.util.*;

public class SumOfOverlappingElements {

    public static void findOverlappingElements(int [] setA, int [] setB){

        System.out.println("Set 1: " + Arrays.toString(setA) + ", Set 2: " + Arrays.toString(setB));
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i <setA.length ; i++) {
            int element = setA[i];
            if(map.containsKey(element)) {
                int count = map.get(element);
                map.put(element, count+1);
            }else
                map.put(element, 1);
        }

        for (int i = 0; i <setB.length ; i++) {
            int element = setB[i];
            if(map.containsKey(element)) {
                int count = map.get(element);
                map.put(element, count+1);
            }else
                map.put(element, 1);
        }

        //get sum of distinct elements
        int sum = 0;
        Set<Integer> set = map.keySet();
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()){
            int key = iterator.next();
            int count = map.get(key);
            if(count==2)
                sum += key*count;
        }
        System.out.println("Sum of overlapping elements: " + sum);
        System.out.println("----------------------------------------");
    }

    public static void main(String[] args) {
        int A[] = {2, 3, 1, 6};
        int B[] = {4, 0, 6, 7};
        findOverlappingElements(A, B);
        int C[] = {12, 13, 6, 10};
        int D[] = {13, 10, 16, 15};
        findOverlappingElements(C, D);
    }
}
