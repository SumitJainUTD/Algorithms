package Published.Maths.Circle;

/**
 * Created by sumi1 on 6/2/2018.
 */
public class AreaOfTriangleBaseHeight {

    public static void area(double base, double height){

        double area = (base*height)/2;
        System.out.println("Area of Triangle is: " + area);
    }

    public static void main(String[] args) {
        double base = 4;
        double height = 5;
        area(base, height);
    }
}
