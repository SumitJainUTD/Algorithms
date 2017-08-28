package NotInTH.MISC;
//Not in TH
/**
 * Created by sumi1 on 7/13/2017.
 */
public class FindRemainder {

    public static void remainder(int n, int divisor){
        if(divisor==0){
            System.out.println("Cannot divide by 0");
            return;
        }
        //if either number or divisor is negative
        if(n<0)
            n *=-1;
        if(divisor<0)
            divisor *= -1;
        int number = n;
        //subtract divisor from n till n>=divisor
        while(n>=divisor){
            n -= divisor;
        }
        System.out.println("Number: " + number + " , divisor: " + divisor + ". remainder: " + n);
    }

    public static void main(String[] args) {
        int n = 10;
        int divisor = 4;
        remainder(n, divisor);
    }
}
