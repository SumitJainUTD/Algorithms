package Published.Bitwise;

import java.util.Arrays;

/**
 * Created by sjain on 8/30/17.
 */
public class nBits {

    int [] arr;

    public nBits(int n){
        arr = new int [n];
    }

    public void print(int n){
        if(n<=0){
            System.out.println(Arrays.toString(arr));
        }else{
            arr[n-1] = 0;
            print(n-1);
            arr[n-1]=1;
            print(n-1);
        }
    }

    public static void main(String[] args) {
        nBits nBits = new nBits(3);
        nBits.print(3);
    }
}
