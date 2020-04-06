package Algorithm2020.Arrays.pairs.passingcar;

import java.util.Arrays;

public class CodilityPassingCarBruteForce {

    public static void countPassingCar(int [] input){

        int passingCount = 0;
        for (int i = 0; i <input.length ; i++) {
            int x = input[i];
            if(x==0){
                for (int j = i+1; j <input.length ; j++) {
                    int y = input[j];
                    if(y==1)
                        passingCount++;
                }
            }
        }
        System.out.println("Input: " + Arrays.toString(input));
        System.out.println("Number of passing cars: " + passingCount);
    }

    public static void main(String[] args) {
        int input [] = {0, 1, 0, 1, 1};
        countPassingCar(input);
    }
}
