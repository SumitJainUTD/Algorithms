package SecondLot.Bitwise;

/**
 * Created by sjain on 8/16/17.
 */
public class CountSetBitsInInteger {

    public int calculate(int x){
        int count =0;
        while (x>0){
            count += x & 1;
            x >>= 1;
        }
        return count;
    }

//    Brian Kernighan’s Algorithm
    public int bkAlgorithm(int x){
        //subtract 1 from the number
        //this will turn off the right most bit of the number, keep track of the count
        int count  = 0;
        while(x>0){
            x = x & (x-1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        CountSetBitsInInteger c = new CountSetBitsInInteger();
        int x = 10;
        System.out.println("Number of set bits in : " + x + " are: " + c.calculate(x));
        System.out.println("(Brian Kernighan’s Algorithm) Number of set bits in : " + x + " are: " + c.bkAlgorithm(x));
    }
}
