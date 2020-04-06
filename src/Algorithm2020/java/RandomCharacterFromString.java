package Algorithm2020.java;

import java.util.Random;

public class RandomCharacterFromString {

    public static char getRandomCharacter(String input){
        Random random = new Random();
        int length = input.length();
        char randomChar = '\0';
        int randIndex = random.nextInt(length);
        while (randomChar==' ' || randomChar=='\0'){
            randomChar = input.charAt(randIndex);
            randIndex = random.nextInt(length);
        }
        return randomChar;
    }

    public static void main(String[] args) {
        String input = "algorithms @ tutorial horizon";
        System.out.println("Given string = " + input);
        for (int i = 0; i <5 ; i++) {
            System.out.println("Random character: " + getRandomCharacter(input));
        }
    }
}
