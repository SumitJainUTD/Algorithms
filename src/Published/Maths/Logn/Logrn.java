package Published.Maths.Logn;

/**
 * Created by sumi1 on 6/6/2018.
 */
public class Logrn {

    static void computeLogNBaseR(int n, int r){
        int result = 0;
        int number = n;
        while(n>0){
            n=n/r;
            if(n>=1)
                result++;
        }
        System.out.println("Log"+number + " with base " + r + " value: " +  result);
    }

    public static void main(String[] args) {
        int n = 64;
        int r = 4;
        computeLogNBaseR(n, r);
    }
}
