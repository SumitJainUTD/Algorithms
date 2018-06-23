package ThirdLot.Graph.MISC;

/**
 * Created by sumi1 on 6/18/2018.
 */
public class LeftRightShift {

    static void LeftShift(int n){
        int x = n<<1;
        System.out.println("n<<1, Left shift by 1 of n: "+ n + " is : " + x);
    }

    static void RightShift(int n){
        int x = n>>1;
        System.out.println("n>>1, Right shift by 1 of n: "+ n + " is : " + x);
    }

    public static void main(String[] args) {
        int n = 10;
        LeftShift(n);
        RightShift(n);
        n = 62;
        LeftShift(n);
        RightShift(n);
    }
}
