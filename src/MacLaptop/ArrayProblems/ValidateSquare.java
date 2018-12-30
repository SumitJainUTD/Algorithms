package MacLaptop.ArrayProblems;

/**
 * Created by sjain on 9/10/17.
 */
public class ValidateSquare {
    public static boolean isSquare(int n){
        if(n==0 || n==1)
            return true;
        for (int i = 0; i <n/2 ; i++) {
            int x = i*i;
            if(x==n)
                return true;
            else if (n<x)
                return false;
            else
                continue;
        }
        return false;
    }

    public static void main(String[] args) {
        int n = 1;
        System.out.println(n + " is square: " + isSquare(n));
        n = 49;
        System.out.println(n + " is square: " + isSquare(n));

    }
}
