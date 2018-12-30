package Published.Arrays.TwoRepeatedElements;

/**
 * Created by sumi1 on 7/22/2017.
 */
public class TwoRepeatingXOR {
    public static void twoRepeating(int [] A, int n){
        int XOR = A[0];
        int right_most_bit, X=0, Y=0, size = A.length;

        for (int i = 1; i <=n ; i++)
            XOR ^= i;

        for (int i = 0; i <size ; i++)
            XOR ^= A[i];

        //Now XOR contains the X XOR Y

        //get the right most bit number
        right_most_bit = XOR & ~(XOR-1);

        //divide the elements into 2 groups based on the right most set bit

        for (int i = 0; i <size ; i++) {
            if((A[i] & right_most_bit)!=0)
                X = X^A[i];
            else
                Y = Y^A[i];
        }

        for (int i = 1; i <=n ; i++) {
            if((i&right_most_bit)!=0)
                X = X^i;
            else
                Y = Y^i;
        }
        System.out.println("Two Repeated elements are: " + X + " and " + Y);
    }

    public static void main(String[] args) {
        int [] A = {1,4,5,6,3,2,5,2};
        int n = 6;
        twoRepeating(A, n);
    }
}
