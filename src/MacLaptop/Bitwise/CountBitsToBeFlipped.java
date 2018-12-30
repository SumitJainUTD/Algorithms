package MacLaptop.Bitwise;

/**
 * Created by sjain on 8/16/17.
 */
public class CountBitsToBeFlipped {

    public int calculate(int x, int y){
        //xor of  2 numbers, the bit will be in the result if that bit is set in either x or y
        //so by doing xor we will get all the bits which needs to be flipped to convert x to y
        int z = x ^ y;
        int count =0;
        while (z>0){
            count += z & 1;
            z >>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        CountBitsToBeFlipped c = new CountBitsToBeFlipped();
        int x = 10;
        int y = 20;
        System.out.println("Number of bit needs to be flipped to convert " + x + " to " + y + " are: " + c.calculate(x,y));
    }
}
