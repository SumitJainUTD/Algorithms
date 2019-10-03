package Algo2019.Jobs.Interval.MaxCPULoad;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MaximumCPULoad {

    static class Job{
        int startTime;
        int endTime;
        int load;

        public Job(int startTime, int endTime, int load) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.load = load;
        }

        @Override
        public String toString() {
            return "["+this.startTime+", "+this.endTime+", "+ load +"]" ;
        }
    }

    public static void findMaxLoad(List<Job> jobList) {

        System.out.println("Given Jobs: " + jobList.toString());

        Job[] jobs = jobList.toArray(new Job[0]);

        Job[] arrStart = Arrays.copyOf(jobs, jobs.length);
        Job[] arrEnd = Arrays.copyOf(jobs, jobs.length);

        Arrays.sort(arrStart, Comparator.comparingInt(o -> o.startTime));
        Arrays.sort(arrEnd, Comparator.comparingInt(o -> o.endTime));

        int maxLoad = 0;
        int currentLoad = 0;

        int i = 0, j = 0;
        int time=0;
        while (i < arrStart.length && j < arrEnd.length) {
            if (arrStart[i].startTime <= arrEnd[j].endTime) {
                currentLoad += arrStart[i].load;
                if(currentLoad>maxLoad){
                    maxLoad = currentLoad;
                    time = arrStart[i].startTime;
                }
                i++;
            } else {
                currentLoad -= arrEnd[j].load;
                j++;
            }
        }
        System.out.println("Maximum CPU Load is: "+ maxLoad+ " at time: " +time);
    }

    public static void main(String[] args) {
        List<Job> jobList = new ArrayList<>();
        jobList.add(new Job(2, 4, 5));
        jobList.add(new Job(0, 6, 7));
        jobList.add(new Job(5, 10, 6));
        jobList.add(new Job(0, 3, 10));

        findMaxLoad(jobList);
    }
}
