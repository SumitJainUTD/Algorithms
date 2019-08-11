package Algo2019.PrimeNumber;

public class FindPrimeNumberInRangeNaive {

    public static void findPrimes(int N){

        for (int i = 2; i <=N ; i++) {
            if(isPrime(i))
                System.out.print(i + " ");
        }
    }

    public static boolean isPrime(int n){
        if(n==1)
            return false;
        for(int i=2;i<n;i++){
            if(n%i==0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int N = 100;
        findPrimes(N);
    }
}
