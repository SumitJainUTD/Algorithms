package Published.Arrays.TwoRepeatedElements;

/**
 * Created by sumi1 on 7/22/2017.
 */
public class TwoRepeatingByFormula {
    //this solution will work only if all the numbers are in the range of 1 to n and are >0
    //lets say twp repeated elements are a, b
    //Sum of 1 to n elements = S, Sum of all array elements = X, so a + b = X-S
    //Product of 1 to n elements = n!, Product of all array elements = Y, so a * b = Y/n!
    //now we have 2 equations and 2 unknowns , we can solve to get a and b
    // we know that a - b = sqrt( (a + b)^2 - 4ab )
    public static void twoElements(int [] A, int n){
        int a,b;
        int X =0;
        int Y =1;
        int S = n*(n+1)/2;
        int fact = factorial(n);
        for (int i = 0; i <A.length ; i++) {
            X += A[i];
            Y *= A[i];
        }
        int sum = X - S;
        int product = Y/fact;
        int subtract = (int)Math.sqrt(sum*sum - 4*product);

        a = (sum + subtract)/2;
        b = sum - a;

        System.out.println("Two Repeating Elements are: " + a + " and " + b);

    }
    static int factorial(int n){
        if(n==0)
            return 1;
        else
            return n*factorial(n-1);
    }

    public static void main(String[] args) {
        int [] A = {1,4,5,6,3,2,5,2};
        int n = 6;
        twoElements(A, n);
    }
}
