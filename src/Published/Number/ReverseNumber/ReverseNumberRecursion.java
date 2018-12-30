package Published.Number.ReverseNumber;

/**
 * Created by sumi1 on 6/25/2018.
 */
public class ReverseNumberRecursion {

    static void reverse(int N, int reverseNumber){

        if(N==0){
            System.out.println("Reversed Number using recursion: " +  reverseNumber);
            return;
        }
        int rem = N%10;
        reverseNumber *= 10;
        reverseNumber += rem;
        N = N/10;
        reverse(N, reverseNumber);
    }

    public static void main(String[] args) {
        int N = 1234;
        System.out.println("Given Number: " +  N);
        reverse(N, 0);
        N = 1020;
        System.out.println("Given Number: " +  N);
        reverse(N, 0);
    }
}