package ThirdLot.MISC;

/**
 * Created by sumi1 on 6/3/2018.
 */
public class CountAllSetBits {

    public static void countSetBits(int number){
        int count = 0;
        int x = number;
        while(number>0){
            //check the last bit of number
            //if last bit is 1, increment the count
            count = count + (number & 1);
            //right shift the number
            number >>= 1;
        }

        System.out.println("Number of set bits in integer " + x + " is :" + count );
    }

    public static void main(String[] args) {
        int number = 23;
        countSetBits(number);
        number = 16;
        countSetBits(number);
        number = 15;
        countSetBits(number);
    }
}
