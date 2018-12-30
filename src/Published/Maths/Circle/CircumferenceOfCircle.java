package Published.Maths.Circle;

/**
 * Created by sumi1 on 6/2/2018.
 */
public class CircumferenceOfCircle {
    public static void circumference(double radius){
        double pi = 3.14;
        double circumference = 2*pi*radius;
        System.out.println("Area of circumference with radius="+radius + " is: " + circumference);
    }

    public static void main(String[] args) {
        double radius = 4;
        circumference(radius);
    }
}
