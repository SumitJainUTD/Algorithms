package Algo2019.Jobs.Interval;

import java.util.ArrayList;
import java.util.Arrays;

public class ValueLiesInIntervals {
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

    public static void countIntervalsWithValue(ArrayList<Interval> intervals, int value){

        System.out.println("Given Interval: " + Arrays.toString(intervals.toArray()));

        int count = 0;
        for (int i = 0; i <intervals.size() ; i++) {
            Interval current = intervals.get(i);
            if(current.start<=value && current.end>=value)
                count++;
        }
        System.out.println("Value : " + value +  " lies in Intervals: " + count);
        System.out.println("-------------------------------------------");
    }

    public static void main(String[] args) {
        ArrayList<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1,7));
        intervals.add(new Interval(3,10));
        intervals.add(new Interval(12,15));
        int value = 6;
        countIntervalsWithValue(intervals, value);
    }
}
