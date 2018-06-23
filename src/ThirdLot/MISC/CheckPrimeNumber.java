package ThirdLot.MISC;

/**
 * Created by sumi1 on 6/6/2018.
 */
public class CheckPrimeNumber {

    static void naiveMethod(int n){
        System.out.print("O(N) Solution : ");
        boolean isPrime = true;
        for (int i = 2; i <n ; i++) {
            if(n%i==0) {
                System.out.println("Number " + n +" is not a prime no");
                isPrime = false;
                break;
            }
        }
        if(isPrime)
            System.out.println("Number " + n +" is a prime no");

        //Time Complexity: O(N)
    }

    static void betterMethod(int n){
        boolean isPrime = true;
        System.out.print("O(N/2) Solution : ");
        for (int i = 2; i <=Math.sqrt(n) ; i++) {
            if(n%i==0) {
                System.out.println("Number " + n +" is not a prime no");
                isPrime = false;
                break;
            }
        }
        if(isPrime)
            System.out.println("Number " + n +" is a prime no");

        //Time Complexity: O(N/2) ~ O(N)
    }

    static void bestMethod(int n){
        boolean isPrime = true;
        System.out.print("O(√N) Solution : ");
        for (int i = 2; i <=Math.sqrt(n) ; i++) {
            if(n%i==0) {
                System.out.println("Number " + n +" is not a prime no");
                isPrime = false;
                break;
            }
        }
        if(isPrime)
            System.out.println("Number " + n +" is a prime no");

        //Time Complexity: O(√N)
    }

    public static void main(String[] args) {
        int n = 13;
        naiveMethod(n);
        betterMethod(n);
        bestMethod(n);
        n = 15;
        naiveMethod(n);
        betterMethod(n);
        bestMethod(n);
    }
}
