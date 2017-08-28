package NotInTH.MISC;
//Not in TH
/**
 * Created by sumi1 on 7/13/2017.
 */
public class SwapNumbers {

    public static void swap(int a, int b){
        System.out.println("first number: " + a + " second number: " + b);
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("After Swappng: first number: " + a + " second number: " + b);
    }

    public static void main(String[] args) {
        int a = 3;
        int b = 5;
        swap(a,b);
    }
}
