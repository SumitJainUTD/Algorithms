package MacLaptop.October2018;

/**
 * Created by sjain on 10/21/18.
 */
public class MostSignificantBits {
    static int setBitNumber(int n) {
        if (n == 0)
            return 0;

        int msb = 0;
        while (n>1)
        {
            n = n / 2;
            msb++;
        }

        return (1 << msb);
    }

    static int setBitNumberLog(int n) {

        // To find the position of the
        // most significant set bit
        int k = (int)(Math.log(n) / Math.log(2));

        // To return the the value of the number
        // with set bit at k-th position
        return (int)(Math.pow(2, k));
    }

    // Driver code
    public static void main (String[] args) {
        int n = 172;
        System.out.println(setBitNumber(n));
        System.out.println(setBitNumberLog(n));
    }
}
