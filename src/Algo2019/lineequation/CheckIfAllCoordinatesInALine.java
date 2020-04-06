package Algo2019.lineequation;

import java.util.ArrayList;

public class CheckIfAllCoordinatesInALine {
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

    public static void isStraightLine(ArrayList<Coordinate> coordinates){
        System.out.println("Given Coordinates: " + coordinates);
        if(coordinates.size()<=2) {
            System.out.println("Given coordinates are in a straight line");
            return;
        }
        Coordinate c1  = coordinates.get(0);
        Coordinate c2 = coordinates.get(1);
        //  create a line equation
        //  slope = (y2-y1)/(x2-x1)
        int slope = (c2.y-c1.y)/(c2.x-c1.x);

//        y = mx + b, b = y - mx, m = slope
        int b = c1.y - slope*c1.x;
        //now check all the other coordinates if these are in this line
        for (int i = 2; i <coordinates.size() ; i++) {
            Coordinate c = coordinates.get(i);
            int b1 = c.y - slope*c.x;
            if(b1!=b){
                System.out.println("Given coordinates are NOT in a straight line");
                return;
            }
        }
        //if here means all coordinates in a line
        System.out.println("Given coordinates are in a straight line");
    }

    public static void main(String[] args) {
        ArrayList<Coordinate> coordinates = new ArrayList<>();
        coordinates.add(new Coordinate(1,1));
        coordinates.add(new Coordinate(2,2));
        coordinates.add(new Coordinate(3,3));
        coordinates.add(new Coordinate(4,4));
        isStraightLine(coordinates);
        System.out.println("---------------------------");
        coordinates.add(new Coordinate(8,9));
        isStraightLine(coordinates);

    }
}