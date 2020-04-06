package Algorithm2020.Arrays.inversions;

import java.util.Arrays;

public class CountInversionsNaive {

    public static void countInversionsBruteForce(int [] input){

        int count = 0;
        for (int i = 0; i <input.length ; i++)
            for (int j = i+1; j <input.length ; j++)
                if(input[i]>input[j])
                    count++;

        System.out.println("Input[] : " + Arrays.toString(input) + ", count inversions: " + count);
    }

    public static void main(String[] args) {
        int [] input = {1, 20, 6, 4, 5};
        countInversionsBruteForce(input);
    }
}


