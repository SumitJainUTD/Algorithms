package Algo2019.lineequation;

public class CreateLineEquation {

    static class Coordinate{
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public String toString() {
            return "["+this.x+","+this.y+"]" ;
        }
    }

    public static void createEquation(Coordinate c1, Coordinate c2){

        System.out.println("Given coordinates: " + c1 + " and " + c2);

//        slope = (y2-y1)/(x2-x1)
        int slope = (c2.y-c1.y)/(c2.x-c1.x);

//        y = mx + b, b = y - mx, m = slope
        int b = c1.y - slope*c1.x;

        System.out.format("Line Equation: y = %+dx %+d", slope,b);
    }

    public static void main(String[] args) {
        Coordinate c1 = new Coordinate(2,2);
        Coordinate c2 = new Coordinate(4,12);
        createEquation(c1, c2);
    }
}
