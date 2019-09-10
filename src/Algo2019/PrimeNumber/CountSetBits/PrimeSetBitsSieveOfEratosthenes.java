package Algo2019.PrimeNumber.CountSetBits;

import java.util.ArrayList;

public class PrimeSetBitsSieveOfEratosthenes {

    public void primeSetBits(int L, int R) {

        ArrayList<Integer> primeNumbers = findPrimeNumbers(R);
        if(primeNumbers.size()==0) {
            System.out.println("No numbers found for which set bits count is prime");
            return;
        }
        System.out.println("Numbers found for which set bits count is prime: ");
        for(int i=L;i<=R;i++){
            if(primeNumbers.contains(countBits(i)))
                System.out.print(i + " ");
        }
    }

    public static ArrayList<Integer> findPrimeNumbers(int N){

        ArrayList<Integer> primeNumbers = new ArrayList<>();
        if(N<2)
            return primeNumbers;

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
        //add all the prime numbers to list
        for (int i = 2; i <=N ; i++) {
            if(prime[i] == 1)
                primeNumbers.add(i);
        }
        return primeNumbers;
    }

    public int countBits(int n){
        int count = 0;
        while(n>0){
            if((n&1)==1)
                count++;
            n = n>>1;
        }
        return count;
    }

    public static void main(String[] args) {
        PrimeSetBitsSieveOfEratosthenes c = new PrimeSetBitsSieveOfEratosthenes();
        c.primeSetBits(4, 10);
    }
}
