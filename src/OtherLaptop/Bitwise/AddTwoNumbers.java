package OtherLaptop.Bitwise;

/**
 * Created by sjain on 8/14/17.
 */
public class AddTwoNumbers {

    public static int AddNumbers(int x, int y) {
        // while carry !=0
        while (y != 0) {

            // calculate the carry, carry will have the common set bits of x and y
            int carry = x & y;

            // Sum of bits of x and y where at least one of the bits is not set
            x = x ^ y;

            // Carry is shifted by one so that adding it to x gives the required sum
            y = carry << 1;
        }
        return x;
    }

    public static void main(String[] args) {
        int x = 3;
        int y = 2;
        System.out.println(AddNumbers(x,y));
    }
}
