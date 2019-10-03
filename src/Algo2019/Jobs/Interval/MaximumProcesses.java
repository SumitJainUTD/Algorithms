package Algo2019.Jobs.Interval;

import java.util.ArrayList;
import java.util.List;

public class MaximumProcesses {

    static class Process {
        int startTime;
        int endTime;

        public Process(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
        @Override
        public String toString() {
            return "["+this.startTime+","+this.endTime+"]" ;
        }
    }

    public static void findMaxProcesses(List<Process> processes) {

        System.out.println("Given Processes " + processes.toString());

        int size = processes.size();
        // Find the time when the last process ends on the server
        int last_time = 0;
        for (int i = 0; i <processes.size() ; i++) {
            if(last_time<processes.get(i).endTime)
                last_time = processes.get(i).endTime;
        }

        int []count = new int[last_time+1];

        //fill the count array
        for(int i = 0; i < size; i++) {
            //When process starts, do +1 at the start time index
            ++count[processes.get(i).startTime];
            // guest process ends, do -1  at the end time index
            --count[processes.get(i).endTime];
        }

        int currentProcess=0;
        int time=0;
        int maxProcesses=0;

        for(int i = 0; i < last_time; i++) {
            currentProcess += count[i];
            if(maxProcesses < currentProcess) {
                maxProcesses = currentProcess;
                time = i;
            }
        }
        System.out.println("Maximum Processes running on server are: "+ maxProcesses+ " at time: " +time);
    }

    public static void main(String[] args) {
        List<Process> processes = new ArrayList<>();
        processes.add(new Process(0, 3));
        processes.add(new Process(4, 7));
        processes.add(new Process(2, 5));
        processes.add(new Process(3, 6));
        processes.add(new Process(3, 6));
        processes.add(new Process(6, 8));
        processes.add(new Process(0, 6));

        findMaxProcesses(processes);
    }
}
