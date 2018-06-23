package ThirdLot.MISC;

/**
 * Created by sumi1 on 6/2/2018.
 */
public class AreaOfTriangle {

    public static void area(double a, double b, double c){
        //get the semi parameter
        double s = (a + b + c)/2;
        //find the area of triangle
        double area = Math.sqrt(s*(s-a)*(s-b)*(s-c));

        System.out.println("Area of triangle : " + area + " sq unit");
    }

    public static void main(String[] args) {
        double a = 3.5;
        double b = 4.5;
        double c = 6.0;
        area(a,b,c);
    }
}
