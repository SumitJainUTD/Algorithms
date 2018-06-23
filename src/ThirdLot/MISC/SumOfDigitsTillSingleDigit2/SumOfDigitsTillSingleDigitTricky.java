package ThirdLot.MISC.SumOfDigitsTillSingleDigit2;

/**
 * Created by sumi1 on 6/9/2018.
 */
public class SumOfDigitsTillSingleDigitTricky {

    static int findSum(int N){
        if(N==0)
            return N;

        int remainder = N%9;
        if(remainder==0)
            return 9;
        else
            return remainder;
    }

    public static void main(String[] args) {
        int N = 12345;
        int result = findSum(N);
        System.out.println("Sum of digits in a number " + N + " till it become a single digit: " + result);
        N = 999;
        result = findSum(N);
        System.out.println("Sum of digits in a number " + N + " till it become a single digit: " + result);
        N = 111;
        result = findSum(N);
        System.out.println("Sum of digits in a number " + N + " till it become a single digit: " + result);
    }
}
