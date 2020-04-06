package Algo2019;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class LengthOfMaximumSum {

    public static void lengthOfMaxSum(int [] input, int k){

        System.out.println("Given Input: " + Arrays.toString(input) + ", and K = " + k);
        int currentLength = 0;
        int currentSum = 0;

        Map<Integer, Integer> map = new TreeMap<>((o1, o2) -> o2-o1);
        for (int i = 0; i <input.length ; i++) {
            int current = input[i];
            if (current <= k) {
                currentSum += current;
                currentLength++;
            } else {
                if (map.containsKey(currentSum)) {
                    int count = map.get(currentSum);
                    map.put(currentSum, count + currentLength);
                } else
                    map.put(currentSum, currentLength);

                //reset
                currentSum = 0;
                currentLength = 0;
            }
        }

        //for last elements (if less than k)
        if (map.containsKey(currentSum)) {
            int count = map.get(currentSum);
            map.put(currentSum, count + currentLength);
        } else
            map.put(currentSum, currentLength);

        //get the first entry in map
        int index = map.keySet().iterator().next();
        System.out.print("Length of subsets with maximum sum: " + map.get(index));
    }

    public static void main(String[] args) {
        int input[] = {4, 4, 5, 6, 7, 1, 2, 4, 12, 4, 3, 1};
        int k = 4;
        lengthOfMaxSum(input, k);
    }
}
