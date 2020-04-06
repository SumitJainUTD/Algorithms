package Algo2019;

import java.util.*;

public class DivideIntoGroupOfConsecutiveNumbers {

    public static void divideIntoGroups(int [] input){

        System.out.println("Given Input: " + Arrays.toString(input));

        Integer [] indices = new Integer[input.length];

        for (int i = 0; i <input.length ; i++)
            indices[i]=i;

        Arrays.sort(indices, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return input[o1]-input[o2];
            }
        });

        List<Integer> list = new ArrayList<>();

        list.add(indices[0]);
        for (int i = 1; i <indices.length ; i++) {
            if(input[indices[i]]-input[indices[i-1]]==1){
                list.add(indices[i]);
            }else{
                printGroups(list, input);
                list = new ArrayList<>();
                list.add(indices[i]);
            }
        }
        //print the last group
        printGroups(list, input);
    }

    public static void printGroups(List<Integer> list, int [] input){
        Collections.sort(list);
        System.out.print("[");
        for(Integer i: list){
            System.out.print(input[i] + " ");
        }
        System.out.print("]  ");
    }

    public static void main(String[] args) {
        int [] input = {8, 2, 4, 7, 1, 11, 0, 3, 6, 10};
        divideIntoGroups(input);
    }
}
