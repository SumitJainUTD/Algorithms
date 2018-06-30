package ThirdLot.MISC.BitManipulation;

/**
 * Created by sumi1 on 6/25/2018.
 */
public class SwapNumbers {

    static void swap(int x, int y){

        System.out.println("x: " + x + ", y: " + y);

        //x : 4 => 0100
        //y: 8 => 1000

        x = x ^ y;

        //x:1100, y: 1000

        y = x ^ y;

        //x:1100, y:0100

        x = x ^ y;

        //x:1000, y:0100

        System.out.println("After swapping");
        System.out.println("x: " + x + ", y: " + y);
    }

    public static void main(String[] args) {
        int x = 4;
        int y= 8;
        swap(x,y);
    }
}
