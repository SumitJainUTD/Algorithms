package Algorithm2020.Arrays.pairs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DistinctPairsWithGivenSum {

    public static int findPairs(int [] input, int sum){

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i <input.length ; i++) {
            int num =input[i];
            if(map.containsKey(num)){
                int count = map.get(num);
                map.put(num, count+1);
            }else
                map.put(num, 1);
        }

        //count pairs
        int pairCount = 0;

        for(Integer num:map.keySet()){
            int first = num;
            int count = map.get(first);
            if(count>0) {
                map.put(first, count - 1);
                int second = sum - first;
                if (map.containsKey(second) && map.get(second) > 0) {
                    pairCount++;
                    System.out.println("Pair: " + first + ", " + second);
                    int secondCount = map.get(second);
                    map.put(second, secondCount - 1);
                }
            }
        }
        return pairCount;
    }

    public static void main(String[] args) {
        int input[] = new int[]{4, 6, 8, -2, 2, 4, 8, 2} ;
        int sum = 10;
        System.out.println("Given array: " + Arrays.toString(input) + ", Sum= " + sum);
        System.out.println("Total Pairs: " + findPairs(input, sum));
    }
}
