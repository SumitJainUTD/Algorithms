package Published.Maths.PowerOf2;

/**
 * Created by sumi1 on 6/5/2018.
 */
public class PowerOfTwoBitMethod {

    public static void checkNumber(int n){
        int countBits = countSetBits(n);
        if(countBits == 1)
            System.out.println("Given number " + n + " is power of 2");
        else
            System.out.println("Given number " + n + " is not power of 2");
    }

    public static int countSetBits(int number){
        int count = 0;
        int x = number;
        while(number>0){
            //check the last bit of number
            //if last bit is 1, increment the count
            count = count + (number & 1);
            //right shift the number
            number >>= 1;
        }
        return count;
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
