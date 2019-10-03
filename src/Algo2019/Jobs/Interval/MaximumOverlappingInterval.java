package Algo2019.Jobs.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MaximumOverlappingInterval {
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
        int maxTime = -1;
        for (int i = 0; i <intervals.size() ; i++) {
            allTimesList.add(new Time(intervals.get(i).start, "start"));
            allTimesList.add(new Time(intervals.get(i).end, "end"));
            maxTime = Math.max(maxTime, intervals.get(i).end);
        }

        Collections.sort(allTimesList, new Comparator<Time>() {
            @Override
            public int compare(Time o1, Time o2) {
                return o1.time-o2.time;
            }
        });

        int counter = 0;
        int [] maxCounts = new int[maxTime];
        for (int i = 0; i <maxTime ; i++) {

            while (allTimesList.get(0).time==i){
                Time time = allTimesList.remove(0);
                if(time.type.equals("start"))
                    counter++;
                else
                    counter--;
            }
            maxCounts[i] = counter;
        }
//        System.out.println(Arrays.toString(maxCounts));
        int maxOverlap = 0;
        for (int i = 0; i <maxCounts.length ; i++) {
            if(maxOverlap<maxCounts[i]) {
                maxOverlap = maxCounts[i];
            }
        }

        System.out.println("Maximum overlaps: " +  maxOverlap);
        System.out.print("Maximum Interval: ");
        for (int i = 0; i <maxCounts.length ; i++) {
            if(maxCounts[i]==maxOverlap){
                int maxIntervalStart= i;
                while(i+1<maxCounts.length && maxCounts[i]==maxCounts[i+1]){
                    i++;
                }
                int maxIntervalEnd= ++i; // for covering the end when counter reduces by 1.
                Interval maxInterval = new Interval(maxIntervalStart, maxIntervalEnd);

                System.out.print(maxInterval.toString());
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(0,2));
        intervals.add(new Interval(3,8));
        intervals.add(new Interval(1,6));
        intervals.add(new Interval(8,9));
        intervals.add(new Interval(4,7));

        intervals.add(new Interval(10,12));
        intervals.add(new Interval(13,17));
        intervals.add(new Interval(11,15));
        intervals.add(new Interval(17,18));
        intervals.add(new Interval(14,16));

        maxOverlapIntervalCount(intervals);
    }
}
