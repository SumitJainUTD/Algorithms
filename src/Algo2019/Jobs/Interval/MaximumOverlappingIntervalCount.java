package Algo2019.Jobs.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MaximumOverlappingIntervalCount {

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
    static class Time{
        int time;
        String type;

        public Time(int time, String type) {
            this.time = time;
            this.type = type;
        }
    }

    public static void maxOverlapIntervalCount(ArrayList<Interval> intervals){

        System.out.println("Given Intervals: " + intervals.toString());

        ArrayList<Time> allTimesList = new ArrayList<>();

        for (int i = 0; i <intervals.size() ; i++) {
            allTimesList.add(new Time(intervals.get(i).start, "start"));
            allTimesList.add(new Time(intervals.get(i).end, "end"));
        }

        Collections.sort(allTimesList, new Comparator<Time>() {
            @Override
            public int compare(Time o1, Time o2) {
                return o1.time-o2.time;
            }
        });

        int maxOverlap = 0;
        int count = 0;
        for (int i = 0; i <allTimesList.size() ; i++) {
            Time time = allTimesList.get(i);
            if(time.type.equals("start"))
                count++;
            else
                count--;
            if(count>maxOverlap)
                maxOverlap=count;
        }

        System.out.println("Maximum overlapping: " + maxOverlap);
    }

    public static void main(String[] args) {
        ArrayList<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(0,2));
        intervals.add(new Interval(3,7));
        intervals.add(new Interval(1,5));
        intervals.add(new Interval(7,8));
        intervals.add(new Interval(4,6));

       maxOverlapIntervalCount(intervals);
    }
}
