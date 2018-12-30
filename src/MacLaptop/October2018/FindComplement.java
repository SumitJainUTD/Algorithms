package MacLaptop.October2018;

/**
 * Created by sjain on 10/21/18.
 */
public class FindComplement {
    public static int findComplement(int num) {
        int msb = getMostSignificantBit(num);
        int temp = 1;
        for (int i = 0; i <msb ; i++) {
            temp = temp<<1;
            temp = temp | 1;
        }

        // NOw take XOR temp with num -- to get the compliment
        return num^temp;
    }

    static int getMostSignificantBit(int n) {
        // To find the position of the
        // most significant set bit
        int k = (int)(Math.log(n) / Math.log(2));
        return k;
    }

    public static void main(String[] args) {
        System.out.println(findComplement(8));
    }
}
