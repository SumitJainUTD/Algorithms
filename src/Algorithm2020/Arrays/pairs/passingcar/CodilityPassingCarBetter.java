package Algorithm2020.Arrays.pairs.passingcar;

import java.util.Arrays;

public class CodilityPassingCarBetter {

    public static void countPassingCar(int [] input){

        int passingCount = 0;
        int countOne = 0;
        for (int i = input.length-1; i >=0; i--) {
            int x = input[i];
            if(x==1)
                countOne++;
            if(x==0)
                passingCount += countOne;
        }
        System.out.println("Input: " + Arrays.toString(input));
        System.out.println("Number of passing cars: " + passingCount);
    }

    public static void main(String[] args) {
        int input [] = {0, 1, 0, 1, 1};
        countPassingCar(input);
    }
}
