package ThirdLot.MISC.PowerOf2;

/**
 * Created by sumi1 on 6/4/2018.
 */
public class PowerOf2LogMethod {

    public static void checkNumber(int n){
        double x = Math.ceil(Math.log(n)/Math.log(2));
        double y = Math.floor(Math.log(n)/Math.log(2));
        if(x==y)
            System.out.println("Given number " + n + " is power of 2");
        else
            System.out.println("Given number " + n + " is not power of 2");
    }

    public static void main(String[] args) {
        int n = 6;
        checkNumber(n);
        n = 8;
        checkNumber(n);
        n = 24;
        checkNumber(n);
        n=512;
        checkNumber(n);
    }
}
