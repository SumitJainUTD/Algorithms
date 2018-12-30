package Published.Number;

/**
 * Created by sumi1 on 6/1/2018.
 */
public class SumOfDigits {

    public static void digitsSums(int number){
        int sum = 0;
        int n = number;
        while(n>0){
            sum += n%10;
            n = n/10;
        }
        System.out.println("Sum of digits of number " + number + " is: " + sum);
    }

    public static void main(String[] args) {
        int number = 3045;
        digitsSums(number);
    }
}
