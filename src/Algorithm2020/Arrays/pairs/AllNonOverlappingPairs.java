package Algorithm2020.Arrays.pairs;

import java.util.*;

public class AllNonOverlappingPairs {

    public static void findNonOverlappingPairsTemp(int [] input){

        System.out.println("Given Input: " + Arrays.toString(input));

        HashMap<Integer, HashSet<Integer>> index_map = new HashMap<>();
        HashMap<Integer, List<Pair>> sum_map = new HashMap<>();
        for (int i = 0; i <input.length ; i++) {
            for (int j = i+1; j <input.length ; j++) {

                int currSum = input[i] + input[j];

                //check if sum is present in map
                if (sum_map.containsKey(currSum)) {
                    //check all the pairs with sum for overlapping
                    HashSet<Integer> set = index_map.get(currSum);
                    //check of overlapping
                    if (!set.contains(i) && !set.contains(j)) {
                        sum_map.get(currSum).add(new Pair(i, j));
                        set.add(i);
                        set.add(j);
                        index_map.put(currSum, set);
                    }
                } else {
                    //current sum does not exist in map, put it
                    sum_map.put(currSum, new ArrayList<>());
                    Pair p = new Pair(i, j);
                    sum_map.get(currSum).add(p);
                    HashSet<Integer> set = new HashSet<>();
                    set.add(i);
                    set.add(j);
                    index_map.put(currSum, set);
                }
            }
        }

        for(Integer key:sum_map.keySet()){
            List<Pair> list = sum_map.get(key);
            if(list.size()>1){
                System.out.print("Non overlapping pairs with sum = " + key);
                for (int i = 0; i <list.size() ; i++) {
                    Pair p = list.get(i);
                    System.out.print(" [" + input[p.x] +", " + input[p.y] + "]");
                }
                System.out.println();
            }
        }
    }

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

    public static void main(String[] args) {
//        int[] A = { -1, 4, 2, 5, 3, 8, 9};
        int[] A = { 4, 2, 5, 3, 5, 2};
        findNonOverlappingPairsTemp(A);
    }
}
