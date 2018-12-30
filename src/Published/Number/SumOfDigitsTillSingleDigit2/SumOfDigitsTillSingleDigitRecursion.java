package Published.Number.SumOfDigitsTillSingleDigit2;

/**
 * Created by sumi1 on 6/9/2018.
 */
public class SumOfDigitsTillSingleDigitRecursion {

    static int findSum(int N){
        if(N<10)
            return N;

        int sum = 0;
        while(N>0){
            sum += N%10;
            N = N/10;
        }
        return findSum(sum);
    }

    public static void main(String[] args) {
        int N = 12345;
        int result = findSum(N);
        System.out.println("Sum of digits in a number " + N + " till it become a single digit: " + result);
        N = 999;
        result = findSum(N);
        System.out.println("Sum of digits in a number " + N + " till it become a single digit: " + result);
    }
}
