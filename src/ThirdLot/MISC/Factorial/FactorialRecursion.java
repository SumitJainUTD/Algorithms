package ThirdLot.MISC.Factorial;

/**
 * Created by sumi1 on 6/1/2018.
 */
public class FactorialRecursion {

    public static int factorial(int num){
        if(num==0)
            return 1;
        return num * factorial(num-1);
    }

    public static void main(String[] args) {
        int num = 10;
        int fact = factorial(num);
        System.out.println("Factorial of a number: " + num + " is(Recursion): " + fact);
    }
}
