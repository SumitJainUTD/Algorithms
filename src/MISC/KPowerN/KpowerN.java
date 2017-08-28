package MISC.KPowerN;

/**
 * Created by sumi1 on 7/28/2017.
 */
public class KpowerN {
    public static double kPowerN(int k, int n){
        if(n==0)
            return 1;
        double halfResult = kPowerN(k, n/2);
         if(n%2==0){
            return halfResult*halfResult;
        }else if(n>0){ //n is odd
             return halfResult*halfResult*k;
         }else // n<0
            return halfResult*halfResult/k;
    }

    public static void main(String[] args) {
        int k = 4;
        int n = -2;
        System.out.println(k + " power " + n + " :  Result: " + kPowerN(k,n));
    }
}
