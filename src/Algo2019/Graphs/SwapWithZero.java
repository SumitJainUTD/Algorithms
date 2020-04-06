package Algo2019.Graphs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SwapWithZero {

    public static void swapZero(int [] source, int [] target){

        System.out.println("Source[] = " + Arrays.toString(source) + ", Target[] = " + Arrays.toString(target));
        //store all the incorrect positions in map
        //mandatory for 0
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i <source.length ; i++) {
            if(source[i]!=target[i]||source[i]==0){
                map.put(source[i], i);
            }
        }
        arrange(source, target, map);
    }

    public static void arrange(int [] source, int [] target, Map<Integer, Integer> sourceMap){
        //until all the numbers are not at correct positions
        while(sourceMap.size()>1){
             int zeroIndex = sourceMap.get(0);
             // get the element at zero index in target array
            int target_zeroIndex = target[zeroIndex];
            if(target_zeroIndex!=0){
                // if target_zeroIndex is non zero, swap this element with 0 with source array
                int swapIndex = sourceMap.get(target_zeroIndex);
                swap(source, swapIndex, zeroIndex);
                sourceMap.put(0, swapIndex); //update index of 0 in source array
                sourceMap.remove(target_zeroIndex); // remove this index from sourceMap since right element at this index
            } else{
                //means target_zeroIndex = 0, get the next element in sourceMap
                Iterator<Integer> iterator = sourceMap.keySet().iterator();
                Integer next = iterator.next();
                while(iterator.hasNext()){
                    if(next == 0) {
                        next = iterator.next();
                        break;
                    }
                }
                int nextIndex = sourceMap.get(next);
                swap(source,zeroIndex,nextIndex);
                sourceMap.put(0,nextIndex);
                sourceMap.put(next,zeroIndex);
            }
        }
    }

    public static void swap(int[] source, int i, int j) {
        System.out.print("Swapping elements: " + source[i] + " with " + source[j]) ;
        int temp = source[i];
        source[i] = source[j];
        source[j] = temp;
        System.out.println(", Source[] = " + Arrays.toString(source));
    }

    public static void main(String[] args) {
        int [] source = {1, 0, 2, 3};
        int [] target = {0, 2, 3, 1};
        swapZero(source, target);
    }
}
