package ThirdLot.MISC.ReverseNumber;

/**
 * Created by sumi1 on 6/25/2018.
 */
public class ReverseNumber {

    static void reverse(int N){

        System.out.println("Given Number: " +  N);
        int reverseNumber = 0;

        while(N>0){
            int rem = N%10;
            reverseNumber *= 10;
            reverseNumber += rem;
            N = N/10;
        }
        System.out.println("Reversed Number: " + reverseNumber);
    }

    public static void main(String[] args) {
        int N = 1234;
        reverse(N);
        N = 1020;
        reverse(N);
    }
}
