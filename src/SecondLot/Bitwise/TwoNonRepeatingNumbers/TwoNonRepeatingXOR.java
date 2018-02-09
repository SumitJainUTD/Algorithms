package SecondLot.Bitwise.TwoNonRepeatingNumbers;

/**
 * Created by sjain on 8/16/17.
 */
public class TwoNonRepeatingXOR {

    public void find(int [] arrA){
        //xor will the xor of two non repeating elements
        //we know that in a XOR b, any particular bit is set if that bit is set in either a or b
        //we can use this to divide the array elements into two groups where each group will be responsible
        // to get a and b
        int xor = arrA[0];
        for (int i = 1; i <arrA.length ; i++) {
            xor ^= arrA[i];
        }
        //get the right most set bit
        int right_most_set_bit = xor & ~ (xor -1);

        //divide the array elements into 2 groups
        int a=0,b=0;
        for (int i = 0; i <arrA.length ; i++) {
            int x = arrA[i];
            if((x & right_most_set_bit)!=0)
                a ^= x;
            else
                b ^= x;
        }
        System.out.println("Non Repeating Elements are: " + a + " and " + b);
    }
    public static void main(String[] args) {
        TwoNonRepeatingXOR t = new TwoNonRepeatingXOR();
        int [] arrA = {4,5,4,5,3,2,9,3,9,8};
        t.find(arrA);

    }
}
