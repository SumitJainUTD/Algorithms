package Algo2019.Jobs.Interval.CheckIfTwoIntervalsOverlaps;

import java.util.ArrayList;
import java.util.Arrays;

public class CheckIfAnyTwoIntervalsOverlapsUsingCount {

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

        //find the last end time
        int lastTime = -1;
        for (int i = 1; i <intervals.size() ; i++) {
            if(lastTime<intervals.get(i).end)
                lastTime = intervals.get(i).end;
        }

        int [] count = new int[lastTime+2];
        boolean isIntersect = false;
        for (int i = 0; i <intervals.size() ; i++) {
            Interval current = intervals.get(i);
            //mark the count +1 for start time and -1 for end time
            count[current.start]++;
            count[current.end+1]--;
        }

        //now iterate the count array and keep adding values and
        // if at any index sum is > 1 that means another interval started before the previous one ended
        //means intervals are overlapping
        int sum = 0;
        for (int i = 0; i <count.length ; i++) {
            sum += count[i];
            if(sum>1){
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
        intervals.add(new Interval(2,3));
        findIntervalOverlaps(intervals);
    }
}
