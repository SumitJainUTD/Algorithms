package Published.Maths;

/**
 * Created by sumi1 on 6/23/2018.
 */
public class QuadraticEquation {

    static void findRoots(int a, int b, int c){

        //first find Discriminant d = b*b - 4ac
        int d = b*b - 4*a*c;

        double root_1 = (-b + Math.sqrt(d))/(2*a);
        double root_2 = (-b - Math.sqrt(d))/(2*a);

        System.out.format("Quadratic Equation: %+dx^2 %+dx %+d = 0", a, b, c );
        System.out.println(", Roots are: (" + root_1 + ", " + root_2);
    }

    public static void main(String[] args) {
        int a = 3;
        int b = -5;
        int c = -8;
        findRoots(a, b, c);
    }
}
