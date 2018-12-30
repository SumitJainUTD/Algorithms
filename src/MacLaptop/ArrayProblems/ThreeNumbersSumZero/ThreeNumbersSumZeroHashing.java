package MacLaptop.ArrayProblems.ThreeNumbersSumZero;

import java.util.HashSet;

/**
 * Created by sjain on 8/11/17.
 */
public class ThreeNumbersSumZeroHashing {

    //we need to find a + b + c = 0
    //OR reduce the problem c = -(a+b)

    public static void find(int [] x){
        for (int i = 0; i <x.length ; i++) {
            int a = x[i];
            HashSet<Integer> set = new HashSet<Integer>();

            for (int j=i+1; j<x.length; j++) {
                int b = x[j];
                int c = -(a+b);
                if(set.contains(c)){
                    System.out.println("Found 3 elements whose sum is = 0");
                    System.out.println("Elements are " + a + " " + b + " " + c);
                    return;
                }else
                    set.add(b);
            }
        }
    }
    public static void main(String[] args) {
        int a [] = { 3,-1,-7,-4,-5,9,10};
        find(a);
    }
}

