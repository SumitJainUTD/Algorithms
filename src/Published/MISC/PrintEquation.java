package Published.MISC;

/**
 * Created by sumi1 on 6/23/2018.
 */
public class PrintEquation {

    static void printEquation(int a, int b, int c){
        System.out.println("Wrong Equation: "+ a + "x + " +b+ "y + " + c );
        System.out.format("Correct Equation: %+dx %+dy %+d = 0", a, b, c );
    }

    public static void main(String[] args) {
        int a = 2;
        int b = -3;
        int c = -6;
        printEquation(a,b,c);

    }
}
