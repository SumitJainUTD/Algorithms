package Bitwise;
//Not in TH
/**
 * Created by sumi1 on 7/11/2017.
 */
public class RightMostSetBit {
    public static void findRightMostSetBit(int n){
         double position =  1 + Math.log(n & ~(n-1))/Math.log(2);
        System.out.println("Right most set bit for " + n + " is : " + Integer.toBinaryString(n & ~(n-1)));
        System.out.println("Position: " + position);
    }

    public static void main(String[] args) {
        int n = 1;
        findRightMostSetBit(n);
    }
}
