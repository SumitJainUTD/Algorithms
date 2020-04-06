package Algorithm2020.Arrays.pairs;

import java.util.*;

public class TwoNonOverlappingPairs {
    static class Pair{
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public String toString() {
            return "[" + x + ", " + y +"]";
        }
    }

    public static void findNonOverlappingPairs(int [] input){

        System.out.println("Given Input: " + Arrays.toString(input));

        HashMap<Integer, List<Pair>> sum_map = new HashMap<>();

        for (int i = 0; i <input.length ; i++) {
            for (int j = i+1; j <input.length ; j++) {

                int currSum = input[i] + input[j];

                //check if sum is present in map
                if(sum_map.containsKey(currSum)){
                    //check all the pairs with sum for overlapping
                    List<Pair>  list = sum_map.get(currSum);
                    for (int k = 0; k <list.size() ; k++) {
                        Pair p = list.get(k);
                        //check of overlapping
                        if(i!=p.x && i!=p.y && j!=p.x && j!=p.y){
                            System.out.println("Non overlapping pair: " +
                                    "["+input[i]+" , "+input[j]+"] and ["+input[p.x]+" , "+input[p.y]+"] with sum = " + currSum);
                            return;
                        }
                    }
                } else{
                    //current sum does not exist in map, put it
                    sum_map.put(currSum, new ArrayList<>());
                    Pair p = new Pair(i, j);
                    sum_map.get(currSum).add(p);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] A = {-1, 4, 2, 5, 3, 8, 9};
        findNonOverlappingPairs(A);
    }
}
