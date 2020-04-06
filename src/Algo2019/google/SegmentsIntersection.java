package Algo2019.google;

import java.util.Arrays;

public class SegmentsIntersection {

    static class Segment{
        int startIndex;
        int endIndex;

        public Segment(int startIndex, int endIndex) {
            this.startIndex = startIndex;
            this.endIndex = endIndex;
        }
        @Override
        public String toString() {
            return "[" + this.startIndex + "," + this.endIndex + "]";
        }
    }

    public static void findIntersection(int [] input, Segment s1, Segment s2){

        System.out.println("Given array " + Arrays.toString(input));
        System.out.println("Given Segments: " + s1.toString() + " and " + s2.toString());

        if((s1.startIndex<=s2.startIndex && s2.startIndex<=s1.endIndex)
            || (s1.startIndex<=s2.startIndex && s2.startIndex<=s1.endIndex)){
            int n = Math.min(s1.endIndex, s2.endIndex)-Math.max(s1.startIndex, s2.startIndex)+1;
            System.out.println("Intersections between the given segments: " + n);
        }else{
            System.out.println("No Intersection between the given segments");
        }
        System.out.println("----------------------------------------------------------\n");
    }

    public static void main(String[] args) {
        int [] input = {2, 6, 4, 1, 9, 10, 5, 2, 8};

        Segment s1 = new Segment(1, 5);
        Segment s2 = new Segment(3, 8);
        findIntersection(input, s1, s2);

        s1 = new Segment(1, 3);
        s2 = new Segment(4, 8);
        findIntersection(input, s1, s2);
    }
}
