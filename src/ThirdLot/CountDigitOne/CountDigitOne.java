package ThirdLot.CountDigitOne;

/**
 * Created by sjain on 9/11/17.
 */
public class CountDigitOne {

    public int count(int n){
        int countOnes = 0;
        for (int i = 1; i <=n ; i++) {
            int x = i;
            while(x>0){
                if(x%10==1)
                    countOnes++;
                x = x/10;
            }
        }
        return countOnes;
    }

    public int countSmart(int n){
        int ones = 0;
        for (long m = 1; m <= n; m *= 10)
            ones += (n/m + 8) / 10 * m + (n/m % 10 == 1 ? n%m + 1 : 0);
        return ones;
    }

    public int countDigits(int n) {
        int count = 0;

        for (long k = 1; k <= n; k *= 10) {
            long r = n / k, m = n % k;
            // sum up the count of ones on every place k
            count += (r + 8) / 10 * k + (r % 10 == 1 ? m + 1 : 0);
        }

        return count;
    }

    public static void main(String[] args) {
        CountDigitOne c = new CountDigitOne();
        int n = 1234;
        System.out.println(c.count(n));
        System.out.println(c.countSmart(n));
        System.out.println(c.countDigits(n));
    }
}
