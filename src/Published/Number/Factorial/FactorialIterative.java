package Published.Number.Factorial;

/**
 * Created by sumi1 on 6/1/2018.
 */
public class FactorialIterative {

    public static int factorial(int num){
        if(num==0)
            return 1;
        int result = 1;
        for (int i = 2; i <=num ; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        int num = 7;
        int fact = factorial(num);
        System.out.println("Factorial of a number: " + num + " is(Iterative): " + fact);
    }
}
