package Published.Bitwise;
//Not in TH
/**
 * Created by sumi1 on 7/11/2017.
 */
public class DivideByPowerOf2 {
//http://www.codingalpha.com/divide-two-numbers-without-arithmetic-operator-c-program/
//code this one as well
    public static void divide(int n, int k){
        System.out.print("Number " + n + " divided by 2^" + k +" is: ");
        System.out.println(n>>k);
    }
    public static void main(String[] args) {
        int n = 48;
        int k = 2;
        divide(n,k);
    }
}
