package Algorithm2020.google;

import java.util.Arrays;
import java.util.Random;

public class RandomIncreasingSublist {

    public static void getSubList(int [] input, int n){
        int [] result = new int[n];
        Random random = new Random();
        int index = 0;
        int length = input.length;
        for (int i = 0; i < result.length ; i++) {
            //any elements except last (n-1) elements can be picked
            //subtract n not n-1 since n array index starts from 0
            int range = (length-n-index);
            int x = random.nextInt(range+1); //+1 for picking any element from 0 to range
            index = x + index; // add previous to get to the right index at current iteration
            result[i] = input[index];
            index++;// move to the next element for next iteration
            n--; //now one less element is required
        }

        System.out.println(Arrays.toString(result));
    }

    public static void main(String[] args) {
        int [] input = {1, 2, 3, 4, 5};
        int n = 3;
        getSubList(input, n);
    }
}
