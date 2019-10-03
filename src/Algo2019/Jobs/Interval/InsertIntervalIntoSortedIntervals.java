package Algo2019.Jobs.Interval;

import java.util.ArrayList;
import java.util.List;

public class InsertIntervalIntoSortedIntervals {

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

    public static void insertInterval(List<Interval> intervals, Interval newInterval){

        System.out.println("Given list of Intervals: " +  intervals.toString());
        System.out.println("New Interval: " +  newInterval.toString());

        List<Interval> result = new ArrayList<>();

        for (int i = 0; i <intervals.size() ; i++) {
            Interval currentInterval = intervals.get(i);
            if(currentInterval.end<newInterval.start){
                //means new interval starts after current interval
                result.add(currentInterval);
            } else if(currentInterval.start>newInterval.end){
                //means current interval starts after the new interval ends
                //add new interval to result
                // and current interval will become the interval which becomes new interval (needs insert)
                result.add(newInterval);
                newInterval = currentInterval;
            } else{
                //here means overlapping found, merge them
                int start = Math.min(newInterval.start, currentInterval.start);
                int end = Math.max(newInterval.end, currentInterval.end);
                newInterval = new Interval(start, end);
            }
        }

        //add the remaining interval
        result.add(newInterval);

        System.out.println("New Sorted List: " +  result.toString());
    }

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1,4));
        intervals.add(new Interval(5,8));

        Interval newInterval = new Interval(3,6);

        insertInterval(intervals, newInterval);
    }
}
