package Published.Maths;

/**
 * Created by sumi1 on 6/2/2018.
 */
public class AreaOfRectangle {

    public static void area(double a, double b){
        double area = a * b;
        System.out.println("Area of Rectangle: " + area);
    }

    public static void perimeter(double a, double b){
        double perimeter = 2*(a + b);
        System.out.println("Perimeter of Rectangle: " + perimeter);
    }

    public static void main(String[] args) {
        double a = 3;
        double b = 4;
        area(a, b);
        perimeter(a, b);
    }
}
