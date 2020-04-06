package Algorithm2020.java;

import java.util.Arrays;
import java.util.Random;

public class GetRandomElementFromArray {

    public static int getRandomElement(int [] input){
        Random random = new Random();
        int length = input.length;

        int randIndex = random.nextInt(length);
        int randomElement =  input[randIndex];

        return randomElement;
    }

    public static void main(String[] args) {
        int [] input = {4, 7, 1, 9, 3, 10, 13};
        System.out.println("Given input [] = " + Arrays.toString(input));
        for (int i = 0; i <5 ; i++) {
            System.out.println("Random element: " + getRandomElement(input));
        }
    }
}
