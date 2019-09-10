package Algo2019.PrimeNumber;

public class SieveOfEratosthenes {

    public static void findPrimeNumbers(int N){
        if(N<2)
            return;

        int prime[] = new int[N+1];
        for(int i=0; i<=N; i++)
            prime[i] = 1;

        for (int i = 2; i <=Math.sqrt(N) ; i++) {
            //check if number i is prime
            if(prime[i]==1){
                //update all the multiples of i
                for (int j = i*i; j <=N ; j=j+i) {
                    prime[j] = 0;
                }
            }
        }
        //Now print all the prime numbers
        for (int i = 2; i <=N ; i++) {
            if(prime[i] == 1)
                System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        int N = 60;
        System.out.println("Number of Prime numbers less than N=" +N);
        findPrimeNumbers(N);
    }
}
