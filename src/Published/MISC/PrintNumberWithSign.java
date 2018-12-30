package Published.MISC;

/**
 * Created by sumi1 on 12/24/2018.
 */
public class PrintNumberWithSign {
    static void printNumber(int a, int b){
        System.out.println("Wrong way: "+ a + " " + b);
        System.out.format("Correct Way: %+d %+d", a, b);
    }

    public static void main(String[] args) {
        int a = 5;
        int b = -8;
        printNumber(a,b);

    }
}
