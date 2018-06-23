package ThirdLot.MISC;

/**
 * Created by sumi1 on 6/2/2018.
 */
public class CheckTriangle {

    public static void checkTriangleFormed(double a, double b, double c){

        //check all combinations,
        //sum of any 2 sides must be greater than the third side to form a triangle
        if(check(a, b, c) && check(a, c, b) && check(b, c, a))
            System.out.println("Triangle can be formed using side " + a + ", " + b + ", " +c );
        else
            System.out.println("Triangle cannot be formed using side " + a + ", " + b + ", " +c );
    }

    public static boolean check(double x, double y, double z){
        //check if sum of x and y is greater than z
        if((x+y)>z)
            return true;

        System.out.println("Sum of " + x + " and "+ y + " is not > " + z);
        return false;
    }

    public static void main(String[] args) {
        double a = 2.5;
        double b = 3.5;
        double c = 5;
        checkTriangleFormed(a, b, c);
        System.out.println("________________________");
         a = 1;
         b = 3;
         c = 5;
        checkTriangleFormed(a, b, c);
    }
}
