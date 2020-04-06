package Algo2019.nearlySortedArray;

import java.util.Arrays;
import java.util.PriorityQueue;

public class NearlySortedArrayPQ {

    public static void sort(int [] input, int k){

        System.out.println("Given Input:" + Arrays.toString(input) + ", K=" + k);
        PriorityQueue<Integer> pq = new PriorityQueue<>(k+1);

        int index = 0;
        for (int i = 0; i <input.length ; i++) {
            if(i<=k)
                pq.offer(input[i]);
            else {
                input[index++] = pq.remove();
                pq.offer(input[i]);
            }
        }
        //iterate through priority queue and fill the array
        while(!pq.isEmpty())
            input[index++] = pq.remove();
        System.out.println("Sorted Input:" + Arrays.toString(input));
    }

    public static void main(String[] args) {
        int k = 3;
        int input[] = { 1, 5, 4, 11, 45, 10 };
        sort(input, k);
        k = 4;
        int input1[] = {4, 5, 6, 2, 3};
        sort(input1, k);
    }
}
