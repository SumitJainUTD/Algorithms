package Algorithm2020.Arrays.pairs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NumberOfPairsWithGivenSum {

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

        for(Integer num:map.keySet()) {
            int first = num;
            int firstCount = map.get(first);
            int second = sum - first;
            if (firstCount > 0 && map.containsKey(second) && map.get(second) > 0) {
                int secondCount = map.get(second);
                int sumCount = firstCount * secondCount;
                if(first==second) {
                    //when both numbers are same then
                    //number of ways to pick 2 elements out of n = nC2
                    sumCount = firstCount*(firstCount-1)/2;
                }
                pairCount += sumCount;
                map.put(first, 0);
                map.put(second, 0);
            }
        }
        return pairCount;
    }

    public static void main(String[] args) {
        int input[] = new int[] {1, 5, 7, 1, -1};
        int sum = 6;
        System.out.println("Given array: " + Arrays.toString(input) + ", Sum= " + sum);
        System.out.println("Total Pairs: " + findPairs(input, sum));
    }
}
