package Algo2019.Jobs.Interval.CheckIfTwoIntervalsOverlaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CheckIfAnyTwoIntervalsOverlapsSorting {

    static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "["+this.start+","+this.end+"]" ;
        }
    }

    public static void findIntervalOverlaps(ArrayList<Interval> intervals){

        System.out.println("Given Interval: " + Arrays.toString(intervals.toArray()));
        boolean isIntersect = false;
        Collections.sort(intervals, (o1, o2) -> o1.start-o2.start);
        //lets consider first interval as common interval
        Interval prevInterval = intervals.get(0);
        for (int i = 1; i <intervals.size() ; i++) {
            Interval current = intervals.get(i);

            if(current.start<prevInterval.end){
                //found the interval which intersects
                isIntersect = true;
                break;
            }
        }
        if(isIntersect)
            System.out.println("Intervals are overlapping");
        else
            System.out.println("No intervals overlap");

        System.out.println("-------------------------------------------");
    }

    public static void main(String[] args) {
        ArrayList<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1,5));
        intervals.add(new Interval(6,10));
        intervals.add(new Interval(12,15));
        findIntervalOverlaps(intervals);
        intervals.add(new Interval(3,7));
        findIntervalOverlaps(intervals);
    }
}
