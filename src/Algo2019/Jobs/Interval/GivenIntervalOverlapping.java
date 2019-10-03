package Algo2019.Jobs.Interval;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class GivenIntervalOverlapping {

    static class Coordinate {
        int x1;
        int x2;
        public Coordinate(int x1, int x2) {
            this.x1 = x1;
            this.x2 = x2;
        }
        @Override
        public String toString() {
            return "["+this.x1+","+this.x2+"]" ;
        }
    }

    public static boolean checkIfIntervalIsOverlapping(Coordinate [] coordinates, Coordinate interval){

        System.out.println("Given Coordinates: " +  Arrays.toString(coordinates));
        System.out.println("Given Interval: " +  interval.toString());

        Stack<Coordinate> stack = new Stack<>();

//        Sort the Interval[] as per ascending order of the start time

        Arrays.sort(coordinates, new Comparator<Coordinate>() {
            @Override
            public int compare(Coordinate o1, Coordinate o2) {
                return o1.x1-o2.x1;
            }
        });

//        add first interval to stack
        stack.push(coordinates[0]);

//        now iterate through rest of the intervals
        for (int i = 1; i <coordinates.length ; i++) {
            Coordinate current = coordinates[i];

//            check if this interval can be merged with top interval in the stack
            Coordinate previous = stack.peek();
//            if end of previous >= start of current
            if(previous.x2>=current.x1){
//                merge them
                previous.x2 = current.x2;
                stack.pop();
                stack.push(previous);
            }else{
//                cannot be merged, push new interval to stack
                stack.push(current);
            }
        }

        //check if given coordinate is overlapping
        boolean result  = false;
        while (!stack.isEmpty()) {
            Coordinate coordinate = stack.pop();
            if(coordinate.x1<=interval.x1 && coordinate.x2>=interval.x2){
                System.out.println("Given interval is COVERED in coordinates");
                return true;
            }
        }
        System.out.println("Given interval is NOT COVERED in coordinates");
        return false;
    }

    public static void main(String[] args) {
        Coordinate coordinate_1 = new Coordinate(2, 5);
        Coordinate coordinate_2 = new Coordinate(5, 7);
        Coordinate coordinate_3 = new Coordinate(1, 4);

        Coordinate [] coordinates = {coordinate_1, coordinate_2, coordinate_3};
        Coordinate interval = new Coordinate(1, 6);
        checkIfIntervalIsOverlapping(coordinates, interval);
        System.out.println("-------------------------------------------------------");
        Coordinate interval_one = new Coordinate(1, 8);
        checkIfIntervalIsOverlapping(coordinates, interval_one);
    }
}
