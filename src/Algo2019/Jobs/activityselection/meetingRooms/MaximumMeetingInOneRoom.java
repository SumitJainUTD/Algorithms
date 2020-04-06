package Algo2019.Jobs.activityselection.meetingRooms;

import java.util.ArrayList;
import java.util.Collections;

public class MaximumMeetingInOneRoom {

    static class Meeting{
        int startTime;
        int endTime;
        String meetingTitle;

        public Meeting(int startTime, int endTime, String meetingTitle) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.meetingTitle = meetingTitle;
        }

        @Override
        public String toString(){
             return "Meeting: "+ this.meetingTitle + "[ Start Time: " + this.startTime + ", End Time: " + this.endTime + "]";
        }
    }

    public static void maxMeetings(ArrayList<Meeting> meetings){

        //sort the meetings in ascending order of meeting finish time
        System.out.println("All meetings: " + meetings);
        Collections.sort(meetings, (o1, o2) -> o1.endTime-o2.endTime);

        ArrayList<Meeting> selectedMeetings = new ArrayList<>();
        int currentEndTime = -1;
        for (int i = 0; i <meetings.size() ; i++) {
            Meeting currentMeeting = meetings.get(i);
            if(currentMeeting.startTime>currentEndTime){
                selectedMeetings.add(currentMeeting);
                currentEndTime = currentMeeting.endTime;
            }
        }

        //print selected meetings
        System.out.println("Scheduled meetings: ");
        for (int i = 0; i <selectedMeetings.size() ; i++) {
            System.out.println(selectedMeetings.get(i).toString());
        }
    }

    public static void main(String[] args) {

        Meeting meetingA = new Meeting(1, 3, "A");
        Meeting meetingB = new Meeting(2, 5, "B");
        Meeting meetingC = new Meeting(0, 7, "C");
        Meeting meetingD = new Meeting(6, 8, "D");
        Meeting meetingE = new Meeting(9, 11, "F");
        Meeting meetingF = new Meeting(10, 12, "G");

        ArrayList<Meeting> meetings = new ArrayList<>();
        meetings.add(meetingA);
        meetings.add(meetingB);
        meetings.add(meetingC);
        meetings.add(meetingD);
        meetings.add(meetingE);
        meetings.add(meetingF);

        maxMeetings(meetings);
    }
}
