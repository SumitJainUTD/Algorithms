package ThirdLot.MISC.PowerOf2;

/**
 * Created by sumi1 on 6/4/2018.
 */
public class PowerOf2RemainderMethod {

    public static void checkNumber(int n){
        boolean isPowOfTwo = true;
        int num = n;
        while(n>1){
            if(n%2!=0)
                isPowOfTwo = false;
            n=n/2;
        }
        if(isPowOfTwo)
            System.out.println("Given number " + num + " is power of 2");
        else
            System.out.println("Given number " + num + " is not power of 2");
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