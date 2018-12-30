package MacLaptop.October2018;

/**
 * Created by sjain on 10/18/18.
 */
public class ReverseBits {
    public static int reverseBits(int n) {
        int result = 0;
        while(n>0){
            result=result<<1;
            int x = n&1;
            result = result|x;
            n=n>>1;

        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(reverseBits(6));
    }
}
