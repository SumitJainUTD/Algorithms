package MISC.KPowerN;

/**
 * Created by sumi1 on 8/20/2017.
 */
public class KpowerN_OnlyPositive {
    public static double kPowerN(int k, int n){
        if(n==0)
            return 1;
        double halfResult = kPowerN(k, n/2);
        if(n%2==0){
            return halfResult*halfResult;
        }else{ //n is odd
            return halfResult*halfResult*k;
        }
    }

    public static void main(String[] args) {
        int k = 4;
        int n = 5;
        System.out.println(k + " power " + n + " :  Result: " + kPowerN(k,n));
    }
}
