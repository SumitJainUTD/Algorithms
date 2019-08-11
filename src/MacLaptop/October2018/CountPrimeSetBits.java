package MacLaptop.October2018;

public class CountPrimeSetBits {

    public int countPrimeSetBits(int L, int R) {
        int result = 0;
        for(int i=L;i<=R;i++){
            if(isPrime(countBits(i)))
                result++;
        }
        return result;
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

    public boolean isPrime(int n){
        if(n==1)
            return false;
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        CountPrimeSetBits c = new CountPrimeSetBits();
        System.out.println(c.countPrimeSetBits(4, 10));
    }
}
