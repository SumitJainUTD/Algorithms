package Bitwise;

/**
 * Created by sumi1 on 7/28/2017.
 */
public class RightMostUnsetBit {

    public static double getRightMostUnsetBit(int n){
        if(n==1)
            return -1;
        return Math.log(~n & (n+1))/Math.log(2);
    }

    public static void main(String[] args) {
        int n = 11;
        System.out.println("Right most Unset bit :" + getRightMostUnsetBit(n));
    }
}
