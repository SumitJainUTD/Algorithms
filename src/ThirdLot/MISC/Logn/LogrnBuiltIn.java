package ThirdLot.MISC.Logn;

/**
 * Created by sumi1 on 6/6/2018.
 */
public class LogrnBuiltIn {
    static void computeLogNBaseR(int n, int r){
        double result = Math.log(n)/Math.log(r);
        System.out.println("Log"+n + " with base " + r + " value: " +  result);
    }

    public static void main(String[] args) {
        int n = 64;
        int r = 4;
        computeLogNBaseR(n, r);
    }
}