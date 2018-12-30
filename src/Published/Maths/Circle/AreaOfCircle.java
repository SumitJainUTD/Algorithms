package Published.Maths.Circle;

/**
 * Created by sumi1 on 6/2/2018.
 */
public class AreaOfCircle {

    public static void area(double radius){
        double pi = 3.14;
        double area = pi*radius*radius;
        System.out.println("Area of circle with radius="+radius + " is: " + area);
    }

    public static void main(String[] args) {
        double radius = 4;
        area(radius);
    }
}
