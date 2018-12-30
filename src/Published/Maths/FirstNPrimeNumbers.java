package Published.Maths;

import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * Created by sumi1 on 6/5/2018.
 */
public class FirstNPrimeNumbers {

    static void printPrimeNos(int N){

        int number = 2;
        int primeCount = 0;

        while(primeCount< N){
            if(isPrime(number)){
                System.out.print(number + " ");
                primeCount++;
            }
            number++;
        }
    }

    static boolean isPrime(int n){
        for (int i = 2; i <=Math.sqrt(n) ; i++) {
            if(n%i==0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int N = 5;
        printPrimeNos(N);
        System.out.println();
        N = 20;
        printPrimeNos(N);
    }
}
