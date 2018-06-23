package ThirdLot.MISC;

import java.util.Scanner;

/**
 * Created by sumi1 on 6/1/2018.
 */
public class TakeUserInput {
    public static void main(String[] args) {
        String userInput;
        System.out.println("How are you feeling today? ");
        Scanner scanner = new Scanner(System.in);
        userInput = scanner.nextLine();
        scanner.close();
        System.out.println("User Said : " + userInput);
    }
}
