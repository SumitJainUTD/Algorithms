package Algorithm2020.google;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSumProblem {

    public static void find(int [] input, int sum){

        HashMap<Integer, Integer> map = new HashMap<>();
        int x=-1, y=-1;
        for (int i = 0; i <input.length ; i++) {
            int num1 = input[i];
            int num2 = sum-num1;
            if(map.containsKey(num2)){
                x = i;
                y = map.get(num2);
                break;
            }
            map.put(num1, i);
        }
        System.out.println("Given array: " + Arrays.toString(input) + ", Sum = " + sum);
        if(x!=-1&&y!=-1)
            System.out.println("Found indexes are: " + x + " and " + y);
        else
            System.out.println("No indexes are found");
    }

    public static void main(String[] args) {
        int input [] = {5, 4, 7, 3, 9, 2};
        int sum = 13;
        find(input, sum);
    }
}
