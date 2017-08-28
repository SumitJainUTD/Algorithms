package MISC.KPowerN;

/**
 * Created by sumi1 on 7/28/2017.
 */
public class KPowerN_Naive {

    public static double kPowerN(int k, int n){
        double result = 1;
        for (int i = 0; i <n ; i++) {
            result *= k;
        }
        return result;
    }

    public static void main(String[] args) {
        int k = 4;
        int n = 5;
        System.out.println(k + " power " + n + " :  Result: " + kPowerN(k,n));
    }
}
