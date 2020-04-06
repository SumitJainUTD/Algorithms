package Algo2019.Jobs.Interval;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class MergeIntervals {

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

    public static void merge(Interval[] intervals){

        System.out.println("Given Intervals: " +  Arrays.toString(intervals));

        Stack<Interval> stack = new Stack<>();

//        Sort the Interval[] as per ascending order of the start time

        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start-o2.start;
            }
        });

//        add first interval to stack
        stack.push(intervals[0]);

//        now iterate through rest of the intervals
        for (int i = 1; i <intervals.length ; i++) {
            Interval current = intervals[i];

//            check if this interval can be merged with top interval in the stack
            Interval previous = stack.peek();
//            if end of previous >= start of current
            if(previous.end>=current.start){
//                merge them
                previous.end = current.end;
                stack.pop();
                stack.push(previous);
            }else{
//                cannot be merged, push new interval to stack
                stack.push(current);
            }
        }

        // Print all merged intervals
        System.out.print("Merged Intervals: ");
        while (!stack.isEmpty()) {
            Interval interval = stack.pop();
            System.out.print("["+interval.start+","+interval.end+"] ");
        }
    }

    public static void main(String[] args) {
        Interval interval_1 = new Interval(2, 5);
        Interval interval_2 = new Interval(5, 7);
        Interval interval_3 = new Interval(1, 4);
        Interval interval_4 = new Interval(3, 6);
        Interval interval_5 = new Interval(8, 10);
        Interval interval_6 = new Interval(9, 11);

        Interval [] intervals = {interval_1, interval_2, interval_3, interval_4, interval_5, interval_6};
        merge(intervals);
    }
}
