package Algo2019.Jobs.Interval;

import java.util.ArrayList;
import java.util.Arrays;

public class CommonInterval {
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

    public static void findCommonInterval(ArrayList<Interval> intervals){

        System.out.println("Given Interval: " + Arrays.toString(intervals.toArray()));
        //lets consider first interval as common interval
        Interval commonInterval = intervals.get(0);
        for (int i = 1; i <intervals.size() ; i++) {
            Interval current = intervals.get(i);

            if(current.start>commonInterval.end){
                //no common interval
                System.out.println("No Common Interval");
                return;
            }
            //update the common interval
            commonInterval.start = Math.max(commonInterval.start, current.start);
            commonInterval.end = Math.min(commonInterval.end, current.end);
        }
        System.out.println("Common Interval: " +  commonInterval.toString());
    }

    public static void main(String[] args) {
        ArrayList<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(3,7));
        intervals.add(new Interval(1,5));
        intervals.add(new Interval(2,6));

        findCommonInterval(intervals);
    }
}
